/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hex.logiikka;


import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ppnauman
 */
public class PeliTest {
    
    Peli p;
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        p = new Peli(11, "VladimirPutin", "JohnForbesNash", Color.RED, Color.WHITE);
    }
    
    @Test
    public void variNytVuorossaTesti() {
        assertEquals(Color.RED, p.variNytVuorossa());
    }
    
    @Test
    public void nimiNytVuorossaTesti() {
        assertEquals("VladimirPutin", p.nimiNytVuorossa());
    }
    
    @Test
    public void monikulmionVariTesti1() {
        assertEquals(Color.LIGHT_GRAY, p.monikulmionVari(55));
    }
    
    @Test
    public void monikulmionVariTesti2() {
        p.asetaKuusikulmio(30, Color.RED);
        assertEquals(Color.RED, p.monikulmionVari(30));
    }
    
    @Test
    public void vaihdaVuoroaTesti() {
        for(int i=0; i<5; i++) {
            p.vaihdaVuoroa();
        }      
        assertEquals(Color.WHITE, p.variNytVuorossa());
    }
    
    @Test
    public void tarkistaVoittajaTesti1() {
        for(int i = 27; i < 38; i++) {
            p.asetaKuusikulmio(i, p.variNytVuorossa());
            p.vaihdaVuoroa();
            p.asetaKuusikulmio(i+13, p.variNytVuorossa());
            p.vaihdaVuoroa();
        }
        assertEquals("VladimirPutin", p.tarkistaVoittaja());
    }
    
    @Test
    public void tarkistaVoittajaTesti2() {
        for (int i= 14; i<145; i+=13) {
            p.asetaKuusikulmio(i, p.variNytVuorossa());
            p.vaihdaVuoroa();
            p.asetaKuusikulmio(i+1, p.variNytVuorossa());
            p.vaihdaVuoroa();
        }
        assertEquals("JohnForbesNash", p.tarkistaVoittaja());
    }
    
    @Test
    public void tarkistaVoittajaTesti3() {
        for(int i = 27; i < 37; i++) {
            p.asetaKuusikulmio(i, p.variNytVuorossa());
            p.vaihdaVuoroa();
            p.asetaKuusikulmio(i+13, p.variNytVuorossa());
            p.vaihdaVuoroa();
        }
        assertEquals(null, p.tarkistaVoittaja());
    }
    
    @Test
    public void asetaKuusikulmioAsettaaVarin() {
        p.asetaKuusikulmio(29, p.variNytVuorossa());
        assertEquals(p.monikulmionVari(29), p.variNytVuorossa());
    }
    
    @Test
    public void asetaKuusikulmioPalauttaaOikeinRuutuVapaa() {
        assertEquals(true, p.asetaKuusikulmio(30, Color.RED));
    }
    
    @Test
    public void asetaKuusikulmioPalauttaaOikeinRuutuVarattu() {
        p.asetaKuusikulmio(30, Color.YELLOW);
        assertEquals(false, p.asetaKuusikulmio(30,Color.GREEN));
    }
    
    @Test
    public void pelaaja1variTesti() {
        assertEquals(Color.RED, p.pelaaja1vari());
    }
    
    @Test
    public void pelaaja2variTesti() {
        assertEquals(Color.WHITE, p.pelaaja2vari());
    }
    
    
}
