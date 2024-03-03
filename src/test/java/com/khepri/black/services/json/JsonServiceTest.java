package com.khepri.black.services.json;

import com.khepri.black.json.JsonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class JsonServiceTest {
    private IJsonService jsonService;
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

    @BeforeEach
    void initializeJsonService() {
        this.jsonService = new JsonService();
    }

    @Test
    void returns_instance_of_java_class_from_json_object() {
        Object actual = jsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        assertInstanceOf(Car.class, actual);
    }

    @Test
    void maps_associated_json_key_to_class_attribute() {
        Car actual = (Car) jsonService.deserializeJsonObjectToJavaClass(json, Car.class);
        assertEquals(color, actual.getColor());
    }

    @Test
    void returns_properties_from_json_object() {
        Properties actual = jsonService.getPropertiesFromJsonObject(json);
        assertEquals(actual.getProperty("color"), color);
    }
}
