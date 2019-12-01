package org.yardimci.hue.core.model.response.lamp;

public class LampState {
    private boolean on;

    //The parameters 'hue' and 'sat' are used to set the colour
    //The 'hue' parameter has the range 0-65535 so represents approximately 182*degrees (technically 182.04 but the difference is imperceptible)
    //Philips Hue API uses values of 0–255 for brightness and saturation
    //The hue value is a wrapping value between 0 and 65535. Both 0 and 65535 are red, 25500 is green and 46920 is blue.
    //e.g. “hue”: 50000 will set the light to a specific hue.
    private int bri;
    private int hue;
    private int sat;
    private String effect;
    private double[] xy;
    private int ct;
    private String alert;
    private String colormode;
    private String mode;
    private boolean reachable;

    public double[] getXy() {
        return xy;
    }

    public void setXy(double[] xy) {
        this.xy = xy;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getBri() {
        return bri;
    }

    public void setBri(int bri) {
        this.bri = bri;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getColormode() {
        return colormode;
    }

    public void setColormode(String colormode) {
        this.colormode = colormode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }
}
