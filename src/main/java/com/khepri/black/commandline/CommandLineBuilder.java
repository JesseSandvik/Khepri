package com.khepri.black.commandline;

import com.khepri.black.command.CommandFactory;
import com.khepri.black.command.CommandType;
import com.khepri.black.command.ICommand;
import com.khepri.black.services.systems.file.FileSystemServiceImpl;

import java.util.Properties;

public class CommandLineBuilder {
    private final ICommand rootCommand;

    public CommandLineBuilder() {
        this.rootCommand = CommandFactory.create("", CommandType.EXECUTOR);
    }

    public CommandLineBuilder getPropertiesFromJsonFile(String filePath) {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(filePath);
        rootCommand.setProperties(properties);
        return this;
    }

    public CommandLineBuilder setRootCommandAttributesFromProperties() {
        Properties properties = rootCommand.getProperties();
        rootCommand.setName(properties.getProperty("name"));
        rootCommand.setVersion(properties.getProperty("version"));
        rootCommand.setSynopsis(properties.getProperty("synopsis"));
        rootCommand.setDescription(properties.getProperty("description"));
        return this;
    }

    public ICommand build() {
        return rootCommand;
    }
}
