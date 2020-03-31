package model.components;

import model.Rateable;

// Represents a case of a keyboard that indicates what material it is made out of as well as the size of the case.
public class Case implements Rateable {
    private String caseMaterial;
    private String caseSize;
    private int soundRating;
    private int feelRating;
    private int weightRating;

    // EFFECTS: Constructs a case with no caseMaterial and no caseSize
    public Case() {
        caseMaterial = "";
        caseSize = "";
    }

    // Getters
    // EFFECTS: returns the material of the case
    public String getCaseMaterial() {
        return caseMaterial;
    }

    // EFFECTS: returns the size of the case
    public String getCaseSize() {
        return caseSize;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the material of the case
    public void setCaseMaterial(String caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    // MODIFIES: this
    // EFFECTS: sets the size of the case
    public void setCaseSize(String caseSize) {
        this.caseSize = caseSize;
    }

    // MODIFIES: this
    // EFFECTS: rates the Case based on the properties
    @Override
    public void rate() {
        if (getCaseMaterial().equals("Aluminum")) {
            soundRating += 1;
        } else if (getCaseMaterial().equals("Plastic")) {
            soundRating -= 1;
        }

        if (getCaseMaterial().equals("Aluminum")) {
            feelRating += 1;
        } else if (getCaseMaterial().equals("Plastic")) {
            feelRating -= 1;
        }

        if (getCaseMaterial().equals("Aluminum")) {
            weightRating += 2;
        } else if (getCaseMaterial().equals("Plastic")) {
            weightRating -= 2;
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