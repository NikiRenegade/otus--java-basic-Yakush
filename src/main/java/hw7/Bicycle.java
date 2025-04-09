package hw7;

import java.util.ArrayList;
import java.util.Arrays;

public class Bicycle extends Transport {
    public Bicycle(double humanStamina) {
        super("Велосипед", humanStamina, 1.5,
                new ArrayList<TerrainType>(Arrays.asList(TerrainType.swamp)));
    }
}
