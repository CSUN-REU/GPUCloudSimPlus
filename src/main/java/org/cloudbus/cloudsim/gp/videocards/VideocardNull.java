package org.cloudbus.cloudsim.gp.videocards;

import java.util.*;
import java.util.stream.Stream;

import org.cloudbus.cloudsim.gp.allocationpolicies.VGpuAllocationPolicy;
import org.gpucloudsimplus.listeners.VideocardVGpuMigrationEventInfo;
import org.cloudbus.cloudsim.gp.provisioners.VideocardBwProvisioner;
import org.cloudbus.cloudsim.gp.resources.Gpu;
import org.cloudbus.cloudsim.gp.vgpu.VGpu;

import org.cloudsimplus.listeners.EventListener;
import org.gpucloudsimplus.listeners.GpuEventInfo;

public class VideocardNull implements Videocard {

	/*@Override public long getId () {
		return -1;
	}
	
	@Override public void setId (long id) {}
	
	@Override public String getType () { return "";}
	
	@Override public void setType (String type) {}
	
	@Override public VGpuScheduler getVGpuScheduler () {
		return VGpuScheduler.NULL;
	}
	
	@Override public Videocard setVGpuScheduler (VGpuScheduler vgpuScheduler) {
		return this;
	}*/
	
	@Override public VideocardBwProvisioner getPcieBwProvisioner () {
		return VideocardBwProvisioner.NULL;
	}
	@Override public Videocard setPcieBwProvisioner (VideocardBwProvisioner pcieBwProvisioner) {
		return this;
	}
	@Override public VGpuAllocationPolicy getVGpuAllocationPolicy () { 
		return VGpuAllocationPolicy.NULL;
	}
	@Override public Videocard setVGpuAllocationPolicy (VGpuAllocationPolicy vgpuAllocationPolicy) {
		return this;
	}
	@Override public void requestVGpuMigration (VGpu sourceVGpu, Gpu targetGpu) { /**/ }
	@Override public void requestVGpuMigration (VGpu sourceVGpu) { /**/ }
	@Override public List<Gpu> getGpuList () { return Collections.emptyList(); }
	@Override public Stream<? extends Gpu> getActiveGpuStream () { return Stream.empty(); }
	@Override public Gpu getGpu(int index) { return Gpu.NULL; }
	@Override public long getActiveGpusNumber () { return 0; }
	@Override public long size () { return 0; }
	@Override public Gpu getGpuById (long id) { return Gpu.NULL; }
	@Override public <T extends Gpu> Videocard addGpuList(List<T> gpuList) {
		return this;
	}
	@Override public <T extends Gpu> Videocard addGpu (T gpu) { return this; }
	@Override public <T extends Gpu> Videocard removeGpu (T gpu) { return this; }
	@Override public double getSchedulingInterval () { return 0.0; }
	@Override public Videocard setSchedulingInterval (double schedulingInterval) {
		return this;
	}
	@Override public double getBandwidthPercentForMigration () { return 0.0; }
	@Override public void setBandwidthPercentForMigration (double bandwidthPercentForMigration) { /**/ }

	@Override public Videocard addOnGpuAvailableListener (EventListener<GpuEventInfo> listener) {
		return this;
	}

	@Override
	public Videocard addOnVGpuMigrationFinishListener (
			EventListener<VideocardVGpuMigrationEventInfo> listener) { return this; }
	@Override public boolean isMigrationsEnabled () { return false; }
	@Override public Videocard enableMigrations () { return this; } 
	@Override public Videocard disableMigrations () { return this; }
	@Override public double getGpuSearchRetryDelay () { return 0.0; }
	@Override public Videocard setGpuSearchRetryDelay (double delay) { return this; }
}

