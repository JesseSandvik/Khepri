package com.khepri.black.services.systems.operating;

import java.util.Properties;

public class OperatingSystemServiceImpl implements IOperatingSystemService {
    private final Properties operatingSystemProperties;

    public OperatingSystemServiceImpl() {
        this.operatingSystemProperties = System.getProperties();
    }

    @Override
    public String getUserHomeDirectory() {
        return operatingSystemProperties.getProperty("user.home");
    }
}
