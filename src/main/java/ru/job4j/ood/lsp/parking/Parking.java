package ru.job4j.ood.lsp.parking;

import java.util.List;
import java.util.Map;

public interface Parking {
    boolean park(Vehicle car);
    Map<LotType, List<Vehicle>> getCars();
}
