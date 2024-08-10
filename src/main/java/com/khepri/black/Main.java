package com.khepri.black;

import com.khepri.black.command.ICommand;
import com.khepri.black.command.models.PositionalParameter;
import com.khepri.black.command.properties.loader.CommandPropertiesLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        String commandPropertiesJsonFilePath = "src/test/resources/.khepri/example/etc/example.json";

        ICommand command = new CommandPropertiesLoader()
                .setPropertiesSource(commandPropertiesJsonFilePath)
                .load();

        command.setOriginalArguments(args);
        PositionalParameter positionalParameterA = new PositionalParameter();
        positionalParameterA.setValue(args[0]);
        command.addPositionalParameter(positionalParameterA);

        PositionalParameter positionalParameterB = new PositionalParameter();
        positionalParameterB.setValue(args[1]);
        command.addPositionalParameter(positionalParameterB);

        int exitCode = command.call();
        System.exit(exitCode);
    }
}
