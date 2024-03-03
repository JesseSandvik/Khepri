package com.khepri.black.filesystem.file;

import org.apache.commons.io.FilenameUtils;

public class FileService {
    private final String filePath;
    private final FileType fileType;
    private final IFileHandler fileHandler;

    public FileService(String filePath) {
        this.filePath = filePath;
        this.fileType = FileType.valueOf(getFileExtension().toUpperCase());
        this.fileHandler = fileType.getFileHandler();
    }

    public String getFilePath() {
        return filePath;
    }

    public FileType getFileType() {
        return fileType;
    }

    public IFileHandler getFileHandler() {
        return fileHandler;
    }

    public String getFileExtension() {
        return FilenameUtils.getExtension(filePath);
    }

    public Object getFileContent() {
        return fileHandler.getFileContent(filePath);
    }
}
