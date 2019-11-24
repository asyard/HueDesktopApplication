package org.yardimci.hue.core;

import org.yardimci.hue.core.model.Bridge;
import org.yardimci.hue.core.model.response.lamp.Lamp;

import java.util.List;

public class HueContext {

    private Bridge bridge;
    private List<Lamp> lamps;

    private static HueContext instance;

    public static HueContext getInstance() {
        if (instance == null) {
            instance = new HueContext();
        }
        return instance;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public void setLamps(List<Lamp> lamps) {
        this.lamps = lamps;
    }
}
