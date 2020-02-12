package model;

import model.components.PrintedCircuitBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintedCircuitBoardTest {
    PrintedCircuitBoard testPCB;

    @BeforeEach
    void runBefore() {
        testPCB = new PrintedCircuitBoard();
    }

    @Test
    void testConstructor() {
        assertEquals("",testPCB.getPcbSize());
    }

    @Test
    void testGetPCBSize() {
        assertEquals("",testPCB.getPcbSize());
        testPCB.setPcbSize("small");
        assertEquals("small",testPCB.getPcbSize());
    }

    @Test
    void testSetPCBSize() {
        assertEquals("",testPCB.getPcbSize());
        testPCB.setPcbSize("medium");
        assertEquals("medium",testPCB.getPcbSize());
    }
}
