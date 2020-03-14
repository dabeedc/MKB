package ui.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuBar {
    public void displayMenuBar() {
        // File Menu
        Menu fileMenu = new Menu("File");

        // Menu Items
        fileMenu.getItems().add(new MenuItem("Save Keyboard"));
        fileMenu.getItems().add(new MenuItem("Load Keyboard"));

        // Main Menu Bar
        javafx.scene.control.MenuBar menubar = new javafx.scene.control.MenuBar();
        menubar.getMenus().addAll(fileMenu);
    }
}
