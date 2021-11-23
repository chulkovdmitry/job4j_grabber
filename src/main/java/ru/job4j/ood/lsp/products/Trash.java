package ru.job4j.ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    List<Food> foods = new ArrayList<>();
    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public boolean add(Food food, long fresh) {
        if (fresh <= 100) {
            System.out.println("Продукт годен к продаже");
            return false;
        }
        return true;
    }
}
