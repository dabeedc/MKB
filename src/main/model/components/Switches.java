package model.components;

import model.Rateable;

// Represents switches for the keyboard having a switch type and an indicator for whether or not they are silent
public class Switches implements Rateable {
    private String switchType;
    private boolean silentSwitches;
    private int soundRating;
    private int feelRating;

    // EFFECTS: Constructs a keyboard switch with no switchType and a default of non silent switches
    public Switches() {
        switchType = "";
        silentSwitches = false;
    }

    // MODIFIES: this
    // EFFECTS: rates the Keycaps based on the properties
    @Override
    public void rate() {
        if (isSilentSwitches()) {
            soundRating -= 5;
        }
        if (getSwitchType().equals("Tactile")) {
            soundRating += 1;
        } else if (getSwitchType().equals("Linear")) {
            soundRating -= 1;
        } else if (getSwitchType().equals("Clicky")) {
            soundRating += 3;
        }

        if (getSwitchType().equals("Tactile")) {
            feelRating += 2;
        } else if (getSwitchType().equals("Linear")) {
            feelRating -= 1;
        } else if (getSwitchType().equals("Clicky")) {
            feelRating += 2;
        }
    }

    // Getters
    // EFFECTS: returns the switch type
    public String getSwitchType() {
        return switchType;
    }

    // EFFECTS: returns true if switches are silent
    public boolean isSilentSwitches() {
        return this.silentSwitches;
    }

    // EFFECTS: returns the sound rating
    public int getSoundRating() {
        return soundRating;
    }

    // EFFECTS: returns the feel rating
    public int getFeelRating() {
        return feelRating;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the switch type
    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    // MODIFIES: this
    // EFFECTS: sets if the switches are silent or not
    public void setSilentSwitches(boolean silentSwitches) {
        this.silentSwitches = silentSwitches;
    }


}
