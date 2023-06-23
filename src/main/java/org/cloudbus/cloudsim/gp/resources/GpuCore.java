package org.cloudbus.cloudsim.gp.resources;

import org.cloudbus.cloudsim.gp.provisioners.CoreProvisioner;
import org.cloudsimplus.core.ChangeableId;
import org.cloudsimplus.resources.ResourceManageable;

public interface GpuCore extends ChangeableId, ResourceManageable {

    enum Status {
        FREE,
        BUSY,
        FAILED
    }

    GpuCore NULL = new GpuCoreNull();

    @Override
    long getCapacity();

    @Override
    boolean setCapacity(long mipsCapacity);

    boolean setCapacity(double mipsCapacity);

    GpuCore setCoreProvisioner(CoreProvisioner coreProvisioner);

    CoreProvisioner getCoreProvisioner();

    Status getStatus();

    boolean setStatus(Status status);

    boolean isWorking();

    boolean isFailed();

    boolean isFree();

    boolean isBusy();
}
