package model;

import model.components.Case;
import model.components.*;

// Represents a fully built keyboard having a case, keycaps, plate, printed circuit board, and switches.
public class Keyboard {
    public Case keyboardCase;
    public Keycaps keyboardKeycaps;
    public Plate keyboardPlate;
    public PrintedCircuitBoard keyboardPrintedCircuitBoard;
    public Switches keyboardSwitches;

    // EFFECTS: constructs a keyboard with case, keycaps, plate, printed circuit board, and switches
    public Keyboard() {
        keyboardCase = new Case();
        keyboardKeycaps = new Keycaps();
        keyboardPlate = new Plate();
        keyboardPrintedCircuitBoard = new PrintedCircuitBoard();
        keyboardSwitches = new Switches();
    }

    // Getters

    // Setters
}