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
import ui.gui.AlertBox;
import ui.gui.ExitConfirmationBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


// Keyboard builder application
// EFFECTS: starts the GUI class
public class GUI extends Application {
    private Keyboard keyboard;
    private static final String ACCOUNTS_FILE = "./data/keyboard.txt";

    // Stage
    Stage window;

    //Buttons
    Button buttonInfo;
    Button buttonBuild;
    Button buttonPrint;
    Button buttonRate;

    // Menus
    Menu fileMenu = new Menu("_File");

    // EFFECTS: runs the builder application
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        displayMainMenu();
    }

    // EFFECTS: closes the builder application
    private void closeProgram() {
        ExitConfirmationBox closeProgramBox = new ExitConfirmationBox();
        Boolean answerToExit = closeProgramBox.displayConfirmation("Confirm Exit", "Are you sure you "
                + "want to quit?");
        if (answerToExit)
            window.close();
    }

    private void displayMainMenu() {
        AlertBox alert = new AlertBox();
        Text header = TextBuilder.create().text("Welcome to MK Parts Picker...").build();

        window.setTitle("Mechanical Keyboard Parts Picker");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        buttonInfo = new Button(" _Information ");
        buttonInfo.setOnAction(e -> alert.displayAlert("Message", "\n     No build found! "
                + "Please return to the menu and select Build to start your build!     \n"));
        buttonBuild = new Button("      _Build      ");
        buttonBuild.setOnAction(e -> alert.displayAlert("Message", "\n     No build found! "
                + "Please return to the menu and select Build to start your build!     \n"));
        buttonPrint = new Button("      _Print      ");
        buttonPrint.setOnAction(e -> alert.displayAlert("Message", "\n     No build found! "
                + "Please return to the menu and select Build to start your build!     \n"));
        buttonRate = new Button("      _Rate      ");
        buttonRate.setOnAction(e -> alert.displayAlert("Message", "\n     No build found! "
                + "Please return to the menu and select Build to start your build!     \n"));

        VBox menuLayout = new VBox(30);
        menuLayout.setPadding(new Insets(0,-50,0,75));
        menuLayout.getChildren().addAll(buttonInfo, buttonBuild, buttonPrint, buttonRate);
        menuLayout.setAlignment(Pos.CENTER);

        BorderPane mainMenuLayout = new BorderPane();
        mainMenuLayout.setTop(displayMenuBar());
        mainMenuLayout.setCenter(header);
        mainMenuLayout.setLeft(menuLayout);

        Scene scene = new Scene(mainMenuLayout, 800, 450);
        window.setScene(scene);
        window.show();

    }

    private void displayInformationMenu() {

    }

    private void displayBuildMenu() {

    }

    private void displayPrint() {
        // if no build, display no build found.. else show print statement
    }

    private void displayRate() {

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
            keyboard = new Keyboard();
            writer.write(keyboard);
            writer.close();
            saveAlert.displayAlert("Save Successful!","Keyboard saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            saveFailedAlert.displayAlert("Save Unsuccessful!","Unable to save keyboard to file "
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
            loadAlert.displayAlert("Load Successful!","Keyboard loaded from " + ACCOUNTS_FILE);
        } catch (IOException e) {
            displayMainMenu();
        }
    }

























}
