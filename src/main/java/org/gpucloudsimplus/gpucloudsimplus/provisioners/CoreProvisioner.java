package org.gpucloudsimplus.gpucloudsimplus.provisioners;

import org.gpucloudsimplus.gpucloudsimplus.resources.GpuCore;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;

public interface CoreProvisioner extends GpuResourceProvisioner {

    CoreProvisioner NULL = new CoreProvisionerNull();

    void setCore(GpuCore core);

    @Override
    boolean allocateResourceForVGpu(VGpu vgpu, long mipsCapacity);

    @Override
    long getAllocatedResourceForVGpu(VGpu vgpu);

    @Override
    long deallocateResourceForVGpu(VGpu vgpu);

    @Override
    long getTotalAllocatedResource();

    double getUtilization();
}
