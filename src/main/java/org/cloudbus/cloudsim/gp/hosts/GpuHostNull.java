package org.cloudbus.cloudsim.gp.hosts;

import org.cloudbus.cloudsim.gp.videocards.Videocard;
import org.cloudsimplus.core.Machine;
import org.cloudsimplus.core.Simulation;
import org.cloudsimplus.datacenters.Datacenter;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.hosts.HostStateHistoryEntry;
import org.cloudsimplus.hosts.HostSuitability;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.listeners.HostEventInfo;
import org.cloudsimplus.listeners.HostUpdatesVmsProcessingEventInfo;
import org.cloudsimplus.power.models.PowerModelHost;
import org.cloudsimplus.provisioners.ResourceProvisioner;
import org.cloudsimplus.resources.FileStorage;
import org.cloudsimplus.resources.Pe;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;
import org.cloudsimplus.schedulers.vm.VmScheduler;
import org.cloudsimplus.vms.HostResourceStats;
import org.cloudsimplus.vms.Vm;

import java.util.Collections;
import java.util.List;
import java.util.Set;

final class GpuHostNull implements GpuHost {
    @Override
    public int compareTo(Host host) {
        return 0;
    }

    @Override
    public boolean addMigratingInVm(Vm vm) {
        return false;
    }

    @Override
    public Set<Vm> getVmsMigratingOut() {
        return Collections.emptySet();
    }

    @Override
    public boolean addVmMigratingOut(Vm vm) {
        return false;
    }

    @Override
    public boolean removeVmMigratingOut(Vm vm) {
        return false;
    }

    @Override
    public double getTotalAvailableMips() {
        return 0;
    }

    @Override
    public double getTotalAllocatedMips() {
        return 0;
    }

    @Override
    public Resource getBw() {
        return Resource.NULL;
    }

    @Override
    public ResourceProvisioner getBwProvisioner() {
        return ResourceProvisioner.NULL;
    }

    @Override
    public Host setBwProvisioner(ResourceProvisioner bwProvisioner) {
        return NULL;
    }

    @Override
    public Datacenter getDatacenter() {
        return Datacenter.NULL;
    }

    @Override
    public long getId() {
        return -1;
    }

    @Override
    public int getFreePesNumber() {
        return 0;
    }

    @Override
    public long getPesNumber() {
        return 0;
    }

    @Override
    public double getMips() {
        return 0;
    }

    @Override
    public List<Pe> getPeList() {
        return Collections.emptyList();
    }

    @Override
    public Resource getRam() {
        return Resource.NULL;
    }

    @Override
    public ResourceProvisioner getRamProvisioner() {
        return ResourceProvisioner.NULL;
    }

    @Override
    public Host setRamProvisioner(ResourceProvisioner ramProvisioner) {
        return NULL;
    }

    @Override
    public FileStorage getStorage() {
        return FileStorage.NULL;
    }

    @Override
    public double getTotalAllocatedMipsForVm(Vm vm) {
        return 0.0;
    }

    @Override
    public <T extends Vm> List<T> getVmCreatedList() {
        return Collections.emptyList();
    }

    @Override
    public List<Vm> getVmList() {
        return Collections.emptyList();
    }

    @Override
    public VmScheduler getVmScheduler() {
        return VmScheduler.NULL;
    }

    @Override
    public Host setVmScheduler(VmScheduler vmScheduler) {
        return NULL;
    }

    @Override
    public double getStartTime() {
        return -1;
    }

    @Override
    public Machine setStartTime(double startTime) {
        return this;
    }

    @Override
    public double getFirstStartTime() {
        return -1;
    }

    @Override
    public double getShutdownTime() {
        return 0;
    }

    @Override
    public void setShutdownTime(double v) {

    }

    @Override
    public boolean isFailed() {
        return false;
    }

    @Override
    public boolean isSuitableForVm(Vm vm) {
        return false;
    }

