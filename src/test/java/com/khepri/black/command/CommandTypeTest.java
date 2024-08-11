package com.khepri.black.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CommandTypeTest {
    @Test
    void should_create_executor_command_for_executor_command_type() {
        ICommand command = CommandType.EXECUTOR.create();
        assertInstanceOf(ExecutorCommand.class, command);
    }
}
