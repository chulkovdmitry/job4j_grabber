package ru.job4j.design;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR implements Report {

    private Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        Comparator<Employee> cmp = Comparator.comparingDouble(Employee::getSalary).reversed();
        List<Employee> rsl = store.findBy(filter);
        rsl.sort(cmp);
        for (Employee employee : rsl) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
