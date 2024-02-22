package com.khepri.black.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorCommandTest {
    private ICommand executorCommand;

    @BeforeEach
    void initializeExecutorCommand() {
        executorCommand = CommandFactory.create("echo", CommandType.EXECUTOR);
    }

    @Test
    void executing_command_returns_success_exit_code_for_successful_execution() throws Exception {
        int expected = 0;
        int actual = executorCommand.call();
        assertEquals(expected, actual);
    }
}
