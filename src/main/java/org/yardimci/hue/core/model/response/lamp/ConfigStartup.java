package org.yardimci.hue.core.model.response.lamp;

public class ConfigStartup {
    private String mode;
    private boolean configured;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isConfigured() {
        return configured;
    }

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }
}
