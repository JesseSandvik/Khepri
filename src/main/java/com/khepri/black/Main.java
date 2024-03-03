package com.khepri.black;

import com.khepri.black.command.ICommand;
import com.khepri.black.command.properties.loader.CommandPropertiesLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        String commandPropertiesJsonFilePath = "src/test/resources/.khepri/example/etc/example.json";
        ICommand command = new CommandPropertiesLoader()
                .setPropertiesSource(commandPropertiesJsonFilePath)
                .load();

        int exitCode = command.call();
        System.exit(exitCode);
    }
}
