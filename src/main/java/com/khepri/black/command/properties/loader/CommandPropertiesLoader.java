package com.khepri.black.command.properties.loader;

import com.khepri.black.command.CommandFactory;
import com.khepri.black.command.CommandType;
import com.khepri.black.command.ICommand;
import com.khepri.black.command.models.Option;
import com.khepri.black.command.models.PositionalParameter;

import java.util.Properties;

public class CommandPropertiesLoader {
    private final ICommand command;
    private String propertiesSource;
    private CommandPropertiesLoaderSource commandPropertiesLoaderSource = CommandPropertiesLoaderSource.FILE;

    public CommandPropertiesLoader() {
        this.command = CommandFactory.create(CommandType.EXECUTOR);
    }

    public CommandPropertiesLoader setPropertiesSource(String propertiesSource) {
        this.propertiesSource = propertiesSource;
        return this;
    }

    private void loadCommandAttributesFromProperties(Properties properties) {
        command.setName(properties.getProperty("name"));
        command.setVersion(properties.getProperty("version"));
        command.setSynopsis(properties.getProperty("synopsis"));
        command.setDescription(properties.getProperty("description"));
    }

    private void loadCommandPositionalParametersFromProperties(Properties properties) {
        int index = 1;
        while (properties.getProperty("positionalParameters." + index + ".label") != null) {
            PositionalParameter positionalParameter = new PositionalParameter();
            positionalParameter.setLabel(properties.getProperty("positionalParameters." + index + ".label"));
            positionalParameter.setSynopsis(properties.getProperty("positionalParameters." + index + ".synopsis"));
            command.addPositionalParameter(positionalParameter);
            index += 1;
        }
    }

    private void loadCommandOptionsFromProperties(Properties properties) {
        int index = 1;
        while (properties.getProperty("options." + index + ".longName") != null) {
            Option option = new Option();
            option.setLongName(properties.getProperty("options." + index + ".longName"));
            option.setShortName(properties.getProperty("options." + index + ".shortName"));
            option.setSynopsis(properties.getProperty("options." + index + ".synopsis"));
            command.addOption(option);
            index += 1;
        }
    }

    public ICommand load() {
        commandPropertiesLoaderSource.load(command, propertiesSource);
        loadCommandAttributesFromProperties(command.getProperties());
        loadCommandPositionalParametersFromProperties(command.getProperties());
        loadCommandOptionsFromProperties(command.getProperties());
        return command;
    }
}
