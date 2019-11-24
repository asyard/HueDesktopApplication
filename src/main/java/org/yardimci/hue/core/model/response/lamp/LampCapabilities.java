package org.yardimci.hue.core.model.response.lamp;

public class LampCapabilities {
    private boolean certified;
    private LampControl control;
    private LampStreaming streaming;


    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public LampControl getControl() {
        return control;
    }

    public void setControl(LampControl control) {
        this.control = control;
    }

    public LampStreaming getStreaming() {
        return streaming;
    }

    public void setStreaming(LampStreaming streaming) {
        this.streaming = streaming;
    }
}
