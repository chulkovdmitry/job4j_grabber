package ru.job4j.ood.ocp;

public class Calc {
    private double a;
    private double b;
    public double result;

    public class Substraction {
        public void operation() {
            result = a - b;
        }
    }
}
