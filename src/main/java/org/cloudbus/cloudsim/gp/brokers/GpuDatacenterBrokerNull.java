package org.cloudbus.cloudsim.gp.brokers;

import org.cloudbus.cloudsim.gp.datacenters.GpuDatacenter;
import org.cloudsimplus.brokers.DatacenterBroker;
import org.cloudsimplus.brokers.VmCreation;
import org.cloudsimplus.cloudlets.Cloudlet;
import org.cloudsimplus.core.SimEntity;
import org.cloudsimplus.core.SimEntityNullBase;
import org.cloudsimplus.datacenters.Datacenter;
import org.cloudsimplus.listeners.DatacenterBrokerEventInfo;
import org.cloudsimplus.listeners.EventInfo;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.vms.Vm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

final class GpuDatacenterBrokerNull implements GpuDatacenterBroker, SimEntityNullBase {
	
	@Override public int compareTo (SimEntity entity) { return 0; }
    @Override public boolean bindCloudletToVm (Cloudlet cloudlet, Vm vm) {
        return false;
    }
    @Override public <T extends Cloudlet> List<T> getCloudletWaitingList () {
        return Collections.emptyList();
    }
    @Override public <T extends Cloudlet> List<T> getCloudletFinishedList () {
        return Collections.emptyList();
    }
    @Override public Vm getWaitingVm (int index) {
        return Vm.NULL;
    }
    @Override public <T extends Vm> List<T> getVmWaitingList () {
        return Collections.emptyList();
    }
    @Override public <T extends Vm> List<T> getVmExecList () {
        return Collections.emptyList();
    }
    @Override public int getVmsNumber () { return 0; }
    @Override public GpuDatacenterBroker requestIdleVmDestruction (Vm vm) { return this; }
    @Override public void requestShutdownWhenIdle () {/**/}
    @Override public List<Cloudlet> destroyVm (Vm vm) { return Collections.emptyList(); }
    @Override public <T extends Vm> List<T> getVmCreatedList () { return Collections.emptyList(); }
    @Override public GpuDatacenterBroker setDatacenterMapper (
    		BiFunction<Datacenter, Vm, Datacenter> datacenterMapper) { return this; }
    @Override public GpuDatacenterBroker setVmMapper (Function<Cloudlet, Vm> vmMapper) { return this; }
    @Override public GpuDatacenterBroker setSelectClosestDatacenter (boolean select) { return this; }
    @Override public boolean isSelectClosestDatacenter () { return false; }
    @Override public List<Cloudlet> getCloudletCreatedList () { return Collections.emptyList(); }
    @Override public GpuDatacenterBroker addOnVmsCreatedListener (
    		EventListener<DatacenterBrokerEventInfo> listener) { return this; }
    @Override public GpuDatacenterBroker removeOnVmsCreatedListener (
    		EventListener<? extends EventInfo> listener) { return this; }
    @Override public GpuDatacenterBroker setVmDestructionDelayFunction (
    		Function<Vm, Double> function) { return this; }
    @Override public GpuDatacenterBroker setVmDestructionDelay (double delay) { return this; }
    @Override public List<Cloudlet> getCloudletSubmittedList () { return Collections.emptyList(); }
    @Override public <T extends Vm> List<T> getVmFailedList () { return Collections.emptyList(); }

    @Override
    public VmCreation getVmCreation() {
        return VmCreation.ofZero();
    }

    @Override
    public DatacenterBroker setLastSelectedDc(Datacenter datacenter) {
        return GpuDatacenterBroker.NULL;
    }

    @Override
    public Datacenter getLastSelectedDc() {
        return GpuDatacenter.NULL;
    }

    @Override public boolean isShutdownWhenIdle () { return false; }
    @Override public GpuDatacenterBroker setShutdownWhenIdle (boolean shutdownWhenIdle) { 
    	return this; 
    }
    @Override public GpuDatacenterBroker setVmComparator (Comparator<Vm> comparator) { return this; }
    @Override public DatacenterBroker setCloudletComparator (Comparator<Cloudlet> comparator) { return GpuDatacenterBroker.NULL; }
    @Override public GpuDatacenterBroker submitCloudlet (Cloudlet cloudlet) { return this; }
    @Override public GpuDatacenterBroker submitCloudletList (
    		List<? extends Cloudlet> list) { return this; }
    @Override public GpuDatacenterBroker submitCloudletList (
    		List<? extends Cloudlet> list, double submissionDelay) { return this; }
    @Override public GpuDatacenterBroker submitCloudletList (
    		List<? extends Cloudlet> list, Vm vm) { return this; }
    @Override public GpuDatacenterBroker submitCloudletList (
    		List<? extends Cloudlet> list, Vm vm, double submissionDelay) { return this; }
    @Override public GpuDatacenterBroker submitVm (Vm vm) { return this; }
    @Override public GpuDatacenterBroker submitVmList (List<? extends Vm> list) { return this; }
    @Override public GpuDatacenterBroker submitVmList (
    		List<? extends Vm> list, double submissionDelay) { return this; }
    @Override public double getStartTime() { return -1; }

    @Override
    public boolean isRetryFailedVms() {
        return false;
    }

    @Override
    public double getFailedVmsRetryDelay() {
        return 0;
    }

    @Override
    public void setFailedVmsRetryDelay(double failedVmsRetryDelay) {
        /**/
    }

    @Override
    public Function<Vm, Double> getVmDestructionDelayFunction() {
        return null;
    }
}