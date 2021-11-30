package ru.job4j.ood.dip.violations;

import ru.job4j.ood.dip.ShopStore;

import java.util.ArrayList;
import java.util.List;

public class Employer {
    List<String> employersList = new ArrayList<>();

    void addDeveloper(String name) {
        employersList.add(name);
    }

    void addDesigner(String name) {
        employersList.add(name);
    }

    void addTester(String name) {
        employersList.add(name);
    }
}
