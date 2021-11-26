package ru.job4j.ood.isp;

import java.util.List;

public class Kukuruznik implements Airplane {

    List<String> passengers;

    public Kukuruznik(List<String> passengers) {
        this.passengers = passengers;
    }

    @Override
    public void fly() {
    }

    @Override
    public List<String> getPassengers() {
        return passengers;
    }

    @Override
    public void overturn() {
        System.out.println("Не нужно выполнять фигуры высшего пилотажа, поэтому глушим метод");
    }
}
