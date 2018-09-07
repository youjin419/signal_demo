package com.signal.demo.service;

import com.signal.demo.common.SignalInstance;
import com.signal.demo.sip.SipSignal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ServiceManager implements Serializable {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ServiceManager serviceManager;
    private static SipSignal sipSignal;

    public static ServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

    public void loop() {
        logger.debug("Service Start");
        this.startService();

        Runtime.getRuntime().addShutdownHook( new Thread( () -> {
            this.stopService();
        }));
    }

    private void startService() {
        logger.debug("SipSignal GetInstance");
        sipSignal = SipSignal.getInstance();

        sipSignal.init();
    }

    private void stopService() {
        logger.debug("SipSignal Stop");
        sipSignal.processStop();
    }

}
