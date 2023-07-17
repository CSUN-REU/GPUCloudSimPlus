package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.cloudsimplus.listeners.EventInfo;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;

public interface GpuTaskEventInfo extends EventInfo {

    GpuTask getGpuTask();
}

