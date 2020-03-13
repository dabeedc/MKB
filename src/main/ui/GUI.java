package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.gui.AlertBox;
import ui.gui.ConfirmationBox;

public class GUI extends Application {
    Stage window;
    Button button;
    Button button2;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        AlertBox alert = new AlertBox();
        StackPane layout = new StackPane();

        window.setTitle("Mechanical Keyboard Parts Picker");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        button = new Button("Download Virus");
        button.setOnAction(e -> alert.displayAlert("Message", "\n     No build found! "
                + "Please return to the menu and select Build to start your build!     \n"));
        button2 = new Button("Exit");
        button2.setOnAction(event -> closeProgram());

        layout.getChildren().addAll(button, button2);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1500, 750);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        ConfirmationBox closeProgramBox = new ConfirmationBox();
        Boolean answerToExit = closeProgramBox.displayConfirmation("Confirm Exit", "Are you sure you "
                + "want to quit?");
        if (answerToExit)
            window.close();
    }


}
