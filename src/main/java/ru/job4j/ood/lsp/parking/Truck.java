package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {
    private int size;
    private LotType type;

    public Truck(int size) {
        this.size = size;
        this.type = LotType.TRUCK;
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
