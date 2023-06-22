package org.cloudbus.cloudsim.gp.brokers;

import org.cloudsimplus.brokers.DatacenterBroker;
import org.cloudsimplus.vms.Vm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public interface GpuDatacenterBroker extends DatacenterBroker {
	Logger LOGGER = LoggerFactory.getLogger(DatacenterBroker.class.getSimpleName());

    GpuDatacenterBroker NULL = new GpuDatacenterBrokerNull();
    
    double DEF_GPUVM_DESTRUCTION_DELAY = -1.0;

    double DEF_VGPU_DESTRUCTION_DELAY = -1.0;

    boolean isRetryFailedVms();

    double getFailedVmsRetryDelay();

    void setFailedVmsRetryDelay (double failedVmsRetryDelay);

    Function<Vm, Double> getVmDestructionDelayFunction();

    //boolean bindGpuTaskToVGpu (GpuTask gpuTask, VGpu vgpu);
    
    //DatacenterBroker requestIdleVGpuDestruction(VGpu vgpu);
    
}
