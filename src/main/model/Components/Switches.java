package model.Components;

// Represents switches having a switch type
public class Switches {
    private static String switchType;
    private static boolean silentSwitches;

    // EFFECTS: Constructs a keyboard switch with no switchType and a default of non silent switches
    public Switches() {
        switchType = "";
        silentSwitches = false;
    }

    // Getters
    // EFFECTS: returns the switch type
    public static String getSwitchType() {
        return switchType;
    }

    // EFFECTS: returns true if switches are silent
    public static boolean isSilentSwitches() {
        return Switches.silentSwitches;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the switch type
    public static void setSwitchType(String switchType) {
        Switches.switchType = switchType;
    }

    // MODIFIES: this
    // EFFECTS: sets if the switches are silent or not
    public static void setSilentSwitches(boolean silentSwitches) {
        Switches.silentSwitches = silentSwitches;
    }
}
