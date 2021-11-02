package ru.job4j.cache;

public class Emulator {
    private final DirFileCache dir;

    public Emulator(String dirFileCache) {
        dir = new DirFileCache(dirFileCache);
    }

    public void load(String key) {
        dir.load(key);
    }

    public String getCacheData(String key) {
        return dir.get(key);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator("src/main/java/ru/job4j/cache/");
        emulator.load("Names.txt");
        String data = emulator.getCacheData("Names.txt");
        System.out.println("Names.txt :");
        System.out.println(data);
        emulator.load("Address.txt");
        data = emulator.getCacheData("Address.txt");
        System.out.println("Address.txt :");
        System.out.println(data);
    }
}
