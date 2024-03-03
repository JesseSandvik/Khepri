package com.khepri.black.filesystem.file;

import com.khepri.black.filesystem.file.IFileHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertiesFileHandlerImpl implements IFileHandler {
    @Override
    public Object getFileContent(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
