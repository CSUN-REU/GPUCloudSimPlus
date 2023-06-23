package org.cloudbus.cloudsim.gp.core;

import org.cloudsimplus.core.ChangeableId;
import org.cloudsimplus.core.Simulation;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;

import java.util.Collections;
import java.util.List;

final class AbstractGpuNull implements AbstractGpu {

    @Override
    public Resource getBw() {
        return Resource.NULL;
    }

    @Override
    public Resource getGddram() {
        return Resource.NULL;
    }

    /*@Override public Resource getStorage() {
        return Resource.NULL;
    }*/
    @Override
    public long getNumberOfCores() {
        return 0;
    }

    @Override
    public double getMips() {
        return 0;
    }

    @Override
    public Simulation getSimulation() {
        return Simulation.NULL;
    }

    @Override
    public double getStartTime() {
        return 0;
    }

    @Override
    public AbstractGpu setStartTime(double startTime) {
        return this;
    }

    @Override
    public double getLastBusyTime() {
        return 0;
    }

    @Override
    public boolean isIdle() {
        return true;
    }

    @Override
    public ChangeableId setId(long id) {
        return null;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public double getTotalMipsCapacity() {
        return 0.0;
    }

    @Override
    public List<ResourceManageable> getResources() {
        return Collections.emptyList();
    }
}