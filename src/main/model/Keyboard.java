package model;

import model.components.*;
import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

// Represents a fully built keyboard having a case, keycaps, plate, printed circuit board, and switches.
public class Keyboard implements Saveable {
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
    // EFFECTS: returns the rating of the keyboard based on components
    public void rateKeyboard() {
        rateCaseSound();
        rateKeycapsSound();
        ratePlateSound();
        rateSwitchesSound();
        rateCaseFeel();
        ratePlateFeel();
        rateSwitchesFeel();
        rateCaseWeight();
        ratePlateWeight();
        if (getSoundRating() <= 0) {
            setSoundRating(1);
        }
        if (getSoundRating() >= 10) {
            setSoundRating(10);
        }
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the case's properties
    public int rateCaseSound() {
        if (getKeyboardCase().getCaseMaterial().equals("aluminum")) {
            soundRating += 1;
        } else if (keyboardCase.getCaseMaterial().equals("plastic")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the keycaps' properties
    public int rateKeycapsSound() {
        if (getKeyboardKeycaps().getKeycapsMaterial().equals("abs")) {
            soundRating += 1;
        } else if (getKeyboardKeycaps().getKeycapsMaterial().equals("pbt")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the plate's properties
    public int ratePlateSound() {
        if (getKeyboardPlate().getPlateMaterial().equals("brass")) {
            soundRating += 2;
        } else if (getKeyboardPlate().getPlateMaterial().equals("aluminum")) {
            soundRating += 1;
        } else if (getKeyboardPlate().getPlateMaterial().equals("polycarbonate")) {
            soundRating -= 1;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the sound of the keyboard based on the switches' properties
    public int rateSwitchesSound() {
        if (getKeyboardSwitches().isSilentSwitches()) {
            soundRating -= 5;
        }
        if (getKeyboardSwitches().getSwitchType().equals("tactile")) {
            soundRating += 1;
        } else if (getKeyboardSwitches().getSwitchType().equals("linear")) {
            soundRating -= 1;
        } else if (getKeyboardSwitches().getSwitchType().equals("clicky")) {
            soundRating += 3;
        }
        return soundRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the case's properties
    public int rateCaseFeel() {
        if (getKeyboardCase().getCaseMaterial().equals("aluminum")) {
            feelRating += 1;
        } else if (getKeyboardCase().getCaseMaterial().equals("plastic")) {
            feelRating -= 1;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the plate's properties
    public int ratePlateFeel() {
        if (getKeyboardPlate().getPlateMaterial().equals("brass")) {
            feelRating += 2;
        } else if (getKeyboardPlate().getPlateMaterial().equals("aluminum")) {
            feelRating += 1;
        } else if (getKeyboardPlate().getPlateMaterial().equals("polycarbonate")) {
            feelRating -= 1;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the typing feel of the keyboard based on the switches' properties
    public int rateSwitchesFeel() {
        if (getKeyboardSwitches().getSwitchType().equals("tactile")) {
            feelRating += 2;
        } else if (getKeyboardSwitches().getSwitchType().equals("linear")) {
            feelRating -= 1;
        } else if (getKeyboardSwitches().getSwitchType().equals("clicky")) {
            feelRating += 2;
        }
        return feelRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard's weight based on the case's properties
    public int rateCaseWeight() {
        if (getKeyboardCase().getCaseMaterial().equals("aluminum")) {
            weightRating += 2;
        } else if (getKeyboardCase().getCaseMaterial().equals("plastic")) {
            weightRating -= 2;
        }
        return weightRating;
    }

    // MODIFIES: this
    // EFFECTS: rates the keyboard's weight based on the plate's properties
    public int ratePlateWeight() {
        if (getKeyboardPlate().getPlateMaterial().equals("brass")) {
            weightRating += 2;
        } else if (getKeyboardPlate().getPlateMaterial().equals("aluminum")) {
            weightRating += 1;
        } else if (getKeyboardPlate().getPlateMaterial().equals("polycarbonate")) {
            weightRating -= 1;
        }
        return weightRating;
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
}