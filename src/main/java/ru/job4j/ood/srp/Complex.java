package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Complex {
    List<String> strings = new ArrayList<>();

    public void out() {
        System.out.println(strings);
    }

    public void add(String s) {
        strings.add(s);
    }

    public void delete(int index) {
        strings.remove(index);
    }

    public void order() {
        strings.sort(Comparator.naturalOrder());
    }
}
