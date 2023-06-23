package org.cloudbus.cloudsim.gp.core;

import org.cloudsimplus.core.ChangeableId;
import org.cloudsimplus.core.Simulation;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.Resourceful;

//  <T extends Resource>
public interface AbstractGpu extends ChangeableId, Resourceful {

    AbstractGpu NULL = new AbstractGpuNull();

    Resource getBw();

    Resource getGddram();

    //T getStorage ();

    long getNumberOfCores();

    double getMips();

    double getTotalMipsCapacity();

    Simulation getSimulation();

    double getStartTime();

    AbstractGpu setStartTime(double startTime);

    default boolean isIdleEnough(final double time) {
        if (time < 0) {
            return false;
        }

        return getIdleInterval() >= time;
    }

    default double getIdleInterval() {
        return getSimulation().clock() - getLastBusyTime();
    }

    double getLastBusyTime();

    default boolean isIdle() {
        return getIdleInterval() > 0;
    }

    static void validateCapacity(final double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
    }
}
