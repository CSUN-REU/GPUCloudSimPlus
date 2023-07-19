package org.gpucloudsimplus.gpucloudsimplus.brokers;

import org.cloudsimplus.core.CloudSimPlus;
import org.cloudsimplus.vms.Vm;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.GpuCloudlet;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.gpucloudsimplus.gpucloudsimplus.vms.GpuVm;

import java.util.Comparator;

/**
 * Adapted from {@link org.cloudsimplus.brokers.DatacenterBrokerBestFit} and modified for GpuCloudSim Plus.
 *
 * In order for a GpuCloudlet to fit inside the GpuVm, two conditions must be satisfied:
 * 1) The GpuTask must fit inside the VGpu
 * 2) The Cloudlet must fit inside the VM
 *
 * The "best fit" portion of the algorithm determines best fit based on criteria 1).
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

        final VGpu mappedVGpu = getVmCreatedList()
                .stream()
                .filter(vm -> vm.getExpectedFreePesNumber() >= cloudlet.getPesNumber())
                .map(vm -> ((GpuVm) vm).getVGpu())
                .filter(vgpu -> vgpu.getExpectedFreeCoresNumber() >= cloudlet.getGpuTask().getNumberOfCores())
                .min(Comparator.comparingLong(VGpu::getExpectedFreeCoresNumber))
                .orElse(VGpu.NULL);

        if (VGpu.NULL.equals(mappedVGpu)) {
            LOGGER.warn("{}: {}: {} (PEs: {}) couldn't be mapped to any suitable VM.",
                    getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber());
        } else {
            LOGGER.trace("{}: {}: {} (PEs: {}) mapped to {} (available PEs: {}, tot PEs: {})",
                    getSimulation().clockStr(), getName(), cloudlet, cloudlet.getPesNumber(), mappedVGpu,
                    mappedVGpu.getGpuVm().getExpectedFreePesNumber(), mappedVGpu.getGpuVm().getFreePesNumber());
        }

        return mappedVGpu.getGpuVm();
    }

}
