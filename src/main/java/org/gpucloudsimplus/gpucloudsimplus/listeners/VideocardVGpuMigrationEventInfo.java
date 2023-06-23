package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.resources.GpuSuitability;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.gpucloudsimplus.gpucloudsimplus.videocards.Videocard;
import org.cloudsimplus.listeners.EventListener;


public final class VideocardVGpuMigrationEventInfo implements VGpuVideocardEventInfo {
    private final double time;
    private final VGpu vgpu;
    private final GpuSuitability suitability;
    private final EventListener<VideocardVGpuMigrationEventInfo> listener;

    private VideocardVGpuMigrationEventInfo(final VGpu vgpu, final GpuSuitability suitability,
                                            final EventListener<VideocardVGpuMigrationEventInfo> listener) {
        this.vgpu = vgpu;
        this.time = vgpu.getSimulation().clock();
        this.suitability = suitability;
        this.listener = listener;
    }

    public VGpu getVGpu() {
        return vgpu;
    }

    @Override
    public Videocard getVideocard() {
        return vgpu.getGpu().getVideocard();
    }

    @Override
    public double getTime() {
        return time;
    }

    public boolean isMigrationSuccessful() {
        return suitability.fully();
    }

    public GpuSuitability getGpuSuitability() {
        return suitability;
    }

    @Override
    public EventListener<VideocardVGpuMigrationEventInfo> getListener() {
        return listener;
    }

    public static VideocardVGpuMigrationEventInfo of(
            final EventListener<VideocardVGpuMigrationEventInfo> listener,
            final VGpu vgpu, final GpuSuitability suitability) {
        return new VideocardVGpuMigrationEventInfo(vgpu, suitability, listener);
    }
}
