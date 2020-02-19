package model.components;

// Represents switches for the keyboard having a switch type and an indicator for whether or not they are silent
public class Switches {
    private String switchType;
    private boolean silentSwitches;

    // EFFECTS: Constructs a keyboard switch with no switchType and a default of non silent switches
    public Switches() {
        switchType = "";
        silentSwitches = false;
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
