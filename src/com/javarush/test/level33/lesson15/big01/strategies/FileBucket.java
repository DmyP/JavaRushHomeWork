package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
        }
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        }
        catch (IOException e){
        }
        return 0L;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (Exception e) {
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            Entry entry = (Entry) objectInputStream.readObject();
            return entry;
        } catch (Exception e) {
        }
        return null;
    }

    public void remove() {
        if (path != null) try {
            Files.delete(path);
        } catch (IOException e) {
        }
    }
}
