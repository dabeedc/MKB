package ui.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

// Represents a confirmation box that confirms information with the user
public class ExitConfirmationBox extends DialogBox {
    public boolean answer;
    Label label = new Label();
    Stage window = new Stage();

    // EFFECTS: Displays the confirmation box to the user
    public boolean displayConfirmation(String title, String message) {

        //This blocks the events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        label.setText(message);

        Button yesButton = new Button("     Yes     ");
        Button noButton = new Button("     No     ");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox layout = new HBox(20);

        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }



}
