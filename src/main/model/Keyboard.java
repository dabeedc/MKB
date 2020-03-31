package model;

import model.components.*;
import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

// Represents a fully built keyboard having a case, keycaps, plate, printed circuit board, and switches.
public class Keyboard implements Saveable, Rateable {
    private Case keyboardCase;
    private Keycaps keyboardKeycaps;
    private Plate keyboardPlate;
    private PrintedCircuitBoard keyboardPrintedCircuitBoard;
    private Switches keyboardSwitches;

    private int soundRating;
    private int feelRating;
    private int weightRating;

    // EFFECTS: constructs a keyboard with case, keycaps, plate, printed circuit board, and switches
    public Keyboard() {
        keyboardCase = new Case();
        keyboardKeycaps = new Keycaps();
        keyboardPlate = new Plate();
        keyboardPrintedCircuitBoard = new PrintedCircuitBoard();
        keyboardSwitches = new Switches();

        soundRating = 5;
        feelRating = 5;
        weightRating = 5;
    }

    // EFFECTS: Constructor used only when constructing a keyboard stored in file
    public Keyboard(String caseMat, String caseSize, String keycapMat, String plateMat, String plateSize,
                    String pcbSize, String keySwitch, String silentSwitch, String soundRating, String feelRating,
                    String weightRating) {
        keyboardCase = new Case();
        keyboardKeycaps = new Keycaps();
        keyboardPlate = new Plate();
        keyboardPrintedCircuitBoard = new PrintedCircuitBoard();
        keyboardSwitches = new Switches();
        this.keyboardCase.setCaseMaterial(caseMat);
        this.keyboardCase.setCaseSize(caseSize);
        this.keyboardKeycaps.setKeycapsMaterial(keycapMat);
        this.keyboardPlate.setPlateMaterial(plateMat);
        this.keyboardPlate.setPlateSize(plateSize);
        this.keyboardPrintedCircuitBoard.setPcbSize(pcbSize);
        this.keyboardSwitches.setSwitchType(keySwitch);
        this.keyboardSwitches.setSilentSwitches(Boolean.parseBoolean(silentSwitch));
        this.soundRating = Integer.parseInt(soundRating);
        this.feelRating = Integer.parseInt(feelRating);
        this.weightRating = Integer.parseInt(weightRating);
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard based on the ratings of its individual components
    @Override
    public void rate() {
        getKeyboardCase().rate();
        getKeyboardKeycaps().rate();
        getKeyboardPlate().rate();
        getKeyboardSwitches().rate();
        this.soundRating = this.soundRating + getKeyboardCase().getSoundRating() + getKeyboardKeycaps().getSoundRating()
                + getKeyboardPlate().getSoundRating() + getKeyboardSwitches().getSoundRating();
        this.feelRating = this.feelRating + getKeyboardCase().getFeelRating() + getKeyboardPlate().getFeelRating()
                + getKeyboardSwitches().getFeelRating();
        this.weightRating = this.weightRating + getKeyboardCase().getWeightRating()
                + getKeyboardPlate().getWeightRating();

        if (getSoundRating() <= 0) {
            setSoundRating(1);
        }
        if (getSoundRating() >= 10) {
            setSoundRating(10);
        }
    }

    // EFFECTS: save the keyboard to file
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(keyboardCase.getCaseMaterial());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardCase.getCaseSize());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardKeycaps.getKeycapsMaterial());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardPlate.getPlateMaterial());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardPlate.getPlateSize());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardPrintedCircuitBoard.getPcbSize());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardSwitches.getSwitchType());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(keyboardSwitches.isSilentSwitches());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(soundRating);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(feelRating);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(weightRating);
    }

    // Getters
    // EFFECTS: returns the sound rating of the keyboard
    public int getSoundRating() {
        return soundRating;
    }

    // EFFECTS: returns the feel rating of the keyboard
    public int getFeelRating() {
        return feelRating;
    }

    // EFFECTS: returns the weight rating of the keyboard
    public int getWeightRating() {
        return weightRating;
    }

    // EFFECTS: returns the keyboard Case
    public Case getKeyboardCase() {
        return keyboardCase;
    }

    // EFFECTS: returns the keyboard Keycaps
    public Keycaps getKeyboardKeycaps() {
        return keyboardKeycaps;
    }

    // EFFECTS: returns the keyboard Plate
    public Plate getKeyboardPlate() {
        return keyboardPlate;
    }

    // EFFECTS: returns the keyboard PrintedCircuitBoard
    public PrintedCircuitBoard getKeyboardPrintedCircuitBoard() {
        return keyboardPrintedCircuitBoard;
    }

    // EFFECTS: returns the keyboard Switches
    public Switches getKeyboardSwitches() {
        return keyboardSwitches;
    }

    // Setters
    // EFFECTS: sets the given sound rating
    public void setSoundRating(int soundRating) {
        this.soundRating = soundRating;
    }
}