package model.Components;

// Represents switches having a switch type
public class Switches {
    private static String switchType;
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
        return silentSwitches;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the switch type
    public static void setSwitchType(String switchType) {
        Switches.switchType = switchType;
    }

    // MODIFIES: this
    // EFFECTS: sets if the switches are silent or not
    public void setSilentSwitches(boolean silentSwitches) {
        this.silentSwitches = silentSwitches;
    }
}
