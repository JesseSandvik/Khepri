package com.khepri.black.filesystem.file;

public enum FileType {

    JSON {
        @Override
        public IFileHandler getFileHandler() {
            return new JsonFileHandler();
        }
    },

    PROPERTIES {
        @Override
        public IFileHandler getFileHandler() {
            return new PropertiesFileHandler();
        }
    };

    public abstract IFileHandler getFileHandler();
}
