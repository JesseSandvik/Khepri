package com.khepri.black.command;

import com.khepri.black.command.models.PositionalParameter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutorCommandTest {
    private ICommand executorCommand;
    private static final String executableFilePath = "src/test/resources/echo";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void initializeExecutorCommand() {
        executorCommand = CommandFactory.create("echo", CommandType.EXECUTOR);
    }

    @BeforeEach
    void setUpStream() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void executing_command_returns_success_exit_code_for_successful_execution() throws Exception {
        int expected = 0;
        int actual = executorCommand.call();
        assertEquals(expected, actual);
    }

    @Test
    void executes_an_executable_file_from_the_file_system() throws Exception {
        String expected = "Hello, world!";

        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setLabel("text");
        positionalParameter.setValue(expected);
        executorCommand.addPositionalParameter(positionalParameter);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expected));
    }
}
