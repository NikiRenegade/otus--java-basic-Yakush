package hw7;

import java.util.ArrayList;
import java.util.Arrays;

public class AllTerrainVehicle extends Transport{
    public AllTerrainVehicle(double fuel) {
        super("Вездеход", fuel, 0.7,
                new ArrayList<TerrainType>(Arrays.asList()));
    }
}
