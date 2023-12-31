package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.resources.ResourceManageable;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;

public interface GpuTaskResourceAllocationFailEventInfo extends GpuTaskEventInfo {

    Class<? extends ResourceManageable> getResourceClass();

    long getRequestedAmount();

    long getAvailableAmount();

    @Override
    EventListener<GpuTaskResourceAllocationFailEventInfo> getListener();

    static GpuTaskResourceAllocationFailEventInfo of(
            final EventListener<GpuTaskResourceAllocationFailEventInfo> listener,
            final GpuTask gpuTask,
            final Class<? extends ResourceManageable> resourceClass,
            final long requestedAmount,
            final long availableAmount,
            final double time) {
        return new GpuTaskResourceAllocationFailEventInfo() {
            @Override
            public EventListener<GpuTaskResourceAllocationFailEventInfo> getListener() {
                return listener;
            }

            @Override
            public GpuTask getGpuTask() {
                return gpuTask;
            }

            @Override
            public Class<? extends ResourceManageable> getResourceClass() {
                return resourceClass;
            }

            @Override
            public long getRequestedAmount() {
                return requestedAmount;
            }

            @Override
            public long getAvailableAmount() {
                return availableAmount;
            }

            @Override
            public double getTime() {
                return time;
            }
        };
    }
}

