
package hex.main;

import hex.kayttoliittyma.Kayttoliittyma;
import hex.kayttoliittyma.PeliAlkaa;
import hex.logiikka.HexPinta;
import hex.logiikka.Peli;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *Pääohjelma.
 */
public class Hex {
    
    public static void main (String[] args) {

        
        HexPinta peli = new Peli(11,"PietHein", "JohnForbesNash", Color.GREEN, Color.WHITE);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
        PeliAlkaa alkuIkkuna = new PeliAlkaa();
        SwingUtilities.invokeLater(alkuIkkuna);
                
    }
}
    

