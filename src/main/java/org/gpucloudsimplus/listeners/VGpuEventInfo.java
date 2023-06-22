package org.gpucloudsimplus.listeners;

import org.cloudbus.cloudsim.gp.vgpu.VGpu;
import org.cloudsimplus.listeners.EventInfo;

public interface VGpuEventInfo extends EventInfo {

    VGpu getVGpu();
}
