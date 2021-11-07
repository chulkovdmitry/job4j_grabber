package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Emulator {

    private static final String MENU_DELIMITER = "======";
    private static final String MENU_FILE_NAME = "Enter file name:";
    private static final String MENU_LOAD = "load";
    private static final String MENU_GET = "get";
    private static final String MENU_EXIT = "exit";

    public static void main(String[] args) throws IOException {
        System.out.println("Enter your directory path:");
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();
        if (!new File(dir).isDirectory()) {
            throw new IllegalArgumentException("Not a directory");
        }
        System.out.println(MENU_DELIMITER);
        AbstractCache<String, String> cache = new DirFileCache(dir);
        boolean isRunning = true;
        System.out.printf("Enter \"%s\" to load file%n", MENU_LOAD);
        System.out.printf("Enter \"%s\" to display file's content%n", MENU_GET);
        System.out.printf("Enter \"%s\" to exit%n", MENU_EXIT);
        System.out.println(MENU_DELIMITER);
        while (isRunning) {
            String input = in.nextLine();
            if (input.equals(MENU_EXIT)) {
                isRunning = false;
            }
            if (input.equals(MENU_LOAD)) {
                System.out.println(MENU_FILE_NAME);
                String fileName = in.nextLine();
                cache.put(fileName, cache.load(fileName));
                System.out.println(MENU_DELIMITER);
            }
            if (input.equals(MENU_GET)) {
                System.out.println(MENU_FILE_NAME);
                String value = cache.get(in.nextLine());
                System.out.println(value != null ? value : "No content or no such file found");
                System.out.println(MENU_DELIMITER);
            }
        }
    }
}
