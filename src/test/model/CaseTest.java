package model;

import model.components.Case;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        testCase.setCaseMaterial("aluminum");
        assertEquals("aluminum", testCase.getCaseMaterial());
    }

    @Test
    void testGetCaseSize() {
        assertEquals("", testCase.getCaseSize());
        testCase.setCaseSize("small");
        assertEquals("small", testCase.getCaseSize());
    }

    @Test
    void testSetCaseMaterial() {
        assertEquals("", testCase.getCaseMaterial());
        testCase.setCaseMaterial("plastic");
        assertEquals("plastic", testCase.getCaseMaterial());
    }

    @Test
    void testSetCaseSize() {
        assertEquals("", testCase.getCaseSize());
        testCase.setCaseSize("large");
        assertEquals("large", testCase.getCaseSize());
    }

    @Test
    void testCaseSpecs() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals("", testCase.getCaseSize());
        testCase.setCaseMaterial("aluminum");
        testCase.setCaseSize("small");
        assertEquals("aluminum", testCase.getCaseMaterial());
        assertEquals("small", testCase.getCaseSize());
    }

    @Test
    void testRateCaseSoundAluminum() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals(0, testCase.getSoundRating());
        testCase.setCaseMaterial("Aluminum");
        assertEquals("Aluminum", testCase.getCaseMaterial());
        testCase.rate();
        assertEquals(1,testCase.getSoundRating());
    }

    @Test
    void testRateCaseSoundPolycarbonate() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals(0, testCase.getSoundRating());
        testCase.setCaseMaterial("Polycarbonate");
        assertEquals("Polycarbonate", testCase.getCaseMaterial());
        testCase.rate();
        assertEquals(0, testCase.getSoundRating());
    }

    @Test
    void testRateCaseSoundPlastic() {
        assertEquals("", testCase.getCaseMaterial());
        assertEquals(0, testCase.getSoundRating());
        testCase.setCaseMaterial("Plastic");
        assertEquals("Plastic", testCase.getCaseMaterial());
        assertEquals(0, testCase.getSoundRating());
    }

    @Test
    void testRateCaseFeelAluminum() {
        testCase.setCaseMaterial("Aluminum");
        testCase.rate();
        assertEquals(1, testCase.getFeelRating());
    }

    @Test
    void testRateCaseFeelPlastic() {
        testCase.setCaseMaterial("Plastic");
        testCase.rate();
        assertEquals(-1, testCase.getFeelRating());
    }

    @Test
    void testRateCaseWeightAluminum() {
        testCase.setCaseMaterial("Aluminum");
        testCase.rate();
        assertEquals(1, testCase.getFeelRating());
    }

    @Test
    void testRateCaseWeightPlastic() {
        testCase.setCaseMaterial("Plastic");
        testCase.rate();
        assertEquals(-1, testCase.getFeelRating());
    }
}
