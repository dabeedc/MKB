package ui;

import model.Keyboard;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

// Keyboard builder application
// Citation: CPSC210 TellerApp for Scanner use and persistence
public class BuilderApp {
    private Scanner choice;
    private Keyboard keyboard;
    private static final String ACCOUNTS_FILE = "./data/keyboard.txt";

    // EFFECTS: runs the builder application
    public BuilderApp() {
        runBuilder();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBuilder() {
        keyboard = new Keyboard();
        boolean trueLoop = true;
        String input;
        choice = new Scanner(System.in);

        while (trueLoop) {
            displayMenu();
            input = choice.next();
            input = input.toLowerCase();

            if (input.equals("quit")) {
                trueLoop = false;
            } else {
                processCommand(input);
            }
        }

        System.out.println("\nSee you next time!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "information":
                informationMenu();
                break;
            case "build":
                startBuild();
                break;
            case "print":
                printBuild();
                break;
            case "rate":
                printRating();
                break;
            case "save":
                saveKeyboard();
                break;
            case "load":
                loadKeyboard();
                break;
            default:
                System.out.println("Invalid selection...");
                break;
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to MK Parts Picker! What would you like to do?");
        System.out.println("\tInformation");
        System.out.println("\tBuild");
        System.out.println("\tPrint");
        System.out.println("\tRate");
        System.out.println("\tSave");
        System.out.println("\tLoad");
        System.out.println("\tQuit");
    }

    // EFFECTS: starts the building process of a keyboard
    private void startBuild() {
        String selection = "";
        System.out.println("What size keyboard are you interested in: 60%, 75%, or TKL?");

        while (!(selection.equals("60%") || (selection.equals("75%") || (selection.equals("tkl"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        switch (selection) {
            case "60%":
            case "75%":
            case "tkl":
                keyboard.getKeyboardCase().setCaseSize(selection);
                break;
        }
        buildCaseMaterial();
    }

    // EFFECTS: Prompts for user input for case material
    private void buildCaseMaterial() {
        String selection = "";
        System.out.println("Choose a case material for your " + keyboard.getKeyboardCase().getCaseSize().toUpperCase()
                + " keyboard: Aluminum, Plastic or Polycarbonate?");

        while (!(selection.equals("aluminum") || (selection.equals("plastic")
                || (selection.equals("polycarbonate"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        switch (selection) {
            case "aluminum":
            case "plastic":
            case "polycarbonate":
                keyboard.getKeyboardCase().setCaseMaterial(selection);
                break;
        }
        buildKeycapsMaterial();
    }

    // EFFECTS: Prompts for user input for keycaps material
    private void buildKeycapsMaterial() {
        String selection = "";
        System.out.println("Choose a keycap material for your " + keyboard.getKeyboardCase().getCaseSize().toUpperCase()
                + ", " + keyboard.getKeyboardCase().getCaseMaterial() + " keyboard: PBT or ABS");

        while (!(selection.equals("pbt") || (selection.equals("abs")))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        keyboard.getKeyboardKeycaps().setKeycapsMaterial(selection);
        buildPlateMaterial();
    }

    // EFFECTS: Prompts for user input for plate material
    private void buildPlateMaterial() {
        String selection = "";
        System.out.println("Choose a plate material for your "
                + keyboard.getKeyboardCase().getCaseSize().toUpperCase() + ", "
                + keyboard.getKeyboardCase().getCaseMaterial()
                + " keyboard: Brass, Aluminum, or Polycarbonate?");

        while (!(selection.equals("brass") || (selection.equals("aluminum") || (selection.equals("polycarbonate"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        switch (selection) {
            case "brass":
            case "aluminum":
            case "polycarbonate":
                keyboard.getKeyboardPlate().setPlateMaterial(selection);
                break;
        }
        buildPlateSize();
    }

    // EFFECTS: Prompts for user input for plate size
    private void buildPlateSize() {
        String selection = "";
        System.out.println("How large is your " + keyboard.getKeyboardPlate().getPlateMaterial() + " plate: 60%, "
                + "75%, or TKL?");

        while (!(selection.equals("60%") || (selection.equals("75%") || (selection.equals("tkl"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
            while (!selection.equals(keyboard.getKeyboardCase().getCaseSize())) {
                System.out.println("Your case size is: " + keyboard.getKeyboardCase().getCaseSize().toUpperCase()
                        + ". Please reselect a plate that will fit inside your case: 60%, 75%, or TKL?");
                selection = choice.nextLine();
                selection = selection.toLowerCase();
            }
        }

        switch (selection) {
            case "60%":
            case "75%":
            case "tkl":
                keyboard.getKeyboardPlate().setPlateSize(selection);
                break;
        }
        buildPrintedCircuitBoardSize();
    }

    // EFFECTS: Prompts for user input for PCB size
    private void buildPrintedCircuitBoardSize() {
        String selection = "";
        System.out.println("Select a PCB size: 60%, 75% or TKL?");

        while (!(selection.equals("60%") || (selection.equals("75%") || (selection.equals("tkl"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
            while (!selection.equals(keyboard.getKeyboardCase().getCaseSize())) {
                System.out.println("Your plate size is: " + keyboard.getKeyboardPlate().getPlateSize().toUpperCase()
                        + ". Please reselect a PCB that fits your plate: 60%, 75%, or TKL?");
                selection = choice.nextLine();
                selection = selection.toLowerCase();
            }
        }
        switch (selection) {
            case "60%":
            case "75%":
            case "tkl":
                keyboard.getKeyboardPrintedCircuitBoard().setPcbSize(selection);
                break;
        }
        buildSwitchesType();
    }

    // EFFECTS: Prompts for user input for key switch type
    private void buildSwitchesType() {
        String selection = "";
        System.out.println("What switches would you like to use in your keyboard: Tactile, Linear, or Clicky?");

        while (!(selection.equals("tactile") || (selection.equals("linear") || (selection.equals("clicky"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        switch (selection) {
            case "tactile":
            case "linear":
                keyboard.getKeyboardSwitches().setSwitchType(selection);
                buildSilentSwitches();
                break;
            case "clicky":
                keyboard.getKeyboardSwitches().setSwitchType(selection);
                keyboardRating();
                break;
        }
    }

    // EFFECTS: Prompts user for preference of silent switches or not
    private void buildSilentSwitches() {
        System.out.println("Do you want your " + keyboard.getKeyboardSwitches().getSwitchType()
                + " switches to be silent?");
        String selection = choice.nextLine();
        boolean b = selection.equals("yes");
        keyboard.getKeyboardSwitches().setSilentSwitches(b);
        keyboardRating();
    }

    // EFFECTS: gives a rating of the keyboard based on typing sound, typing feel, and weight
    private void keyboardRating() {
        System.out.println("\nOn a scale of 1 to 10: 1 being quiet, soft, and light; 10 being loud, "
                + "hard, and heavy for the typing sound, feel, and weight of the keyboard, respectively.");
        System.out.println("This is your keyboard rating:");
        keyboard.rateKeyboard();
        System.out.println("Sound level: " + keyboard.getSoundRating());
        System.out.println("Typing feel: " + keyboard.getFeelRating());
        System.out.println("Weight: " + keyboard.getWeightRating());
    }

    // EFFECTS: displays information menu to user
    private void informationMenu() {
        System.out.println("\tWhich component would you like to learn about?");
        System.out.println("\tCase");
        System.out.println("\tKeycaps");
        System.out.println("\tPlate");
        System.out.println("\tPCB");
        System.out.println("\tSwitches");
        System.out.println("\tBack to Main Menu");
        giveInformation();
    }

    // EFFECTS: prompts user to select an information item
    private String giveInformation() {
        String selection = "";
        while (!(selection.equals("case") || selection.equals("keycaps") || selection.equals("plate")
                || selection.equals("pcb") || selection.equals("switches") || selection.equals("back"))) {
            selection = choice.next();
            selection = selection.toLowerCase();
        }

        switch (selection) {
            case "case":
                return caseInfo();
            case "keycaps":
                return keycapsInfo();
            case "plate":
                return plateInfo();
            case "pcb":
                return pcbInfo();
            case "switches":
                return switchesInfo();
            case "back":
                break;
        }
        return null;
    }

    // EFFECTS: prints the build to the console
    private void printBuild() {
        if (keyboard.getKeyboardCase().getCaseMaterial().equals("")) {
            System.out.println("\n No build found! Please return to the menu and select Build to start your build!");
        } else {
            System.out.println("\nHere is your completed build:");
            System.out.println("Case Specifications:");
            System.out.println(keyboard.getKeyboardCase().getCaseSize());
            System.out.println(keyboard.getKeyboardCase().getCaseMaterial());
            System.out.println("Keycaps Specifications:");
            System.out.println(keyboard.getKeyboardKeycaps().getKeycapsMaterial());
            System.out.println("Plate Specifications:");
            System.out.println(keyboard.getKeyboardPlate().getPlateMaterial());
            System.out.println(keyboard.getKeyboardPlate().getPlateSize());
            System.out.println("PCB Specifications:");
            System.out.println(keyboard.getKeyboardPrintedCircuitBoard().getPcbSize());
            System.out.println("Keyswitch Specifications:");
            System.out.println(keyboard.getKeyboardSwitches().getSwitchType());
            System.out.println("Silent? " + keyboard.getKeyboardSwitches().isSilentSwitches());
        }
    }

    // EFFECTS: prints the rating to the console
    private void printRating() {
        if (keyboard.getKeyboardCase().getCaseMaterial().equals("")) {
            System.out.println("\n There is no build to rate! Please return to the menu and "
                    + "select Build to start your build!");
        } else {
            System.out.println("\nOn a scale of 1 to 10: 1 being quiet, soft, and light; 10 being loud, "
                    + "hard, and heavy for the typing sound, feel, and weight of the keyboard, respectively.");
            System.out.println("This is your keyboard rating:");
            System.out.println("Sound level: " + keyboard.getSoundRating());
            System.out.println("Typing feel: " + keyboard.getFeelRating());
            System.out.println("Weight: " + keyboard.getWeightRating());
        }
    }

    // EFFECTS: gives the user information about the case component
    private String caseInfo() {
        System.out.println(Information.CASE_INFO);
        informationMenu();
        return null;
    }

    // EFFECTS: gives the user information about the keycaps component
    private String keycapsInfo() {
        System.out.println(Information.KEYCAPS_INFO);
        informationMenu();
        return null;
    }

    // EFFECTS: gives the user information about the plate component
    private String plateInfo() {
        System.out.println(Information.PLATE_INFO);
        informationMenu();
        return null;
    }

    // EFFECTS: gives the user information about the printed circuit board component
    private String pcbInfo() {
        System.out.println(Information.PRINTEDCIRCUITBOARD_INFO);
        informationMenu();
        return null;
    }

    // EFFECTS: gives the user information about the switches
    private String switchesInfo() {
        System.out.println(Information.SWITCHES_INFO);
        informationMenu();
        return null;
    }

    // MODIFIES: this
    // EFFECTS: loads keyboard from ACCOUNTS_FILE, if that file exists; otherwise initializes keyboard build
    private void loadKeyboard() {
        try {
            List<Object> keyboards = Reader.getKeyboardParts(new File(ACCOUNTS_FILE));
            keyboard = (Keyboard) keyboards.get(0);
            System.out.println("Keyboard loaded from " + ACCOUNTS_FILE);
        } catch (IOException e) {
            startBuild();
        }
    }

    // EFFECTS: saves built keyboard to ACCOUNTS_FILE
    private void saveKeyboard() {
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(keyboard);
            writer.close();
            System.out.println("Keyboard saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save keyboard to " + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}