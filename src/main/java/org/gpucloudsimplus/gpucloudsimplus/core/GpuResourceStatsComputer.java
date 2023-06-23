package org.gpucloudsimplus.gpucloudsimplus.core;

public interface GpuResourceStatsComputer<T extends GResourceStats<?>> {

    T getGpuUtilizationStats();

    void enableUtilizationStats();
}