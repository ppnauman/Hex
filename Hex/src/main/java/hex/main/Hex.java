
package hex.main;

import hex.kayttoliittyma.Kayttoliittyma;
import hex.logiikka.HexPinta;
import hex.logiikka.Peli;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *
 * @author ppnauman
 */
public class Hex {
    
    public static void main (String[] args) {

        // KOKEILUA laudan piirtämiseksi ja JButtonin muokkaamiseksi
        HexPinta peli = new Peli(11,"PietHein", "JohnForbesNash", Color.RED, Color.BLUE);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
                
    }
}
    

