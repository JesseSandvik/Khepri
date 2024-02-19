package com.khepri.black.services.systems.file;

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

public class FileSystemServiceTest {
    private IFileSystemService fileSystemService;
    private static final String jsonFilePath = "src/test/resources/test.json";
    private static final String textFilePath = "src/test/resources/test.txt";
    private static final String executableFilePath = "src/test/resources/echo";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void initializeFileSystemService() {
        this.fileSystemService = new FileSystemServiceImpl();
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
    void read_file_from_provided_file_path() {
        String expected = "Hello, world!";
        String actual = fileSystemService.read_text_file(textFilePath);
        assertEquals(expected, actual);
    }

    @Test
    void returns_properties_from_json_file() {
        String expected = "world";
        Properties properties = fileSystemService.getPropertiesFromJsonFile(jsonFilePath);
        String actual = properties.getProperty("hello");
        assertEquals(expected, actual);
    }

    @Test
    void executes_provided_command() {
        String expected = "Hello, world!";
        List<String> command = new ArrayList<>();
        command.add(executableFilePath);
        command.add(expected);
        fileSystemService.executeCommand(command);
        assertTrue(outputStream.toString().contains(expected));
    }

    @Test
    void success_exit_code_for_successful_command_execution() {
        int expected = 0;
        List<String> command = new ArrayList<>();
        command.add(executableFilePath);
        int actual = fileSystemService.executeCommand(command);
        assertEquals(expected, actual);
    }
}
