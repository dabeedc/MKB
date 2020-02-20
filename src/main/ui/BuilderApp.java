package ui;

import model.Keyboard;

import java.util.Scanner;

// Keyboard builder application
// Citation: CPSC210 TellerApp for Scanner use
public class BuilderApp {
    private Scanner choice;
    private Keyboard keyboard;

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
        if (command.equals("information")) {
            informationMenu();
        } else if (command.equals("build")) {
            startBuild();
        } else if (command.equals("print")) {
            printBuild();
        } else {
            System.out.println("Invalid selection...");
        }
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

    // EFFECTS: starts the building process of a keyboard
    private void startBuild() {
        String selection = "";
        System.out.println("What size keyboard are you interested in: 60%, 75%, or TKL?");

        while (!(selection.equals("60%") || (selection.equals("75%") || (selection.equals("tkl"))))) {
            selection = choice.nextLine();
            selection = selection.toLowerCase();
        }
        if (selection.equals("60%")) {
            keyboard.getKeyboardCase().setCaseSize(selection);
        } else if (selection.equals("75%")) {
            keyboard.getKeyboardCase().setCaseSize(selection);
        } else if (selection.equals("tkl")) {
            keyboard.getKeyboardCase().setCaseSize(selection);
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
        if (selection.equals("aluminum")) {
            keyboard.getKeyboardCase().setCaseMaterial(selection);
        } else if (selection.equals("plastic")) {
            keyboard.getKeyboardCase().setCaseMaterial(selection);
        } else if (selection.equals("polycarbonate")) {
            keyboard.getKeyboardCase().setCaseMaterial(selection);
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
        if (selection.equals("pbt")) {
            keyboard.getKeyboardKeycaps().setKeycapsMaterial(selection);
        } else if (selection.equals("abs")) {
            keyboard.getKeyboardKeycaps().setKeycapsMaterial(selection);
        }
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
        if (selection.equals("brass")) {
            keyboard.getKeyboardPlate().setPlateMaterial(selection);
        } else if (selection.equals("aluminum")) {
            keyboard.getKeyboardPlate().setPlateMaterial(selection);
        } else if (selection.equals("polycarbonate")) {
            keyboard.getKeyboardPlate().setPlateMaterial(selection);
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

        if (selection.equals("60%")) {
            keyboard.getKeyboardPlate().setPlateSize(selection);
        } else if (selection.equals("75%")) {
            keyboard.getKeyboardPlate().setPlateSize(selection);
        } else if (selection.equals("tkl")) {
            keyboard.getKeyboardPlate().setPlateSize(selection);
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
        if (selection.equals("60%")) {
            keyboard.getKeyboardPrintedCircuitBoard().setPcbSize(selection);
        } else if (selection.equals("75%")) {
            keyboard.getKeyboardPrintedCircuitBoard().setPcbSize(selection);
        } else if (selection.equals("tkl")) {
            keyboard.getKeyboardPrintedCircuitBoard().setPcbSize(selection);
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
        if (selection.equals("tactile")) {
            keyboard.getKeyboardSwitches().setSwitchType(selection);
            buildSilentSwitches();
        } else if (selection.equals("linear")) {
            keyboard.getKeyboardSwitches().setSwitchType(selection);
            buildSilentSwitches();
        } else if (selection.equals("clicky")) {
            keyboard.getKeyboardSwitches().setSwitchType(selection);
            rateKeyboard();
        }
    }

    // EFFECTS: Prompts user for preference of silent switches or not
    private void buildSilentSwitches() {
        String selection = "";
        System.out.println("Do you want your " + keyboard.getKeyboardSwitches().getSwitchType()
                + " switches to be silent?");
        selection = choice.nextLine();
        boolean b = selection.equals("yes");
        keyboard.getKeyboardSwitches().setSilentSwitches(b);
        rateKeyboard();
    }

    // EFFECTS: gives a rating of the keyboard based on typing sound, typing feel, and weight
    private void rateKeyboard() {
        System.out.println("\nOn a scale of 1 to 10: 1 being quiet, soft, and light; 10 being loud, "
                + "hard, and heavy for the typing sound, feel, and weight of the keyboard, respectively.");
        System.out.println("This is your keyboard rating:");
        keyboard.rateTheKeyboard();
        System.out.println("Sound level: " + keyboard.getSoundRating());
        System.out.println("Typing feel: " + keyboard.getFeelRating());
        System.out.println("Weight: " + keyboard.getWeightRating());
        stopLoop();
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

        if (selection.equals("case")) {
            return caseInfo();
        } else if (selection.equals("keycaps")) {
            return keycapsInfo();
        } else if (selection.equals("plate")) {
            return plateInfo();
        } else if (selection.equals("pcb")) {
            return pcbInfo();
        } else if (selection.equals("switches")) {
            return switchesInfo();
        } else if (selection.equals("back")) {
            stopLoop();
        }
        return null;
    }

    // EFFECTS: stops the loop
    private boolean stopLoop() {
        return false;
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

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to MK Parts Picker! What would you like to do?");
        System.out.println("\tInformation");
        System.out.println("\tBuild");
        System.out.println("\tPrint");
        System.out.println("\tQuit");
    }
}