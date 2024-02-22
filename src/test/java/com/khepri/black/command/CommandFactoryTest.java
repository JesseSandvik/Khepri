package com.khepri.black.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CommandFactoryTest {
    @Test
    void creates_executor_command_for_executor_command_type() {
        ICommand command = CommandFactory.create("test", CommandType.EXECUTOR);
        assertInstanceOf(ExecutorCommand.class, command);
    }
}
