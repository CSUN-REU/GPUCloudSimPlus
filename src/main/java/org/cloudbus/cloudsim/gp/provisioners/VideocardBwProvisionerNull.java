package org.cloudbus.cloudsim.gp.provisioners;

import org.cloudbus.cloudsim.gp.resources.Gpu;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;

import java.util.function.Function;

public class VideocardBwProvisionerNull implements VideocardBwProvisioner {

    @Override
    public boolean allocateBwForGpu(Gpu gpu, long bw) {
        return false;
    }

    @Override
    public long getAllocatedBwForGpu(Gpu gpu) {
        return 0;
    }

    @Override
    public long getTotalAllocatedBw() {
        return 0;
    }

    @Override
    public long deallocateBwForGpu(Gpu gpu) {
        return 0;
    }

    @Override
    public boolean isSuitableForGpu(Gpu gpu, long newGpuTotalAllocatedBw) {
        return false;
    }

    @Override
    public boolean isSuitableForGpu(Gpu gpu, Resource resource) {
        return false;
    }

    @Override
    public ResourceManageable getVideocardBwResource() {
        return ResourceManageable.NULL;
    }

    @Override
    public void setResources(ResourceManageable videocardBwResource,
                             Function<Gpu, ResourceManageable> gpuBwFunction) {/**/}

    @Override
    public long getCapacity() {
        return 0;
    }

    @Override
    public long getAvailableResource() {
        return 0;
    }
}

