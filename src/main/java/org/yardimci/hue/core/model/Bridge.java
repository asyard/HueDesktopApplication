package org.yardimci.hue.core.model;

public class Bridge {

    private String id;

    private String internalipaddress;

    private String macaddress;

    private String name;

    public Bridge(String id, String ipAddress, String macAddress, String name) {
        this.id = id;
        this.internalipaddress = ipAddress;
        this.macaddress = macAddress;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public String getInternalipaddress() {
        return internalipaddress;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id:" + id + ",name:" + name + ",ip:" + internalipaddress + ",mac:" + macaddress;
    }
}
