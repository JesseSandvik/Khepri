package com.khepri.black.command;

import com.khepri.black.command.models.CommandAttributes;
import com.khepri.black.command.models.Option;
import com.khepri.black.command.models.PositionalParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class CommandImpl extends CommandAttributes implements ICommand {
    private Properties properties;
    private final List<PositionalParameter> positionalParameters = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private final List<ICommand> subcommands = new ArrayList<>();

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<PositionalParameter> getPositionalParameters() {
        return positionalParameters;
    }

    @Override
    public void addPositionalParameter(PositionalParameter positionalParameter) {
        positionalParameters.add(positionalParameter);
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public void addOption(Option option) {
        options.add(option);
    }

    @Override
    public List<ICommand> getSubcommands() {
        return subcommands;
    }

    @Override
    public void addSubcommand(ICommand subcommand) {
        subcommands.add(subcommand);
    }
}
