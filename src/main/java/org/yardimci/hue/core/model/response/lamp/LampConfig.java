package org.yardimci.hue.core.model.response.lamp;

public class LampConfig {
    private String archetype;
    private String function;
    private String direction;
    private ConfigStartup startup;

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public ConfigStartup getStartup() {
        return startup;
    }

    public void setStartup(ConfigStartup startup) {
        this.startup = startup;
    }
}
