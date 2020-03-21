package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.Keyboard;
import persistence.Reader;
import persistence.Writer;
import ui.gui.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


// Keyboard builder application
// EFFECTS: starts the GUI class
public class GUI extends Application {
    private Keyboard keyboard = new Keyboard(); //todo keyboard placeholder
    private static final String ACCOUNTS_FILE = "./data/keyboard.txt";
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 450;

    // Stages and Scenes
    private Stage mainWindow;
    private Scene menuScene;
    private Scene buildScene;
    private InformationMenu infoWindow;


    //Buttons
    private Button buttonInfo;
    private Button buttonBuild;
    private Button buttonPrint;
    private Button buttonRate;
    private Button buttonCase;
    private Button buttonKeycaps;
    private Button buttonPlate;
    private Button buttonPcb;
    private Button buttonSwitches;
    private Button buttonConfirmation;

    // Menu Bar
    private Menu fileMenu = new Menu("_File");
    private Menu helpMenu = new Menu("_Help");

    // Dialog Boxes
    private AlertBox alert = new AlertBox();


    // EFFECTS: runs the builder application
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        infoWindow = new InformationMenu();
        displayMainMenu();
    }

    // EFFECTS: closes the builder application
    private void closeProgram() {
        ExitConfirmationBox closeProgramBox = new ExitConfirmationBox();
//        Boolean answerToExit = closeProgramBox.displayConfirmation("Confirm Exit", "Are you sure you "
//                + "want to quit?");
//        if (answerToExit)
// todo commented just to allow closing of program quicker
        mainWindow.close();
    }

    private void displayMainMenu() {
        Text header = TextBuilder.create().text("Welcome to MK Parts Picker...").build();
        keyboard.getKeyboardCase().setCaseMaterial("brass"); //todo keyboard placeholder

        mainWindow.setTitle("Mechanical Keyboard Parts Picker");
        mainWindow.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        buttonInfo = new Button(" _Information ");
        buttonInfo.setOnAction(event -> infoWindow.displayInformationMenu());
        buttonBuild = new Button("      _Build      ");
        buttonBuild.setOnAction(event -> displayBuildScene());
        buttonPrint = new Button("      _Print      ");
        buttonPrint.setOnAction(event -> displayPrint());
        buttonRate = new Button("      _Rate      ");
        buttonRate.setOnAction(event -> displayRate());

        VBox buttonMenuLayout = new VBox(30);
        buttonMenuLayout.setPadding(new Insets(0, -50, 0, 75));
        buttonMenuLayout.getChildren().addAll(buttonInfo, buttonBuild, buttonPrint, buttonRate);
        buttonMenuLayout.setAlignment(Pos.CENTER);

        BorderPane mainMenuLayout = new BorderPane();
        mainMenuLayout.setTop(displayMenuBar());
        mainMenuLayout.setCenter(header);
        mainMenuLayout.setLeft(buttonMenuLayout);

        menuScene = new Scene(mainMenuLayout, SCENE_WIDTH, SCENE_HEIGHT);
        mainWindow.setScene(menuScene);
        mainWindow.show();
    }

    private void displayBuildScene() {
        BorderPane buildMenuLayout = new BorderPane();
        buildScene = new Scene(buildMenuLayout, SCENE_WIDTH, SCENE_HEIGHT);
        mainWindow.setScene(buildScene);
        VBox dropDownMenuLayout = new VBox(5);

        buildMenuLayout.setTop(displayHelpMenu());
        buildMenuLayout.setCenter(new VBox());
        buildMenuLayout.setLeft(dropDownMenuLayout);
        HBox componentButtonsLayout = new HBox(25);
        buildMenuLayout.setBottom(componentButtonsLayout);

        dropDownMenuLayout.setPadding(new Insets(150, 0, 50, 50));

        ChoiceBox<String> caseSizeChoice = new ChoiceBox<>();
        caseSizeChoice.getItems().addAll("60%", "75%", "TKL");
        caseSizeChoice.setValue("60%");

        ChoiceBox<String> caseMaterialChoice = new ChoiceBox<>();
        caseMaterialChoice.getItems().addAll("Aluminum", "Plastic", "Polycarbonate");
        caseMaterialChoice.setValue("Aluminum");

        ChoiceBox<String> keycapsMaterialChoice = new ChoiceBox<>();
        keycapsMaterialChoice.getItems().addAll("ABS", "PBT");
        keycapsMaterialChoice.setValue("ABS");


        ChoiceBox<String> plateMaterialChoice = new ChoiceBox<>();
        plateMaterialChoice.getItems().addAll("Brass", "Aluminum", "Polycarbonate");
        plateMaterialChoice.setValue("Brass");

        ChoiceBox<String> plateSizeChoice = new ChoiceBox<>();
        plateSizeChoice.getItems().addAll("60%", "75%", "TKL");
        plateSizeChoice.setValue("60%");

        ChoiceBox<String> pcbSizeChoice = new ChoiceBox<>();
        pcbSizeChoice.getItems().addAll("60%", "75%", "TKL");
        pcbSizeChoice.setValue("60%");

        ChoiceBox<String> switchTypeChoice = new ChoiceBox<>();
        switchTypeChoice.getItems().addAll("Tactile", "Linear", "Clicky");
        switchTypeChoice.setValue("Tactile");

        buttonCase = new Button(" _Case ");
        buttonCase.setOnAction(event -> {
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().addAll(caseSizeChoice, caseMaterialChoice);
        });
        buttonKeycaps = new Button("   _Keycaps   ");
        buttonKeycaps.setOnAction(event -> {
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(keycapsMaterialChoice);
        });
        buttonPlate = new Button("      _Plate      ");
        buttonPlate.setOnAction(event -> {
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().addAll(plateMaterialChoice, plateSizeChoice);
        });
        buttonPcb = new Button("    _Printed Circuit Board    ");
        buttonPcb.setOnAction(event -> {
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(pcbSizeChoice);

        });
        buttonSwitches = new Button("      _Switches      ");
        buttonSwitches.setOnAction(event -> {
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(switchTypeChoice);

        });
        buttonConfirmation = new Button("    _Confirm Build    ");
        buttonConfirmation.setOnAction(event -> mainWindow.setScene(menuScene));

        componentButtonsLayout.getChildren().addAll(buttonCase, buttonKeycaps, buttonPlate, buttonPcb, buttonSwitches,
                buttonConfirmation);
        componentButtonsLayout.setPadding(new Insets(0, 0, 20, 0));
        componentButtonsLayout.setAlignment(Pos.CENTER);
    }

    private void displayPrint() {
        if (keyboard.getKeyboardCase().getCaseMaterial().equals("")) {
            alert.displayAlert("Message", "\n     No build found! "
                    + "Please return to the menu and select Build to start your build!     \n");
        } else {
            PrintBox rateBox = new PrintBox();
            rateBox.displayPrint("Keyboard Specifications", "Here is your build");
        }
    }

    private void displayRate() {
        if (keyboard.getKeyboardCase().getCaseMaterial().equals("")) {
            alert.displayAlert("Message", "\n     No build found! "
                    + "Please return to the menu and select Build to start your build!     \n");
        } else {
            RateBox rateBox = new RateBox();
            rateBox.displayRating("Keyboard Rating", " On a scale from 1 to 10: 1 being quiet, soft, and"
                    + " light; 10 being loud, hard, and heavy for the typing sound, feel, and weight of the "
                    + "keyboard, respectively.");
        }
    }

    public Node displayMenuBar() {
        // Menu Items
        MenuItem save = new MenuItem("Save Keyboard");
        MenuItem load = new MenuItem("Load Keyboard");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().add(save);
        fileMenu.getItems().add(load);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exit);

        // Main Menu Bar
        javafx.scene.control.MenuBar menuBarFile = new javafx.scene.control.MenuBar();
        menuBarFile.getMenus().addAll(fileMenu);

        save.setOnAction(event -> saveKeyboard());
        load.setOnAction(event -> loadKeyboard());
        exit.setOnAction(event -> closeProgram());

        return menuBarFile;
    }

    public Node displayHelpMenu() {
        MenuItem help = new MenuItem("Information");
        helpMenu.getItems().add(help);
        javafx.scene.control.MenuBar menuBarHelp = new javafx.scene.control.MenuBar();
        menuBarHelp.getMenus().add(helpMenu);
        help.setOnAction(event -> infoWindow.displayInformationMenu());
        return menuBarHelp;
    }

    // EFFECTS: saves built keyboard to ACCOUNTS_FILE
    private void saveKeyboard() {
        AlertBox saveAlert = new AlertBox();
        AlertBox saveFailedAlert = new AlertBox();
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(keyboard);
            writer.close();
            saveAlert.displayAlert("Save Successful!", "Keyboard saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            saveFailedAlert.displayAlert("Save Unsuccessful!", "Unable to save keyboard to file "
                    + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads keyboard from ACCOUNTS_FILE, if that file exists; otherwise initializes keyboard build
    private void loadKeyboard() {
        AlertBox loadAlert = new AlertBox();
        try {
            List<Object> keyboards = Reader.getKeyboardParts(new File(ACCOUNTS_FILE));
            keyboard = (Keyboard) keyboards.get(0);
            loadAlert.displayAlert("Load Successful!", "Keyboard loaded from " + ACCOUNTS_FILE);
        } catch (IOException e) {
            displayMainMenu();
        }
    }


}
