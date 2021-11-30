package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu implements Menu {
    private List<Item> list = new ArrayList<>();

    @Override
    public void add(String parentName, Item child) {
        if (parentName.equals("Menu")) {
            list.add(child);
        } else {
            add(parentName, child, list);
        }
    }

    private void add(String parentName, Item child, List<Item> list) {
        for (Item item : list) {
            if (item.getName().contains(parentName)) {
                item.addItem(child);
            } else {
                add(parentName, child, item.getItemList());
            }
        }
    }

    public void print() {
        for (Item item : list) {
            print(item);
        }
    }

    private void print(Item item) {
        System.out.println(item.getName());
        for (Item itemChild : item.getItemList()) {
            print(itemChild);
        }
    }

    private void console() {
        Out out = new ItemsOut();
    }

    public void init(Scanner scanner) {
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

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        Scanner scanner = new Scanner(System.in);
        menu.add("Menu", new Item("Задача 1.", new DoAction()));
        menu.add("1.", new Item("--Задача 1.1.", new DoAction()));
        menu.add("1.", new Item("--Задача 1.2.", new DoAction()));
        menu.add("1.1.", new Item("----Задача 1.1.1.", new DoAction()));
        menu.add("1.1.", new Item("----Задача 1.1.2.", new DoAction()));
        menu.add("Exit", new Item("Out", new DoAction()));
        menu.print();
        menu.init(scanner);
    }
}
