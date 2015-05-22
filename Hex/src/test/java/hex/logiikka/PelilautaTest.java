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
    public void kuusikulmionXBoundOikein() {
        assertEquals(753, p.haeMonikulmio(7,10).haeX());
    }
    
    @Test
    public void kuusikulmionYboundOikein() {
        assertEquals(144, p.haeMonikulmio(3,4).haeY());
    }
}
