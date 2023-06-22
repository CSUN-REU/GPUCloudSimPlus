package org.cloudbus.cloudsim.gp.schedulers.gpucloudlet;

import org.cloudsimplus.schedulers.cloudlet.CloudletScheduler;
import org.slf4j.Logger;
import java.io.Serializable;
import org.slf4j.LoggerFactory;


public interface GpuCloudletScheduler extends Serializable, CloudletScheduler {
	Logger LOGGER = LoggerFactory.getLogger(GpuCloudletScheduler.class.getSimpleName());

	GpuCloudletScheduler NULL = new GpuCloudletSchedulerNull();
	
	
}

