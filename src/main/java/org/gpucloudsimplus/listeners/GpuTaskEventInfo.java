package org.gpucloudsimplus.listeners;

import org.cloudbus.cloudsim.gp.cloudlets.gputasks.GpuTask;
import org.cloudsimplus.listeners.EventInfo;

public interface GpuTaskEventInfo extends EventInfo {

    GpuTask getGpuTask();
}

