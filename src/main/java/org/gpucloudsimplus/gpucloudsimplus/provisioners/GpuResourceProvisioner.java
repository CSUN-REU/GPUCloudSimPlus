package org.gpucloudsimplus.gpucloudsimplus.provisioners;

import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;

import java.util.function.Function;

public interface GpuResourceProvisioner {

    GpuResourceProvisioner NULL = new GpuResourceProvisionerNull();

    boolean allocateResourceForVGpu(VGpu vgpu, long newTotalVGpuResourceCapacity);

    default boolean allocateResourceForVGpu(final VGpu vgpu,
                                            final double newTotalVGpuResource) {
        return allocateResourceForVGpu(vgpu, (long) newTotalVGpuResource);
    }

    long getAllocatedResourceForVGpu(VGpu vgpu);

    long getTotalAllocatedResource();

    long deallocateResourceForVGpu(VGpu vgpu);

    boolean isSuitableForVGpu(VGpu vgpu, long newVGpuTotalAllocatedResource);

    boolean isSuitableForVGpu(VGpu vgpu, Resource resource);

    ResourceManageable getPGpuResource();

    void setResources(ResourceManageable pGpuResource,
                      Function<VGpu, ResourceManageable> vGpuResourceFunction);

    long getCapacity();

    long getAvailableResource();
}
