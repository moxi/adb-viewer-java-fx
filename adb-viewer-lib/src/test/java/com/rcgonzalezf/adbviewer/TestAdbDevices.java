package com.rcgonzalezf.adbviewer;

import com.rcgonzalezf.adbviewer.common.StringResources;
import com.rcgonzalezf.adbviewer.model.Device;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rcgonzalezf.adbviewer.common.StringResources.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TestAdbDevices {

    private AdbDevices sut;
    private List<Device> devices;
    private Device selectedDevice;

    @Before
    public void setup() {
        sut = new AdbDevices();
        givenAdbServerRunning(true);
    }

    @Test
    public void shouldReturnNotConnectedIfAdbServerIsNotRunning() {
        givenAdbServerRunning(false);
        whenGettingListOfDevices();
        thenShouldReturnElements(0);
    }

    @Test
    public void shouldReturnEmptyIfNoDevicesAreAttached() {
        givenDevicesAttached(Collections.<Device>emptyList());
        whenGettingListOfDevices();
        thenShouldReturnElements(1);
        thenFirstElementShouldHaveContent(getString(adb_no_devices));
    }


    @Test
    public void shouldReturnListOfDevicesIfTheUserWantsToSeeTheList() {
        givenDevicesAttached(Arrays.asList(
                new Device(), new Device(), new Device()
        ));
        whenGettingListOfDevices();
        thenShouldReturnElements(3);
        thenFirstElementShouldHaveContent(getString(adb_no_devices));
    }

    @Test
    public void shouldReturnSelectedDeviceForPreviousSelectedDevice() {
        Device expected = new Device();
        givenDeviceSelected(expected);
        whenGettingSelectedDevice();
        thenShouldReturnDevice(expected);
    }

    private void thenShouldReturnDevice(Device expected) {
        assertEquals(expected, selectedDevice);
    }

    private void whenGettingSelectedDevice() {
        selectedDevice = sut.getSelectedDevice();
    }

    private void givenDeviceSelected(Device selected) {
        sut.markDeviceAsSelected(selected);
    }

    private void givenAdbServerRunning(boolean isRunning) {

    }

    private void givenDevicesAttached(List<Device> expectedDevices) {

    }

    private void whenGettingListOfDevices() {
        devices = sut.getDevices();
    }

    private void thenShouldReturnElements(int numberOfDevices) {
        assertEquals(devices.size(), numberOfDevices);
    }

    private void thenFirstElementShouldHaveContent(String adb_no_devices) {

    }
}
