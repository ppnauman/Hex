
package hex.logiikka;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelilautaTest {
    
    Pelilauta p;
    
    public PelilautaTest() {
    }
    
    @Before
    public void setUp() {
        p = new Pelilauta(11, new Tarkastaja(11), Color.RED, Color.BLUE);
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
    public void kuusikulmionXOikein() {
        assertEquals(753, p.haeMonikulmio(7,10).haeX());
    }
    
    @Test
    public void kuusikulmionYOikein() {
        assertEquals(144, p.haeMonikulmio(3,4).haeY());
    }
}
