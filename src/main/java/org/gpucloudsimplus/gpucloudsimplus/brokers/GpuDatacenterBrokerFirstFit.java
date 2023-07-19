package org.gpucloudsimplus.gpucloudsimplus.brokers;


import org.cloudsimplus.core.CloudSimPlus;
import org.cloudsimplus.vms.Vm;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.GpuCloudlet;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.gpucloudsimplus.gpucloudsimplus.vms.GpuVm;

/**
 * Adapted from {@link org.cloudsimplus.brokers.DatacenterBrokerBestFit} and modified for GpuCloudSim Plus.
 *
 * In order for a GpuCloudlet to fit inside the GpuVm, two conditions must be satisfied:
 * 1) The GpuTask must fit inside the VGpu
 * 2) The Cloudlet must fit inside the VM
 */
public class GpuDatacenterBrokerFirstFit extends GpuDatacenterBrokerSimple {

    /**
     * The index of the last Vm used to place a Cloudlet.
     */
    private int lastVmIndex;

    public GpuDatacenterBrokerFirstFit(CloudSimPlus simulation) {
        super(simulation);
    }

    /**
     * Selects the first VM with the lowest number of PEs that is able to run a given Cloudlet.
     * In case the algorithm can't find such a VM, it uses the
     * default DatacenterBroker VM mapper as a fallback.
     *
     * @param cloudlet the Cloudlet to find a VM to run it
     * @return the VM selected for the Cloudlet or {@link Vm#NULL} if no suitable VM was found
     */
    @Override
    public GpuVm defaultGpuVmMapper(final GpuCloudlet cloudlet) {
        if (cloudlet.isBoundToVm()) {
            return (GpuVm) cloudlet.getVm();
        }

        /* The for loop just defines the maximum number of Hosts to try.
         * When a suitable Host is found, the method returns immediately. */
        final int maxTries = getVmCreatedList().size();
        for (int i = 0; i < maxTries; i++) {
            final GpuVm vm = (GpuVm) getVmCreatedList().get(lastVmIndex);
            GpuTask gpuTask = cloudlet.getGpuTask();
            if (vm.getExpectedFreePesNumber() >= cloudlet.getPesNumber() &&
                    vm.getVGpu().getExpectedFreeCoresNumber() >= gpuTask.getNumberOfCores()) {
                LOGGER.trace("{}: {}: {} (PEs: {}) mapped to {} (available PEs: {}, tot PEs: {})",
                        getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber(), vm,
                        vm.getVGpu().getExpectedFreeCoresNumber(), vm.getVGpu().getFreeCoresNumber());
                return vm;
            }

            /* If it gets here, the previous Vm doesn't have capacity to place the Cloudlet.
             * Then, moves to the next Vm.
             * If the end of the Vm list is reached, starts from the beginning,
             * until the max number of tries.*/
            lastVmIndex = ++lastVmIndex % getVmCreatedList().size();
        }

        LOGGER.warn("{}: {}: {} (PEs: {}) couldn't be mapped to any suitable VM.",
                getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber());

        return GpuVm.NULL;
    }


}
