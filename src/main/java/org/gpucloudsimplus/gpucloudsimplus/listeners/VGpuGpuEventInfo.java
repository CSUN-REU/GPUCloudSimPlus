package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.resources.Gpu;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.listeners.EventListener;

public interface VGpuGpuEventInfo extends VGpuEventInfo, GpuEventInfo {

    static VGpuGpuEventInfo of(final EventListener<VGpuGpuEventInfo> listener, final VGpu vgpu) {
        return of(listener, vgpu, vgpu.getGpu());
    }


    static VGpuGpuEventInfo of(final EventListener<VGpuGpuEventInfo> listener, final VGpu vgpu,
                               final Gpu gpu) {

        final double time = vgpu.getSimulation().clock();
        return new VGpuGpuEventInfo() {
            @Override
            public Gpu getGpu() {
                return gpu;
            }

            @Override
            public VGpu getVGpu() {
                return vgpu;
            }

            @Override
            public double getTime() {
                return time;
            }

            @Override
            public EventListener<VGpuGpuEventInfo> getListener() {
                return listener;
            }
        };
    }
}
