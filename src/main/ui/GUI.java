package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
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

    // Stages and Scenes
    Stage mainWindow;
    Scene menuScene;
    InformationMenu infoWindow;

    //Buttons
    Button buttonInfo;
    Button buttonBuild;
    Button buttonPrint;
    Button buttonRate;

    // Menu Bar
    Menu fileMenu = new Menu("_File");

    // Dialog Boxes
    AlertBox alert = new AlertBox();


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
        buttonBuild.setOnAction(event -> displayBuildMenu());
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

        menuScene = new Scene(mainMenuLayout, 800, 450);
        mainWindow.setScene(menuScene);
        mainWindow.show();
    }

    private void displayBuildMenu() {
        System.out.println("This is the build button clicked");
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
        javafx.scene.control.MenuBar menubar = new javafx.scene.control.MenuBar();
        menubar.getMenus().addAll(fileMenu);

        save.setOnAction(event -> saveKeyboard());
        load.setOnAction(event -> loadKeyboard());
        exit.setOnAction(event -> closeProgram());

        return menubar;
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
