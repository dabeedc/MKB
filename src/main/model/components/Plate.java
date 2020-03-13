package model.components;

// Represents a plate of the keyboard having a material type and size
public class Plate {
    private String plateMaterial;
    private String plateSize;

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
    public void setPlateMaterial(String plateMaterial) {
        this.plateMaterial = plateMaterial;
    }

    // MODIFIES: this
    // EFFECTS: sets the size of the plate
    public void setPlateSize(String plateSize) {
        this.plateSize = plateSize;
    }
}