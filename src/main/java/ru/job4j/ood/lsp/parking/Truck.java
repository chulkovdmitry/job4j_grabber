package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {
    private final int size;
    private LotType type;

    public Truck(int size) {
        this.size = size;
        this.type = LotType.TRUCK;
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
