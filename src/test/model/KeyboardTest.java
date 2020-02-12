package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardTest {
    private Keyboard testKeyboard;

    @BeforeEach
    void runBefore() {
        testKeyboard = new Keyboard();
    }

    @Test
    void testConstructor() {
        assertEquals("", testKeyboard.keyboardCase.getCaseMaterial());
        assertEquals("", testKeyboard.keyboardCase.getCaseSize());
        assertEquals("", testKeyboard.keyboardKeycaps.getKeycapsMaterial());
        assertEquals("", testKeyboard.keyboardPlate.getPlateMaterial());
        assertEquals("", testKeyboard.keyboardPlate.getPlateSize());
        assertEquals("", testKeyboard.keyboardPrintedCircuitBoard.getPcbSize());
        assertEquals("", testKeyboard.keyboardSwitches.getSwitchType());
        assertFalse(testKeyboard.keyboardSwitches.isSilentSwitches());
    }

}