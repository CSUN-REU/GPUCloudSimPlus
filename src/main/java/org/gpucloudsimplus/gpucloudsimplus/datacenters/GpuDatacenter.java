package org.gpucloudsimplus.gpucloudsimplus.datacenters;

import org.cloudsimplus.datacenters.Datacenter;

public interface GpuDatacenter extends Datacenter {

    GpuDatacenter NULL = new GpuDatacenterNull();

}
