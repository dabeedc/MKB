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
        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
        assertEquals("", testKeyboard.getKeyboardCase().getCaseSize());
        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
        assertEquals("", testKeyboard.getKeyboardPlate().getPlateMaterial());
        assertEquals("", testKeyboard.getKeyboardPlate().getPlateSize());
        assertEquals("", testKeyboard.getKeyboardPrintedCircuitBoard().getPcbSize());
        assertEquals("", testKeyboard.getKeyboardSwitches().getSwitchType());
        assertFalse(testKeyboard.getKeyboardSwitches().isSilentSwitches());
    }

    @Test
    void testIndividualRating() {
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("abs");
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        testKeyboard.getKeyboardSwitches().setSwitchType("tactile");
        assertEquals(7, testKeyboard.ratePlateWeight());
        assertEquals(9, testKeyboard.rateCaseWeight());
        assertEquals(6, testKeyboard.rateSwitchesSound());
        assertEquals(8, testKeyboard.ratePlateSound());
        assertEquals(9, testKeyboard.rateCaseSound());
        assertEquals(10, testKeyboard.rateKeycapsSound());
    }

    @Test
    void testRateTheKeyboard() {
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("abs");
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        testKeyboard.getKeyboardSwitches().setSwitchType("tactile");
        testKeyboard.rateTheKeyboard();
        assertEquals(10,testKeyboard.getSoundRating());
        assertEquals(10,testKeyboard.getFeelRating());
        assertEquals(9,testKeyboard.getWeightRating());
    }

    @Test
    void testRateTheKeyboardSilent() {
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("pbt");
        testKeyboard.getKeyboardPlate().setPlateMaterial("plastic");
        testKeyboard.getKeyboardSwitches().setSwitchType("linear");
        testKeyboard.getKeyboardSwitches().setSilentSwitches(true);
        testKeyboard.rateTheKeyboard();
        assertEquals(1,testKeyboard.getSoundRating());
        assertEquals(5,testKeyboard.getFeelRating());
        assertEquals(7,testKeyboard.getWeightRating());
    }


    @Test
    void testRateCaseSoundAluminum() {
        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
        assertEquals(5, testKeyboard.getSoundRating());
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        assertEquals("aluminum", testKeyboard.getKeyboardCase().getCaseMaterial());
        assertEquals(6, testKeyboard.rateCaseSound());
    }

    @Test
    void testRateCaseSoundPlastic() {
        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
        assertEquals(5, testKeyboard.getSoundRating());
        testKeyboard.getKeyboardCase().setCaseMaterial("plastic");
        assertEquals("plastic", testKeyboard.getKeyboardCase().getCaseMaterial());
        assertEquals(4, testKeyboard.rateCaseSound());
    }

    @Test
    void testRateKeycapsSoundABS() {
        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
        assertEquals(5, testKeyboard.getSoundRating());
        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("abs");
        assertEquals("abs", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
        assertEquals(6, testKeyboard.rateKeycapsSound());
    }

    @Test
    void testRateKeycapsSoundPBT() {
        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
        assertEquals(5, testKeyboard.getSoundRating());
        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("pbt");
        assertEquals("pbt", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
        assertEquals(4, testKeyboard.rateKeycapsSound());
    }

    @Test
    void testRatePlateSoundBrass() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals(7, testKeyboard.ratePlateSound());
    }

    @Test
    void testRatePlateSoundAluminum() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("aluminum");
        assertEquals(6, testKeyboard.ratePlateSound());
    }

    @Test
    void testRatePlateSoundPolycarbonate() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("polycarbonate");
        assertEquals(4, testKeyboard.ratePlateSound());
    }

    @Test
    void testRateSwitchesSoundTactile() {
        testKeyboard.getKeyboardSwitches().setSwitchType("tactile");
        assertEquals(6, testKeyboard.rateSwitchesSound());
    }

    @Test
    void testRateSwitchesSoundLinear() {
        testKeyboard.getKeyboardSwitches().setSwitchType("linear");
        assertEquals(4, testKeyboard.rateSwitchesSound());
    }

    @Test
    void testRateSwitchesSoundClicky() {
        testKeyboard.getKeyboardSwitches().setSwitchType("clicky");
        assertEquals(8, testKeyboard.rateSwitchesSound());

    }

    @Test
    void testRateSwitchesSoundisSilenced() {
        testKeyboard.getKeyboardSwitches().setSwitchType("tactile");
        assertEquals(6, testKeyboard.rateSwitchesSound());
        testKeyboard.getKeyboardSwitches().setSilentSwitches(true);
        assertEquals(2, testKeyboard.rateSwitchesSound());
    }

    @Test
    void testRateCaseFeelAluminum() {
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        assertEquals(6, testKeyboard.rateCaseFeel());
    }

    @Test
    void testRateCaseFeelPlastic() {
        testKeyboard.getKeyboardCase().setCaseMaterial("plastic");
        assertEquals(4, testKeyboard.rateCaseFeel());
    }

    @Test
    void testRatePlateFeelBrass() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals(7, testKeyboard.ratePlateFeel());
    }

    @Test
    void testRatePlateFeelAluminum() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("aluminum");
        assertEquals(6, testKeyboard.ratePlateFeel());
    }

    @Test
    void testRatePlateFeelPolycarbonate() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("polycarbonate");
        assertEquals(4, testKeyboard.ratePlateFeel());

    }

    @Test
    void testRateSwitchesFeelTactile() {
        testKeyboard.getKeyboardSwitches().setSwitchType("tactile");
        assertEquals(7, testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateSwitchesFeelLinear() {
        testKeyboard.getKeyboardSwitches().setSwitchType("linear");
        assertEquals(4, testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateSwitchesFeelClicky() {
        testKeyboard.getKeyboardSwitches().setSwitchType("clicky");
        assertEquals(7, testKeyboard.rateSwitchesFeel());
    }

    @Test
    void testRateCaseWeightAluminum() {
        testKeyboard.getKeyboardCase().setCaseMaterial("aluminum");
        assertEquals(7, testKeyboard.rateCaseWeight());
    }

    @Test
    void testRateCaseWeightPlastic() {
        testKeyboard.getKeyboardCase().setCaseMaterial("plastic");
        assertEquals(3, testKeyboard.rateCaseWeight());
    }

    @Test
    void testRatePlateWeightBrass() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals(7, testKeyboard.ratePlateWeight());
    }

    @Test
    void testRatePlateWeightAluminum() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("aluminum");
        assertEquals(6, testKeyboard.ratePlateWeight());
    }

    @Test
    void testRatePlateWeightPolycarbonate() {
        testKeyboard.getKeyboardPlate().setPlateMaterial("polycarbonate");
        assertEquals(4, testKeyboard.ratePlateWeight());
    }

    @Test
    void testSetSoundRating() {
        assertEquals(5, testKeyboard.getSoundRating());
        testKeyboard.setSoundRating(10);
        assertEquals(10, testKeyboard.getSoundRating());
    }

    @Test
    void testGetFeelRating() {
        assertEquals(5,testKeyboard.getFeelRating());
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals("brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
        testKeyboard.rateTheKeyboard();
        assertEquals(7,testKeyboard.getFeelRating());
    }

    @Test
    void testGetSoundRating() {
        assertEquals(5,testKeyboard.getSoundRating());
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals("brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
        testKeyboard.rateTheKeyboard();
        assertEquals(7,testKeyboard.getSoundRating());
    }

    @Test
    void testGetWeightRating() {
        assertEquals(5,testKeyboard.getWeightRating());
        testKeyboard.getKeyboardPlate().setPlateMaterial("brass");
        assertEquals("brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
        testKeyboard.rateTheKeyboard();
        assertEquals(7,testKeyboard.getWeightRating());
    }
}