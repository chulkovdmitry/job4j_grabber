package ru.job4j.ood.lsp.parking;

import java.util.List;
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
    public void getVehicleWhenNoTrackLots() {
        CarParking parking = new CarParking(6, 0);
        Truck truck = new Truck(3);
        parking.park(truck);
        parking.park(new Car());
        assertEquals(parking.getCars().get(LotType.CAR).size(), 1);
    }

    @Test
    public void getVehicleWhenNoCarLots() {
        CarParking parking = new CarParking(0, 2);
        parking.park(new Truck(3));
        parking.park(new Car());
        List<Vehicle> trucks = parking.getCars().get(LotType.TRUCK);
        List<Vehicle> cars = parking.getCars().get(LotType.CAR);
        assertEquals(trucks.size(), 1);
    }

    @Test
    public void getVehicleWhenNoEnoughLots() {
        CarParking parking = new CarParking(2, 0);
        parking.park(new Truck(3));
        parking.park(new Car());
        List<Vehicle> cars = parking.getCars().get(LotType.CAR);
        assertEquals(cars.size(), 1);
    }

}