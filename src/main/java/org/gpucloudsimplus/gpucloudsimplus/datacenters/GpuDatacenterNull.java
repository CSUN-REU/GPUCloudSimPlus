package org.gpucloudsimplus.gpucloudsimplus.datacenters;

import org.gpucloudsimplus.gpucloudsimplus.allocationpolicies.GpuVmAllocationPolicy;
import org.gpucloudsimplus.gpucloudsimplus.hosts.GpuHost;
import org.cloudsimplus.core.SimEntity;
import org.cloudsimplus.core.SimEntityNullBase;
import org.cloudsimplus.datacenters.Datacenter;
import org.cloudsimplus.datacenters.DatacenterCharacteristics;
import org.cloudsimplus.datacenters.TimeZoned;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.listeners.DatacenterVmMigrationEventInfo;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.listeners.HostEventInfo;
import org.cloudsimplus.power.PowerAware;
import org.cloudsimplus.power.models.PowerModelDatacenter;
import org.cloudsimplus.resources.DatacenterStorage;
import org.cloudsimplus.vms.Vm;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

final class GpuDatacenterNull implements GpuDatacenter, SimEntityNullBase {

    private static final DatacenterStorage STORAGE = new DatacenterStorage();

    @Override
    public void requestVmMigration(Vm sourceVm, Host targetHost) { /**/ }

    @Override
    public void requestVmMigration(Vm sourceVm) { /**/ }

    @Override
    public <T extends Host> List<T> getHostList() {
        return Collections.emptyList();
    }

    @Override
    public Stream<? extends Host> getActiveHostStream() {
        return Stream.empty();
    }

    @Override
    public Host getHost(int index) {
        return GpuHost.NULL;
    }

    @Override
    public long getActiveHostsNumber() {
        return 0;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Host getHostById(long id) {
        return GpuHost.NULL;
    }

    @Override
    public <T extends Host> Datacenter addHostList(List<T> hostList) {
        return this;
    }

    @Override
    public <T extends Host> Datacenter addHost(T host) {
        return this;
    }

    @Override
    public <T extends Host> Datacenter removeHost(T host) {
        return this;
    }

    @Override
    public double getSchedulingInterval() {
        return 0;
    }

    @Override
    public Datacenter setSchedulingInterval(double schedulingInterval) {
        return this;
    }

    @Override
    public DatacenterCharacteristics getCharacteristics() {
        return DatacenterCharacteristics.NULL;
    }

    @Override
    public Datacenter setCharacteristics(DatacenterCharacteristics datacenterCharacteristics) {
        return null;
    }

    @Override
    public DatacenterStorage getDatacenterStorage() {
        return STORAGE;
    }

    @Override
    public void setDatacenterStorage(DatacenterStorage datacenterStorage) { /**/ }

    @Override
    public double getBandwidthPercentForMigration() {
        return 0;
    }

    @Override
    public void setBandwidthPercentForMigration(double bandwidthPercentForMigration) {
        /**/
    }

    @Override
    public Datacenter addOnHostAvailableListener(EventListener<HostEventInfo> listener) {
        return this;
    }

    @Override
    public Datacenter addOnVmMigrationFinishListener(
            EventListener<DatacenterVmMigrationEventInfo> listener) {
        return this;
    }

    @Override
    public boolean isMigrationsEnabled() {
        return false;
    }

    @Override
    public Datacenter enableMigrations() {
        return this;
    }

    @Override
    public Datacenter disableMigrations() {
        return this;
    }

    @Override
    public double getHostSearchRetryDelay() {
        return 0;
    }

    @Override
    public Datacenter setHostSearchRetryDelay(double delay) {
        return this;
    }

    @Override
    public int compareTo(SimEntity o) {
        return 0;
    }

    @Override
    public PowerModelDatacenter getPowerModel() {
        return PowerModelDatacenter.NULL;
    }

    @Override
    public PowerAware<PowerModelDatacenter> setPowerModel(PowerModelDatacenter powerModel) { /**/
        return null;
    }

    @Override
    public double getTimeZone() {
        return Integer.MAX_VALUE;
    }

    @Override
    public TimeZoned setTimeZone(double timeZone) {
        return this;
    }

    @Override
    public GpuVmAllocationPolicy getVmAllocationPolicy() {
        return GpuVmAllocationPolicy.NULL;
    }

}
