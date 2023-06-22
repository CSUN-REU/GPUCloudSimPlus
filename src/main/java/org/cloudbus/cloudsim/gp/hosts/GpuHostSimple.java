package org.cloudbus.cloudsim.gp.hosts;


import org.cloudsimplus.core.AbstractMachine;
import org.cloudsimplus.core.ResourceStatsComputer;
import org.cloudsimplus.hosts.Host;
import org.cloudsimplus.hosts.HostSimple;
import org.cloudsimplus.hosts.HostStateHistoryEntry;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.listeners.HostEventInfo;
import org.cloudsimplus.listeners.HostUpdatesVmsProcessingEventInfo;

import org.cloudbus.cloudsim.gp.vms.GpuVm;
import org.cloudbus.cloudsim.gp.resources.Gpu;
import org.cloudbus.cloudsim.gp.vms.GpuVmSimple;
import org.cloudbus.cloudsim.gp.videocards.Videocard;
import org.cloudbus.cloudsim.gp.datacenters.GpuDatacenter;
import org.cloudbus.cloudsim.gp.videocards.VideocardSimple;
import org.cloudbus.cloudsim.gp.datacenters.GpuDatacenterSimple;
import org.cloudbus.cloudsim.gp.allocationpolicies.VGpuAllocationPolicy;
import org.cloudbus.cloudsim.gp.allocationpolicies.VGpuAllocationPolicySimple;
import org.cloudsimplus.power.models.PowerModelHost;
import org.cloudsimplus.provisioners.ResourceProvisioner;
import org.cloudsimplus.resources.FileStorage;
import org.cloudsimplus.resources.HarddriveStorage;
import org.cloudsimplus.resources.Pe;
import org.cloudsimplus.resources.Ram;
import org.cloudsimplus.resources.Resource;
import org.cloudsimplus.resources.ResourceManageable;
import org.cloudsimplus.schedulers.MipsShare;
import org.cloudsimplus.util.BytesConversion;
import org.cloudsimplus.util.TimeUtil;
import org.cloudsimplus.vms.HostResourceStats;
import org.cloudsimplus.vms.Vm;
import org.cloudsimplus.vms.VmStateHistoryEntry;

import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static org.cloudbus.cloudsim.gp.hosts.GpuHost.DEF_IDLE_SHUTDOWN_DEADLINE;

//  extends HostSimple 
public class GpuHostSimple extends HostSimple implements GpuHost {
	
	private static long defaultRamCapacity = (long) BytesConversion.gigaToMega(10);
    private static long defaultBwCapacity = 1000;
    private static long defaultStorageCapacity = (long) BytesConversion.gigaToMega(500);
    
	private Videocard videocard;
	
	public GpuHostSimple (final List<Pe> peList, final Videocard videocard) {
        this(peList, videocard, true);
    }
	
    public GpuHostSimple (final List<Pe> peList, final Videocard videocard, final boolean activate) {
    	
        this(defaultRamCapacity, defaultBwCapacity, defaultStorageCapacity, peList, videocard, activate,
        		new VGpuAllocationPolicySimple());
    }

    public GpuHostSimple (final ResourceProvisioner ramProvisioner,
    		final ResourceProvisioner bwProvisioner, final long storage, final List<Pe> peList,
    		final Videocard videocard, final VGpuAllocationPolicy vgpuAllocationPolicyfinal) {
    	
        this(ramProvisioner.getCapacity(), bwProvisioner.getCapacity(), storage, peList, videocard);
        setVideocard(videocard);
        setRamProvisioner(ramProvisioner);
        setBwProvisioner(bwProvisioner);
        getPeList().addAll(peList);
        this.videocard.setVGpuAllocationPolicy(vgpuAllocationPolicyfinal);
        
    }

    public GpuHostSimple (final long ram, final long bw, final long storage, final List<Pe> peList,
    		final Videocard videocard) {
        this(ram, bw, new HarddriveStorage(storage), peList, videocard);
    }

    public GpuHostSimple ( final long ram, final long bw, final HarddriveStorage storage, 
    		final List<Pe> peList, final Videocard videocard) {
    	//super(ram, bw, storage, peList);
        this(ram, bw, storage, peList, true);
        setVideocard (videocard);
    }

    public GpuHostSimple (final long ram, final long bw, final long storage,
    		final List<Pe> peList, final Videocard videocard, boolean activate, 
    		final VGpuAllocationPolicy vgpuAllocationPolicyfinal) {
    	//super(ram, bw, storage, peList, activate);
        this(ram, bw, new HarddriveStorage(storage), peList, activate);
        setVideocard (videocard);
        this.videocard.setVGpuAllocationPolicy(vgpuAllocationPolicyfinal);
    }

    private GpuHostSimple(final long ram, final long bw, final HarddriveStorage storage,
            final List<Pe> peList, final boolean activate) {
    	super(ram, bw, storage.getCapacity(), peList, activate);
	}

    public static long getDefaultRamCapacity() {
        return defaultRamCapacity;
    }

    public static void setDefaultRamCapacity(final long defaultCapacity) {
        AbstractMachine.validateCapacity(defaultCapacity);
        defaultRamCapacity = defaultCapacity;
    }

    public static long getDefaultBwCapacity() {
        return defaultBwCapacity;
    }

    public static void setDefaultBwCapacity(final long defaultCapacity) {
        AbstractMachine.validateCapacity(defaultCapacity);
        defaultBwCapacity = defaultCapacity;
    }

    public static long getDefaultStorageCapacity() {
        return defaultStorageCapacity;
    }

    public static void setDefaultStorageCapacity(final long defaultCapacity) {
        AbstractMachine.validateCapacity(defaultCapacity);
        defaultStorageCapacity = defaultCapacity;
    }

	@Override
	public Videocard getVideocard () {
		return videocard;
	}
	
	@Override
	public boolean hasVideocard () {
		return getVideocard() != null;
	}
	
	@Override
	public GpuHost setVideocard (Videocard videocard) {
		this.videocard = videocard;
		if (!videocard.hasGpuHost())
			videocard.setHost(this);
		setUpVideocardSimulation ();
		return this;
	}
	
	protected void setUpVideocardSimulation () {
		this.videocard.setSimulation (this.getSimulation());
	}

}
