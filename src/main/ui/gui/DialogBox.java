package ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogBox {
    // EFFECTS: Displays the alert box to user
    public void displayDialog(String title, String message, int width) {
        Stage window = new Stage();

        window.setTitle(title);
        window.setMinWidth(width);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(25);
        layout.getChildren().addAll(label, closeButton);
        layout.setPadding(new Insets(25));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
