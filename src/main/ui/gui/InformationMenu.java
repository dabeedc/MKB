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

// Represents an alert box that alerts the user
public class InformationMenu {
    Button caseInfo;
    Button keycapsInfo;
    Button plateInfo;
    Button pcbInfo;
    Button switchesInfo;

    Scene infoScene;

    // EFFECTS: Displays the information menu to user
    public void displayInformationMenu() {
        Stage window = new Stage();

        window.setTitle("Information");
        window.setMinWidth(350);

        caseInfo = new Button(" Case ");
        caseInfo.setOnAction(event -> System.out.println("Clicked Case Button"));
        keycapsInfo = new Button("      Keycaps      ");
        keycapsInfo.setOnAction(event -> System.out.println("Clicked Keycaps Button"));
        plateInfo = new Button("      Plate      ");
        plateInfo.setOnAction(event -> System.out.println("Clicked Plate Button"));
        pcbInfo = new Button("      PCB      ");
        pcbInfo.setOnAction(event -> System.out.println("Clicked PCB Button"));
        switchesInfo = new Button("      Switches      ");
        switchesInfo.setOnAction(event -> System.out.println("Clicked Switches Button"));
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox infoButtonsLayout = new VBox(30);
        infoButtonsLayout.setPadding(new Insets(25));
        infoButtonsLayout.getChildren().addAll(caseInfo, keycapsInfo, plateInfo, pcbInfo, switchesInfo, closeButton);
        infoButtonsLayout.setAlignment(Pos.CENTER);

        Text infoHeader = TextBuilder.create().text("Welcome to MK Parts Picker...").build();
        BorderPane infoMenuLayout = new BorderPane();
        infoMenuLayout.setCenter(infoHeader);
        infoMenuLayout.setLeft(infoButtonsLayout);

        //Display window and wait for it to be closed before returning
        infoScene = new Scene(infoMenuLayout, 600,350);
        window.setScene(infoScene);
        window.showAndWait();
    }


}
//
//    private void displayInformationMenu() {
//        Text infoHeader = TextBuilder.create().text("Welcome to MK Parts Picker...").build();
//        infoWindow.setTitle("Information");
//        infoWindow.setOnCloseRequest(event -> {
//            event.consume();
//            closeProgram();
//        });
//
//        BorderPane infoMenuLayout = new BorderPane();
//        infoMenuLayout.setCenter(infoHeader);
//
//
//        infoScene = new Scene(infoMenuLayout, 800, 450);
//        infoWindow.setScene(infoScene);
//        infoWindow.show();
//    }