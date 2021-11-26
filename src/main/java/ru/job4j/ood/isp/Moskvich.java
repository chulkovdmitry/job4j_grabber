package ru.job4j.ood.isp;

public class Moskvich implements Car {

    @Override
    public void engine() {
        System.out.println("Двигатель есть");
    }

    @Override
    public void transmission() {
        System.out.println("Трансмиссия есть");
    }

    @Override
    public void autoSound() {
        System.out.println("Магнитола есть");
    }

    @Override
    public void ruleHeater() {
        System.out.println("Подогрева руля нет, поэтому глушим этот метод");
    }

    @Override
    public void condition() {
        System.out.println("Кондиционера нет, поэтому глушим метод");
    }

}
