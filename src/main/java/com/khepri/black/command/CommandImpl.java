package com.khepri.black.command;

import com.khepri.black.command.models.CommandAttributes;

import java.util.Properties;

public abstract class CommandImpl extends CommandAttributes implements ICommand {
    private Properties properties;

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
