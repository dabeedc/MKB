package model.components;

import model.Rateable;

// Represents the keycaps of a keyboard having a material type
public class Keycaps implements Rateable {
    private String keycapsMaterial;
    private int soundRating;


    // EFFECTS: Constructs keycaps with no keycapsMaterial
    public Keycaps() {
        keycapsMaterial = "";
    }

    // Getters
    // EFFECTS: returns the material of the keycaps
    public String getKeycapsMaterial() {
        return keycapsMaterial;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the material of the keycaps
    public void setKeycapsMaterial(String keycapsMaterial) {
        this.keycapsMaterial = keycapsMaterial;
    }

    // MODIFIES: this
    // EFFECTS: rates the Keycaps based on the properties
    @Override
    public void rate() {
        if (getKeycapsMaterial().equals("ABS")) {
            soundRating += 1;
        } else if (getKeycapsMaterial().equals("PBT")) {
            soundRating -= 1;
        }
    }

    // EFFECTS: returns the sound rating
    public int getSoundRating() {
        return soundRating;
    }
}