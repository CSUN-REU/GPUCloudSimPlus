package org.gpucloudsimplus.gpucloudsimplus.cloudlets;

import org.cloudsimplus.brokers.DatacenterBroker;
import org.cloudsimplus.cloudlets.Cloudlet;
import org.cloudsimplus.core.ChangeableId;
import org.cloudsimplus.core.CustomerEntity;
import org.cloudsimplus.core.Simulation;
import org.cloudsimplus.datacenters.Datacenter;
import org.cloudsimplus.listeners.CloudletVmEventInfo;
import org.cloudsimplus.listeners.EventListener;
import org.cloudsimplus.resources.ResourceManageable;
import org.cloudsimplus.utilizationmodels.UtilizationModel;
import org.cloudsimplus.vms.Vm;
import org.gpucloudsimplus.gpucloudsimplus.cloudlets.gputasks.GpuTask;
import org.gpucloudsimplus.gpucloudsimplus.datacenters.GpuDatacenter;
import org.gpucloudsimplus.gpucloudsimplus.vms.GpuVm;

import java.util.Collections;
import java.util.List;

public class GpuCloudletNull implements GpuCloudlet {

    @Override
    public ChangeableId setId(long id) {
        return null;
    }

    @Override
    public long getId() {
        return -1;
    }

    @Override
    public String getUid() {
        return "";
    }

    @Override
    public boolean addRequiredFile(String fileName) {
        return false;
    }

    @Override
    public boolean addRequiredFiles(List<String> fileNames) {
        return false;
    }

    @Override
    public boolean deleteRequiredFile(String filename) {
        return false;
    }

    @Override
    public double getArrivalTime() {
        return -1;
    }

