package ru.job4j.ood.isp.menu;

import java.util.List;

public class ItemsOut implements Out {
    @Override
    public void show(List<Menu.Item> itemList) {
        for (Menu.Item item : itemList) {
            String result = item.getName();
            System.out.println(result);
        }
    }
}