package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = "";
        try {
            result = Files.readString(Path.of(cachingDir, key));
            put(key, result);
        } catch (IOException e) {
            System.out.println("class DirFileCache, protected String load()"); e.printStackTrace();
        }
        return result;
    }
}
