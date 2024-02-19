package com.khepri.black.services.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.IOException;
import java.util.Properties;

public class JsonServiceImpl implements IJsonService {
    @Override
    public Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonObject, javaClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Properties getPropertiesFromJsonObject(String jsonObject) {
        try {
            Object object = deserializeJsonObjectToJavaClass(jsonObject, Object.class);
            JavaPropsMapper javaPropsMapper = new JavaPropsMapper();
            return javaPropsMapper.writeValueAsProperties(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
