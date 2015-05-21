package hex.logiikka;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViisikulmioTest {

    Viisikulmio v;

    public ViisikulmioTest() {
    }

    @Before
    public void setUp() {
        int[] x = {10, 10, 15, 20, 20,};
        int[] y = {100, 110, 115, 110, 100,};
        v = new Viisikulmio(1, 0, 0, Color.BLUE);
    }

    @Test
    public void konstruktoriAsettaaVarinOikein() {
        assertEquals(Color.BLUE, v.haeVari());
    }


}
