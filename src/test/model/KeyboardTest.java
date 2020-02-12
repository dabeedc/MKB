package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardTest {
    private Keyboard testKeyboard;

    int soundRating;
    int feelRating;
    int weightRating;

    @BeforeEach
    void runBefore() {
        testKeyboard = new Keyboard();
        soundRating = 5;
        feelRating = 5;
        weightRating = 5;
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

    @Test
    void testRateCaseSoundAluminum() {
        assertEquals("", testKeyboard.keyboardCase.getCaseMaterial());
        assertEquals(5, soundRating);
        testKeyboard.keyboardCase.setCaseMaterial("aluminum");
        assertEquals("aluminum", testKeyboard.keyboardCase.getCaseMaterial());
        assertEquals(6, testKeyboard.rateCaseSound());
    }

    @Test
    void testRateCaseSoundPlastic() {
        assertEquals("", testKeyboard.keyboardCase.getCaseMaterial());
        assertEquals(5, soundRating);
        testKeyboard.keyboardCase.setCaseMaterial("plastic");
        assertEquals("plastic", testKeyboard.keyboardCase.getCaseMaterial());
        assertEquals(4,testKeyboard.rateCaseSound());
    }

    @Test
    void testRateKeycapsSoundABS() {
    }

    @Test
    void testRateKeycapsSoundPBT() {

    }

    @Test
    void testRatePlateSoundBrass() {

    }

    @Test
    void testRatePlateSoundAluminum() {

    }

    @Test
    void testRatePlateSoundPolycarbonate() {

    }

    @Test
    void testRateSwitchesSoundTactile() {

    }

    @Test
    void testRateSwitchesSoundLinear() {

    }

    @Test
    void testRateSwitchesSoundClicky() {

    }

    @Test
    void testRateCaseFeelAluminum() {

    }

    @Test
    void testRateCaseFeelPlastic() {

    }

    @Test
    void testRatePlateFeelBrass() {

    }

    @Test
    void testRatePlateFeelAluminum() {

    }

    @Test
    void testRatePlateFeelPolycarbonate() {

    }

    @Test
    void testRateSwitchesFeelTactile() {

    }

    @Test
    void testRateSwitchesFeelLinear() {

    }

    @Test
    void testRateSwitchesFeelClicky() {

    }

    @Test
    void testRateCaseWeightAluminum() {

    }

    @Test
    void testRateCaseWeightPlastic() {

    }

    @Test
    void testRatePlateWeightBrass() {

    }

    @Test
    void testRatePlateWeightAluminum() {

    }

    @Test
    void testRatePlateWeightPolycarbonate() {

    }
}