package org.cloudbus.cloudsim.gp.allocationpolicies;

import org.cloudbus.cloudsim.gp.vms.GpuVm;
import org.cloudsimplus.allocationpolicies.VmAllocationPolicy;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.vms.Vm;

import java.util.*;
import java.util.function.BiFunction;

import static java.util.Comparator.comparing;

public class GpuVmAllocationPolicySimple extends GpuVmAllocationPolicyAbstract{
	
	public GpuVmAllocationPolicySimple () {
        super();
    }

    public GpuVmAllocationPolicySimple (
    		final BiFunction<VmAllocationPolicy, Vm, Optional<Host>> findGpuHostForGpuVmFunction) {
        super(findGpuHostForGpuVmFunction);
    }

    @Override
    protected Optional<Host> defaultFindGpuHostForGpuVm (final GpuVm vm) {
        final Comparator<Host> comparator = comparing(Host::isActive).thenComparingLong(
        		Host::getFreePesNumber);

        final var hostStream = isParallelHostSearchEnabled() ? 
        		getHostList().stream().parallel() : getHostList().stream();
        return hostStream.filter(host -> host.isSuitableForVm(vm)).max(comparator);
    }
}

