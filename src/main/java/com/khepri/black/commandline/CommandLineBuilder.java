package com.khepri.black.commandline;

import com.khepri.black.command.CommandFactory;
import com.khepri.black.command.CommandType;
import com.khepri.black.command.ICommand;
import com.khepri.black.command.models.Option;
import com.khepri.black.command.models.PositionalParameter;
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

    public CommandLineBuilder setPositionalParametersFromProperties() {
        Properties properties = rootCommand.getProperties();
        int index = 1;
        while (properties.getProperty("positionalParameters." + index + ".label") != null) {
            PositionalParameter positionalParameter = new PositionalParameter();
            positionalParameter.setLabel(properties.getProperty("positionalParameters." + index + ".label"));
            positionalParameter.setSynopsis(properties.getProperty("positionalParameters." + index + ".synopsis"));
            rootCommand.addPositionalParameter(positionalParameter);
            index += 1;
        }
        return this;
    }

    public CommandLineBuilder setOptionsFromProperties() {
        Properties properties = rootCommand.getProperties();
        int index = 1;
        while (properties.getProperty("options." + index + ".longName") != null) {
            Option option = new Option();
            option.setLongName(properties.getProperty("options." + index + ".longName"));
            option.setShortName(properties.getProperty("options." + index + ".shortName"));
            option.setSynopsis(properties.getProperty("options." + index + ".synopsis"));
            rootCommand.addOption(option);
            index += 1;
        }
        return this;
    }

    public ICommand build() {
        return rootCommand;
    }
}
