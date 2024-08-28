package chapter02;

import java.util.ArrayList;
import java.util.List;

interface Supply {

    boolean isContaminated();

};

// p64
public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSupplies() {
        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                supplies.remove(supply);
            }
        }
    }
}
