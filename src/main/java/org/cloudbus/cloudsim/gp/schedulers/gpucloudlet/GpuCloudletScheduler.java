package org.cloudbus.cloudsim.gp.schedulers.gpucloudlet;

import org.cloudsimplus.schedulers.cloudlet.CloudletScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public interface GpuCloudletScheduler extends Serializable, CloudletScheduler {
	Logger LOGGER = LoggerFactory.getLogger(GpuCloudletScheduler.class.getSimpleName());

	GpuCloudletScheduler NULL = new GpuCloudletSchedulerNull();
	
	
}

