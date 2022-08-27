package org.gpucloudsimplus.listeners;

import org.cloudbus.cloudsim.gp.videocards.Videocard;
import org.cloudbus.cloudsim.gp.resources.GpuSuitability;
import org.cloudbus.cloudsim.gp.resources.CustomVGpu;
import org.cloudsimplus.listeners.EventListener;


public final class VideocardVGpuMigrationEventInfo implements VGpuVideocardEventInfo {
    private final double time;
    private final CustomVGpu vgpu;
    private final GpuSuitability suitability;
    private final EventListener<VideocardVGpuMigrationEventInfo> listener;

    private VideocardVGpuMigrationEventInfo (final CustomVGpu vgpu, final GpuSuitability suitability,
    		final EventListener<VideocardVGpuMigrationEventInfo> listener){
    	this.vgpu = vgpu;
        this.time = vgpu.getSimulation().clock();
        this.suitability = suitability;
        this.listener = listener;
    }

    public CustomVGpu getVGpu () {
        return vgpu;
    }

    @Override
    public Videocard getVideocard () {
        return vgpu.getGpu().getVideocard();
    }

    @Override
    public double getTime() {
        return time;
    }

    public boolean isMigrationSuccessful () {
        return suitability.fully();
    }

    public GpuSuitability getGpuSuitability () {
        return suitability;
    }

    @Override
    public EventListener<VideocardVGpuMigrationEventInfo> getListener () {
        return listener;
    }

    public static VideocardVGpuMigrationEventInfo of (
    		final EventListener<VideocardVGpuMigrationEventInfo> listener, 
    		final CustomVGpu vgpu, final GpuSuitability suitability) {
        return new VideocardVGpuMigrationEventInfo(vgpu, suitability, listener);
    }
}
