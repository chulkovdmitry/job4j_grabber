package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;

public class CarParkingTest {

    @Test
    public void whenParkCar() {
        CarParking parking = new CarParking(1, 0);
        Car car = new Car();
        assertTrue(parking.park(car));
    }

    @Test
    public void whenNoCarLots() {
        CarParking parking = new CarParking(0, 0);
        Car car = new Car();
        assertFalse(parking.park(car));
    }

    @Test
    public void whenParkTruck() {
        CarParking parking = new CarParking(0, 1);
        Truck truck = new Truck(3);
        assertTrue(parking.park(truck));
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
    public void validTruckWhenNoCarLots() {
        CarParking parking = new CarParking(0, 6);
        Truck truck1 = new Truck(3);
        Truck truck2 = new Truck(4);
        parking.park(truck1);
        parking.park(truck2);
        assertEquals(parking.getFreeSpaceTruck(), 4);
    }

    @Test
    public void validTrucksOnCarsSpacesWhenNoTruckLots() {
        CarParking parking = new CarParking(10, 0);
        Truck truck1 = new Truck(2);
        Truck truck2 = new Truck(4);
        parking.park(truck1);
        parking.park(truck2);
        assertEquals(parking.getFreeSpaceCar(), 4);
    }

    @Test
    public void validTrucksAndCarOnCarsSpacesWhenNoTruckLots() {
        CarParking parking = new CarParking(10, 0);
        Truck truck1 = new Truck(3);
        Truck truck2 = new Truck(5);
        Car car = new Car();
        parking.park(truck1);
        parking.park(truck2);
        parking.park(car);
        assertEquals(parking.getFreeSpaceCar(), 1);
    }

    @Test
    public void validTrucksAndCarOnBothSpacesWhenCarsAndTruckLots() {
        CarParking parking = new CarParking(10, 1);
        Truck truck1 = new Truck(3);
        Truck truck2 = new Truck(5);
        Car car = new Car();
        parking.park(truck1);
        parking.park(truck2);
        parking.park(car);
        assertEquals(parking.getFreeSpaceCar(), 4);
    }
}