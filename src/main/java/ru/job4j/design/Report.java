package ru.job4j.design;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
