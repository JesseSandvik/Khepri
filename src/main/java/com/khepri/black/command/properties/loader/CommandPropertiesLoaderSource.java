package com.khepri.black.command.properties.loader;

import com.khepri.black.command.ICommand;
import com.khepri.black.filesystem.file.FileService;
import com.khepri.black.json.JsonService;

import java.util.Properties;

public enum CommandPropertiesLoaderSource {
    FILE {
        @Override
        public void load(ICommand command, String source) {
            FileService fileService = new FileService(source);
            Object fileContent = fileService.getFileContent();

            if (fileService.getFileType().name().equalsIgnoreCase("json")) {
                command.setProperties(JsonService.getPropertiesFromJsonObject((String) fileContent));
            }

            if (fileService.getFileType().name().equalsIgnoreCase("properties")) {
                command.setProperties((Properties) fileContent);
            }
        }
    };

    public abstract void load(ICommand command, String source);
}
