package org.delta.serialization;

import com.google.gson.Gson;

import javax.inject.Singleton;

@Singleton
public class GsonSerializationService implements StringSerializationService {

    private Gson gson = new Gson();

    @Override
    public String serialization(Object objectToSerialization) {
        return this.gson.toJson(objectToSerialization);
    }

    @Override
    public <T> T deserialization(String objectToDeserialization, Class<T> classOf) {
        return this.gson.fromJson(objectToDeserialization, classOf);
    }
}
