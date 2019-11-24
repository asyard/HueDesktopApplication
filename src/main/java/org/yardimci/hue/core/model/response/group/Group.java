package org.yardimci.hue.core.model.response.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
    private String name;
    private String[] lights;
    //todo add rest


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLights() {
        return lights;
    }

    public void setLights(String[] lights) {
        this.lights = lights;
    }
}
