package org.gpucloudsimplus.listeners;

import org.cloudbus.cloudsim.gp.videocards.Videocard;
import org.cloudsimplus.listeners.EventInfo;

public interface VideocardEventInfo extends EventInfo {

	Videocard getVideocard();
}

