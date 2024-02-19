package com.khepri.black.services.systems.file;

import com.khepri.black.services.json.JsonService;
import com.khepri.black.services.json.JsonServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileSystemServiceImpl implements FileSystemService {
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
        JsonService jsonService = new JsonServiceImpl();
        return jsonService.getPropertiesFromJsonObject(jsonFileContent);
    }
}
