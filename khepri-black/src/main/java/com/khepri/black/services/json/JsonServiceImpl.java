package com.khepri.black.services.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonServiceImpl implements JsonService {
    @Override
    public Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonObject, javaClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
