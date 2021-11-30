package ru.job4j.ood.dip.violations;

import ru.job4j.ood.dip.Order;
import ru.job4j.ood.dip.User;

public class OrderForStorage {
    public void payOrder(User user, Order order) {
        if (user.getName().isEmpty()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
    }
}
