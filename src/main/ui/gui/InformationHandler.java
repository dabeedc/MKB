package ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.Keyboard;
import ui.Information;

import static ui.GUI.DIALOG_SIZE;

// Represents all information about a keyboard
public class InformationHandler {
    Button caseInfo = new Button("         Case        ");
    Button keycapsInfo = new Button("      Keycaps      ");
    Button plateInfo = new Button("         Plate         ");
    Button pcbInfo = new Button("          PCB          ");
    Button switchesInfo = new Button("       Switches       ");

    Scene infoScene;

    String text = "Please click on what you would like to learn more about";
    Text infoHeader = TextBuilder.create().text(text).build();

    // EFFECTS: Displays the information menu to user
    public void displayInformationMenu() {
        Stage window = new Stage();

        window.setTitle("Information");
        window.setMinWidth(800);

        caseInfo.setOnAction(event -> infoHeader.setText(Information.CASE_INFO));

        keycapsInfo.setOnAction(event -> infoHeader.setText(Information.KEYCAPS_INFO));
        plateInfo.setOnAction(event -> infoHeader.setText(Information.PLATE_INFO));
        pcbInfo.setOnAction(event -> infoHeader.setText(Information.PRINTEDCIRCUITBOARD_INFO));
        switchesInfo.setOnAction(event -> infoHeader.setText(Information.SWITCHES_INFO));

        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox infoButtonsLayout = new VBox(30);

        infoButtonsLayout.setPadding(new Insets(0, -20, 0, 25));
        infoButtonsLayout.getChildren().addAll(caseInfo, keycapsInfo, plateInfo, pcbInfo, switchesInfo, closeButton);
        infoButtonsLayout.setAlignment(Pos.CENTER);

        BorderPane infoMenuLayout = new BorderPane();
        infoMenuLayout.setCenter(infoHeader);
        infoMenuLayout.setLeft(infoButtonsLayout);

        infoScene = new Scene(infoMenuLayout, 600, 350);
        window.setScene(infoScene);
        window.showAndWait();
    }

    // EFFECTS: Prints the build to a dialog box, if available, else tells the user to load or start a build
    public void displayPrint(Keyboard keyboard) {
        try {
            DialogBox rateBox = new DialogBox() {
            };
            rateBox.displayDialog("Keyboard Specifications", "Here is your keyboard!\n\n"
                    + "Case Specifications: \n   " + keyboard.getKeyboardCase().getCaseSize() + "\n   "
                    + keyboard.getKeyboardCase().getCaseMaterial() + "\n\n" + "Keycaps Specifications: \n   "
                    + keyboard.getKeyboardKeycaps().getKeycapsMaterial() + "\n\nPlate Specifications: \n   "
                    + keyboard.getKeyboardPlate().getPlateMaterial() + "\n   "
                    + keyboard.getKeyboardPlate().getPlateSize() + "\n\nPCB Specifications: \n   "
                    + keyboard.getKeyboardPrintedCircuitBoard().getPcbSize() + "\n\nKey Switch Specifications: \n   "
                    + keyboard.getKeyboardSwitches().getSwitchType() + "\n   Silent Switches? "
                    + keyboard.getKeyboardSwitches().isSilentSwitches(), 310);
        } catch (NullPointerException e) {
            DialogBox printFailedAlert = new AlertBox();
            printFailedAlert.displayDialog("Print Unsuccessful!", "There is no build to show! "
                    + "Please load a keyboard or start a build.", DIALOG_SIZE);
        }
    }

    // EFFECTS: Prints the rating to a dialog box, if available, else tells the user to load or start a build
    public void displayRate(Keyboard keyboard) {
        try {
            DialogBox rateBox = new DialogBox();
            rateBox.displayDialog("Keyboard Rating", "On a scale from 1 to 10: 1 being quiet, soft, and"
                    + " light; 10 being loud, hard, \nand heavy for the typing sound, feel, and weight of the "
                    + "keyboard, respectively. \n\nThis is your keyboard's rating:\nSound Level: "
                    + keyboard.getSoundRating() + "\nTyping Feel: " + keyboard.getFeelRating() + "\nWeight: "
                    + keyboard.getWeightRating(), DIALOG_SIZE);
        } catch (NullPointerException e) {
            DialogBox rateFailedAlert = new AlertBox();
            rateFailedAlert.displayDialog("Rate Unsuccessful!", "There is no build to rate! "
                    + "Please load a keyboard or start a build.", DIALOG_SIZE);
        }
    }
}

