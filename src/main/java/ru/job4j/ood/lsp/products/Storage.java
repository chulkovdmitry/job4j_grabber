package ru.job4j.ood.lsp.products;

import java.util.List;

public interface Storage {
    List<Food> getList();
    boolean add(Food food, long fresh);
    void removeList();
}
