package com.khepri.black.command;

import com.khepri.black.services.systems.file.FileSystemServiceImpl;
import com.khepri.black.services.systems.file.IFileSystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExecutorCommand extends CommandImpl {
    @Override
    public Integer call() {
        if (getProperties() == null || getProperties().isEmpty()) {
            return 0;
        }

        List<String> command = new ArrayList<>();
        Properties properties = getProperties();
        command.add(properties.getProperty("executable.file.path"));

        getPositionalParameters()
                .forEach(positionalParameter -> command.add((String) positionalParameter.getValue()));
        getOptions().forEach(option -> command.add((String) option.getValue()));

        IFileSystemService fileSystemService = new FileSystemServiceImpl();
        return fileSystemService.executeCommand(command);
    }
}
