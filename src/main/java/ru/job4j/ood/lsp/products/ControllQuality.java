package ru.job4j.ood.lsp.products;

import java.time.LocalDate;
import java.util.List;

public class ControllQuality {
    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public long fresh(Food food) {
        long term = food.getExpiryDate().toEpochDay() - food.getCreateDate().toEpochDay();
        long now = LocalDate.now().toEpochDay() - food.getCreateDate().toEpochDay();
        return now * 100 / term;
    }

    public boolean distribute(Food food) {
        long fresh = fresh(food);
        boolean rsl = false;
        for (Storage storage : storages) {
            rsl = storage.add(food, fresh);
            if (rsl) {
                break;
            }
        }
        return rsl;
    }

    public List<Storage> getStorages() {
        return storages;
    }
}
