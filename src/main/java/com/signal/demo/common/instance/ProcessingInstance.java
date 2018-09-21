package com.signal.demo.common.instance;

import com.signal.demo.sip.SipSignal;

import javax.sip.ServerTransaction;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.header.*;
import java.util.ArrayList;

public class ProcessingInstance {
    private static ProcessingInstance processingInstance = null;
    private AddressFactory addressFactory;
    private HeaderFactory headerFactory;

    private String toip;
    private String fromip;
    private ServerTransaction serverTransaction;
    private int toPort;
    private int fromPort;
    private String toTags;
    private String fromTags;
    private String toUser;
    private String fromUser;
    private String sdp;
    private long seq;

    private CallIdHeader callIdHeader;
    private SipSignal sipSignal = SipSignal.getInstance();


    public static ProcessingInstance getProcessingInstance() {
        if (processingInstance == null) processingInstance = new ProcessingInstance();

        return processingInstance;
    }

    public String getToip() {
        return toip;
    }

    public void setToip(String toip) {
        this.toip = toip;
    }

    public String getFromip() {
        return fromip;
    }

    public void setFromip(String fromip) {
        this.fromip = fromip;
    }

    public ServerTransaction getServerTransaction() {
        return serverTransaction;
    }

    public void setServerTransaction(ServerTransaction serverTransaction) {
        this.serverTransaction = serverTransaction;
    }

    public int getToPort() {
        return toPort;
    }

    public int getFromPort() {
        return fromPort;
    }

    public String getToTags() {
        return toTags;
    }

    public void setToTags(String toTags) {
        this.toTags = toTags;
    }

    public String getFromTags() {
        return fromTags;
    }

    public void setFromTags(String fromTags) {
        this.fromTags = fromTags;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }


    public CallIdHeader getCallIdHeader() {
        return callIdHeader;
    }

    public void setCallIdHeader(CallIdHeader callIdHeader) {
        this.callIdHeader = callIdHeader;
    }

    public void setAddressFactory(AddressFactory addressFactory) {
        this.addressFactory = addressFactory;
    }

    public void setHeaderFactory(HeaderFactory headerFactory) {
        this.headerFactory = headerFactory;
    }

    public void setToPort(int toPort) {
        this.toPort = toPort;
    }

    public void setFromPort(int fromPort) {
        this.fromPort = fromPort;
    }

    public ContactHeader createContactHeader(String user, String ip, Integer port) throws Exception {

        SipURI contactURI = this.addressFactory.createSipURI(user, ip);
        contactURI.setPort(port);
        Address contactAddress = this.addressFactory.createAddress(contactURI);

        contactAddress.setDisplayName(user);
        return this.headerFactory.createContactHeader(contactAddress);
    }

    public SipURI createSipUri(String ip, Integer port, String user) throws Exception {
        String host = ip + ":" + port;
        return this.addressFactory.createSipURI(user,host);
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

    public MaxForwardsHeader createMaxForwardsHeader() throws Exception {
        MaxForwardsHeader maxForwardsHeader = this.headerFactory.createMaxForwardsHeader(70);
        return maxForwardsHeader;
    }

    public ArrayList createViaHeaders() throws Exception {
        ArrayList viaHeaders = new ArrayList();
        String address = this.sipSignal.getSipProvider().getListeningPoint().getIPAddress();
        ViaHeader viaHeader = this.headerFactory.createViaHeader(address, this.sipSignal.getSipProvider().getListeningPoint("udp").getPort(), "udp", null);
        viaHeaders.add(viaHeader);

        return viaHeaders;
    }



}
