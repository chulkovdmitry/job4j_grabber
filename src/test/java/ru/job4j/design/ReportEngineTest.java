package ru.job4j.design;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import com.google.gson.GsonBuilder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void WhenJSONReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Semen", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new JSONReport(store);
        StringBuilder expect = new StringBuilder();
        var gson = new GsonBuilder().create();
        expect.append("[")
                .append(gson.toJson(worker))
                .append(",")
                .append(gson.toJson(worker2))
                .append("]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void WhenXMLReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 200);
        store.add(worker);
        store.add(worker2);
        Report engine = new XMLReport(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "\n" +
                "<employees>\n" +
                "    <employee>\n" +
                "        <fired>" + dateFormat.format(worker.getHired().getTime()) + "</fired>\n" +
                "        <hired>" + dateFormat.format(worker.getHired().getTime()) + "</hired>\n" +
                "        <name>Ivan</name>\n" +
                "        <salary>100.0</salary>\n" +
                "    </employee>\n" +
                "    <employee>\n" +
                "        <fired>" + dateFormat.format(worker.getHired().getTime()) + "</fired>\n" +
                "        <hired>" + dateFormat.format(worker.getHired().getTime()) + "</hired>\n" +
                "        <name>Oleg</name>\n" +
                "        <salary>200.0</salary>\n" +
                "    </employee>\n" +
                "</employees>\n";
        assertThat(engine.generate(em -> true), is(expect));
    }

}