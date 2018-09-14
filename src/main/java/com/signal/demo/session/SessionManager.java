package com.signal.demo.session;

import com.signal.demo.common.log.SipLogger;

import java.io.Serializable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class SessionManager extends SipLogger implements Serializable {
    private static SessionManager sessionManager = null;
    private ScheduledExecutorService scheduleService;
    private static ScheduledFuture<?> scheduleFuture;

    public static SessionManager getInstance() {
        if (sessionManager == null) sessionManager = new SessionManager();

        return sessionManager;
    }

    public void start() {
        // TODO: Config 설정
        // TODO: SessionRunabled
    }


}
