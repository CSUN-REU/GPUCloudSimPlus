package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.resources.Gpu;
import org.cloudsimplus.listeners.EventInfo;
import org.cloudsimplus.listeners.EventListener;

public interface GpuEventInfo extends EventInfo {

    Gpu getGpu();

    static GpuEventInfo of(final EventListener<? extends EventInfo> listener,
                           final Gpu gpu, final double time) {
        return new GpuEventInfo() {
            @Override
            public Gpu getGpu() {
                return gpu;
            }

            @Override
            public double getTime() {
                return time;
            }

            @Override
            public EventListener<? extends EventInfo> getListener() {
                return listener;
            }
        };
    }
}
