package org.gpucloudsimplus.gpucloudsimplus.cloudlets;

import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.cloudsimplus.cloudlets.Cloudlet;

public interface GpuCloudlet extends Cloudlet {
    GpuCloudlet NULL = new GpuCloudletNull();

    GpuCloudlet setGpuTask(GpuTask gpuTask);

    GpuTask getGpuTask();
}
