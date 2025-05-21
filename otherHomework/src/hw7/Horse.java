package hw7;

import java.util.ArrayList;
import java.util.Arrays;

public class Horse extends Transport {
    public Horse(double stamina) {
        super("Лошадь", stamina, 1,
                new ArrayList<TerrainType>(Arrays.asList(TerrainType.swamp)));
    }
}
