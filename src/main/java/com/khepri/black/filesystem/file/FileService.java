package com.khepri.black.filesystem.file;

import com.khepri.black.json.JsonService;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.util.Properties;

public class FileService {
    private final String filePath;
    private final FileType fileType;
    private final IFileHandler fileHandler;

    public FileService(String filePath) {
        this.filePath = filePath;
        this.fileType = FileType.valueOf(getFileExtension().toUpperCase());
        this.fileHandler = fileType.getFileHandler();
    }

    public FileType getFileType() {
        return fileType;
    }

    public String getFileExtension() {
        return FilenameUtils.getExtension(filePath);
    }

    public Object getFileContent() throws IOException {
        return fileHandler.getFileContent(filePath);
    }

    public Properties getPropertiesFromFile() throws IOException {
        if (getFileType().name().equalsIgnoreCase("json")) {
            return JsonService.getPropertiesFromJsonObject((String) getFileContent());
        }
        return (Properties) getFileContent();
    }
}
