package org.yardimci.hue.core.model.response.lamp;

public class LampStreaming {
    private boolean renderer;
    private boolean proxy;

    public boolean isRenderer() {
        return renderer;
    }

    public void setRenderer(boolean renderer) {
        this.renderer = renderer;
    }

    public boolean isProxy() {
        return proxy;
    }

    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }
}
