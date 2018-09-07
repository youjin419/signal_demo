package com.signal.demo.service;

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
        this.startService();

        Runtime.getRuntime().addShutdownHook( new Thread( () -> {
            logger.debug("Service Stop");
            this.stopService();
        }));

    }

    private void startService() {
        sipSignal.init();
    }

    private void stopService() {

    }

}
