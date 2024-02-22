package com.khepri.black.command;

public class CommandFactory {
    public static ICommand create(String name, CommandType commandType) {
        return commandType.create(name);
    }
}
