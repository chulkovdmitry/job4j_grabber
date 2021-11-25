package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {
    private int size;
    private LotType type;

    public Car() {
        this.size = 1;
        this.type = LotType.CAR;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public LotType getLotType() {
        return null;
    }

    @Override
    public boolean setLotType(LotType type) {
        return false;
    }
}
