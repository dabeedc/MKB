package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Keyboard;
import persistence.Reader;
import persistence.Writer;
import ui.gui.*;

import java.io.*;
import java.util.List;

// Keyboard builder application
// EFFECTS: starts the GUI class
public class GUI extends Application {
    private Keyboard keyboard;
    private static final String ACCOUNTS_FILE = "./data/keyboard.txt";
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 450;
    private static final String MENU_IMAGE = "data/Photos/mainImage.jpg";
    private static final String CASE_IMAGE = "data/Photos/caseImage.jpg";
    private static final String KEYCAPS_IMAGE = "data/Photos/keycapsImage.jpg";
    private static final String PLATE_IMAGE = "data/Photos/plateImage.jpg";
    private static final String PCB_IMAGE = "data/Photos/pcbImage.jpg";
    private static final String SWITCHES_IMAGE = "data/Photos/switchesImage.gif";
    public static final int DIALOG_SIZE = 350;

    // Stages and Scenes
    private Stage mainWindow;
    private Scene menuScene;
    private Scene buildScene;
    private InformationHandler infoWindow;
    BorderPane buildMenuLayout = new BorderPane();
    VBox dropDownMenuLayout = new VBox(5);
    VBox buttonMenuLayout = new VBox(30);

    // Buttons
    private Button buttonInfo = new Button(" _Information ");
    private Button buttonBuild = new Button("      _Build      ");
    private Button buttonPrint = new Button("      _Print      ");
    private Button buttonRate = new Button("      _Rate      ");
    private Button buttonCase;
    private Button buttonKeycaps;
    private Button buttonPlate;

    public Keyboard getKeyboard() {
        return keyboard;
    }

    private Button buttonPcb;
    private Button buttonSwitches;
    private Button buttonConfirmation;

    // Menu Bar
    private Menu fileMenu = new Menu("_File");
    private Menu helpMenu = new Menu("_Help");

    // Dialog Boxes
    CheckBox wantSilent = new CheckBox("Silent");
    ChoiceBox<String> caseSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> caseMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> keycapsMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> plateMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> plateSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> pcbSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> switchTypeChoice = new ChoiceBox<>();

    ImageView imageView = null;


    // EFFECTS: runs the GUI application
    public static void main(String[] args) {
        launch(args);
    }

