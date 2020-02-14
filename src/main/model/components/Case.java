package model.components;

// Represents a case of a keyboard that indicates what material it is made out of as well as the size of the case.
public class Case {
    private String caseMaterial;
    private String caseSize;

    // EFFECTS: Constructs a case with no caseMaterial and no caseSize
    public Case() {
        caseMaterial = "";
        caseSize = "";
    }

    // Getters
    // EFFECTS: returns the material of the case
    public String getCaseMaterial() {
        return caseMaterial;
    }

    // EFFECTS: returns the size of the case
    public String getCaseSize() {
        return caseSize;
    }

    // Setters
    // MODIFIES: this
    // EFFECTS: sets the material of the case
    public void setCaseMaterial(String caseMaterial) {
        Case.caseMaterial = caseMaterial;
    }

    // MODIFIES: this
    // EFFECTS: sets the size of the case
    public void setCaseSize(String caseSize) {
        Case.caseSize = caseSize;
    }
}
Test