package model;

import model.components.Keycaps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.components.Case.setCaseMaterial;
import static model.components.Case.setCaseSize;
import static model.components.Keycaps.setKeycapsMaterial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeycapsTest {
    Keycaps testKeycaps;

    @BeforeEach
    void runBefore() {
        testKeycaps = new Keycaps();
    }

    @Test
    void testConstructor() {
        assertEquals("", testKeycaps.getKeycapsMaterial());
    }

    @Test
    void testGetCaseMaterial() {
        assertEquals("", testKeycaps.getKeycapsMaterial());
        setKeycapsMaterial("ABS");
        assertEquals("ABS", testKeycaps.getKeycapsMaterial());
    }


    @Test
    void testSetKeycapsMaterial() {
        assertEquals("", testKeycaps.getKeycapsMaterial());
        setKeycapsMaterial("PBT");
        assertEquals("PBT", testKeycaps.getKeycapsMaterial());
    }
}
