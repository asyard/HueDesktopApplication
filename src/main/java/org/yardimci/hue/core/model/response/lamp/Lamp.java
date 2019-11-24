package org.yardimci.hue.core.model.response.lamp;

public class Lamp {
    private LampState state;
    private SWUpdate swupdate;
    private String type;
    private String name;
    private String modelid;
    private String manufacturername;
    private String productname;
    private LampCapabilities capabilities;
    private LampConfig config;
    private String uniqueid;
    private String swversion;
    private String swconfigid;
    private String productid;

    // <editor-fold defaultstate="collapsed" desc="getter-setters">
    public LampState getState() {
        return state;
    }

    public void setState(LampState state) {
        this.state = state;
    }

    public SWUpdate getSwupdate() {
        return swupdate;
    }

    public void setSwupdate(SWUpdate swupdate) {
        this.swupdate = swupdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getManufacturername() {
        return manufacturername;
    }

    public void setManufacturername(String manufacturername) {
        this.manufacturername = manufacturername;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public LampCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(LampCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public LampConfig getConfig() {
        return config;
    }

    public void setConfig(LampConfig config) {
        this.config = config;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion;
    }

    public String getSwconfigid() {
        return swconfigid;
    }

    public void setSwconfigid(String swconfigid) {
        this.swconfigid = swconfigid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
    // </editor-fold>
}
