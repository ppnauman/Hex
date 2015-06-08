
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

        
        SwingUtilities.invokeLater(new PeliAlkaa());
                
    }
}
    

