package hw7;

import java.util.ArrayList;

public class Transport {
    protected String name;
    protected double resource;
    protected double resourceСonsumption;
    protected ArrayList<TerrainType> impassableTerrain;

    public Transport(String name, double resource, double resourceСonsumption, ArrayList<TerrainType> terrainTypes) {
        this.name = name;
        this.resource = resource;
        this.resourceСonsumption = resourceСonsumption;
        this.impassableTerrain = terrainTypes;
    }
    public boolean move(double distance, TerrainType terrain) {
        if (impassableTerrain.contains(terrain)) {
            System.out.println(name + " не может двигаться по " + terrain);
            return false;
        }
        double resourceNeeded = distance * resourceСonsumption;
        if (resource >= resourceNeeded) {
            resource -= resourceNeeded;
            return true;
        } else {
            System.out.println("Недостаточно ресурса для передвижения на этом транспорте: " + name );
            return false;
        }
    }
    public String getName() {
        return name;
    }
}
