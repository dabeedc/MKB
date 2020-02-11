package ui;

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
        System.out.println("print statement for startBuild");
    }

    // EFFECTS: displays information menu to user
    private void informationMenu() {
        giveInformation();
        System.out.println("\nWhich component would you like to learn about?");
        System.out.println("\tCase");
        System.out.println("\tKeycaps");
        System.out.println("\tPlate");
        System.out.println("\tPCB");
        System.out.println("\tSwitches");
    }

    // EFFECTS: prompts user to select an information item
    private String giveInformation() {
        String selection = "";
        while (!(selection.equals("case") || selection.equals("keycaps") || selection.equals("plate") ||
                selection.equals("pcb") || selection.equals("switches"))) {
            System.out.println("Case");
            System.out.println("Keycaps");
            System.out.println("Plate");
            System.out.println("PCB");
            System.out.println("Switches");
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