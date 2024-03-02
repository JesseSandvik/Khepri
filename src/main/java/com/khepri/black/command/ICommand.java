package com.khepri.black.command;

import com.khepri.black.command.models.Option;
import com.khepri.black.command.models.PositionalParameter;

import java.util.List;
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
    List<PositionalParameter> getPositionalParameters();
    void addPositionalParameter(PositionalParameter positionalParameter);
    List<Option> getOptions();
    void addOption(Option option);
    List<ICommand> getSubcommands();
    void addSubcommand(ICommand subcommand);
}
