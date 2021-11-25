package ru.job4j.ood.lsp.parking;

import java.util.List;
import java.util.Map;

public class CarParking implements Parking {
    private Vehicle[] ordinaryLot;
    private Vehicle[] trackLot;

    public CarParking(int ordinaryLot, int trackLot) {
        this.ordinaryLot = new Vehicle[ordinaryLot];
        this.trackLot = new Vehicle[trackLot];
    }

    @Override
    public boolean park(Vehicle car) {
        return false;
    }

    @Override
    public boolean leave(Vehicle car) {
        return false;
    }

    @Override
    public Map<LotType, List<Vehicle>> getCars() {
        return null;
    }
}
