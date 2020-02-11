package model;

import model.Components.*;

// Represents a fully built keyboard having a case, keycaps, plate, printed circuit board, and switches.
public class Keyboard {
    Case keyboardCase;
    Keycaps keyboardKeycaps;
    Plate keyboardPlate;
    PrintedCircuitBoard keyboardPrintedCircuitBoard;
    Switches keyboardSwitches;

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