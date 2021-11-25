package ru.job4j.ood.lsp.parking;

public interface Vehicle {
    int getSize();
    LotType getLotType();
    boolean setLotType(LotType type);
}