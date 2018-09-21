package com.signal.demo.common.instance;

import com.signal.demo.session.SessionModel;
import com.signal.demo.common.log.SipLogger;

import javax.sip.ClientTransaction;
import javax.sip.ServerTransaction;
import javax.sip.message.Request;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class SessionInstance extends SipLogger implements Serializable {
    private static SessionInstance sessionInstance = null;

    private HashMap<String, SessionModel> hmap;

    public static SessionInstance getInstance() {
        if (sessionInstance == null) sessionInstance = new SessionInstance();
        return sessionInstance;
    }

    public HashMap<String, SessionModel> getMap() {
        if (hmap == null) hmap = new HashMap<>();
        return hmap;
    }

    public void putMap(String k, SessionModel s) {
        logger.debug("Key :: " +k + "SessionModel :: " +s);
        HashMap<String, SessionModel> hmap = getMap();
        logger.debug("!!!!!!!! Put HashMap " +hmap);
        hmap.put(k,s);
    }



    public void setClientTransactionCallId(String callId1, ClientTransaction clientTransaction) {
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        SessionModel sessionModel = map.get(callId1);
        sessionModel.setClientTransaction(clientTransaction);
    }

    public SessionModel findSessionModel(String callId) {
        logger.debug("Find Request CallId: " + callId);
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        logger.debug("Find Hashmap Keyset" + map.keySet());
        return map.get(callId);
    }

    public Request findRequest (String callId) {
        logger.debug("Find Request CallId: " + callId);
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        return map.get(callId).getRequest();
    }

    public Set<String> findKeyset() {
        logger.debug("Find keySet" );
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        return map.keySet();
    }

    // OutboundCallId 로 inboundRequestEvent 조회
    public Request findRequestMap (String callId) {
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        String call1 = map.get(callId).getCallId();
        return map.get(call1).getRequest();
    }

    public ClientTransaction findClientTransaction (String callId) {
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        logger.debug("ClientTransactoin Model " + map);
        SessionModel sessionModel = map.get(callId);
        logger.debug("ClientTransactionCallId SessionModel CallID " + callId);
        return sessionModel.getClientTransaction();
    }

    public ServerTransaction findTransactionId (String callId) {
        logger.debug("FindTransactoinId CallId "+ callId);
        HashMap<String, SessionModel> map = SessionInstance.getInstance().getMap();
        ServerTransaction st = map.get(callId).getServerTransaction();
        return st;
    }




}
