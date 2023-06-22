package org.cloudbus.cloudsim.gp.hosts;


import org.cloudbus.cloudsim.gp.allocationpolicies.VGpuAllocationPolicy;
import org.cloudbus.cloudsim.gp.allocationpolicies.VGpuAllocationPolicySimple;
import org.cloudbus.cloudsim.gp.videocards.Videocard;
import org.cloudsimplus.core.AbstractMachine;
import org.cloudsimplus.hosts.HostSimple;
import org.cloudsimplus.provisioners.ResourceProvisioner;
import org.cloudsimplus.resources.HarddriveStorage;
import org.cloudsimplus.resources.Pe;
import org.cloudsimplus.util.BytesConversion;

import java.util.List;

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
