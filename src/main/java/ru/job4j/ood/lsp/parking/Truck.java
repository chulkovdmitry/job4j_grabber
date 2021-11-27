package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    public int getSize() {
        if (size > 1) {
            return size;
        }
        return 0;
    }
}
