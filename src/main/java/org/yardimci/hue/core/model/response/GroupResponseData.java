package org.yardimci.hue.core.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.yardimci.hue.core.model.response.group.Group;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupResponseData {

    @JsonProperty("1")
    private Group group1;

    public Group getGroup1() {
        return group1;
    }

    public void setGroup1(Group group1) {
        this.group1 = group1;
    }
}
