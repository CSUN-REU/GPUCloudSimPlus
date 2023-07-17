package org.gpucloudsimplus.gpucloudsimplus.vgpu;

import org.cloudsimplus.core.ChangeableId;
import org.cloudsimplus.core.Simulation;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.schedulers.MipsShare;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.gpucloudsimplus.gpucloudsimplus.core.AbstractGpu;
import org.gpucloudsimplus.gpucloudsimplus.core.GpuResourceStatsComputer;
import org.gpucloudsimplus.gpucloudsimplus.listeners.VGpuGpuEventInfo;
import org.gpucloudsimplus.gpucloudsimplus.listeners.VGpuVideocardEventInfo;
import org.gpucloudsimplus.gpucloudsimplus.resources.Gpu;
import org.gpucloudsimplus.gpucloudsimplus.resources.VGpuCore;
import org.gpucloudsimplus.gpucloudsimplus.schedulers.gputask.GpuTaskScheduler;
import org.gpucloudsimplus.gpucloudsimplus.videocards.Videocard;
import org.gpucloudsimplus.gpucloudsimplus.vms.GpuVm;

import java.util.List;

public interface VGpu extends AbstractGpu, Comparable<VGpu>,
        GpuResourceStatsComputer<VGpuResourceStats> {

    VGpu NULL = new VGpuNull();

    //updateProcessing
    double updateGpuTaskProcessing(MipsShare mipsShare);

    double updateGpuTaskProcessing(double currentTime, MipsShare mipsShare);

    MipsShare getCurrentRequestedMips();

    double getTotalGpuMipsRequested();

    //double getMaxMipsRequested ();

    long getCurrentRequestedBw();

    long getCurrentRequestedGddram();

    //utilization in vgpu need

    double getTotalGpuMipsUtilization();

    double getTotalGpuMipsUtilization(double time);

    long getId();

    ChangeableId setId(long id);

    void setType(String type);

    String getType();

    VGpu setGpuVm(GpuVm gpuVm);

    GpuVm getGpuVm();

    VGpu setGpuTaskScheduler(GpuTaskScheduler gpuTaskScheduler);

    GpuTaskScheduler getGpuTaskScheduler();

    int getPCIeBw();

    void setPCIeBw(int PCIeBw);

    String getTenancy();

    void setTenancy(String tenancy);

    ///
    String getDescription();

    VGpu setDescription(String description);

    //VmGroup getGroup ();

    void addStateHistoryEntry(VGpuStateHistoryEntry entry);

    long getFreeCoresNumber();

    long getExpectedFreeCoresNumber();

    VGpu addOnGpuAllocationListener(EventListener<VGpuGpuEventInfo> listener);

    VGpu addOnMigrationStartListener(EventListener<VGpuGpuEventInfo> listener);

    VGpu addOnMigrationFinishListener(EventListener<VGpuGpuEventInfo> listener);

    VGpu addOnGpuDeallocationListener(EventListener<VGpuGpuEventInfo> listener);

    VGpu addOnCreationFailureListener(EventListener<VGpuVideocardEventInfo> listener);

    VGpu addOnUpdateProcessingListener(EventListener<VGpuGpuEventInfo> listener);

    void notifyOnGpuAllocationListeners();

    void notifyOnGpuDeallocationListeners(Gpu deallocatedGpu);

    void notifyOnCreationFailureListeners(Videocard failedVideocard);

    boolean removeOnMigrationStartListener(EventListener<VGpuGpuEventInfo> listener);

    boolean removeOnMigrationFinishListener(EventListener<VGpuGpuEventInfo> listener);

    boolean removeOnUpdateProcessingListener(EventListener<VGpuGpuEventInfo> listener);

    boolean removeOnGpuAllocationListener(EventListener<VGpuGpuEventInfo> listener);

    boolean removeOnGpuDeallocationListener(EventListener<VGpuGpuEventInfo> listener);

    boolean removeOnCreationFailureListener(EventListener<VGpuVideocardEventInfo> listener);

    @Override
    Resource getBw();

    @Override
    Resource getGddram();

    //@Override
    //Resource getStorage ();

    List<VGpuStateHistoryEntry> getStateHistory();

    double getCorePercentUtilization(double time);

    double getCorePercentUtilization();

    double getCorePercentRequested(double time);

    double getCorePercentRequested();

    //void enableUtilizationStats ();

    double getGpuGddramUtilization(); // videocard or Gpu

    double getGpuBwUtilization(); // videocard or Gpu

    //videocard's total MIPS capacity
    default double getGpuCoreUtilization() {
        return getGpuCoreUtilization(getSimulation().clock());
    }

    double getGpuCoreUtilization(double time);

    double getExpectedGpuCoreUtilization(double vgpuCpuUtilizationPercent);

    double getTotalCoreMipsUtilization();

    double getTotalCoreMipsUtilization(double time);

    //String getVmm ();

    boolean isCreated();

    boolean isSuitableForGpuTask(GpuTask gpuTask);

    void setCreated(boolean created);

    boolean isInMigration();

    void setInMigration(boolean migrating);

    VGpu setBw(long bwCapacity);

    VGpu setGpu(Gpu gpu);

    VGpu setGddram(long gddramCapacity);

    //CustomVGpu setSize (long size); //storage

    void setFailed(boolean failed);

    boolean isFailed();

    boolean isWorking();

    //@Override
    //default boolean isIdleEnough (final double time) {
    //    return getCloudletScheduler().getCloudletExecList().isEmpty() && AbstractMachine.super.isIdleEnough(time);
    //}

    //HorizontalVGpuScaling getHorizontalScaling ();

    //CustomVGpu setHorizontalScaling (HorizontalVGpuScaling horizontalScaling) throws IllegalArgumentException;

    //CustomVGpu setRamVerticalScaling (VerticalVmScaling ramVerticalScaling) throws IllegalArgumentException;

    //Vm setBwVerticalScaling (VerticalVmScaling bwVerticalScaling) throws IllegalArgumentException;

    //Vm setPeVerticalScaling (VerticalVmScaling peVerticalScaling) throws IllegalArgumentException;

    //VerticalVmScaling getRamVerticalScaling ();

    //VerticalVmScaling getBwVerticalScaling ();

    //VerticalVmScaling getPeVerticalScaling ();

    VGpuCore getVGpuCore();

    //@Override
    //DatacenterBroker getBroker ();

    //@Override
    //void setBroker (DatacenterBroker broker);

    double getStopTime();

    double getTotalExecutionTime();

    VGpu setStopTime(double stopTime);

    //@Override
    //double getTimeZone ();

    //@Override
    //CustomVGpu setTimeZone (double timeZone);

    @Override
    Simulation getSimulation();

    Gpu getGpu();

    //getSimulationdouble getMips ();

    //long getNumberOfCores ();

    double getGpuPercentUtilization(double time);

    double getGpuPercentUtilization();

    VGpu setStartTime(final double startTime);
}
