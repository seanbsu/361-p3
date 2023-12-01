package test.tm;

import org.junit.Test;

import static org.junit.Assert.*;

import tm.Tape;

public class TestTape {

    @Test
    public void testConstructor() {
        String input = "1212312";
        Tape t = new Tape(input);
        assertEquals(input, t.toString());
    }

    @Test
    public void testRightLeft() {
        String input = "1212312";
        Tape t = new Tape(input);
        assertEquals(1, t.getValue());
        t.moveRight();
        assertEquals(2, t.getValue());
        t.moveRight();
        assertEquals(1, t.getValue());
        t.moveRight();
        assertEquals(2, t.getValue());
        t.moveRight();
        assertEquals(3, t.getValue());
        t.moveLeft();
        assertEquals(2, t.getValue());
        t.moveLeft();
        assertEquals(1, t.getValue());
        t.moveRight();
        assertEquals(2, t.getValue());
        t.moveRight();
        assertEquals(3, t.getValue());
        t.moveRight();
        assertEquals(1, t.getValue());
        t.moveRight();
        assertEquals(2, t.getValue());
    }

    @Test
    public void testBiInfinite() {
        String input = "123";
        Tape t = new Tape(input);
        for (int i = 0; i < input.length(); i++) {
            t.moveLeft();
            assertEquals(0, t.getValue());
        }
        for (int i = 0; i < input.length(); i++) {
            t.moveRight();
        }
        for (int i = 0; i < input.length(); i++) {
            assertNotEquals(0, t.getValue());
            t.moveRight();
        }
        for (int i = 0; i < input.length(); i++) {
            t.moveRight();
            assertEquals(0, t.getValue());
        }

    }

    @Test
    public void testSetValue() {
        String input = "1212312";
        Tape t = new Tape(input);
        int i = 0;
        while (t.getValue() != 0) {
            t.setValue((i % 3) + 1);
            i++;
            t.moveRight();
        }

        do {
            t.moveLeft();
        } while (t.getValue() != 0);
        t.moveRight();

        i = 0;
        while (t.getValue() != 0) {
            assertEquals((i % 3) + 1, t.getValue());
            i++;
            t.moveRight();
        }

        assertEquals("012312310", t.toString());
    }

    @Test
    public void testToStringTrue(){
        Tape t = new Tape("100101");
        t.moveRight();
        t.moveRight();
        t.moveLeft();
        t.moveLeft();
        t.moveLeft();
        t.moveRight();
        t.moveRight();
        t.moveRight();
        t.moveRight();
        t.moveLeft();
        assertEquals("01001", t.toString(true));
    }

    @Test
    public void testPrivateNodeConstructor() {
        Tape.NodeWrapper nw = new Tape.NodeWrapper(1);
        assertEquals(1, nw.getValue());
        assertNull(nw.getLeft());
        assertNull(nw.getRight());
    }
}
