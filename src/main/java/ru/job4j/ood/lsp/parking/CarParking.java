package ru.job4j.ood.lsp.parking;

public class CarParking implements Parking {
    private int parkingSpaceCar;
    private int parkingSpaceTruck;

    public CarParking(int parkingSpaceCar, int parkingSpaceTruck) {
        this.parkingSpaceCar = parkingSpaceCar;
        this.parkingSpaceTruck = parkingSpaceTruck;
    }

    @Override
    public boolean park(Vehicle car) {
        if (car.getSize() == 1) {
            return parkingCar(car);
        } else if (car.getSize() > 1) {
            return parkingTruck(car);
        }
        return false;
    }

    private boolean parkingTruck(Vehicle car) {
        if (parkingSpaceTruck >= 1) {
            parkingSpaceTruck--;
            return true;
        } else if (parkingSpaceCar >= car.getSize()) {
            parkingSpaceCar = parkingSpaceCar - car.getSize();
            return true;
        }
        return false;
    }

    private boolean parkingCar(Vehicle car) {
        if (parkingSpaceCar >= car.getSize()) {
            parkingSpaceCar--;
            return true;
        }
        return false;
    }
}