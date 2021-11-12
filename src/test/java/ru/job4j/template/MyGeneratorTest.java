package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MyGeneratorTest {

    @Ignore
    @Test
    public void produce() {
        Generator gen = new MyGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
        Assert.assertEquals(rsl, "I am a Petr, Who are you? ");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void produceWhenLessArgs() {
        Generator gen = new MyGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
    }

    @Ignore
    @Test
    public void produceWhenMoreArgs() {
        Generator gen = new MyGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        args.put("age", "28");
        String rsl = gen.produce("I am a ${name}, Who are ${subject}? ", args);
        Assert.assertNotEquals(rsl, "I am a Pavel, Who are you? ");
    }

}