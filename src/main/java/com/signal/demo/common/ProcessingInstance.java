package com.signal.demo.common;

import javax.sip.SipFactory;
import javax.sip.address.AddressFactory;
import javax.sip.header.ContactHeader;
import javax.sip.header.HeaderFactory;

public class ProcessingInstance {
    private static ProcessingInstance processingInstance = null;
    private int toPort;
    private int fromPort;
    private String fromTags;
    private ContactHeader contactHeader;
    private AddressFactory addressFactory;
    private HeaderFactory headerFactory;
    private SipFactory sipFactory;

    public HeaderFactory getHeaderFactory() {
        return headerFactory;
    }

    public static ProcessingInstance getProcessingInstance() {
        if (processingInstance == null) new ProcessingInstance();

        return processingInstance;
    }


    public AddressFactory getAddressFactory() {
        return addressFactory;
    }

    public void setAddressFactory(AddressFactory addressFactory) {
        this.addressFactory = addressFactory;
    }

    public SipFactory getSipFactory() { return  sipFactory; }

    public void setSipFactory(SipFactory sipFactory) { this.sipFactory = sipFactory; }

    public int getToPort() {
        return toPort;
    }

    public void setToPort(int toPort) {
        this.toPort = toPort;
    }

    public int getFromPort() {
        return fromPort;
    }

    public void setFromPort(int fromPort) {
        this.fromPort = fromPort;
    }

    public String getFromTags() {
        return fromTags;
    }

    public void setFromTags(String fromTags) {
        this.fromTags = fromTags;
    }

    public void setContactHeader(ContactHeader contactHeader) {
        this.contactHeader = contactHeader;
    }

    public void setHeaderFactory(HeaderFactory headerFactory) {
        this.headerFactory = headerFactory;
    }

    public ContactHeader getContactHeader() {

        return contactHeader;
    }


}
