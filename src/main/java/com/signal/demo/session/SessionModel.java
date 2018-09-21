package com.signal.demo.session;

import javax.sip.ClientTransaction;
import javax.sip.ServerTransaction;
import javax.sip.message.Request;
import java.io.Serializable;

public class SessionModel implements Serializable {
    private static SessionModel sessionModel = null;
    private Request request;
    private String callId;
    private ServerTransaction serverTransaction;
    private ClientTransaction clientTransaction;

    private String toip;
    private String fromip;
    private int toPort;
    private int fromPort;
    private String toTags;
    private String fromTags;
    private String toUser;
    private String fromUser;
    private String sdp;
    private long seq;
    private String type;


    public static SessionModel getInstance() {

        if (sessionModel == null) sessionModel = new SessionModel();
        return sessionModel;
    }

    public static SessionModel getSessionModel() {
        return sessionModel;
    }

    public static void setSessionModel(SessionModel sessionModel) {
        SessionModel.sessionModel = sessionModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }


    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public ServerTransaction getServerTransaction() {
        return serverTransaction;
    }

    public void setServerTransaction(ServerTransaction serverTransaction) {
        this.serverTransaction = serverTransaction;
    }

    public ClientTransaction getClientTransaction() {
        return clientTransaction;
    }

    public void setClientTransaction(ClientTransaction clientTransaction) {
        this.clientTransaction = clientTransaction;
    }



    @Override
    public String toString() {
        return String.format("SessionModel{callId='%s', request='%s', serverTransaction='%s', clientTransaction='%s', type='%s', }"
                , callId, request, serverTransaction, clientTransaction, type);
    }

}
