package com.signal.demo.common.instance;

import com.signal.demo.sip.SipSignal;

import javax.sip.SipProvider;
import javax.sip.SipStack;

public class SignalInstance {
    private static SignalInstance signalInstance = null;
    private SipSignal sipSignal;
    private SipStack sipStack;
    private SipProvider sipProvider;
    private String sdpParser;


    public static SignalInstance getSignalInstance() {
        if (signalInstance == null) signalInstance = new SignalInstance();

        return signalInstance;
    }

    public SipSignal getSignal() {
        return sipSignal;
    }

    public void setSignal(SipSignal sipSignal) {
        this.sipSignal = sipSignal;
    }

    public SipStack getSipStack() {
        return sipStack;
    }

    public void setSipStack(SipStack sipStack) {
        this.sipStack = sipStack;
    }

    public SipProvider getSipProvider() {
        return sipProvider;
    }

    public void setSipProvider(SipProvider sipProvider) {
        this.sipProvider = sipProvider;
    }


    public String getSdpParser() {
        return sdpParser;
    }

    public void setSdpParser(String parser) {
        this.sdpParser = parser;
    }


}
