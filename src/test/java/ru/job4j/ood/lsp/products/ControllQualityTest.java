package ru.job4j.ood.lsp.products;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllQualityTest {

    @Test
    public void fresh() {
        ControllQuality checker = new ControllQuality(List.of(new Shop()));
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        assertEquals(checker.fresh(milk), 80);
    }

    @Test
    public void whenNotFresh() {
        ControllQuality checker = new ControllQuality(List.of(new Shop()));
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(6), 60, 0);
        assertEquals(checker.fresh(milk), 120);
    }

    @Test
    public void whenDiscount() {
        ControllQuality checker = new ControllQuality(List.of(new Shop()));
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        checker.distribute(milk);
        assertEquals(milk.getDiscount(), 25);
    }

    @Test
    public void whenDistribute() {
        ControllQuality checker = new ControllQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        Bread bread = new Bread("Bread", now, 32, 0);
        Milk anotherMilk = new Milk("Milk", now.minusDays(2), 60, 0);
        Bread anotherBread = new Bread("Bread", now.minusDays(10), 32, 0);
        checker.distribute(milk);
        checker.distribute(bread);
        checker.distribute(anotherMilk);
        checker.distribute(anotherBread);
        List<Storage> storages = checker.getStorages();
        assertEquals(Arrays.toString(new int[]{
                        storages.get(0).getList().size(),
                        storages.get(1).getList().size(),
                        storages.get(2).getList().size()}),
                Arrays.toString(new int[]{1, 2, 1}));
    }

    @Test
    public void whenResort() {
        ControllQuality checker = new ControllQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        Bread bread = new Bread("Bread", now, 32, 0);
        Milk anotherMilk = new Milk("Milk", now.minusDays(2), 60, 0);
        Bread anotherBread = new Bread("Bread", now.minusDays(10), 32, 0);
        checker.distribute(milk);
        checker.distribute(bread);
        checker.distribute(anotherMilk);
        checker.distribute(anotherBread);
        bread.setCreateDate(now.minusDays(4));
        bread.setExpiryDate(now.minusDays(1));
        checker.resort();
        List<Storage> storages = checker.getStorages();
        assertEquals(Arrays.toString(new int[]{
                        storages.get(0).getList().size(),
                        storages.get(1).getList().size(),
                        storages.get(2).getList().size()}),
                Arrays.toString(new int[]{0, 2, 3}));
    }
}