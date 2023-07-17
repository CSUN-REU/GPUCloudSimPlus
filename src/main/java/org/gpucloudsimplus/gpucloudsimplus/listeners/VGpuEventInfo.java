package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.cloudsimplus.listeners.EventInfo;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;

public interface VGpuEventInfo extends EventInfo {

    VGpu getVGpu();
}
