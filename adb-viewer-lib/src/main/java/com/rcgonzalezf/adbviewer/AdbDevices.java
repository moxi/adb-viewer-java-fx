package com.rcgonzalezf.adbviewer;

import com.rcgonzalezf.adbviewer.base.AdbCommandRunner;
import com.rcgonzalezf.adbviewer.base.CommandListener;
import com.rcgonzalezf.adbviewer.model.Device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdbDevices implements CommandListener<String, IOException>{

    private final String command;
    private final List<String> params;
    private boolean serviceStarting;
    private List<Device> devices;
    private Device selectedDevice;

    public AdbDevices() {
        command = "devices";
        params = new ArrayList<>();
        params.add("-l");
        populateDevices();
    }

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

    @Override
    public void onSuccess(String successType) {

    }

    @Override
    public void onFailure(IOException failureType) {

    }


    private void populateDevices() {
        new AdbCommandRunner(this, command, params).execute();
    }
}
