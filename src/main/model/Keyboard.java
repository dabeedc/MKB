package model;

import model.components.Case;
import model.components.*;

import java.security.Key;

// Represents a fully built keyboard having a case, keycaps, plate, printed circuit board, and switches.
public class Keyboard {
    public Case keyboardCase;
    public Keycaps keyboardKeycaps;
    public Plate keyboardPlate;
    public PrintedCircuitBoard keyboardPrintedCircuitBoard;
    public Switches keyboardSwitches;
    public static int soundRating = 5;
    public static int feelRating = 5;
    public static int weightRating = 5;

    // EFFECTS: constructs a keyboard with case, keycaps, plate, printed circuit board, and switches
    public Keyboard() {
        keyboardCase = new Case();
        keyboardKeycaps = new Keycaps();
        keyboardPlate = new Plate();
        keyboardPrintedCircuitBoard = new PrintedCircuitBoard();
        keyboardSwitches = new Switches();
    }

    // EFFECTS: prints the rating of the keyboard out into console
    public static void rateTheKeyboard() {
        rateCaseSound();
        rateKeycapsSound();
        ratePlateSound();
        rateSwitchesSound();
        rateCaseFeel();
        ratePlateFeel();
        rateSwitchesFeel();
        rateCaseWeight();
        ratePlateWeight();
        if (soundRating <= 0) {
            soundRating = 0;
        }
        if (soundRating >= 10) {
            soundRating = 10;
        }
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the case's properties
    protected static int rateCaseSound() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            soundRating += 1;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the keycaps' properties
    protected static int rateKeycapsSound() {
        if (Keycaps.getKeycapsMaterial().equals("abs")) {
            soundRating += 1;
        } else if (Keycaps.getKeycapsMaterial().equals("pbt")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the plate's properties
    protected static int ratePlateSound() {
        if (Plate.getPlateMaterial().equals("brass")) {
            soundRating += 2;
        } else if (Plate.getPlateMaterial().equals("aluminum")) {
            soundRating += 1;
        } else if (Plate.getPlateMaterial().equals("polycarbonate")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the switches' properties
    protected static int rateSwitchesSound() {
        if (Switches.isSilentSwitches()) {
            soundRating -= 5;
        }
        if (Switches.getSwitchType().equals("tactile")) {
            soundRating += 1;
        } else if (Switches.getSwitchType().equals("linear")) {
            soundRating -= 1;
        } else if (Switches.getSwitchType().equals("clicky")) {
            soundRating += 3;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the case's properties
    protected static int rateCaseFeel() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            feelRating += 1;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            feelRating -= 1;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the plate's properties
    protected static int ratePlateFeel() {
        if (Plate.getPlateMaterial().equals("brass")) {
            feelRating += 2;
        } else if (Plate.getPlateMaterial().equals("aluminum")) {
            feelRating += 1;
        } else if (Plate.getPlateMaterial().equals("polycarbonate")) {
            feelRating -= 1;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the switches' properties
    protected static int rateSwitchesFeel() {
        if (Switches.getSwitchType().equals("tactile")) {
            feelRating += 2;
        } else if (Switches.getSwitchType().equals("linear")) {
            feelRating -= 1;
        } else if (Switches.getSwitchType().equals("clicky")) {
            feelRating += 2;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard's weight based on the case's properties
    protected static int rateCaseWeight() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            weightRating += 2;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            weightRating -= 2;
        }
        return weightRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard's weight based on the plate's properties
    protected static int ratePlateWeight() {
        if (Plate.getPlateMaterial().equals("brass")) {
            weightRating += 2;
        } else if (Plate.getPlateMaterial().equals("aluminum")) {
            weightRating += 1;
        } else if (Plate.getPlateMaterial().equals("polycarbonate")) {
            weightRating -= 1;
        }
        return weightRating;
    }
}
