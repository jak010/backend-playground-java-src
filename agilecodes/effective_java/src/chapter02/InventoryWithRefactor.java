package chapter02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryWithRefactor {

    private List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSupplies() {
        Iterator<Supply> iterator = supplies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isContaminated()) {
                iterator.remove();
            }
        }
    }
}
