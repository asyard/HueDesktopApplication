package org.yardimci.hue.core.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LightResponse {
    private LightResponseData lights;
    private GroupResponseData groups;

    public LightResponseData getLights() {
        return lights;
    }

    public void setLights(LightResponseData lights) {
        this.lights = lights;
    }

    public GroupResponseData getGroups() {
        return groups;
    }

    public void setGroups(GroupResponseData groups) {
        this.groups = groups;
    }
}
