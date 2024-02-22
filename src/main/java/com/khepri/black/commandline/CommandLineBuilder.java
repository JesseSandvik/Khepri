package com.khepri.black.commandline;

import com.khepri.black.command.ICommand;
import com.khepri.black.services.systems.file.FileSystemServiceImpl;

import java.util.Properties;

public class CommandLineBuilder {
    private final ICommand rootCommand;

    public CommandLineBuilder(ICommand rootCommand) {
        this.rootCommand = rootCommand;
    }

    public CommandLineBuilder getPropertiesFromJsonFile(String filePath) {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(filePath);
        rootCommand.setProperties(properties);
        return this;
    }

    public ICommand build() {
        return rootCommand;
    }
}
