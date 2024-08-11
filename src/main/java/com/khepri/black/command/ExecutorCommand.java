package com.khepri.black.command;

import com.khepri.black.filesystem.FileSystemService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExecutorCommand extends Command {

    @Override
    public Integer call() throws IOException, InterruptedException {
        if (getProperties() == null || getProperties().isEmpty()) {
            return 1;
        }

        List<String> command = new ArrayList<>();
        Properties properties = getProperties();
        command.add(properties.getProperty("executableFilePath"));

        getPositionalParameters().forEach(positionalParameter -> {
            if (positionalParameter.getValue() != null) {
                command.add((String) positionalParameter.getValue());
            }
        });

        getOptions().forEach(option -> {
            if (option.getValue() != null) {
                command.add((String) option.getValue());
            }
        });
        return FileSystemService.executeCommand(command);
    }
}
