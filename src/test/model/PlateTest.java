package model;

import model.components.Plate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateTest {
    Plate testPlate;

    @BeforeEach
    void runBefore() {
        testPlate = new Plate();
    }

    @Test
    void testConstructor() {
        assertEquals("", testPlate.getPlateMaterial());
        assertEquals("", testPlate.getPlateSize());
    }

    @Test
    void testGetPlateMaterial() {
        assertEquals("", testPlate.getPlateMaterial());
        testPlate.setPlateMaterial("brass");
        assertEquals("brass", testPlate.getPlateMaterial());
    }

    @Test
    void testGetPlateSize() {
        assertEquals("", testPlate.getPlateSize());
        testPlate.setPlateSize("small");
        assertEquals("small", testPlate.getPlateSize());
    }

    @Test
    void testSetPlateMaterial() {
        assertEquals("", testPlate.getPlateMaterial());
        testPlate.setPlateMaterial("plastic");
        assertEquals("plastic", testPlate.getPlateMaterial());
    }

    @Test
    void testSetPlateSize() {
        assertEquals("", testPlate.getPlateSize());
        testPlate.setPlateSize("large");
        assertEquals("large", testPlate.getPlateSize());
    }

    @Test
    void testPlateSpecs() {
        assertEquals("", testPlate.getPlateMaterial());
        assertEquals("", testPlate.getPlateSize());
        testPlate.setPlateMaterial("brass");
        testPlate.setPlateSize("small");
        assertEquals("brass", testPlate.getPlateMaterial());
        assertEquals("small", testPlate.getPlateSize());
    }
}