    @Override
    public double getActualCpuTime() {
        return 0.0;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public long getFileSize() {
        return 0L;
    }

    @Override
    public long getFinishedLengthSoFar() {
        return 0L;
    }

    @Override
    public long getLength() {
        return 0L;
    }

    @Override
    public long getOutputSize() {
        return 0L;
    }

    @Override
    public long getTotalLength() {
        return 0L;
    }

    @Override
    public double getExecStartTime() {
        return 0.0;
    }

    @Override
    public double getFinishTime() {
        return 0.0;
    }

    @Override
    public int getNetServiceLevel() {
        return 0;
    }

    @Override
    public long getPesNumber() {
        return 0;
    }

    @Override
    public List<String> getRequiredFiles() {
        return Collections.emptyList();
    }

    @Override
    public Status getStatus() {
        return Status.FAILED;
    }

    @Override
    public boolean isReturnedToBroker() {
        return false;
    }

    @Override
    public long getJobId() {
        return 0;
    }

    @Override
    public Cloudlet setJobId(long jobId) {
        return null;
    }

    @Override
    public UtilizationModel getUtilizationModelBw() {
        return UtilizationModel.NULL;
    }

    @Override
    public UtilizationModel getUtilizationModelCpu() {
        return UtilizationModel.NULL;
    }

    @Override
    public UtilizationModel getUtilizationModelRam() {
        return UtilizationModel.NULL;
    }

    @Override
    public UtilizationModel getUtilizationModel(
            Class<? extends ResourceManageable> resourceClass) {
        return UtilizationModel.NULL;
    }

    @Override
    public double getUtilizationOfBw() {
        return 0;
    }

    @Override
    public double getUtilizationOfBw(double time) {
        return 0.0;
    }

    @Override
    public double getUtilizationOfCpu() {
        return 0;
    }

    @Override
    public double getUtilizationOfCpu(double time) {
        return 0.0;
    }

    @Override
    public double getUtilizationOfRam() {
        return 0;
    }

    @Override
    public double getUtilizationOfRam(double time) {
        return 0.0;
    }

    @Override
    public GpuVm getVm() {
        return GpuVm.NULL;
    }

    @Override
    public double getWaitingTime() {
        return 0.0;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean hasRequiresFiles() {
        return false;
    }

    @Override
    public GpuCloudlet setPriority(int priority) {
        return this;
    }

    @Override
    public GpuCloudlet setLength(long length) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setFileSize(long fileSize) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setOutputSize(long outputSize) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setSizes(long size) {
        return this;
    }

    @Override
    public boolean setStatus(Status newStatus) {
        return false;
    }

    @Override
    public Cloudlet setNetServiceLevel(int netServiceLevel) {
        return GpuCloudlet.NULL;
    }

    @Override
    public Cloudlet setPesNumber(long l) {
        return null;
    }

    @Override
    public CustomerEntity setBroker(DatacenterBroker broker) {/**/
        return null;
    }

    @Override
    public DatacenterBroker getBroker() {
        return DatacenterBroker.NULL;
    }

    @Override
    public GpuCloudlet setUtilizationModel(UtilizationModel utilizationModel) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setUtilizationModelBw(UtilizationModel utilizationModelBw) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setUtilizationModelCpu(UtilizationModel utilizationModelCpu) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setUtilizationModelRam(UtilizationModel utilizationModelRam) {
        return GpuCloudlet.NULL;
    }

    @Override
    public GpuCloudlet setVm(Vm vm) {
        return GpuCloudlet.NULL;
    }

    @Override
    public void notifyOnUpdateProcessingListeners(double time) {/**/}

    @Override
    public Simulation getSimulation() {
        return Simulation.NULL;
    }

    @Override
    public CustomerEntity setLastTriedDatacenter(Datacenter lastTriedDatacenter) {
        return null;
    }

    @Override
    public GpuDatacenter getLastTriedDatacenter() {
        return GpuDatacenter.NULL;
    }

    @Override
    public double getArrivedTime() {
        return 0;
    }

    @Override
    public void setArrivedTime(double time) { /**/ }

    @Override
    public double getCreationTime() {
        return 0;
    }

    @Override
    public double getWaitTime() {
        return 0;
    }

    @Override
    public double getSubmissionDelay() {
        return 0;
    }

    @Override
    public boolean isDelayed() {
        return false;
    }

    @Override
    public void setSubmissionDelay(double submissionDelay) {/**/}

    @Override
    public boolean isBoundToVm() {
        return false;
    }

    @Override
    public int compareTo(Cloudlet cloudlet) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cloudlet.NULL";
    }

    @Override
    public boolean addFinishedLengthSoFar(long partialFinishedMI) {
        return false;
    }

    @Override
    public void setExecStartTime(double clockTime) {/**/}

    @Override
    public Cloudlet addOnStartListener(org.cloudsimplus.listeners.EventListener<CloudletVmEventInfo> eventListener) {
        return null;
    }

    @Override
    public boolean removeOnStartListener(org.cloudsimplus.listeners.EventListener<CloudletVmEventInfo> eventListener) {
        return false;
    }

    @Override
    public Cloudlet addOnUpdateProcessingListener(org.cloudsimplus.listeners.EventListener<CloudletVmEventInfo> eventListener) {
        return GpuCloudlet.NULL;
    }

    @Override
    public boolean removeOnUpdateProcessingListener(org.cloudsimplus.listeners.EventListener<CloudletVmEventInfo> eventListener) {
        return false;
    }

    @Override
    public Cloudlet addOnFinishListener(EventListener<CloudletVmEventInfo> eventListener) {
        return GpuCloudlet.NULL;
    }

    @Override
    public boolean removeOnFinishListener(EventListener<CloudletVmEventInfo> eventListener) {
        return false;
    }

    @Override
    public double registerArrivalInDatacenter() {
        return -1;
    }

    @Override
    public GpuCloudlet reset() {
        return this;
    }

    @Override
    public GpuCloudlet setLifeTime(final double lifeTime) {
        return this;
    }

    @Override
    public double getLifeTime() {
        return -1;
    }

    @Override
    public GpuCloudlet setGpuTask(GpuTask gpuTask) {
        return this;
    }

    @Override
    public GpuTask getGpuTask() {
        return GpuTask.NULL;
    }

}
