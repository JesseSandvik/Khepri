package com.khepri.black.services.systems.file;

import com.khepri.black.services.json.IJsonService;
import com.khepri.black.services.json.JsonServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileSystemServiceImpl implements IFileSystemService {
    @Override
    public String read_text_file(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Properties getPropertiesFromJsonFile(String filePath) {
        String jsonFileContent = read_text_file(filePath);
        IJsonService jsonService = new JsonServiceImpl();
        return jsonService.getPropertiesFromJsonObject(jsonFileContent);
    }

    @Override
    public Integer executeCommand(List<String> command) {
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
}