    @Override
    public HostSuitability getSuitabilityFor(Vm vm) {
        return HostSuitability.NULL;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean hasEverStarted() {
        return false;
    }

    @Override
    public Host setActive(boolean activate) {
        return this;
    }

    @Override
    public <T extends Vm> Set<T> getVmsMigratingIn() {
        return Collections.emptySet();
    }

    @Override
    public boolean hasMigratingVms() {
        return false;
    }

    @Override
    public void reallocateMigratingInVms() {/**/}

    @Override
    public void removeMigratingInVm(Vm vm) {/**/}

    @Override
    public void setDatacenter(Datacenter datacenter) {/**/}

    @Override
    public double updateProcessing(double currentTime) {
        return 0.0;
    }

    @Override
    public HostSuitability createVm(Vm vm) {
        return HostSuitability.NULL;
    }

    @Override
    public void destroyVm(Vm vm) {

    }

    @Override
    public HostSuitability createTemporaryVm(Vm vm) {
        return HostSuitability.NULL;
    }

    @Override
    public void destroyTemporaryVm(Vm vm) {

    }

    @Override
    public void destroyAllVms() {

    }

    @Override
    public Host addOnStartupListener(EventListener<HostEventInfo> listener) {
        return this;
    }

    @Override
    public boolean removeOnStartupListener(EventListener<HostEventInfo> listener) {
        return false;
    }

    @Override
    public Host addOnShutdownListener(EventListener<HostEventInfo> listener) {
        return this;
    }

    @Override
    public boolean removeOnShutdownListener(EventListener<HostEventInfo> listener) {
        return false;
    }

    @Override
    public boolean removeOnUpdateProcessingListener(EventListener<HostUpdatesVmsProcessingEventInfo> listener) {
        return false;
    }

    @Override
    public Host addOnUpdateProcessingListener(EventListener<HostUpdatesVmsProcessingEventInfo> listener) {
        return NULL;
    }

    @Override
    public long getAvailableStorage() {
        return 0L;
    }

    @Override
    public boolean setFailed(boolean failed) {
        return false;
    }

    @Override
    public Simulation getSimulation() {
        return Simulation.NULL;
    }

    @Override
    public double getLastBusyTime() {
        return 0;
    }

    @Override
    public boolean isIdle() {
        return true;
    }

    @Override
    public Host setSimulation(Simulation simulation) {
        return this;
    }

    @Override
    public ResourceProvisioner getProvisioner(Class<? extends ResourceManageable> clazz) {
        return ResourceProvisioner.NULL;
    }

    @Override
    public int getWorkingPesNumber() {
        return 0;
    }

    @Override
    public int getBusyPesNumber() {
        return 0;
    }

    @Override
    public double getBusyPesPercent(boolean hundredScale) {
        return 0;
    }

    @Override
    public double getBusyPesPercent() {
        return 0;
    }

    @Override
    public String toString() {
        return "Host.NULL";
    }

    @Override
    public Host setId(long id) {
        return this;
    }

    @Override
    public double getTotalMipsCapacity() {
        return 0.0;
    }

    @Override
    public int getFailedPesNumber() {
        return 0;
    }

    @Override
    public List<Pe> getWorkingPeList() {
        return Collections.emptyList();
    }

    @Override
    public List<Pe> getBusyPeList() {
        return Collections.emptyList();
    }

    @Override
    public List<Pe> getFreePeList() {
        return Collections.emptyList();
    }

    @Override
    public double getCpuPercentUtilization() {
        return 0.0;
    }

    @Override
    public double getCpuPercentRequested() {
        return 0;
    }

    @Override
    public double getCpuMipsUtilization() {
        return 0.0;
    }

    @Override
    public long getBwUtilization() {
        return 0;
    }

    @Override
    public long getRamUtilization() {
        return 0;
    }

    @Override
    public HostResourceStats getCpuUtilizationStats() {
        return new HostResourceStats(this, host -> 0.0);
    }

    @Override
    public void enableUtilizationStats() {/**/}

    @Override
    public PowerModelHost getPowerModel() {
        return PowerModelHost.NULL;
    }

    @Override
    public Host setPowerModel(PowerModelHost powerModel) {
        return this;
    }

    @Override
    public Host setStateHistoryEnabled(boolean enable) {
        return this;
    }

    @Override
    public boolean isStateHistoryEnabled() {
        return false;
    }

    @Override
    public List<HostStateHistoryEntry> getStateHistory() {
        return Collections.emptyList();
    }

    @Override
    public List<Vm> getFinishedVms() {
        return Collections.emptyList();
    }

    @Override
    public List<Vm> getMigratableVms() {
        return Collections.emptyList();
    }

    @Override
    public boolean isLazySuitabilityEvaluation() {
        return false;
    }

    @Override
    public Host setLazySuitabilityEvaluation(boolean lazySuitabilityEvaluation) {
        return this;
    }

    @Override
    public double getTotalUpTime() {
        return 0;
    }

    @Override
    public double getTotalUpTimeHours() {
        return 0;
    }

    @Override
    public double getUpTime() {
        return 0;
    }

    @Override
    public double getUpTimeHours() {
        return 0;
    }

    @Override
    public double getIdleShutdownDeadline() {
        return -1;
    }

    @Override
    public Host setIdleShutdownDeadline(double deadline) {
        return this;
    }

    @Override
    public List<ResourceManageable> getResources() {
        return Collections.emptyList();
    }


    @Override
    public Videocard getVideocard() {
        return Videocard.NULL;
    }

    @Override
    public boolean hasVideocard() {
        return false;
    }

    @Override
    public GpuHost setVideocard(Videocard videocard) {
        return this;
    }
}
