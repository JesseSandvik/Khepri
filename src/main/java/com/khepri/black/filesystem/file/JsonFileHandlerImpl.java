package com.khepri.black.filesystem.file;

import com.khepri.black.filesystem.file.IFileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class JsonFileHandlerImpl implements IFileHandler {
    @Override
    public Object getFileContent(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
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
}
