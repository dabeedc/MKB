package model;

import model.components.Keycaps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        testKeycaps.setKeycapsMaterial("ABS");
        assertEquals("ABS", testKeycaps.getKeycapsMaterial());
    }


    @Test
    void testSetKeycapsMaterial() {
        assertEquals("", testKeycaps.getKeycapsMaterial());
        testKeycaps.setKeycapsMaterial("PBT");
        assertEquals("PBT", testKeycaps.getKeycapsMaterial());
    }
}
