package ui.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

// Represents an alert box that alerts the user
public class RateBox {

    // EFFECTS: Displays the alert box to  user
    public void displayRating(String title, String message) {
        Stage window = new Stage();

        window.setTitle(title);
        window.setMinWidth(350);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(25);
        layout.getChildren().addAll(label, closeButton);
        layout.setPadding(new Insets(25));
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }




}
