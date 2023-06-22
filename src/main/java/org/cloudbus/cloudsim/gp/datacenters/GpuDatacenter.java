package org.cloudbus.cloudsim.gp.datacenters;

import org.cloudbus.cloudsim.gp.allocationpolicies.GpuVmAllocationPolicy;
import org.cloudsimplus.allocationpolicies.VmAllocationPolicy;
import org.cloudsimplus.datacenters.Datacenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface GpuDatacenter extends Datacenter {

    GpuDatacenter NULL = new GpuDatacenterNull();

}
