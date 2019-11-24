package org.yardimci.hue.core.model.response.lamp;

import java.util.List;

public class LightResponse {
    private List<Lights> lights;

    public List<Lights> getLights() {
        return lights;
    }

    public void setLights(List<Lights> lights) {
        this.lights = lights;
    }
}
