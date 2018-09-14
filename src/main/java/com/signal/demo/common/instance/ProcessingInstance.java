package com.signal.demo.common.instance;

import com.signal.demo.sip.SipSignal;

import javax.sip.InvalidArgumentException;
import javax.sip.ServerTransaction;
import javax.sip.SipProvider;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.header.*;
import java.text.ParseException;
import java.util.ArrayList;

public class ProcessingInstance {
    private static ProcessingInstance processingInstance = null;
    private String fromTags;
    private ServerTransaction st;

    private int toIp;
    private int fromIp;
    private int toPort;
    private int fromPort;
    private String toUser;
    private String fromUser;

    // TODO: 다시 정리 필요
    private SipSignal sipSignal;
    private SipProvider sipProvider;
    private ContactHeader contactHeader;
    private AddressFactory addressFactory;
    private HeaderFactory headerFactory;



    public static ProcessingInstance getProcessingInstance() {
        if (processingInstance == null) processingInstance = new ProcessingInstance();

        return processingInstance;
    }

    public AddressFactory getAddressFactory() {
        return addressFactory;
    }

    public void setAddressFactory(AddressFactory addressFactory) {
        this.addressFactory = addressFactory;
    }

    public HeaderFactory getHeaderFactory() {
        return headerFactory;
    }

    public void setHeaderFactory(HeaderFactory headerFactory) {
        this.headerFactory = headerFactory;
    }

    public ServerTransaction getSt() {
        return st;
    }

    public void setSt(ServerTransaction st) {
        this.st = st;
    }


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

    public SipURI createSipUri(String user, String host) throws Exception {
        SipURI sipURI = this.addressFactory.createSipURI(user,host);
        return sipURI;
    }

    public ToHeader createToHeader(SipURI sipURI, String tags) throws Exception {
        Address address = this.addressFactory.createAddress(sipURI);
        ToHeader toHeader = this.headerFactory.createToHeader(address,tags);
        return toHeader;
    }

    public FromHeader createFromHeader(SipURI sipURI, String tags) throws Exception {
        Address address = this.addressFactory.createAddress(sipURI);
        FromHeader fromHeader = this.headerFactory.createFromHeader(address, tags);
        return fromHeader;
    }

    public CSeqHeader createCSeqHeader(long seq, String method) throws Exception {
        CSeqHeader cSeqHeader = this.headerFactory.createCSeqHeader(seq, method);
        return cSeqHeader;
    }

    public ContactHeader createContactHeader(SipURI sipURI) {
        Address address = this.addressFactory.createAddress(sipURI);
        ContactHeader contactHeader = this.headerFactory.createContactHeader();
        return contactHeader;
    }

    public MaxForwardsHeader createMaxForwardsHeader() throws Exception {
        MaxForwardsHeader maxForwardsHeader = this.headerFactory.createMaxForwardsHeader(70);
        return maxForwardsHeader;
    }


}
