package com.khepri.black.json;

import org.junit.jupiter.api.Test;
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
    void returns_instance_of_java_class_from_json_object() {
        Class<Car> expected = Car.class;
        Object actual = JsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        assertInstanceOf(expected, actual);
    }

    @Test
    void maps_associated_json_key_to_class_attribute() {
        String expected = color;
        Car car = (Car) JsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        String actual = car.getColor();
        assertEquals(expected, actual);
    }

    @Test
    void returns_properties_from_json_object() {
        String expected = color;
        Properties properties = JsonService.getPropertiesFromJsonObject(json);
        String actual = properties.getProperty("color");
        assertEquals(expected, actual);
    }
}
