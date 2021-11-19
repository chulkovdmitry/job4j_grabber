package ru.job4j.design;

import java.util.function.Predicate;

public class ReportEngineBuh implements Report {
    private Store store;

    public ReportEngineBuh(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryInDollar;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 71).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
