package org.cloudbus.cloudsim.gp.allocationpolicies;

import org.cloudbus.cloudsim.gp.hosts.GpuHost;
import org.cloudsimplus.allocationpolicies.VmAllocationPolicy;
import org.cloudsimplus.autoscaling.VerticalVmScaling;
import org.cloudsimplus.datacenters.Datacenter;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.hosts.HostSuitability;
import org.cloudsimplus.vms.Vm;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

final class GpuVmAllocationPolicyNull implements GpuVmAllocationPolicy {

    @Override
    public Datacenter getDatacenter() {
        return Datacenter.NULL;
    }

    @Override
    public GpuVmAllocationPolicy setDatacenter(Datacenter datacenter) {
        return GpuVmAllocationPolicy.NULL;
    }

    @Override
    public HostSuitability allocateHostForVm(Vm vm) {
        return HostSuitability.NULL;
    }

    @Override
    public HostSuitability allocateHostForVm(Vm vm, Host host) {
        return HostSuitability.NULL;
    }

    @Override
    public <T extends Vm> List<T> allocateHostForVm(Collection<T> gpuvmCollection) {
        return Collections.emptyList();
    }

    @Override
    public boolean scaleVmVertically(VerticalVmScaling scaling) {
        return false;
    }

    @Override
    public void deallocateHostForVm(Vm vm) { /**/ }

    @Override
    public GpuVmAllocationPolicy setFindHostForVmFunction(
            BiFunction<VmAllocationPolicy, Vm, Optional<Host>> findGpuHostForGpuVmFunction) {
        return GpuVmAllocationPolicy.NULL;
    }

    @Override
    public List<GpuHost> getHostList() {
        return Collections.emptyList();
    }

    @Override
    public Map<Vm, Host> getOptimizedAllocationMap(List<? extends Vm> gpuvmList) {
        return Collections.emptyMap();
    }

    @Override
    public Optional<Host> findHostForVm(Vm vm) {
        return Optional.empty();
    }

    @Override
    public boolean isVmMigrationSupported() {
        return false;
    }

    @Override
    public int getHostCountForParallelSearch() {
        return 0;
    }

    @Override
    public GpuVmAllocationPolicy setHostCountForParallelSearch(int gpuHostCountForParallelSearch) {
        return GpuVmAllocationPolicy.NULL;
    }

}