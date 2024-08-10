package com.khepri.black.filesystem.file;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {

    @Test
    void reads_json_content_from_file() {
        String expected = "{  \"hello\": \"world\",  \"niceTo\": \"meet you!\"}";
        String filePath = "src/test/resources/test.json";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getFileContent();
        assertEquals(expected, actual);
    }

    @Test
    void reads_properties_from_file() {
        Properties expected = new Properties();
        expected.setProperty("niceTo", "meet you!");
        expected.setProperty("hello", "world");
        String filePath = "src/test/resources/test.properties";
        FileService fileService = new FileService(filePath);
        Object actual = fileService.getFileContent();
        assertEquals(expected, actual);
    }
}
