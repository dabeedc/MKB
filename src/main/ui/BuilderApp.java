package ui;

import model.Keyboard;
import model.*;
import model.Components.*;
import model.Components.Case;

import java.util.Scanner;

// Keyboard builder application
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
            System.out.println("Selection not valid...");
        }
    }

    private void printBuild() {
        System.out.println("print statement for printBuild");
    }

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

    private void buildCaseMaterial() {
        String selection = "";
        System.out.println("Choose a material for your " + Case.getCaseSize() + " keyboard: aluminum or plastic?");

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

    private void buildKeycapsMaterial() {
        System.out.println("THIS IS WHERE I LEFT OFF");
        // todo asdasdasdasdhjdafsfdhjkjashdfhjfasdhjlasfdhasf
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
        while (!(selection.equals("case") || selection.equals("keycaps") || selection.equals("plate") ||
                selection.equals("pcb") || selection.equals("switches") || selection.equals("back"))) {
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
        return  null;
    }

    private String caseInfo() {
        System.out.println("THIS IS CASE INFORMATION");
        informationMenu();
        return null;
    }

    private String keycapsInfo() {
        System.out.println("THIS IS KEYCAPS INFORMATION");
        informationMenu();
        return null;
    }

    private String plateInfo() {
        System.out.println("THIS IS PLATE INFORMATION");
        informationMenu();
        return null;
    }

    private String pcbInfo() {
        System.out.println("THIS IS PCB INFORMATION");
        informationMenu();
        return null;
    }

    private String switchesInfo() {
        System.out.println("THIS IS SWITCHES INFORMATION");
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