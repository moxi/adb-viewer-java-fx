package com.rcgonzalezf.adbviewer.base;

public class AdbEnvironment {

    private String version;
    private boolean installed;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }
}
