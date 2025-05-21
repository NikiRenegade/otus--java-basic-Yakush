package hw7;

import java.util.ArrayList;
import java.util.Arrays;

public class Car extends Transport {
    public Car(double fuel) {
        super("Машина", fuel, 0.5,
                new ArrayList<TerrainType>(Arrays.asList(TerrainType.forest, TerrainType.swamp)));
    }
}
