package com.khepri.black.filesystem.file;

public enum FileType {
    JSON {
        @Override
        public IFileHandler getFileHandler() {
            return new JsonFileHandlerImpl();
        }
    },
    PROPERTIES {
        @Override
        public IFileHandler getFileHandler() {
            return new PropertiesFileHandlerImpl();
        }
    };

    public abstract IFileHandler getFileHandler();
}
