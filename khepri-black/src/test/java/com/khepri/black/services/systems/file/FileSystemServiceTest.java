package com.khepri.black.services.systems.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemServiceTest {
    private FileSystemService fileSystemService;
    private static final String jsonFilePath = "src/test/resources/test.json";
    private static final String textFilePath = "src/test/resources/test.txt";

    @BeforeEach
    void initializeFileSystemService() {
        this.fileSystemService = new FileSystemServiceImpl();
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
}
