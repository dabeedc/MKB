package model.Components;

// Represents a plate having a material type and size
public class Plate {
    private static String plateMaterial;
    private static String plateSize;

    // EFFECTS: Constructs a plate with no plateMaterial and no plateSize
    public Plate() {
        plateMaterial = "";
        plateSize = "";
    }

    // Getters
    // EFFECTS: returns the material of the plate
    public String getPlateMaterial() {
        return plateMaterial;
    }

    // EFFECTS: returns the size of the plate
    public String getPlateSize() {
        return plateSize;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets material of the plate
    public static void setPlateMaterial(String plateMaterial) {
        Plate.plateMaterial = plateMaterial;
    }

    // MODIFIES: this
    // EFFECTS: sets the size of the plate
    public static void setPlateSize(String plateSize) {
        Plate.plateSize = plateSize;
    }
}
