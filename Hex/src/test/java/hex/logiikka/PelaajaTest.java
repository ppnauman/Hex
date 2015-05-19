package hex.logiikka;

import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Matti", Color.RED);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void haeNimiTesti() {

        assertEquals("Matti", pelaaja.haeNimi());
    }

    @Test
    public void haeVariTesti() {

        assertEquals(Color.RED, pelaaja.haeVari());
    }
}
