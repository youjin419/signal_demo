package com.signal.demo.common;

import com.signal.demo.sip.SipSignal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignalInstance {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SignalInstance instance;
    private SipSignal signal;

    public SignalInstance getInstance() {
        if (instance == null) {
            instance = new SignalInstance();
        }
        return instance;
    }

    public void setInstance(SignalInstance signalInstance) {
        this.instance = signalInstance;
    }

    public SipSignal getSipSignal() {
        return signal;
    }

    public void setSipSignal(SipSignal sipSignal) {
        this.signal = sipSignal;
    }



}
