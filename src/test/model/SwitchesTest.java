package model;

import model.components.Switches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchesTest {
    Switches testSwitches;

    @BeforeEach
    void runBefore() {
        testSwitches = new Switches();
    }

    @Test
    void testConstructor() {
        assertEquals("", testSwitches.getSwitchType());
        assertFalse(testSwitches.isSilentSwitches());
    }

    @Test
    void testGetSwitchType() {
        assertEquals("", testSwitches.getSwitchType());
        testSwitches.setSwitchType("tactile");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("tactile", testSwitches.getSwitchType());
    }

    @Test
    void testIsSilentSwitchesFalse() {
        assertEquals("", testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("linear", testSwitches.getSwitchType());
    }

    @Test
    void testIsSilentSwitchesTrue() {
        assertEquals("", testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        testSwitches.setSilentSwitches(true);
        assertEquals("linear", testSwitches.getSwitchType());
        assertTrue(testSwitches.isSilentSwitches());
    }

    @Test
    void testSetSwitchType() {
        assertEquals("", testSwitches.getSwitchType());
        testSwitches.setSwitchType("clicky");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("clicky", testSwitches.getSwitchType());
    }

    @Test
    void testSetSilentSwitches() {
        assertEquals("", testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        testSwitches.setSilentSwitches(true);
        assertEquals("linear", testSwitches.getSwitchType());
        assertTrue(testSwitches.isSilentSwitches());
    }

    @Test
    void testRateSwitchesSoundTactile() {
        testSwitches.setSwitchType("Tactile");
        testSwitches.rate();
        assertEquals(1, testSwitches.getSoundRating());
    }

    @Test
    void testRateSwitchesSoundLinear() {
        testSwitches.setSwitchType("Linear");
        testSwitches.rate();
        assertEquals(-1, testSwitches.getSoundRating());
    }

    @Test
    void testRateSwitchesSoundClicky() {
        testSwitches.setSwitchType("Clicky");
        testSwitches.rate();
        assertEquals(3, testSwitches.getSoundRating());
    }

    @Test
    void testRateSwitchesSoundisSilenced() {
        testSwitches.setSwitchType("Tactile");
        testSwitches.rate();
        assertEquals(1, testSwitches.getSoundRating());
        testSwitches.setSilentSwitches(true);
        testSwitches.rate();
        assertEquals(-3, testSwitches.getSoundRating());    }

    @Test
    void testRateSwitchesFeelTactile() {
        testSwitches.setSwitchType("Tactile");
        testSwitches.rate();
        assertEquals(2, testSwitches.getFeelRating());
    }

    @Test
    void testRateSwitchesFeelLinear() {
        testSwitches.setSwitchType("Linear");
        testSwitches.rate();
        assertEquals(-1, testSwitches.getFeelRating());
    }

    @Test
    void testRateSwitchesFeelClicky() {
        testSwitches.setSwitchType("Clicky");
        testSwitches.rate();
        assertEquals(2, testSwitches.getFeelRating());
    }
}
