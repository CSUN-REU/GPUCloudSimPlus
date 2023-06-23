package org.cloudbus.cloudsim.gp.core;

public interface GpuResourceStatsComputer<T extends GResourceStats<?>> {

    T getGpuUtilizationStats();

    void enableUtilizationStats();
}