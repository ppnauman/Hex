
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
        k = new Kuusikulmio(55, Color.LIGHT_GRAY);
    }
    
    @Test
    public void konstruktoriAsettaaVarinHarmaaksi() {
        assertEquals(Color.LIGHT_GRAY, k.haeVari());
    }
    
    @Test
    public void asetaVariToimii() {
        k.asetaVari(Color.WHITE);
        assertEquals(Color.WHITE, k.haeVari());
    }
    
    @Test
    public void haePaikkaindeksiToimii() {
        assertEquals(55, k.haePaikkaindeksi());
    }
}
