package model.Components;

// Represents a printed circuit board having a size
public class PrintedCircuitBoard {
    private static String pcbSize;

    // EFFECTS: Constructs a printed circuit board with no pcbSize
    public PrintedCircuitBoard() {
        pcbSize = "";
    }

    // Getters
    // EFFECTS: gets the size of the printed circuit board
    public static String getPcbSize() {
        return pcbSize;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the size of the printed circuit board
    public static void setPcbSize(String pcbSize) {
        PrintedCircuitBoard.pcbSize = pcbSize;
    }
}
