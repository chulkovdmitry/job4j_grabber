package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarParkingTest {

    @Ignore
    @Test
    public void whenParkCar() {
        CarParking parking = new CarParking(1, 0);
        Car car = new Car();
        assertTrue(parking.park(car));
    }

    @Ignore
    @Test
    public void whenParkTruck() {
        CarParking parking = new CarParking(0, 1);
        Truck truck = new Truck(3);
        assertTrue(parking.park(truck));
    }

    @Ignore
    @Test
    public void whenNoCarLots() {
        CarParking parking = new CarParking(0, 0);
        Car car = new Car();
        assertFalse(parking.park(car));
    }

    @Ignore
    @Test
    public void whenNoTruckLots() {
        CarParking parking = new CarParking(4, 0);
        Truck truck = new Truck(3);
        assertTrue(parking.park(truck));
    }

    @Ignore
    @Test
    public void whenNoLots() {
        CarParking parking = new CarParking(2, 0);
        Truck truck = new Truck(3);
        assertFalse(parking.park(truck));
    }

}