import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private final HashMap<String, ArrayList<String>> storageUnits;

    public StorageFacility() {
        this.storageUnits = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storageUnits.putIfAbsent(unit, new ArrayList<>());
        this.storageUnits.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if (!this.storageUnits.containsKey(storageUnit)) {
            return;
        }

        this.storageUnits.get(storageUnit).remove(item);
        if (this.storageUnits.get(storageUnit).isEmpty()) {
            this.storageUnits.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsToPrint = new ArrayList<>();
        for (String unit : this.storageUnits.keySet()) {
            if (this.storageUnits.get(unit).isEmpty()) {
                continue;
            }
            unitsToPrint.add(unit);
        }
        return unitsToPrint;
    }
}
