//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class KeyboardTest {
//    private Keyboard testKeyboard;
//
//    @BeforeEach
//    void runBefore() {
//        testKeyboard = new Keyboard();
//    }
//
//    @Test
//    void testConstructor() {
//        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals("", testKeyboard.getKeyboardCase().getCaseSize());
//        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
//        assertEquals("", testKeyboard.getKeyboardPlate().getPlateMaterial());
//        assertEquals("", testKeyboard.getKeyboardPlate().getPlateSize());
//        assertEquals("", testKeyboard.getKeyboardPrintedCircuitBoard().getPcbSize());
//        assertEquals("", testKeyboard.getKeyboardSwitches().getSwitchType());
//        assertFalse(testKeyboard.getKeyboardSwitches().isSilentSwitches());
//    }
//
//    @Test
//    void testIndividualRating() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("ABS");
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        testKeyboard.getKeyboardSwitches().setSwitchType("Tactile");
//        assertEquals(7, testKeyboard.ratePlateWeight());
//        assertEquals(9, testKeyboard.rateCaseWeight());
//        assertEquals(6, testKeyboard.rateSwitchesSound());
//        assertEquals(8, testKeyboard.ratePlateSound());
//        assertEquals(9, testKeyboard.rateCaseSound());
//        assertEquals(10, testKeyboard.rateKeycapsSound());
//    }
//
//    @Test
//    void testRateKeyboard() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("ABS");
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        testKeyboard.getKeyboardSwitches().setSwitchType("Tactile");
//        testKeyboard.rateKeyboard();
//        assertEquals(10,testKeyboard.getSoundRating());
//        assertEquals(10,testKeyboard.getFeelRating());
//        assertEquals(9,testKeyboard.getWeightRating());
//    }
//
//    @Test
//    void testRateKeyboardSilent() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("PBT");
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Plastic");
//        testKeyboard.getKeyboardSwitches().setSwitchType("Linear");
//        testKeyboard.getKeyboardSwitches().setSilentSwitches(true);
//        testKeyboard.rateKeyboard();
//        assertEquals(1,testKeyboard.getSoundRating());
//        assertEquals(5,testKeyboard.getFeelRating());
//        assertEquals(7,testKeyboard.getWeightRating());
//    }
//
//
//    @Test
//    void testRateCaseSoundAluminum() {
//        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        assertEquals("Aluminum", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(6, testKeyboard.rateCaseSound());
//    }
//
//    @Test
//    void testRateCaseSoundPolycarbonate() {
//        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardCase().setCaseMaterial("Polycarbonate");
//        assertEquals("Polycarbonate", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(5, testKeyboard.rateCaseSound());
//    }
//
//    @Test
//    void testRateCaseSoundPlastic() {
//        assertEquals("", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardCase().setCaseMaterial("Plastic");
//        assertEquals("Plastic", testKeyboard.getKeyboardCase().getCaseMaterial());
//        assertEquals(4, testKeyboard.rateCaseSound());
//    }
//
//    @Test
//    void testRateKeycapsSoundABS() {
//        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("ABS");
//        assertEquals("ABS", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
//        assertEquals(6, testKeyboard.rateKeycapsSound());
//    }
//
//    @Test
//    void testRateKeycapsSoundPBT() {
//        assertEquals("", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardKeycaps().setKeycapsMaterial("PBT");
//        assertEquals("PBT", testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
//        assertEquals(4, testKeyboard.rateKeycapsSound());
//    }
//
//    @Test
//    void testRatePlateSoundBrass() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals(7, testKeyboard.ratePlateSound());
//    }
//
//    @Test
//    void testRatePlateSoundAluminum() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Aluminum");
//        assertEquals(6, testKeyboard.ratePlateSound());
//    }
//
//    @Test
//    void testRatePlateSoundPolycarbonate() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Polycarbonate");
//        assertEquals(4, testKeyboard.ratePlateSound());
//    }
//
//    @Test
//    void testRateSwitchesSoundTactile() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Tactile");
//        assertEquals(6, testKeyboard.rateSwitchesSound());
//    }
//
//    @Test
//    void testRateSwitchesSoundLinear() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Linear");
//        assertEquals(4, testKeyboard.rateSwitchesSound());
//    }
//
//    @Test
//    void testRateSwitchesSoundClicky() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Clicky");
//        assertEquals(8, testKeyboard.rateSwitchesSound());
//
//    }
//
//    @Test
//    void testRateSwitchesSoundisSilenced() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Tactile");
//        assertEquals(6, testKeyboard.rateSwitchesSound());
//        testKeyboard.getKeyboardSwitches().setSilentSwitches(true);
//        assertEquals(2, testKeyboard.rateSwitchesSound());
//    }
//
//    @Test
//    void testRateCaseFeelAluminum() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        assertEquals(6, testKeyboard.rateCaseFeel());
//    }
//
//    @Test
//    void testRateCaseFeelPlastic() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Plastic");
//        assertEquals(4, testKeyboard.rateCaseFeel());
//    }
//
//    @Test
//    void testRatePlateFeelBrass() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals(7, testKeyboard.ratePlateFeel());
//    }
//
//    @Test
//    void testRatePlateFeelAluminum() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Aluminum");
//        assertEquals(6, testKeyboard.ratePlateFeel());
//    }
//
//    @Test
//    void testRatePlateFeelPolycarbonate() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Polycarbonate");
//        assertEquals(4, testKeyboard.ratePlateFeel());
//
//    }
//
//    @Test
//    void testRateSwitchesFeelTactile() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Tactile");
//        assertEquals(7, testKeyboard.rateSwitchesFeel());
//    }
//
//    @Test
//    void testRateSwitchesFeelLinear() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Linear");
//        assertEquals(4, testKeyboard.rateSwitchesFeel());
//    }
//
//    @Test
//    void testRateSwitchesFeelClicky() {
//        testKeyboard.getKeyboardSwitches().setSwitchType("Clicky");
//        assertEquals(7, testKeyboard.rateSwitchesFeel());
//    }
//
//    @Test
//    void testRateCaseWeightAluminum() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Aluminum");
//        assertEquals(7, testKeyboard.rateCaseWeight());
//    }
//
//    @Test
//    void testRateCaseWeightPlastic() {
//        testKeyboard.getKeyboardCase().setCaseMaterial("Plastic");
//        assertEquals(3, testKeyboard.rateCaseWeight());
//    }
//
//    @Test
//    void testRatePlateWeightBrass() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals(7, testKeyboard.ratePlateWeight());
//    }
//
//    @Test
//    void testRatePlateWeightAluminum() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Aluminum");
//        assertEquals(6, testKeyboard.ratePlateWeight());
//    }
//
//    @Test
//    void testRatePlateWeightPolycarbonate() {
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Polycarbonate");
//        assertEquals(4, testKeyboard.ratePlateWeight());
//    }
//
//    @Test
//    void testSetSoundRating() {
//        assertEquals(5, testKeyboard.getSoundRating());
//        testKeyboard.setSoundRating(10);
//        assertEquals(10, testKeyboard.getSoundRating());
//    }
//
//    @Test
//    void testGetFeelRating() {
//        assertEquals(5,testKeyboard.getFeelRating());
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals("Brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
//        testKeyboard.rateKeyboard();
//        assertEquals(7,testKeyboard.getFeelRating());
//    }
//
//    @Test
//    void testGetSoundRating() {
//        assertEquals(5,testKeyboard.getSoundRating());
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals("Brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
//        testKeyboard.rateKeyboard();
//        assertEquals(7,testKeyboard.getSoundRating());
//    }
//
//    @Test
//    void testGetWeightRating() {
//        assertEquals(5,testKeyboard.getWeightRating());
//        testKeyboard.getKeyboardPlate().setPlateMaterial("Brass");
//        assertEquals("Brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
//        testKeyboard.rateKeyboard();
//        assertEquals(7,testKeyboard.getWeightRating());
//    }
//}