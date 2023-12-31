package org.gpucloudsimplus.gpucloudsimplus.vgpu;

import org.gpucloudsimplus.gpucloudsimplus.core.GResourceStats;

import java.util.function.Function;

public class VGpuResourceStats extends GResourceStats<VGpu> {
    public static final VGpuResourceStats NULL = new VGpuResourceStats
            (VGpu.NULL, vgpu -> 0.0) {
        @Override
        public boolean add(double time) {
            return false;
        }
    };


    public VGpuResourceStats(final VGpu machine,
                             final Function<VGpu, Double> resourceUtilizationFunction) {
        super(machine, resourceUtilizationFunction);
    }
}
