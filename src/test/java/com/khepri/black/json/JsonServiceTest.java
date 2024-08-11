package com.khepri.black.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class JsonServiceTest {
    private static final String color = "Black";
    static String json = "{\"color\":\"" + color + "\"}";
    static class Car {
        private String color;
        private String type;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    @Test
    void should_return_instance_of_java_class_from_json_object() throws JsonProcessingException {
        Class<Car> expected = Car.class;
        Object actual = JsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        assertInstanceOf(expected, actual);
    }

    @Test
    void should_map_associated_json_key_to_class_attribute() throws JsonProcessingException {
        String expected = color;
        Car car = (Car) JsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        String actual = car.getColor();
        assertEquals(expected, actual);
    }

    @Test
    void should_return_properties_from_json_object() throws IOException {
        String expected = color;
        Properties properties = JsonService.getPropertiesFromJsonObject(json);
        String actual = properties.getProperty("color");
        assertEquals(expected, actual);
    }
}
