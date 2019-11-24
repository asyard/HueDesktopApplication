package org.yardimci.hue.core.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllResponseData {
    private LampResponseData lights;
    private GroupResponseData groups;

    public LampResponseData getLights() {
        return lights;
    }

    public void setLights(LampResponseData lights) {
        this.lights = lights;
    }

    public GroupResponseData getGroups() {
        return groups;
    }

    public void setGroups(GroupResponseData groups) {
        this.groups = groups;
    }
}
