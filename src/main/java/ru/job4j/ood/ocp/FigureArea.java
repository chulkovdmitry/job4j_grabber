package ru.job4j.ood.ocp;

public class FigureArea {
    private static class Area {
        public double area(double radius) {
            return 3.14 * Math.pow(radius, 2);
        }
    }
}
