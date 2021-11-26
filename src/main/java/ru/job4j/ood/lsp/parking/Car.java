package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {
    private final int size;
    private LotType type;

    public Car() {
        this.size = 1;
        this.type = LotType.CAR;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LotType getLotType() {
        return type;
    }

    @Override
    public boolean setLotType(LotType type) {
        if (this.type == type) {
            return false;
        }
        this.type = type;
        return true;
    }
}
