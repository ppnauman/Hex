
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
        k = new Kuusikulmio(55, 0,0);
    }
    
    @Test
    public void konstruktoriAsettaaVarinHarmaaksi() {
        assertEquals(Color.LIGHT_GRAY, k.haeVari());
    }
    
    @Test
    public void asetaVariToimii() {
        k.asetaVari(Color.white);
        assertEquals(Color.white, k.haeVari());
    }
}
