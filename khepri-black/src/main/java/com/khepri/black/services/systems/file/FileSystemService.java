package com.khepri.black.services.systems.file;

import java.util.Properties;

public interface FileSystemService {
    String read_text_file(String filePath);
    Properties getPropertiesFromJsonFile(String filePath);
}
