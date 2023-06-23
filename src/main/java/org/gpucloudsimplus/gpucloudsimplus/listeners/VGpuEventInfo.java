package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.listeners.EventInfo;

public interface VGpuEventInfo extends EventInfo {

    VGpu getVGpu();
}
