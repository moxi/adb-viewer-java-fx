package com.rcgonzalezf.adbviewer.model;

import java.util.Map;

public class Device {

    private String deviceIdentifier;
    // Maybe send the user to fix with http://stackoverflow.com/a/25546300/799162
    private boolean unauthorized;
    private Map<String, String> qualifiers;

    public Map<String, String> getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(Map<String, String> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public boolean isUnauthorized() {
        return unauthorized;
    }

    public void setUnauthorized(boolean unauthorized) {
        this.unauthorized = unauthorized;
    }

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }
}
