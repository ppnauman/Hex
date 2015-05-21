
package hex.logiikka;

import hex.kayttoliittyma.Kayttoliittyma;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *
 * @author ppnauman
 */
public class Hex {
    
    public static void main (String[] args) {
        
        // testaa ohjelmasi toimintaa täällä
        
        Pelilauta lauta = new Pelilauta(11, Color.RED, Color.BLUE, 768);
        lauta.alustaLauta();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lauta);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
    

