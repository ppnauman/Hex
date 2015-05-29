
package hex.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelilautaTest {
    
    Pelilauta p;
    
    public PelilautaTest() {
    }
    
    @Before
    public void setUp() {
        p = new Pelilauta(11, Color.RED, Color.BLUE);
        p.alustaLauta();
    }
    
    @Test
    public void pelilautaOikeanLevyinen() {
        assertEquals(13, p.haePelilauta().length);
        
    }
    
    @Test
    public void pelilautaOikeanKorkuinen() {
        assertEquals(13, p.haePelilauta()[0].length);
    }
    
    @Test
    public void asetaKulmioAsettaaVarinOikein() {
        p.asetaKulmio(29, Color.RED);
        assertEquals(Color.RED, p.haeKulmioIndeksilla(29).haeVari());
    }
    
    @Test
    public void onkoRuutuVapaaToimiiOnVapaa() {
        assertEquals(true, p.onkoRuutuVapaa(55));
    }
    
    @Test
    public void onkoRuutuVapaaToimiiEiVapaa() {
        p.asetaKulmio(55, Color.RED);
        assertEquals(false, p.onkoRuutuVapaa(55));
    }
    
    @Test
    public void asetaKulmioPalauttaaSamanvarisetNaapurit1() {
        p.asetaKulmio(71, Color.CYAN);
        p.asetaKulmio(83, Color.CYAN);
        p.asetaKulmio(96, Color.YELLOW);
        ArrayList<Integer> svNaapurit = new ArrayList();
        svNaapurit.add(83);
        svNaapurit.add(71);
        assertEquals(svNaapurit,p.asetaKulmio(84, Color.CYAN));
    }
    
    @Test
    public void asetaKulmioPalauttaaSamanvarisetNaapurit2() {
        ArrayList<Integer> svNaapurit = new ArrayList();
        assertEquals(svNaapurit, p.asetaKulmio(84, Color.GREEN));
    }
    
    @Test
    public void asetaKulmioPalauttaaSamanvarisetNaapurit3() {
        ArrayList<Integer> svNaapurit = new ArrayList();
        svNaapurit.add(83);
        svNaapurit.add(85);
        svNaapurit.add(71);
        svNaapurit.add(97);
        svNaapurit.add(96);
        svNaapurit.add(72);
        assertEquals(svNaapurit, p.asetaKulmio(84, Color.LIGHT_GRAY));
    }
}

