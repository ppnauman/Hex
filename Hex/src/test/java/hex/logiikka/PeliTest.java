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
    public void vaihdaVuoroaTesti() {
        for(int i=0; i<3; i++) {
            p.vaihdaVuoroa();
        }      
        assertEquals(Color.WHITE, p.variNytVuorossa());
    }
}
