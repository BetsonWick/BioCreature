package Resources;

import Enumerations.Characteristics;
import Enumerations.Units;

import java.util.HashMap;

public class UnitCharacteristics {
    public static HashMap<Units, HashMap<Characteristics, Double>> info;

    static {
        info = new HashMap<>();
        HashMap<Characteristics, Double> infusoria = new HashMap<>();
        infusoria.put(Characteristics.MAX_SPEED, 2.0);
        infusoria.put(Characteristics.ACCELERATION, 0.05);
        infusoria.put(Characteristics.ROTATION_SPEED, 0.5);
        info.put(Units.INFUSORIA, infusoria);
    }
}
