package org.gpucloudsimplus.gpucloudsimplus.brokers;

import org.cloudsimplus.core.CloudSimPlus;
import org.cloudsimplus.vms.Vm;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.GpuCloudlet;
import org.gpucloudsimplus.gpucloudsimplus.vms.GpuVm;

import java.util.Comparator;

/**
 * Adapted from {@link org.cloudsimplus.brokers.DatacenterBrokerBestFit} and modified for GpuCloudSim Plus.
 */
public class GpuDatacenterBrokerBestFit extends GpuDatacenterBrokerSimple {

    public GpuDatacenterBrokerBestFit(CloudSimPlus simulation) {
        super(simulation);
    }

    @Override
    protected GpuVm defaultGpuVmMapper(final GpuCloudlet cloudlet) {
        if (cloudlet.isBoundToVm()) {
            return (GpuVm) cloudlet.getVm();
        }

        final Vm mappedVm = getVmCreatedList()
                .stream()
                .filter(vm -> vm.getExpectedFreePesNumber() >= cloudlet.getPesNumber())
                .min(Comparator.comparingLong(Vm::getExpectedFreePesNumber))
                .orElse(Vm.NULL);

        if (Vm.NULL.equals(mappedVm)) {
            LOGGER.warn("{}: {}: {} (PEs: {}) couldn't be mapped to any suitable VM.",
                    getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber());
        } else {
            LOGGER.trace("{}: {}: {} (PEs: {}) mapped to {} (available PEs: {}, tot PEs: {})",
                    getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber(), mappedVm,
                    mappedVm.getExpectedFreePesNumber(), mappedVm.getFreePesNumber());
        }

        return (GpuVm) mappedVm;
    }

}
