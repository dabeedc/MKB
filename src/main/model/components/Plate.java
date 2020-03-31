package model.components;

import model.Rateable;

// Represents a plate of the keyboard having a material type and size
public class Plate implements Rateable {
    private String plateMaterial;
    private String plateSize;
    private int soundRating;
    private int feelRating;
    private int weightRating;

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

    // MODIFIES: this
    // EFFECTS: rates the Plate based on the properties
    @Override
    public void rate() {
        if (getPlateMaterial().equals("Brass")) {
            soundRating += 2;
        } else if (getPlateMaterial().equals("Aluminum")) {
            soundRating += 1;
        } else if (getPlateMaterial().equals("Polycarbonate")) {
            soundRating -= 1;
        }

        if (getPlateMaterial().equals("Brass")) {
            feelRating += 2;
        } else if (getPlateMaterial().equals("Aluminum")) {
            feelRating += 1;
        } else if (getPlateMaterial().equals("Polycarbonate")) {
            feelRating -= 1;
        }

        if (getPlateMaterial().equals("Brass")) {
            weightRating += 2;
        } else if (getPlateMaterial().equals("Aluminum")) {
            weightRating += 1;
        } else if (getPlateMaterial().equals("Polycarbonate")) {
            weightRating -= 1;
        }
    }

    // EFFECTS: returns the sound rating
    public int getSoundRating() {
        return soundRating;
    }

    // EFFECTS: returns the feel rating
    public int getFeelRating() {
        return feelRating;
    }

    // EFFECTS: returns the weight rating
    public int getWeightRating() {
        return weightRating;
    }
}