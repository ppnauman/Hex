package hex.logiikka;

import hex.logiikka.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Matti", "keltainen");
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

        assertEquals("keltainen", pelaaja.haeVari());
    }
}
