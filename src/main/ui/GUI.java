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
    BorderPane buildMenuLayout = new BorderPane();
    VBox dropDownMenuLayout = new VBox(5);
    // Stages and Scenes
    private Stage mainWindow;
    private Scene menuScene;
    private Scene buildScene;
    private InformationMenu infoWindow;


    // Buttons
    private Button buttonInfo = new Button(" _Information ");
    private Button buttonBuild = new Button("      _Build      ");
    private Button buttonPrint = new Button("      _Print      ");
    private Button buttonRate = new Button("      _Rate      ");
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
    CheckBox wantSilent = new CheckBox("Silent");
    ChoiceBox<String> caseSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> caseMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> keycapsMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> plateMaterialChoice = new ChoiceBox<>();
    ChoiceBox<String> plateSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> pcbSizeChoice = new ChoiceBox<>();
    ChoiceBox<String> switchTypeChoice = new ChoiceBox<>();

    ImageView imageView = null;

    VBox buttonMenuLayout = new VBox(30);

    // EFFECTS: runs the GUI application
    public static void main(String[] args) {
        launch(args);
    }

    // EFFECTS: starts the GUI by setting initial stage
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
        buttonPrint.setOnAction(event -> displayPrint());
        buttonRate.setOnAction(event -> displayRate());

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

    // EFFECTS: displays the build menu to the user to select components of the keyboard
    private void displayBuildScene() {
        buildScene = new Scene(buildMenuLayout, SCENE_WIDTH, SCENE_HEIGHT);
        mainWindow.setScene(buildScene);

        buildMenuLayout.setTop(displayHelpMenu());
        buildMenuLayout.setCenter(imageHolder());
        buildMenuLayout.setLeft(dropDownMenuLayout);
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

        componentButtonsLayout.getChildren().addAll(buttonCase, buttonKeycaps, buttonPlate, buttonPcb, buttonSwitches,
                buttonConfirmation);
        componentButtonsLayout.setPadding(new Insets(0, 0, 20, 0));
        componentButtonsLayout.setAlignment(Pos.CENTER);
    }

    // EFFECTS: Checks whether the sizes are compatible and alerts the user to reselect if it's not
    // MODIFIES: keyboard
    private void checkCompatibility() {
        if (!caseSizeChoice.getValue().equals(plateSizeChoice.getValue())
                || !pcbSizeChoice.getValue().equals(plateSizeChoice.getValue())
                || !caseSizeChoice.getValue().equals(pcbSizeChoice.getValue())) {
            AlertBox notCompatibleAlert = new AlertBox();
            notCompatibleAlert.displayAlert("Not Compatible", "Your PCB and plate must be the same "
                    + "size as your case! Please reselect your sizes!");
        } else {
            ExitConfirmationBox finishBuildBox = new ExitConfirmationBox();
            boolean answerToCompleteBuild = finishBuildBox.displayConfirmation("Confirm Build",
                    "Is this your finished build? ");
            if (answerToCompleteBuild) {
                parseKeyboard();
                keyboard.rateKeyboard();
                mainWindow.setScene(menuScene);
            }
        }
    }

    // EFFECTS: Compiles the keyboard with the choices found in the choice boxes
    // MODIFIES: keyboard
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

    // EFFECTS: Prints the build to a dialog box, if available, else tells the user to load or start a build
    private void displayPrint() {
        try {
            PrintBox rateBox = new PrintBox();
            rateBox.displayPrint("Keyboard Specifications", "Here is your keyboard\n\n"
                    + "Case Specifications: \n   " + keyboard.getKeyboardCase().getCaseSize() + "\n   "
                    + keyboard.getKeyboardCase().getCaseMaterial() + "\n\n" + "Keycaps Specifications: \n   "
                    + keyboard.getKeyboardKeycaps().getKeycapsMaterial() + "\n\nPlate Specifications: \n   "
                    + keyboard.getKeyboardPlate().getPlateMaterial() + "\n   "
                    + keyboard.getKeyboardPlate().getPlateSize() + "\n\nPCB Specifications: \n   "
                    + keyboard.getKeyboardPrintedCircuitBoard().getPcbSize() + "\n\nKey Switch Specifications: \n   "
                    + keyboard.getKeyboardSwitches().getSwitchType() + "\n   Silent Switches? "
                    + keyboard.getKeyboardSwitches().isSilentSwitches());
        } catch (NullPointerException e) {
            AlertBox printFailedAlert = new AlertBox();
            printFailedAlert.displayAlert("Print Unsuccessful!", "There is no build to show! "
                    + "Please load a keyboard or start a build.");
        }
    }

    // EFFECTS: Prints the rating to a dialog box, if available, else tells the user to load or start a build
    private void displayRate() {
        try {
            RateBox rateBox = new RateBox();
            rateBox.displayRating("Keyboard Rating", "On a scale from 1 to 10: 1 being quiet, soft, and"
                    + " light; 10 being loud, hard, \nand heavy for the typing sound, feel, and weight of the "
                    + "keyboard, respectively. \n\nThis is your keyboard's rating:\nSound Level: "
                    + keyboard.getSoundRating() + "\nTyping Feel: " + keyboard.getFeelRating() + "\nWeight: "
                    + keyboard.getWeightRating());
        } catch (NullPointerException e) {
            AlertBox rateFailedAlert = new AlertBox();
            rateFailedAlert.displayAlert("Rate Unsuccessful!", "There is no build to rate! "
                    + "Please load a keyboard or start a build.");
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
        } catch (NullPointerException e) {
            saveFailedAlert.displayAlert("Save Unsuccessful!", "No keyboard found to save to file  "
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