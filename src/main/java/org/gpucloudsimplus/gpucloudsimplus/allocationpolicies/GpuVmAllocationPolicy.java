package org.gpucloudsimplus.gpucloudsimplus.allocationpolicies;

import org.cloudsimplus.allocationpolicies.VmAllocationPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// extends VmAllocationPolicy
public interface GpuVmAllocationPolicy extends VmAllocationPolicy {

    Logger LOGGER = LoggerFactory.getLogger(GpuVmAllocationPolicy.class.getSimpleName());

    int DEF_GPUHOST_COUNT_PARALLEL_SEARCH = 20_000;

    GpuVmAllocationPolicy NULL = new GpuVmAllocationPolicyNull();
    
    /*GpuDatacenter getGpuDatacenter ();

    void setGpuDatacenter (GpuDatacenter datacenter);

    HostSuitability allocateGpuHostForGpuVm (GpuVm vm);

    HostSuitability allocateGpuHostForGpuVm (GpuVm vm, GpuHost host);

    <T extends GpuVm> List<T> allocateGpuHostForGpuVm (Collection<T> gpuvmCollection);

    boolean scaleGpuVmVertically (VerticalVmScaling scaling);

    void deallocateGpuHostForGpuVm (GpuVm vm);

    void setFindGpuHostForGpuVmFunction (
    		BiFunction<GpuVmAllocationPolicy, GpuVm, Optional<GpuHost>> findGpuHostForGpuVmFunction);

    <T extends GpuHost> List<T> getGpuHostList ();

    Map<GpuVm, GpuHost> getOptimizedAllocationMap (List<? extends GpuVm> gpuvmList);

    Optional<GpuHost> findGpuHostForGpuVm (GpuVm vm);

    boolean isGpuVmMigrationSupported ();

    default boolean isParallelGpuHostSearchEnabled (){
        return getGpuHostList().size() >= getGpuHostCountForParallelSearch();
    }

    int getGpuHostCountForParallelSearch ();

    void setGpuHostCountForParallelSearch (int gpuHostCountForParallelSearch);*/
}
