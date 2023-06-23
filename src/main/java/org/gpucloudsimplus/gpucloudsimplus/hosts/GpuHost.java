package org.gpucloudsimplus.gpucloudsimplus.hosts;

import org.gpucloudsimplus.gpucloudsimplus.videocards.Videocard;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.vms.Vm;

import java.util.List;

public interface GpuHost extends Host {

    //Logger LOGGER = LoggerFactory.getLogger(GpuHost.class.getSimpleName());

    double DEF_IDLE_SHUTDOWN_DEADLINE = -1;

    GpuHost NULL = new GpuHostNull();

    Videocard getVideocard();

    boolean hasVideocard();

    GpuHost setVideocard(Videocard videocard);

    @Override
    <T extends Vm> List<T> getVmList();
}


