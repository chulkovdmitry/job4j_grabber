package ru.job4j.ood.lsp.products;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate createDate, double price, int discount) {
        super(name, createDate.plusDays(3), createDate, price, discount);
    }
}
