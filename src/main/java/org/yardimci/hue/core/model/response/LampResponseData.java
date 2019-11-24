package org.yardimci.hue.core.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.yardimci.hue.core.model.response.lamp.Lamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LampResponseData {
    @JsonProperty("1")
    private Lamp lamp1;

    @JsonProperty("2")
    private Lamp lamp2;

    @JsonProperty("3")
    private Lamp lamp3;

    public Lamp getLamp1() {
        return lamp1;
    }

    public void setLamp1(Lamp lamp1) {
        this.lamp1 = lamp1;
    }

    public Lamp getLamp2() {
        return lamp2;
    }

    public void setLamp2(Lamp lamp2) {
        this.lamp2 = lamp2;
    }

    public Lamp getLamp3() {
        return lamp3;
    }

    public void setLamp3(Lamp lamp3) {
        this.lamp3 = lamp3;
    }
}
