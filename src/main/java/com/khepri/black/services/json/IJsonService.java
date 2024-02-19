package com.khepri.black.services.json;

import java.util.Properties;

public interface IJsonService {
    Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass);
    Properties getPropertiesFromJsonObject(String jsonObject);
}
