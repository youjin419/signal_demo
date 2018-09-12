package com.signal.demo;

import com.signal.demo.service.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignalMain {
    private static Logger logger = LoggerFactory.getLogger(SignalMain.class);

    // TODO: Signal 생성
    public static void main(String[] args){
        logger.debug("SignalMain Start");

        ServiceManager serviceManager = ServiceManager.getInstance();

        serviceManager.loop();

    }

}
