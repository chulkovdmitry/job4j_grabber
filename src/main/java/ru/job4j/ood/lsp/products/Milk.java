package ru.job4j.ood.lsp.products;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate createDate, double price, int discount) {
        super(name, createDate.plusDays(5), createDate, price, discount);
    }
}
