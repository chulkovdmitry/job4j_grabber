package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarParkingTest {

    @Test
    public void whenParkCar() {
        CarParking parking = new CarParking(1, 0);
        Car car = new Car();
        assertTrue(parking.park(car));
    }

    @Test
    public void whenParkTruck() {
        CarParking parking = new CarParking(0, 1);
        Truck truck = new Truck(3);
        assertTrue(parking.park(truck));
    }
    @Test
    public void whenNoCarLots() {
        CarParking parking = new CarParking(0, 0);
        Car car = new Car();
        assertFalse(parking.park(car));
    }

    @Test
    public void whenNoTruckLots() {
        CarParking parking = new CarParking(4, 0);
        Truck truck = new Truck(3);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenNoLots() {
        CarParking parking = new CarParking(2, 0);
        Truck truck = new Truck(3);
        assertFalse(parking.park(truck));
    }

    @Test
    public void leave() {
        CarParking parking = new CarParking(1, 0);
        Car car = new Car();
        parking.park(car);
        assertTrue(parking.leave(car));
    }

    @Test
    public void leaveCarWhenNoCar() {
        CarParking parking = new CarParking(0, 0);
        Car car = new Car();
        parking.park(car);
        assertFalse(parking.leave(car));
    }

    @Test
    public void leaveTruck() {
        CarParking parking = new CarParking(3, 0);
        Truck truck = new Truck(3);
        parking.park(truck);
        assertTrue(parking.leave(truck));
    }

    @Test
    public void leaveTruckWhenNoTruck() {
        CarParking parking = new CarParking(0, 0);
        Truck truck = new Truck(3);
        parking.park(truck);
        assertFalse(parking.leave(truck));
    }
}