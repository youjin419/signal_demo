package com.signal.demo.common.instance;

import com.signal.demo.common.log.SipLogger;

import javax.sip.RequestEvent;
import javax.sip.ServerTransaction;
import javax.sip.address.SipURI;
import javax.sip.header.*;
import javax.sip.message.Request;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SessionInstance extends SipLogger implements Serializable {
    private static SessionInstance sessionInstance = null;
    private Request request;
    private List<Request> requestList;
    private HashMap<Request, ServerTransaction> inMap;

    // TODO: 다시 전부 정리 필요
    private ServerTransaction sId;
    private String type;
    private String tag;
    private String toTags;
    private String fromTags;
    private String toIp;
    private String fromIp;
    private int toPort;
    private int fromPort;



    public static SessionInstance getInstance() {
        if (sessionInstance == null) sessionInstance = new SessionInstance();
        return sessionInstance;
    }

    public Request getRequest() {
        return request;
    }

    public Request getOutRequest(){
        return request;
    }

    public void setOutRequest(Request request) {
        this.request = request;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public HashMap<Request, ServerTransaction> getInMap() {
        return inMap;
    }

    public void setInMap(HashMap<Request, ServerTransaction> inMap) {
        this.inMap = inMap;
    }

    public ServerTransaction getsId() {
        return sId;
    }

    public void setsId(ServerTransaction sId) {
        this.sId = sId;
    }

    public String getToTag(Request request) {
        String toTag = ((ToHeader) request.getHeader("To")).getTag();
        return toTag;
    }

    public void setToTags(String toTags) {
        this.toTags = toTags;
    }

    public String getFromTags(Request request) {
        String fromTag = ((FromHeader) request.getHeader("From")).getTag();
        return fromTag;
    }

    public void setFromTags(String fromTags) {
        this.fromTags = fromTags;
    }

    public String getFromHost(Request request) {
        String ip = ((SipURI) ((FromHeader) request.getHeader("From")).getAddress().getURI()).getHost();
        return ip;
    }

    public void setFromHost(String host) {
        this.fromIp = host;
    }

    public Integer getFromPort(Request request) {
        Integer fromport = ((SipURI) ((FromHeader) request.getHeader("From")).getAddress().getURI()).getPort();
        return fromport;
    }

    public void setFromPort(Integer port) {
        this.fromPort = port;
    }

    public String getToHost(Request request) {
        String ip = ((SipURI) ((ToHeader) request.getHeader("To")).getAddress().getURI()).getHost();
        return ip;
    }

    public void setToHost(String host) {
        this.fromIp = host;
    }

    public Integer getToPort(Request request) {
        Integer fromport = ((SipURI) ((ToHeader) request.getHeader("To")).getAddress().getURI()).getPort();
        return fromport;
    }

    public void setToPort(Integer port) {
        this.fromPort = port;
    }

    public String getToUsers(Request request) {
        String users = ((SipURI) ((ToHeader) request.getHeader("To")).getAddress().getURI()).getUser();
        return users;
    }

    public String getFromUsers(Request request) {
        String users = ((SipURI) ((FromHeader) request.getHeader("From")).getAddress().getURI()).getUser();
        return users;
    }

    public Request findRequest(String CallId, String method) {
        List<Request> requestList1 = SessionInstance.getInstance().getRequestList();
        Request findRequest = requestList1.stream().filter(l -> ((CallIdHeader) l.getHeader("Call-ID")).getCallId().equals(CallId)).collect(Collectors.toList()).stream().filter(
                r -> ((CSeqHeader) r.getHeader("Cseq")).getMethod().equals(method)).collect(Collectors.toList()).get(0);

        return findRequest;

    }

    public ServerTransaction findTransactionId (Request request) {
        String CallId = ((CallIdHeader) request.getHeader("Call-ID")).getCallId();
        CSeqHeader cSeqHeader = ((CSeqHeader) request.getHeader("CSeq"));
        HashMap<Request, ServerTransaction> map = SessionInstance.getInstance().getInMap();
        Request mapRequest = map.keySet().stream().filter(m -> ((CallIdHeader) m.getHeader("Call-ID")).getCallId().equals(CallId)).collect(Collectors.toList()).stream().filter(
                c -> ((CSeqHeader) c.getHeader("CSeq")).equals(cSeqHeader)).collect(Collectors.toList()).get(0);
        ServerTransaction sId = map.get(mapRequest);
        return sId;
    }


    public List<Request> findRequestByCallId(String CallId) {
        List<Request> requestList = SessionInstance.getInstance().getRequestList();
        List<Request> requestList1 = requestList.stream().filter(s -> ((CallIdHeader) s.getHeader("Call-ID")).getCallId().equals(CallId)).collect(Collectors.toList());
        return requestList1;
    }

    public ArrayList createViaHeaders(Request request) throws Exception {
        ArrayList viaHeaders = new ArrayList();
        ViaHeader viaHeader = ((ViaHeader) request.getHeader("Via"));
        viaHeaders.add(viaHeader);

        return viaHeaders;
    }



}
