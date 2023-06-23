package org.gpucloudsimplus.gpucloudsimplus.vms;

import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.vms.Vm;

public interface GpuVm extends Vm {

    GpuVm NULL = new GpuVmNull();

    void setType(String type);

    String getType();

    GpuVm setVGpu(VGpu vgpu);

    VGpu getVGpu();

    boolean hasVGpu();
}
