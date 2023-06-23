package org.gpucloudsimplus.gpucloudsimplus.provisioners;

import org.gpucloudsimplus.gpucloudsimplus.resources.GpuCore;
import org.gpucloudsimplus.gpucloudsimplus.vgpu.VGpu;
import org.cloudsimplus.resources.ResourceManageable;

import java.util.Objects;

public class CoreProvisionerSimple extends GpuResourceProvisionerSimple implements
        CoreProvisioner {

    public CoreProvisionerSimple() {
        super(GpuCore.NULL, vgpu -> ResourceManageable.NULL);
    }

    public CoreProvisionerSimple(final GpuCore core) {
        super(core, VGpu::getVGpuCore);
        core.setCoreProvisioner(this);
    }

    @Override
    public void setCore(final GpuCore core) {
        if (isOtherProvisionerAssignedToCore(core)) {
            throw new IllegalArgumentException("Core already has a CoreProvisioner assigned "
                    + "to it. Each Core must have its own CoreProvisioner instance.");
        }
        setResources(core, VGpu::getVGpuCore);
    }

    @Override
    public double getUtilization() {
        return getTotalAllocatedResource() / (double) getCapacity();
    }

    private boolean isOtherProvisionerAssignedToCore(final GpuCore core) {
        Objects.requireNonNull(core);
        return core.getCoreProvisioner() != null &&
                core.getCoreProvisioner() != CoreProvisioner.NULL &&
                !core.getCoreProvisioner().equals(this);
    }
}
