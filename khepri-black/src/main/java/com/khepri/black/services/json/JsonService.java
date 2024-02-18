package com.khepri.black.services.json;

public interface JsonService {
    Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass);
}
