package com.khepri.black.filesystem.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FileServiceTest {

    @Test
    void should_read_file_content_from_json_file() throws IOException {
        String expected = "{  \"hello\": \"world\",  \"niceTo\": \"meet you!\"}";
        String filePath = "src/test/resources/test.json";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getFileContent();
        assertEquals(expected, actual);
    }

    @Test
    void should_read_file_content_from_properties_file() throws IOException {
        Properties expected = new Properties();
        expected.setProperty("niceTo", "meet you!");
        expected.setProperty("hello", "world");
        String filePath = "src/test/resources/test.properties";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getFileContent();
        assertEquals(expected, actual);
    }

    @Test
    void should_get_properties_from_json_file() throws IOException {
        Properties expected = new Properties();
        expected.setProperty("niceTo", "meet you!");
        expected.setProperty("hello", "world");
        String filePath = "src/test/resources/test.json";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getPropertiesFromFile();
        assertEquals(expected, actual);
    }

    @Test
    void should_get_properties_from_properties_file() throws IOException {
        Properties expected = new Properties();
        expected.setProperty("niceTo", "meet you!");
        expected.setProperty("hello", "world");
        String filePath = "src/test/resources/test.properties";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getPropertiesFromFile();
        assertEquals(expected, actual);
    }
}
