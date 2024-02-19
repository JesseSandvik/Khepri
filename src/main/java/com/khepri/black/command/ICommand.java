package com.khepri.black.command;

import java.util.Properties;
import java.util.concurrent.Callable;

public interface ICommand extends Callable<Integer> {
    String getName();
    void setName(String name);
    String getVersion();
    void setVersion(String version);
    String getSynopsis();
    void setSynopsis(String synopsis);
    String getDescription();
    void setDescription(String description);
    Properties getProperties();
    void setProperties(Properties properties);
}
