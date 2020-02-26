package persistence;

import model.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {
    private static final String TEST_FILE = "./data/testKeyboard.txt";
    private Writer testWriter;
    private Keyboard testKeyboard;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testKeyboard = new Keyboard("polycarbonate", "60%", "abs", "brass",
                "60%", "60%", "tactile", "false",
                "9", "9", "7");
    }

    @Test
    void testWriteKeyboard() {
        testWriter.write(testKeyboard);
        testWriter.close();
        try {
            List<Object> keyboards = Reader.getKeyboardParts(new File(TEST_FILE));
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
}
