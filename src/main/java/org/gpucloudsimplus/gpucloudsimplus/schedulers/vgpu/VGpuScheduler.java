package org.gpucloudsimplus.gpucloudsimplus.schedulers.vgpu;

import org.gpucloudsimplus.gpucloudsimplus.resources.Gpu;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.schedulers.MipsShare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface VGpuScheduler {
    Logger LOGGER = LoggerFactory.getLogger(VGpuScheduler.class.getSimpleName());

    double DEF_VGPU_MIGRATION_GPU_OVERHEAD = 0.1;

    VGpuScheduler NULL = new VGpuSchedulerNull();

    boolean allocateCoresForVGpu(VGpu vgpu, MipsShare requestedMips);

    boolean allocateCoresForVGpu(VGpu vgpu);

    void deallocateCoresFromVGpu(VGpu vgpu);

    void deallocateCoresFromVGpu(VGpu vgpu, int coresToRemove);

    MipsShare getAllocatedMips(VGpu vgpu);

    double getTotalAvailableMips();

    Gpu getGpu();

    VGpuScheduler setGpu(Gpu gpu);

    MipsShare getRequestedMips(VGpu vgpu);

    boolean isSuitableForVGpu(VGpu vgpu);

    boolean isSuitableForVGpu(VGpu vgpu, MipsShare requestedMips);

    double getTotalAllocatedMipsForVGpu(VGpu vgpu);

    double getMaxGpuUsagePercentDuringOutMigration();

    double getVGpuMigrationGpuOverhead();

}
