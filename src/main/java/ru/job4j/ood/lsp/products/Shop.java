package ru.job4j.ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    public Shop(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public List<Food> getList() {
        List<Food> current = foods;
        foods = new ArrayList<>();
        return current;
    }

    @Override
    public boolean add(Food food, long fresh) {
        if (fresh >= 25 && fresh < 75) {
            foods.add(food);
            return true;
        } else if (fresh < 100 && fresh >= 75) {
            food.setDiscount(25);
            food.setPrice(food.getPrice() * 0.75);
            foods.add(food);
            return true;
        }
        return false;
    }

    @Override
    public void removeList() {
        foods.clear();
    }
}
