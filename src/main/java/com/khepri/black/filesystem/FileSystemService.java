package com.khepri.black.filesystem;

import com.khepri.black.filesystem.file.FileService;
import com.khepri.black.json.JsonService;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class FileSystemService {
    public static Integer executeCommand(List<String> command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(command);
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            return process.exitValue();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getPropertiesFromFile(String filePath) {
        FileService fileService = new FileService(filePath);
        Object fileContent = fileService.getFileContent();

        if (fileContent instanceof Properties &&
                fileService.getFileType().name().equalsIgnoreCase("properties")) {
            return (Properties) fileContent;
        }

        if (fileContent instanceof String && fileService.getFileType().name().equalsIgnoreCase("json")) {
            return JsonService.getPropertiesFromJsonObject((String) fileContent);
        }

        try {
            Properties properties = new Properties();
            assert fileContent instanceof FileInputStream;
            properties.load((FileInputStream) fileContent);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
