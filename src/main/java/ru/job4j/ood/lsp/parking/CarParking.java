package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private final int carLotsCapacity;
    private final int truckLotsCapacity;
    private final List<Vehicle> carLots;
    private final List<Vehicle> truckLots;

    public CarParking(int carLotsCapacity, int truckLotsCapacity) {
        this.carLotsCapacity = carLotsCapacity;
        this.truckLotsCapacity = truckLotsCapacity;
        this.carLots = new ArrayList<>(carLotsCapacity);
        this.truckLots = new ArrayList<>(truckLotsCapacity);
    }

    @Override
    public boolean park(Vehicle car) {
        int freeCarLots = carLotsCapacity - carLots.size();
        if (car.getSize() == 1 && freeCarLots >= car.getSize()) {
            carLots.add(car);
            return true;
        }
        int freeTruckLots = truckLotsCapacity - truckLots.size();
        if (car.getSize() > 1 && freeTruckLots > 0) {
            truckLots.add(car);
            return true;
        }
        if (car.getSize() > 1 && freeTruckLots == 0) {
            if (freeCarLots >= car.getSize()) {
                for (int i = 0; i < car.getSize(); i++) {
                    carLots.add(car);
                }
                return true;
            }
        }
        return false;
    }
}