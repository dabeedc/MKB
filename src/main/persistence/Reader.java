package persistence;

import model.Keyboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read account data from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Object> getKeyboardParts(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one account
    private static List<Object> parseContent(List<String> fileContent) {
        List<Object> keyboardParts = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            keyboardParts.add(parseKeyboard(lineComponents));
        }

        return keyboardParts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 4 where element 0 represents the
    // id of the next account to be constructed, element 1 represents
    // the id, elements 2 represents the name and element 3 represents
    // the balance of the account to be constructed
    // EFFECTS: returns an account constructed from components
    private static Keyboard parseKeyboard(List<String> components) {
        String caseMat = components.get(0);
        String varB = components.get(1);
        String varC = components.get(2);
        String varD = components.get(3);
        String varE = components.get(4);
        String varF = components.get(5);
        String varG = components.get(6);
        String varH = components.get(7);
        int varI = Integer.parseInt(components.get(8));
        int varJ = Integer.parseInt(components.get(9));
        int varK = Integer.parseInt(components.get(10));
        return new Keyboard();
//        String caseMat = components.get(0);
//        String varB = components.get(1);
//        String varC = components.get(2);
//        String varD = components.get(3);
//        String varE = components.get(4);
//        String varF = components.get(5);
//        String varG = components.get(6);
//        String varH = components.get(7);
//        int varI = Integer.parseInt(components.get(8));
//        int varJ = Integer.parseInt(components.get(9));
//        int varK = Integer.parseInt(components.get(10));
//        return new Keyboard(caseMat, varB, varC, varD, varE, varF, varG, varH, varI, varJ, varK);
    } //todo
}