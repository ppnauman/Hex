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
 * @author perttu
 */
public class KuusikulmioTest {
    
    Kuusikulmio k;
    
    public KuusikulmioTest() {
    }
   
    
    @Before
    public void setUp() {
        int[] x = {10,10,15,20,20,15,};
        int[] y = {100,110,115,110,100,95,};
        k = new Kuusikulmio( x, y);
    }

    
    @Test
    public void konstruktoriAsettaaKoordinaatitOikein() {
        String odotetutKoordinaatit = "x: 10,10,15,20,20,15,\n"
                + "y: 100,110,115,110,100,95,";
        assertEquals(odotetutKoordinaatit, k.toString());     
                
    }
    
    @Test
    public void tummennaVariaToimii() {
        Color alkuVari = k.haeVari();
        float[] alkuRGBt = k.haeVari().getRGBColorComponents(null);
        k.tummennaVaria();
        float[] loppuRGBt = k.haeVari().getRGBColorComponents(null);
        boolean tummempi = true;
        for (int i = 0; i < 3; i++){
            if(loppuRGBt[i] > alkuRGBt[i]) tummempi = false;
        }
        if( alkuVari == k.haeVari()) tummempi = false;
        assertEquals(true, tummempi); 
    }
    
    
    @Test
    public void konstruktoriAsettaaVarinHarmaaksi() {
        assertEquals(Color.GRAY, k.haeVari());
    }
    
    @Test
    public void asetaVariToimii() {
        k.asetaVari(Color.white);
        assertEquals(Color.white, k.haeVari());
    }
}
