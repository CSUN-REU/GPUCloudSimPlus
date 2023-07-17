package org.gpucloudsimplus.gpucloudsimplus.listeners;

import org.cloudsimplus.listeners.EventInfo;
import org.gpucloudsimplus.gpucloudsimplus.videocards.Videocard;

public interface VideocardEventInfo extends EventInfo {

    Videocard getVideocard();
}

