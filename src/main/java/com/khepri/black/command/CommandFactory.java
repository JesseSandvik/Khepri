package com.khepri.black.command;

public class CommandFactory {

    public static ICommand create(CommandType commandType) {
        return commandType.create();
    }
}
