package com.khepri.black.filesystem.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertiesFileHandler implements IFileHandler {
    @Override
    public Object getFileContent(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }
}
