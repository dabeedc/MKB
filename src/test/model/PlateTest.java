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

    @Test
    void testRatePlateSoundBrass() {
        testPlate.setPlateMaterial("Brass");
        testPlate.rate();
        assertEquals(2, testPlate.getSoundRating());
    }

    @Test
    void testRatePlateSoundAluminum() {
        testPlate.setPlateMaterial("Aluminum");
        testPlate.rate();
        assertEquals(1, testPlate.getSoundRating());
    }

    @Test
    void testRatePlateSoundPolycarbonate() {
        testPlate.setPlateMaterial("Polycarbonate");
        testPlate.rate();
        assertEquals(-1, testPlate.getSoundRating());
    }

    @Test
    void testRatePlateFeelBrass() {
        testPlate.setPlateMaterial("Brass");
        testPlate.rate();
        assertEquals(2, testPlate.getFeelRating());
    }

    @Test
    void testRatePlateFeelAluminum() {
        testPlate.setPlateMaterial("Aluminum");
        testPlate.rate();
        assertEquals(1, testPlate.getFeelRating());

    }

    @Test
    void testRatePlateFeelPolycarbonate() {
        testPlate.setPlateMaterial("Polycarbonate");
        testPlate.rate();
        assertEquals(-1, testPlate.getFeelRating());


    }

    @Test
    void testRatePlateWeightBrass() {
        testPlate.setPlateMaterial("Brass");
        testPlate.rate();
        assertEquals(2, testPlate.getWeightRating());
    }

    @Test
    void testRatePlateWeightAluminum() {
        testPlate.setPlateMaterial("Aluminum");
        testPlate.rate();
        assertEquals(1, testPlate.getWeightRating());
    }

    @Test
    void testRatePlateWeightPolycarbonate() {
        testPlate.setPlateMaterial("Polycarbonate");
        testPlate.rate();
        assertEquals(-1, testPlate.getWeightRating());
    }
}
