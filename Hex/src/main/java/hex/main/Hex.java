
package hex.main;

import hex.kayttoliittyma.Kayttoliittyma;
import hex.kayttoliittyma.PeliAlkaa;
import hex.logiikka.HexPinta;
import hex.logiikka.Peli;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *Pääohjelma, joka sisältää main-metodin.
 */
public class Hex {
    
    /**
     * Main -metodi käynnistää pelin avaamalla uuden käyttöliittymän alkuikkunan,
     * jonka kautta päästään syöttämään pelaajatietoja.
     * @param args 
     */
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new PeliAlkaa());           
    }
    
}
    

