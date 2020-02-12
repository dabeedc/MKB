package model;

import model.components.Case;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.components.Case.setCaseMaterial;
import static model.components.Case.setCaseSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTest {
    Case testCase;

    @BeforeEach
    void runBefore() {
        testCase = new Case();
    }

    @Test
    void testConstructor() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals("", testCase.getCaseSize());
    }

    @Test
    void testGetCaseMaterial() {
        assertEquals("", testCase.getCaseMaterial());
        setCaseMaterial("aluminum");
        assertEquals("aluminum", testCase.getCaseMaterial());
    }

    @Test
    void testGetCaseSize() {
        assertEquals("", testCase.getCaseSize());
        setCaseSize("small");
        assertEquals("small", testCase.getCaseSize());
    }

    @Test
    void testSetCaseMaterial() {
        assertEquals("", testCase.getCaseMaterial());
        setCaseMaterial("plastic");
        assertEquals("plastic", testCase.getCaseMaterial());
    }

    @Test
    void testSetCaseSize() {
        assertEquals("", testCase.getCaseSize());
        setCaseSize("large");
        assertEquals("large", testCase.getCaseSize());
    }

    @Test
    void testCaseComponents() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals("", testCase.getCaseSize());
        setCaseMaterial("aluminum");
        setCaseSize("small");
        assertEquals("aluminum", testCase.getCaseMaterial());
        assertEquals("small", testCase.getCaseSize());
    }
}
