package org.gpucloudsimplus.gpucloudsimplus.builders;

import org.cloudsimplus.builders.tables.CloudletsTableBuilder;
import org.cloudsimplus.builders.tables.Table;
import org.cloudsimplus.cloudlets.Cloudlet;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.GpuCloudlet;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;

import java.util.List;
import java.util.function.Function;

public class GpuCloudletsTableBuilder extends CloudletsTableBuilder {

    private static final Function<Cloudlet, GpuTask> GPU_TASK_MAP = (cloudlet) -> ((GpuCloudlet) cloudlet).getGpuTask();

    public GpuCloudletsTableBuilder(List<? extends Cloudlet> list) {
        super(list);

        throwExceptionOnInvalidCloudlet(list);
    }

    public GpuCloudletsTableBuilder(List<? extends Cloudlet> list, Table table) {
        super(list, table);

        throwExceptionOnInvalidCloudlet(list);
    }

    private void throwExceptionOnInvalidCloudlet(List<? extends Cloudlet> list) {
        if (list.stream().anyMatch(cloudlet -> !(cloudlet instanceof GpuCloudlet))) {
            throw new IllegalArgumentException("One or more cloudlets are not instances of GpuCloudlet");
        }
    }

    @Override
    protected void createTableColumns() {
        super.createTableColumns();

        addColumn(getTable().newColumn("GPU ExecTime", "Seconds", "%.1f"),
                cloudlet -> GPU_TASK_MAP.andThen(GpuTask::getActualGpuTime).apply(cloudlet));
    }

}
