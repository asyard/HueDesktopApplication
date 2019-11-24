package org.yardimci.hue.core.model.response.lamp;

public class LampControl {
    private int mindimlevel;
    private int maxlumen;
    private String colorgamuttype;
    private double[][] colorgamut;
    private Ct ct;

    public int getMindimlevel() {
        return mindimlevel;
    }

    public void setMindimlevel(int mindimlevel) {
        this.mindimlevel = mindimlevel;
    }

    public int getMaxlumen() {
        return maxlumen;
    }

    public void setMaxlumen(int maxlumen) {
        this.maxlumen = maxlumen;
    }

    public String getColorgamuttype() {
        return colorgamuttype;
    }

    public void setColorgamuttype(String colorgamuttype) {
        this.colorgamuttype = colorgamuttype;
    }

    public double[][] getColorgamut() {
        return colorgamut;
    }

    public void setColorgamut(double[][] colorgamut) {
        this.colorgamut = colorgamut;
    }

    public Ct getCt() {
        return ct;
    }

    public void setCt(Ct ct) {
        this.ct = ct;
    }
}
