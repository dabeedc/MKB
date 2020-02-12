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
        assertEquals("",testSwitches.getSwitchType());
        assertFalse(testSwitches.isSilentSwitches());
    }

    @Test
    void testGetSwitchType() {
        assertEquals("",testSwitches.getSwitchType());
        testSwitches.setSwitchType("tactile");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("tactile",testSwitches.getSwitchType());
    }

    @Test
    void testIsSilentSwitchesFalse() {
        assertEquals("",testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("linear",testSwitches.getSwitchType());
    }

    @Test
    void testIsSilentSwitchesTrue() {
        assertEquals("",testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        testSwitches.setSilentSwitches(true);
        assertEquals("linear",testSwitches.getSwitchType());
        assertTrue(testSwitches.isSilentSwitches());
    }

    @Test
    void testSetSwitchType() {
        assertEquals("",testSwitches.getSwitchType());
        testSwitches.setSwitchType("clicky");
        assertFalse(testSwitches.isSilentSwitches());
        assertEquals("clicky",testSwitches.getSwitchType());
    }

    @Test
    void testSetSilentSwitches() {
        assertEquals("",testSwitches.getSwitchType());
        testSwitches.setSwitchType("linear");
        assertFalse(testSwitches.isSilentSwitches());
        testSwitches.setSilentSwitches(true);
        assertEquals("linear",testSwitches.getSwitchType());
        assertTrue(testSwitches.isSilentSwitches());
    }
}
