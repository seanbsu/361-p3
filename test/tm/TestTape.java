package test.tm;

import org.junit.Test;

import static org.junit.Assert.*;

import tm.Tape;

public class TestTape {

    @Test
    public void testPrivateNodeConstructor() {
        Tape.NodeWrapper nw = new Tape.NodeWrapper(1);
        assertEquals(1, nw.getValue());
        assertNull(nw.getLeft());
        assertNull(nw.getRight());
    }
}
