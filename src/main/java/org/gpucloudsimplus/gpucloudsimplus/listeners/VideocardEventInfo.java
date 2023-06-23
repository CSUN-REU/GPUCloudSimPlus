package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.gpucloudsimplus.gpucloudsimplus.videocards.Videocard;
import org.cloudsimplus.listeners.EventInfo;

public interface VideocardEventInfo extends EventInfo {

    Videocard getVideocard();
}

