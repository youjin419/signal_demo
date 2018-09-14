package com.signal.demo.common;

import com.typesafe.config.ConfigFactory;

public class SignalConfig {
    private String fileName;
    private String configPath = ConfigFactory.load().getString("fileName");

}
