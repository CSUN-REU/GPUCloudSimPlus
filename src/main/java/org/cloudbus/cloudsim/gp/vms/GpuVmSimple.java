package org.cloudbus.cloudsim.gp.vms;

import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudbus.cloudsim.core.CustomerEntityAbstract;

import org.cloudbus.cloudsim.gp.resources.CustomVGpu;
import org.cloudbus.cloudsim.gp.schedulers.gpucloudlet.GpuCloudletScheduler;

public class GpuVmSimple extends VmSimple implements GpuVm {
	
	private String type;
	
	private CustomVGpu vgpu;
	
	//private double arrivalTime;
	
	public GpuVmSimple (final Vm sourceVm, String type) {
		super (sourceVm);
		setType (type);
	}
	
	public GpuVmSimple (final double mipsCapacity, final long numberOfPes, String type) {
		super (mipsCapacity, numberOfPes);
		setType (type);
	}
	
	public GpuVmSimple (final double mipsCapacity, final long numberOfPes, 
			final GpuCloudletScheduler cloudletScheduler, String type) {
        super (mipsCapacity, numberOfPes, cloudletScheduler);
        setCloudletScheduler (cloudletScheduler);
        setType (type);
	
	}
	
	public GpuVmSimple (final long id, final double mipsCapacity, final long numberOfPes, 
			String type) {
        super (id,  mipsCapacity, numberOfPes);
        setType (type);
	}

	public GpuVmSimple (final long id, final long mipsCapacity, final long numberOfPes,
			String type) {
		super (id, mipsCapacity, numberOfPes);
        setType (type);
	}

	@Override
	public void setType (String type) {
		this.type = type;
	}
	
	@Override
	public String getType () {
		return type;
	}
	
	@Override
	public GpuVmSimple setVGpu (CustomVGpu vgpu) {
		this.vgpu = vgpu;
		if (vgpu.getGpuVm () == null)
			vgpu.setGpuVm (this);
		return this;
	}
	
	@Override
	public CustomVGpu getVGpu () {
		return vgpu;
	}
	
	@Override
	public boolean hasVGpu () {
		return getVGpu() != null;
	}
}