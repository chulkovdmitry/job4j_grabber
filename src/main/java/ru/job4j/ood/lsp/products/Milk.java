package ru.job4j.ood.lsp.products;

import java.time.LocalDate;

public class Milk extends Food {
    private double volume;

    public Milk(String name, LocalDate createDate, double price, int discount) {
        super(name, createDate.plusDays(5), createDate, price, discount);
        this.volume = 1;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
