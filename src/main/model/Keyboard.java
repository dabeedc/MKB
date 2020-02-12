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
    static int soundRating = 5;
    static int feelRating = 5;
    static int weightRating = 5;

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
        System.out.println("Sound level: " + soundRating);
        System.out.println("Typing feel: " + feelRating);
        System.out.println("Weight: " + weightRating);
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the case's properties
    private static int rateCaseSound() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            soundRating += 1;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the keycaps' properties
    private static int rateKeycapsSound() {
        if (Keycaps.getKeycapsMaterial().equals("ABS")) {
            soundRating += 1;
        } else if (Keycaps.getKeycapsMaterial().equals("PBT")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the plate's properties
    private static int ratePlateSound() {
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
    private static int rateSwitchesSound() {
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
    private static int rateCaseFeel() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            feelRating += 1;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            feelRating -= 1;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the plate's properties
    private static int ratePlateFeel() {
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
    private static int rateSwitchesFeel() {
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
    private static int rateCaseWeight() {
        if (Case.getCaseMaterial().equals("aluminum")) {
            weightRating += 2;
        } else if (Case.getCaseMaterial().equals("plastic")) {
            weightRating -= 1;
        }
        return weightRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard's weight based on the plate's properties
    private static int ratePlateWeight() {
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
