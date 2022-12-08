package org.delta.storage;

public interface Storage {

    public void save(String dataToSave, String path);

    public String read(String path);

}
