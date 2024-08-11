package com.khepri.black.filesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileSystemServiceTest {
    private static final String executableFilePath = "src/test/resources/echo";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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
    void should_execute_provided_command() throws IOException, InterruptedException {
        String expected = "Hello, world!";
        List<String> command = new ArrayList<>();
        command.add(executableFilePath);
        command.add(expected);
        FileSystemService.executeCommand(command);
        assertTrue(outputStream.toString().contains(expected));
    }

    @Test
    void should_return_success_exit_code_for_successful_command_execution() throws IOException, InterruptedException {
        int expected = 0;
        List<String> command = new ArrayList<>();
        command.add(executableFilePath);
        int actual = FileSystemService.executeCommand(command);
        assertEquals(expected, actual);
    }
}
