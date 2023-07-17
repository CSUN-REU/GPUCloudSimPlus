package org.gpucloudsimplus.gpucloudsimplus.cloudlets;

import org.cloudsimplus.cloudlets.CloudletSimple;
import org.cloudsimplus.utilizationmodels.UtilizationModel;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.gpucloudsimplus.gpucloudsimplus.datacenters.GpuDatacenter;

public class GpuCloudletSimple extends CloudletSimple implements GpuCloudlet {

    private GpuTask gpuTask;

    public GpuCloudletSimple(final long length, final int pesNumber,
                             final UtilizationModel utilizationModel, GpuTask gpuTask) {
        super(length, pesNumber, utilizationModel);
        setGpuTask(gpuTask);
        setLastTriedDatacenter(GpuDatacenter.NULL);
    }

    public GpuCloudletSimple(final long length, final int pesNumber, GpuTask gpuTask) {
        super(length, pesNumber);
        setGpuTask(gpuTask);
        setLastTriedDatacenter(GpuDatacenter.NULL);
    }

    public GpuCloudletSimple(final long length, final long pesNumber, GpuTask gpuTask) {
        super(length, pesNumber);
        setGpuTask(gpuTask);
        setLastTriedDatacenter(GpuDatacenter.NULL);
    }

    public GpuCloudletSimple(final long id, final long length, final long pesNumber,
                             GpuTask gpuTask) {
        super(id, length, pesNumber);
        setGpuTask(gpuTask);
        setLastTriedDatacenter(GpuDatacenter.NULL);
    }

    @Override
    public GpuCloudlet setGpuTask(GpuTask gpuTask) {
        this.gpuTask = gpuTask;
        if (gpuTask != null && gpuTask.getGpuCloudlet() == null)
            gpuTask.setGpuCloudlet(this);
        return this;
    }

    @Override
    public GpuTask getGpuTask() {
        return gpuTask;
    }
}
