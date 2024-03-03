package com.khepri.black.command.properties.loader;

import com.khepri.black.command.ICommand;
import com.khepri.black.filesystem.FileSystemService;

import java.util.Properties;

public enum CommandPropertiesLoaderSource {
    FILE {
        @Override
        public void load(ICommand command, String source) {
            Properties properties = FileSystemService.getPropertiesFromFile(source);
            command.setProperties(properties);
        }
    };

    public abstract void load(ICommand command, String source);
}
