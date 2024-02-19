package com.khepri.black.services.json;

import java.util.Properties;

public interface JsonService {
    Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass);
    Properties getPropertiesFromJsonObject(String jsonObject);
}
