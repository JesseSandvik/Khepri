package com.khepri.black.commandline;

import com.khepri.black.command.CommandFactory;
import com.khepri.black.command.CommandType;
import com.khepri.black.command.ICommand;
import com.khepri.black.services.systems.file.FileSystemServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineBuilderTest {
    private ICommand command = CommandFactory.create("echo", CommandType.EXECUTOR);
    private final String jsonPropertiesFilePath = "src/test/resources/application.json";

    @Test
    void command_properties_are_loaded_from_json_file() {
        command = new CommandLineBuilder(command)
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        assertNotNull(command.getProperties());
    }

    @Test
    void command_name_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("name");
        assertNotNull(expected);

        command = new CommandLineBuilder(command)
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("name");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_version_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("version");
        assertNotNull(expected);

        command = new CommandLineBuilder(command)
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("version");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_synopsis_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("synopsis");
        assertNotNull(expected);

        command = new CommandLineBuilder(command)
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("synopsis");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }

    @Test
    void command_description_attribute_loaded_from_json_file() {
        Properties properties = new FileSystemServiceImpl().getPropertiesFromJsonFile(jsonPropertiesFilePath);

        String expected = properties.getProperty("description");
        assertNotNull(expected);

        command = new CommandLineBuilder(command)
                .getPropertiesFromJsonFile(jsonPropertiesFilePath)
                .build();

        String actual = command.getProperties().getProperty("description");
        assertNotNull(actual);

        assertEquals(expected, actual);
    }
}
