package org.gpucloudsimplus.gpucloudsimplus.cloudlets;

import org.cloudsimplus.cloudlets.Cloudlet;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;

public interface GpuCloudlet extends Cloudlet {
    GpuCloudlet NULL = new GpuCloudletNull();

    GpuCloudlet setGpuTask(GpuTask gpuTask);

    GpuTask getGpuTask();
}
