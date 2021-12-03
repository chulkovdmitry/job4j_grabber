package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    private void console() {
        Out out = new ItemsOut();
    }

    public void init() {
        boolean run = true;
        while (run) {
            console();
            System.out.println("Select: ");
            String select = scanner.nextLine();
            if (!select.equals("Exit")) {
                System.out.println("Пользователь выбрал пункт меню: " + select);
            } else {
                run = false;
            }
        }
    }
}
