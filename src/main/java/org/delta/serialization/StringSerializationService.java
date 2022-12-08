package org.delta.serialization;

public interface StringSerializationService {

    public String serialization(Object objectToSerialization);

    public <T> T deserialization(String objectToDeserialization, Class<T> classOf);
}
