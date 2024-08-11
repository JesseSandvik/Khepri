package com.khepri.black.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CommandFactoryTest {
    @Test
    void should_create_executor_command_for_executor_command_type() {
        ICommand command = CommandFactory.create(CommandType.EXECUTOR);
        assertInstanceOf(ExecutorCommand.class, command);
    }
}
