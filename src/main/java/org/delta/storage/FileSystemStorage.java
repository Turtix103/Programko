package org.delta.storage;

import org.delta.utils.IO;

import java.io.IOException;

public class FileSystemStorage implements Storage {

    @Override
    public void save(String dataToSave, String path) {
        try {
            IO.writeFile(path, dataToSave);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read(String path) {
        try {
            return IO.readFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
