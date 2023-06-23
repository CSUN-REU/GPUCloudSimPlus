package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.cloudsimplus.listeners.EventInfo;

public interface GpuTaskEventInfo extends EventInfo {

    GpuTask getGpuTask();
}

