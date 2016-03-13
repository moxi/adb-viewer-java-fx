package com.rcgonzalezf.adbviewer;

import com.rcgonzalezf.adbviewer.model.Device;

import java.util.List;

public class AdbDevices {

    private String command = "devices";
    private boolean serviceStarting;
    private List<Device> devices;
    private Device selectedDevice;

    public boolean isServiceStarting() {
        return serviceStarting;
    }

    public void setServiceStarting(boolean serviceStarting) {
        this.serviceStarting = serviceStarting;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void markDeviceAsSelected(Device selectedDevice) {
        this.selectedDevice = selectedDevice;
    }

    public Device getSelectedDevice() {
        return selectedDevice;
    }
}
