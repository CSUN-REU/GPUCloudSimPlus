package org.gpucloudsimplus.gpucloudsimplus.provisioners;

import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;

import java.util.function.Function;

class GpuResourceProvisionerNull implements GpuResourceProvisioner {

    @Override
    public boolean allocateResourceForVGpu(VGpu vgpu, long newTotalVmResourceCapacity) {
        return false;
    }

    @Override
    public long getAllocatedResourceForVGpu(VGpu vgpu) {
        return 0;
    }

    @Override
    public long getTotalAllocatedResource() {
        return 0;
    }

    @Override
    public long deallocateResourceForVGpu(VGpu vgpu) {
        return 0;
    }

    @Override
    public boolean isSuitableForVGpu(VGpu vgpu, long newVGpuTotalAllocatedResource) {
        return false;
    }

    @Override
    public boolean isSuitableForVGpu(VGpu vgpu, Resource resource) {
        return false;
    }

    @Override
    public ResourceManageable getPGpuResource() {
        return ResourceManageable.NULL;
    }

    @Override
    public void setResources(ResourceManageable pGpuResource, Function<VGpu, ResourceManageable> vGpuResourceFunction) {

    }

    @Override
    public long getCapacity() {
        return 0;
    }

    @Override
    public long getAvailableResource() {
        return 0;
    }
}

