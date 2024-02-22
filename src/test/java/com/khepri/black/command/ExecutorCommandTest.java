package com.khepri.black.command;

import com.khepri.black.command.models.Option;
import com.khepri.black.command.models.PositionalParameter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    void executes_an_executable_file_from_the_file_system_with_positional_parameter() throws Exception {
        String expected = "Hello, world!";

        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setValue(expected);
        executorCommand.addPositionalParameter(positionalParameter);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expected));
    }

    @Test
    void executes_an_executable_file_from_the_file_system_with_positional_parameters() throws Exception {
        String expectedFirstParameter = "Hello";
        String expectedSecondParameter = "World!";

        PositionalParameter firstPositionalParameter = new PositionalParameter();
        firstPositionalParameter.setValue(expectedFirstParameter);
        executorCommand.addPositionalParameter(firstPositionalParameter);

        PositionalParameter secondPositionalParameter = new PositionalParameter();
        secondPositionalParameter.setValue(expectedSecondParameter);
        executorCommand.addPositionalParameter(secondPositionalParameter);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expectedFirstParameter));
        assertTrue(outputStream.toString().contains(expectedSecondParameter));
    }

    @Test
    void executes_an_executable_file_from_the_file_system_with_option() throws Exception {
        String expected = "Hello, world!";

        Option option = new Option();
        option.setValue(expected);
        executorCommand.addOption(option);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expected));
    }

    @Test
    void executes_an_executable_file_from_the_file_system_with_options() throws Exception {
        String expectedFirstOption = "Hello";
        String expectedSecondOption = "World!";

        Option firstOption = new Option();
        firstOption.setValue(expectedFirstOption);
        executorCommand.addOption(firstOption);

        Option secondOption = new Option();
        secondOption.setValue(expectedSecondOption);
        executorCommand.addOption(secondOption);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expectedFirstOption));
        assertTrue(outputStream.toString().contains(expectedSecondOption));
    }

    @Test
    void executes_an_executable_file_from_the_file_system_with_positional_parameter_and_option() throws Exception {
        String expectedPositionalParameter = "Hello";
        String expectedOption = "World!";

        PositionalParameter positionalParameter = new PositionalParameter();
        positionalParameter.setValue(expectedPositionalParameter);
        executorCommand.addPositionalParameter(positionalParameter);

        Option option = new Option();
        option.setValue(expectedOption);
        executorCommand.addOption(option);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(expectedPositionalParameter));
        assertTrue(outputStream.toString().contains(expectedOption));
    }

    @Test
    void executes_an_executable_file_from_the_file_system_with_positional_parameters_and_options() throws Exception {
        String firstExpectedPositionalParameter = "Hello";
        String firstExpectedOption = "World!";
        String secondExpectedPositionalParameter = "Welcome";
        String secondExpectedOption = "Friends";

        PositionalParameter firstPositionalParameter = new PositionalParameter();
        firstPositionalParameter.setValue(firstExpectedPositionalParameter);
        executorCommand.addPositionalParameter(firstPositionalParameter);

        PositionalParameter secondPositionalParameter = new PositionalParameter();
        secondPositionalParameter.setValue(secondExpectedPositionalParameter);
        executorCommand.addPositionalParameter(secondPositionalParameter);

        Option firstOption = new Option();
        firstOption.setValue(firstExpectedOption);
        executorCommand.addOption(firstOption);

        Option secondOption = new Option();
        secondOption.setValue(secondExpectedOption);
        executorCommand.addOption(secondOption);

        Properties properties = new Properties();
        properties.setProperty("executable.file.path", executableFilePath);
        executorCommand.setProperties(properties);

        executorCommand.call();
        assertTrue(outputStream.toString().contains(firstExpectedPositionalParameter));
        assertTrue(outputStream.toString().contains(firstExpectedOption));
        assertTrue(outputStream.toString().contains(secondExpectedPositionalParameter));
        assertTrue(outputStream.toString().contains(secondExpectedOption));
    }
}
