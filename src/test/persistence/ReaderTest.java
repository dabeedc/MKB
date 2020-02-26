package persistence;

import model.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    private Keyboard testKeyboard;

    @BeforeEach
    void runBefore() {
        testKeyboard = new Keyboard();
    }

    @Test
    void testParseKeyboardFile() {
        try {
            List<Object> keyboards = Reader.getKeyboardParts(new File("./data/testKeyboardFile1.txt"));
            testKeyboard = (Keyboard) keyboards.get(0);
            assertEquals("polycarbonate",testKeyboard.getKeyboardCase().getCaseMaterial());
            assertEquals("60%",testKeyboard.getKeyboardCase().getCaseSize());
            assertEquals("abs",testKeyboard.getKeyboardKeycaps().getKeycapsMaterial());
            assertEquals("brass",testKeyboard.getKeyboardPlate().getPlateMaterial());
            assertEquals("60%",testKeyboard.getKeyboardPlate().getPlateSize());
            assertEquals("60%",testKeyboard.getKeyboardPrintedCircuitBoard().getPcbSize());
            assertEquals("tactile",testKeyboard.getKeyboardSwitches().getSwitchType());
            assertFalse(testKeyboard.getKeyboardSwitches().isSilentSwitches());
            assertEquals(9,testKeyboard.getSoundRating());
            assertEquals(9,testKeyboard.getFeelRating());
            assertEquals(7,testKeyboard.getWeightRating());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.getKeyboardParts(new File("./data/testKeyboardFile1"));
        } catch (IOException e) {
        }
    }
}