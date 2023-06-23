package org.gpucloudsimplus.gpucloudsimplus.provisioners;

import org.gpucloudsimplus.gpucloudsimplus.resources.GpuCore;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;

final class CoreProvisionerNull extends GpuResourceProvisionerNull implements CoreProvisioner {
    @Override
    public void setCore(GpuCore core) {/**/}

    @Override
    public double getUtilization() {
        return 0;
    }

    @Override
    public boolean allocateResourceForVGpu(VGpu vgpu, double newTotalVGpuResource) {
        return false;
    }
}
