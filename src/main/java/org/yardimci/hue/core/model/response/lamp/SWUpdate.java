package org.yardimci.hue.core.model.response.lamp;

public class SWUpdate {
    private String state;
    private String lastinstall;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastinstall() {
        return lastinstall;
    }

    public void setLastinstall(String lastinstall) {
        this.lastinstall = lastinstall;
    }
}
