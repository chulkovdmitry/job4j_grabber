package ru.job4j.design;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineBuhTest {

    @Test
    public void whenGeneratedBuh() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineBuh(store);
        String expect = "Name; Hired; Fired; SalaryInDollar;" +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() / 71 + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }
}