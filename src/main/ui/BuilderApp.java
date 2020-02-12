package ui;

import model.Keyboard;
import model.components.*;
import model.components.Case;

import java.util.Scanner;

// Keyboard builder application
// Citation: CPSC210 TellerApp for Scanner use
public class BuilderApp {
    private Scanner input;

    // EFFECTS: runs the builder application
    public BuilderApp() {
        runBuilder();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBuilder() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
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
        System.out.println("\nHere is your completed build:");
        System.out.println("Case Specifications:");
        System.out.println(Case.getCaseSize());
        System.out.println(Case.getCaseMaterial());
        System.out.println("Keycaps Specifications:");
        System.out.println(Keycaps.getKeycapsMaterial());
        System.out.println("Plate Specifications:");
        System.out.println(Plate.getPlateMaterial());
        System.out.println(Plate.getPlateSize());
        System.out.println("PCB Specifications:");
        System.out.println(PrintedCircuitBoard.getPcbSize());
        System.out.println("Keyswitch Specifications:");
        System.out.println(Switches.getSwitchType());
        System.out.println("Silent? " + Switches.isSilentSwitches());
    }

    // EFFECTS: starts the building process of a keyboard
    private void startBuild() {
        String selection = "";
        System.out.println("What size keyboard are you interested in: small, medium, or large?");

        while (!(selection.equals("small") || (selection.equals("medium") || (selection.equals("large"))))) {
            selection = input.nextLine();
        }
        if (selection.equals("small")) {
            Case.setCaseSize(selection);
        } else if (selection.equals("medium")) {
            Case.setCaseSize(selection);
        } else if (selection.equals("large")) {
            Case.setCaseSize(selection);
        }
        buildCaseMaterial();
    }

    // EFFECTS: Prompts for user input for case material
    private void buildCaseMaterial() {
        String selection = "";
        System.out.println("Choose a case material for your " + Case.getCaseSize() + " keyboard: aluminum or plastic?");

        while (!(selection.equals("aluminum") || (selection.equals("plastic")))) {
            selection = input.nextLine();
            Case.setCaseMaterial(selection);
        }
        if (selection.equals("aluminum")) {
            Case.setCaseMaterial(selection);
        } else if (selection.equals("plastic")) {
            Case.setCaseMaterial(selection);
        }
        buildKeycapsMaterial();
    }

    // EFFECTS: Prompts for user input for keycaps material
    private void buildKeycapsMaterial() {
        String selection = "";
        System.out.println("Choose a keycap material for your " + Case.getCaseSize() + " " + Case.getCaseMaterial()
                + " keyboard: PBT or ABS");

        while (!(selection.equals("pbt") || (selection.equals("abs")))) {
            selection = input.nextLine();
            Keycaps.setKeycapsMaterial(selection);
        }
        if (selection.equals("pbt")) {
            Keycaps.setKeycapsMaterial(selection);
        } else if (selection.equals("abs")) {
            Keycaps.setKeycapsMaterial(selection);
        }
        buildPlateMaterial();
    }

    // EFFECTS: Prompts for user input for plate material
    private void buildPlateMaterial() {
        String selection = "";
        System.out.println("Choose a plate material for your " + Case.getCaseSize() + " " + Case.getCaseMaterial()
                + " with " + Keycaps.getKeycapsMaterial() + " keycaps: brass, aluminum, or polycarbonate?");

        while (!(selection.equals("brass") || (selection.equals("aluminum") || (selection.equals("polycarbonate"))))) {
            selection = input.nextLine();
            Plate.setPlateMaterial(selection);
        }
        if (selection.equals("brass")) {
            Plate.setPlateMaterial(selection);
        } else if (selection.equals("aluminum")) {
            Plate.setPlateMaterial(selection);
        } else if (selection.equals("polycarbonate")) {
            Plate.setPlateMaterial(selection);
        }
        buildPlateSize();
    }

    // EFFECTS: Prompts for user input for plate size
    private void buildPlateSize() {
        String selection = "";
        System.out.println("Choose a plate size for your " + Plate.getPlateMaterial() + " plate: small, "
                + "medium, or large?");

        while (!(selection.equals("small") || (selection.equals("medium") || (selection.equals("large"))))) {
            selection = input.nextLine();
            Plate.setPlateSize(selection);
        }
        if (selection.equals("small")) {
            Plate.setPlateSize(selection);
        } else if (selection.equals("medium")) {
            Plate.setPlateSize(selection);
        } else if (selection.equals("large")) {
            Plate.setPlateSize(selection);
        }
        buildPrintedCircuitBoardSize();
    }

    // EFFECTS: Prompts for user input for PCB size
    private void buildPrintedCircuitBoardSize() {
        String selection = "";
        System.out.println("Select a PCB size: small, medium or large?");

        while (!(selection.equals("small") || (selection.equals("medium") || (selection.equals("large"))))) {
            selection = input.nextLine();
            PrintedCircuitBoard.setPcbSize(selection);
        }
        if (selection.equals("small")) {
            PrintedCircuitBoard.setPcbSize(selection);
        } else if (selection.equals("medium")) {
            PrintedCircuitBoard.setPcbSize(selection);
        } else if (selection.equals("large")) {
            PrintedCircuitBoard.setPcbSize(selection);
        }
        buildSwitchesType();
    }

    // EFFECTS: Prompts for user input for key switch type
    private void buildSwitchesType() {
        String selection = "";
        System.out.println("What switches would you like to accompany your keyboard: tactile, linear, or clicky?");

        while (!(selection.equals("tactile") || (selection.equals("linear") || (selection.equals("clicky"))))) {
            selection = input.nextLine();
            Switches.setSwitchType(selection);
        }
        if (selection.equals("tactile")) {
            Switches.setSwitchType(selection);
        } else if (selection.equals("linear")) {
            Switches.setSwitchType(selection);
        } else if (selection.equals("clicky")) {
            Switches.setSwitchType(selection);
        }
        buildSilentSwitches();
    }

    // EFFECTS: Prompts user for preference of silent switches or not
    private void buildSilentSwitches() {
        String selection = "";
        System.out.println("Do you want your " + Switches.getSwitchType() + " switches to be silent?");
        selection = input.nextLine();
        boolean b = selection.equals("yes");
        Switches.setSilentSwitches(b);
        rateKeyboard();
    }

    // EFFECTS: gives a rating of the keyboard based on typing sound, typing feel, and weight
    private void rateKeyboard() {
        System.out.println("\nOn a scale of 1 to 10: 1 being quiet, soft, and light; 10 being loud, "
                + "hard, and heavy for the typing sound, feel, and weight, respectively.");
        System.out.println("This is your keyboard rating:");
        Keyboard.rateTheKeyboard();
        runBuilder();
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
            selection = input.next();
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
            runBuilder();
        }
        return null;
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
        System.out.println("\tor quit");
    }
}