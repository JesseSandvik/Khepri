package com.khepri.black.services.systems.file;

import java.util.List;
import java.util.Properties;

public interface IFileSystemService {
    String read_text_file(String filePath);
    Properties getPropertiesFromJsonFile(String filePath);
    Integer executeCommand(List<String> command);
}
