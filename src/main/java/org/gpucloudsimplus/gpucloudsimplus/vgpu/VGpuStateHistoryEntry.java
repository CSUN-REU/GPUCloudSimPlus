package org.gpucloudsimplus.gpucloudsimplus.vgpu;

import org.cloudsimplus.vms.VmStateHistoryEntry;

public class VGpuStateHistoryEntry extends VmStateHistoryEntry {

    public VGpuStateHistoryEntry(final double time, final double allocatedMips,
                                 final double requestedMips, final boolean inMigration) {
        super(time, allocatedMips, requestedMips, inMigration);
    }
}