    // EFFECTS: starts the GUI by setting initial stage
    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        infoWindow = new InformationHandler();
        displayMainMenu();
    }

    // EFFECTS: closes the builder application
    private void closeProgram() {
        ExitConfirmationBox closeProgramBox = new ExitConfirmationBox();
        boolean answerToExit = closeProgramBox.displayConfirmation("Confirm Exit", "Are you sure you "
                + "want to quit?");
        if (answerToExit) {
            mainWindow.close();
        }
    }


    // EFFECTS: displays the main menu where the user can interact with various buttons
    private void displayMainMenu() {
        getImage(MENU_IMAGE);

        mainWindow.setTitle("Mechanical Keyboard Parts Picker");
        mainWindow.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        buttonInfo.setOnAction(event -> infoWindow.displayInformationMenu());
        buttonBuild.setOnAction(event -> {
            keyboard = new Keyboard();
            displayBuildScene();
        });
        buttonPrint.setOnAction(event -> infoWindow.displayPrint(keyboard));
        buttonRate.setOnAction(event -> infoWindow.displayRate(keyboard));

        buttonMenuLayout.setPadding(new Insets(0, -50, 0, 75));
        buttonMenuLayout.getChildren().addAll(buttonInfo, buttonBuild, buttonPrint, buttonRate);
        buttonMenuLayout.setAlignment(Pos.CENTER);

        BorderPane mainMenuLayout = new BorderPane();
        mainMenuLayout.setTop(displayMenuBar());
        mainMenuLayout.setCenter(imageView);
        mainMenuLayout.setLeft(buttonMenuLayout);

        menuScene = new Scene(mainMenuLayout, SCENE_WIDTH, SCENE_HEIGHT);
        mainWindow.setScene(menuScene);
        mainWindow.show();
    }

    // EFFECTS: receives the image at a certain file input stream specified
    public void getImage(String image) {
        try {
            Image menuImage = new Image(new FileInputStream(image));
            imageView = new ImageView(menuImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: placeholder image for the build scene
    public Node imageHolder() {
        try {
            Image holderImage = new Image(new FileInputStream("data/Photos/infoImage.jpg"));
            imageView = new ImageView(holderImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageView;
    }


    // EFFECTS: sets nodes in the BorderPane found in the build menu
    public void setBuildMenuLayout() {
        buildMenuLayout.setTop(displayHelpMenu());
        buildMenuLayout.setCenter(imageHolder());
        buildMenuLayout.setLeft(dropDownMenuLayout);
    }

    // EFFECTS: displays the build menu to the user to select components of the keyboard
    private void displayBuildScene() {
        try {
            buildScene = new Scene(buildMenuLayout, SCENE_WIDTH, SCENE_HEIGHT);
            mainWindow.setScene(buildScene);

            setBuildMenuLayout();
            HBox componentButtonsLayout = new HBox(25);
            buildMenuLayout.setBottom(componentButtonsLayout);

            dropDownMenuLayout.setPadding(new Insets(150, 0, 50, 50));

            caseInput();
            keycapsInput();
            plateInput();
            pcbInput();
            switchesInput();
            buttonConfirmation = new Button("    _Confirm Build    ");
            buttonConfirmation.setOnAction(event -> checkCompatibility());

            componentButtonsLayout.getChildren().addAll(buttonCase, buttonKeycaps, buttonPlate, buttonPcb,
                    buttonSwitches, buttonConfirmation);
            componentButtonsLayout.setPadding(new Insets(0, 0, 20, 0));
            componentButtonsLayout.setAlignment(Pos.CENTER);
        } catch (IllegalArgumentException e) {
            DialogBox repeatBuild = new AlertBox();
            repeatBuild.displayDialog("Build Completed", "Build is already complete, please restart to "
                    + "start a new build.", DIALOG_SIZE);
        }
    }

    // MODIFIES: keyboard
    // EFFECTS: Checks whether the sizes are compatible and alerts the user to reselect if it's not
    private void checkCompatibility() {
        try {
            if (!caseSizeChoice.getValue().equals(plateSizeChoice.getValue())
                    || !pcbSizeChoice.getValue().equals(plateSizeChoice.getValue())
                    || !caseSizeChoice.getValue().equals(pcbSizeChoice.getValue())) {
                DialogBox notCompatibleAlert = new AlertBox();
                notCompatibleAlert.displayDialog("Not Compatible", "Your PCB and plate must be the same "
                        + "size as your case! Please reselect your sizes!", DIALOG_SIZE);
            } else {
                ExitConfirmationBox finishBuildBox = new ExitConfirmationBox();
                boolean answerToCompleteBuild = finishBuildBox.displayConfirmation("Confirm Build",
                        "Is this your finished build? ");
                if (answerToCompleteBuild) {
                    parseKeyboard();
                    keyboard.rate();
                    mainWindow.setScene(menuScene);
                }
            }
        } catch (NullPointerException e) {
            DialogBox nullBuildAlert = new AlertBox();
            nullBuildAlert.displayDialog("No selections!", "No components have been selected yet, try"
                    + " starting with a case!", DIALOG_SIZE);
        }
    }

    // EFFECTS: Handles all of the case's inputs in the build menu
    public void caseInput() {
        buttonCase = new Button(" _Case ");
        buttonCase.setOnAction(event -> {
            getImage(CASE_IMAGE);
            buildMenuLayout.setCenter(imageView);
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().addAll(caseSizeChoice, caseMaterialChoice);

            caseSizeChoice.getItems().addAll("60%", "75%", "TKL");
            caseSizeChoice.setValue("60%");

            caseMaterialChoice.getItems().addAll("Aluminum", "Plastic", "Polycarbonate");
            caseMaterialChoice.setValue("Aluminum");
        });
    }

    // EFFECTS: Handles all of the keycaps' inputs in the build menu
    public void keycapsInput() {
        buttonKeycaps = new Button("   _Keycaps   ");
        buttonKeycaps.setOnAction(event -> {
            getImage(KEYCAPS_IMAGE);
            buildMenuLayout.setCenter(imageView);
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(keycapsMaterialChoice);
        });

        keycapsMaterialChoice.getItems().addAll("ABS", "PBT");
        keycapsMaterialChoice.setValue("ABS");
    }

    // EFFECTS: Handles all of the plate's inputs in the build menu
    public void plateInput() {
        buttonPlate = new Button("      _Plate      ");
        buttonPlate.setOnAction(event -> {
            getImage(PLATE_IMAGE);
            buildMenuLayout.setCenter(imageView);
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().addAll(plateMaterialChoice, plateSizeChoice);
        });

        plateMaterialChoice.getItems().addAll("Brass", "Aluminum", "Polycarbonate");
        plateMaterialChoice.setValue("Brass");

        plateSizeChoice.getItems().addAll("60%", "75%", "TKL");
        plateSizeChoice.setValue("60%");
    }

    // EFFECTS: Handles all of the pcb's inputs in the build menu
    public void pcbInput() {
        buttonPcb = new Button("    _Printed Circuit Board    ");
        buttonPcb.setOnAction(event -> {
            getImage(PCB_IMAGE);
            buildMenuLayout.setCenter(imageView);
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(pcbSizeChoice);
        });

        pcbSizeChoice.getItems().addAll("60%", "75%", "TKL");
        pcbSizeChoice.setValue("60%");
    }

    // EFFECTS: Handles all of the switches' inputs in the build menu
    public void switchesInput() {
        buttonSwitches = new Button("      _Switches      ");
        buttonSwitches.setOnAction(event -> {
            getImage(SWITCHES_IMAGE);
            buildMenuLayout.setCenter(imageView);
            dropDownMenuLayout.getChildren().clear();
            dropDownMenuLayout.getChildren().add(switchTypeChoice);
        });

        switchTypeChoice.getItems().addAll("Clicky", "Linear", "Tactile");
        switchTypeChoice.setValue("Clicky");
        switchTypeChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)
                -> {
            dropDownMenuLayout.getChildren().remove(wantSilent);
            if (newValue.equals("Tactile") || newValue.equals("Linear")) {
                dropDownMenuLayout.getChildren().add(wantSilent);
            }
        });
    }

    // MODIFIES: keyboard
    // EFFECTS: Compiles the keyboard with the choices found in the choice boxes
    private void getChoice(ChoiceBox<String> choiceBox) {
        String caseSize = caseSizeChoice.getValue();
        String caseMaterial = caseMaterialChoice.getValue();
        String keycapsMaterial = keycapsMaterialChoice.getValue();
        String plateMaterial = plateMaterialChoice.getValue();
        String plateSize = plateSizeChoice.getValue();
        String pcbSize = pcbSizeChoice.getValue();
        String switchType = switchTypeChoice.getValue();
        keyboard.getKeyboardCase().setCaseSize(caseSize);
        keyboard.getKeyboardCase().setCaseMaterial(caseMaterial);
        keyboard.getKeyboardKeycaps().setKeycapsMaterial(keycapsMaterial);
        keyboard.getKeyboardPlate().setPlateSize(plateSize);
        keyboard.getKeyboardPlate().setPlateMaterial(plateMaterial);
        keyboard.getKeyboardPrintedCircuitBoard().setPcbSize(pcbSize);
        keyboard.getKeyboardSwitches().setSwitchType(switchType);
    }

    // EFFECTS: Retrieves the data from each choicebox and checks whether or not silentCheckBox is true or false
    private void parseKeyboard() {
        getChoice(caseSizeChoice);
        getChoice(caseMaterialChoice);
        getChoice(keycapsMaterialChoice);
        getChoice(plateMaterialChoice);
        getChoice(plateSizeChoice);
        getChoice(pcbSizeChoice);
        getChoice(switchTypeChoice);
        if (wantSilent.isSelected()) {
            keyboard.getKeyboardSwitches().setSilentSwitches(true);
        }
    }

    // EFFECTS: Displays the top menu bar with menu items save, load, and exit
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

    // EFFECTS: an information menu item for when the build starts, so you can look at information while building
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
        DialogBox saveAlert = new AlertBox();
        DialogBox saveFailedAlert = new AlertBox();
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(keyboard);
            writer.close();
            saveAlert.displayDialog("Save Successful!", "Keyboard saved to file " + ACCOUNTS_FILE, DIALOG_SIZE);
        } catch (FileNotFoundException e) {
            saveFailedAlert.displayDialog("Save Unsuccessful!", "Unable to save keyboard to file "
                    + ACCOUNTS_FILE,DIALOG_SIZE);
        } catch (NullPointerException e) {
            saveFailedAlert.displayDialog("Save Unsuccessful!", "No keyboard found to save to file  "
                    + ACCOUNTS_FILE, DIALOG_SIZE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads keyboard from ACCOUNTS_FILE, if that file exists; otherwise initializes keyboard build
    private void loadKeyboard() {
        DialogBox loadAlert = new AlertBox();
        try {
            List<Object> keyboards = Reader.getKeyboardParts(new File(ACCOUNTS_FILE));
            keyboard = (Keyboard) keyboards.get(0);
            loadAlert.displayDialog("Load Successful!", "Keyboard loaded from " + ACCOUNTS_FILE, DIALOG_SIZE);
        } catch (IOException e) {
            displayMainMenu();
        }
    }
}
