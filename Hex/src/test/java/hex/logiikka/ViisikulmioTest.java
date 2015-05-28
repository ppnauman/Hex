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
        v = new Viisikulmio(1, Color.BLUE);
    }

    @Test
    public void konstruktoriAsettaaVarinOikein() {
        assertEquals(Color.BLUE, v.haeVari());
    }
    
    @Test
    public void variEiMuutu() {
        v.asetaVari(Color.RED);
        assertEquals(Color.BLUE, v.haeVari());
    }


}
