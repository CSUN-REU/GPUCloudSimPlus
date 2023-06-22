package org.cloudbus.cloudsim.gp.cloudlets;

import org.cloudbus.cloudsim.gp.cloudlets.gputasks.GpuTask;
import org.cloudsimplus.cloudlets.Cloudlet;

import java.util.EventListener;

public interface GpuCloudlet extends Cloudlet {
	GpuCloudlet NULL = new GpuCloudletNull();

	GpuCloudlet setGpuTask (GpuTask gpuTask);
	
	GpuTask getGpuTask ();
}
