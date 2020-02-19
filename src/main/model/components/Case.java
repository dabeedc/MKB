package model.components;

// Represents a case of a keyboard that indicates what material it is made out of as well as the size of the case.
public class Case {
    private static String caseMaterial;
    private static String caseSize;

    // EFFECTS: Constructs a case with no caseMaterial and no caseSize
    public Case() {
        caseMaterial = "";
        caseSize = "";
    }

    // Getters
    // EFFECTS: returns the material of the case
    public static String getCaseMaterial() {
        return caseMaterial;
    }

    // EFFECTS: returns the size of the case
    public static String getCaseSize() {
        return caseSize;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the material of the case
    public static void setCaseMaterial(String caseMaterial) {
        Case.caseMaterial = caseMaterial;
    }

    // MODIFIES: this
    // EFFECTS: sets the size of the case
    public static void setCaseSize(String caseSize) {
        Case.caseSize = caseSize;
    }
}