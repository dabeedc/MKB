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
        assertEquals(4, testKeyboard.rateCaseSound());
    }

    @Test
    void testRateKeycapsSoundABS() {
        assertEquals("", testKeyboard.keyboardKeycaps.getKeycapsMaterial());
        assertEquals(5, soundRating);
        testKeyboard.keyboardKeycaps.setKeycapsMaterial("abs");
        assertEquals("abs", testKeyboard.keyboardKeycaps.getKeycapsMaterial());
        assertEquals(6, testKeyboard.rateKeycapsSound());
    }

    @Test
    void testRateKeycapsSoundPBT() {
        assertEquals("", testKeyboard.keyboardKeycaps.getKeycapsMaterial());
        assertEquals(5, soundRating);
        testKeyboard.keyboardKeycaps.setKeycapsMaterial("pbt");
        assertEquals("pbt", testKeyboard.keyboardKeycaps.getKeycapsMaterial());
        assertEquals(4, testKeyboard.rateKeycapsSound());
    }

    @Test
    void testRatePlateSoundBrass() {
        testKeyboard.keyboardPlate.setPlateMaterial("brass");
        assertEquals(7,testKeyboard.ratePlateSound());
    }

    @Test
    void testRatePlateSoundAluminum() {
        testKeyboard.keyboardPlate.setPlateMaterial("aluminum");
        assertEquals(6,testKeyboard.ratePlateSound());
    }

    @Test
    void testRatePlateSoundPolycarbonate() {
        testKeyboard.keyboardPlate.setPlateMaterial("polycarbonate");
        assertEquals(4,testKeyboard.ratePlateSound());
    }

    @Test
    void testRateSwitchesSoundTactile() {
        testKeyboard.keyboardSwitches.setSwitchType("tactile");
        assertEquals(6,testKeyboard.rateSwitchesSound());
    }

    @Test
    void testRateSwitchesSoundLinear() {
        testKeyboard.keyboardSwitches.setSwitchType("linear");
        assertEquals(4,testKeyboard.rateSwitchesSound());
    }

    @Test
    void testRateSwitchesSoundClicky() {
        testKeyboard.keyboardSwitches.setSwitchType("clicky");
        assertEquals(8,testKeyboard.rateSwitchesSound());

    }

    @Test
    void testRateCaseFeelAluminum() {
        testKeyboard.keyboardCase.setCaseMaterial("aluminum");
        assertEquals(6,testKeyboard.rateCaseFeel());
    }

    @Test
    void testRateCaseFeelPlastic() {
        testKeyboard.keyboardCase.setCaseMaterial("plastic");
        assertEquals(4,testKeyboard.rateCaseFeel());
    }

    @Test
    void testRatePlateFeelBrass() {
        testKeyboard.keyboardPlate.setPlateMaterial("brass");
        assertEquals(7,testKeyboard.ratePlateFeel());
    }

    @Test
    void testRatePlateFeelAluminum() {
        testKeyboard.keyboardPlate.setPlateMaterial("aluminum");
        assertEquals(6,testKeyboard.ratePlateFeel());
    }

    @Test
    void testRatePlateFeelPolycarbonate() {
        testKeyboard.keyboardPlate.setPlateMaterial("polycarbonate");
        assertEquals(4,testKeyboard.ratePlateFeel());

    }

    @Test
    void testRateSwitchesFeelTactile() {
        testKeyboard.keyboardSwitches.setSwitchType("tactile");
        assertEquals(6,testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateSwitchesFeelLinear() {
        testKeyboard.keyboardSwitches.setSwitchType("linear");
        assertEquals(4,testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateSwitchesFeelClicky() {
        testKeyboard.keyboardSwitches.setSwitchType("clicky");
        assertEquals(7,testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateCaseWeightAluminum() {
        testKeyboard.keyboardCase.setCaseMaterial("aluminum");
        assertEquals(7,testKeyboard.rateCaseWeight());
    }

    @Test
    void testRateCaseWeightPlastic() {
        testKeyboard.keyboardCase.setCaseMaterial("plastic");
        assertEquals(3,testKeyboard.rateCaseWeight());
    }

    @Test
    void testRatePlateWeightBrass() {
        testKeyboard.keyboardPlate.setPlateMaterial("brass");
        assertEquals(7,testKeyboard.ratePlateWeight());
    }

    @Test
    void testRatePlateWeightAluminum() {
        testKeyboard.keyboardPlate.setPlateMaterial("aluminum");
        assertEquals(6,testKeyboard.ratePlateWeight());
    }

    @Test
    void testRatePlateWeightPolycarbonate() {
        testKeyboard.keyboardPlate.setPlateMaterial("polycarbonate");
        assertEquals(4,testKeyboard.ratePlateWeight());
    }
}