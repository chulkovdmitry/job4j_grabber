package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMax() {
        MaxMin max = new MaxMin();
        List<Integer> list = List.of(7, 12, 23, 16, 52, 50);
        Comparator<Integer> comparator = Integer::compareTo;
        int result = max.max(list, comparator);
        assertThat(result, is(52));
    }

    @Test
    public void whenMin() {
        MaxMin min = new MaxMin();
        List<Integer> list = List.of(64, 45, 3, 5);
        Comparator<Integer> comparator = Integer::compareTo;
        int result = min.min(list, comparator);
        assertThat(result, is(3));
    }

    @Test
    public void whenMaxTwo() {
        List<String> rsl = List.of("Boney M", "Abba", "AC DC", "Depeche Mode", "Foreigner");
        MaxMin maxMin = new MaxMin();
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        assertThat(maxMin.max(rsl, cmp), is("Foreigner"));
    }

    @Test
    public void whenMinTwo() {
        List<String> rsl = List.of("Boney M", "Abba", "AC DC", "Depeche Mode", "Foreigner");
        MaxMin maxMin = new MaxMin();
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        assertThat(maxMin.min(rsl, cmp), is("AC DC"));
    }
}