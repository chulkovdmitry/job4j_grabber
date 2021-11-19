package ru.job4j.design;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineProgTest {

    @Test
    public void whenGeneratedProgrammer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineProg(store);
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getSalary() == 100), is(expect.toString()));
    }
}