package ru.job4j.ood.isp;

public class Perforator implements Driller {

    @Override
    public void screw() {
        System.out.println("Описываем работу метода");
    }

    @Override
    public void reverse() {
        System.out.println("Описываем работу метода");
    }

    @Override
    public void punch() {
        System.out.println("Нет опции, глушим");
    }

    @Override
    public void illuminate() {
        System.out.println("Нет опции, глушим");
    }
}
