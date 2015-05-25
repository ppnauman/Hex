
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
        
        // häkkeröintiKOKEILUA
        Tarkastaja t = new Tarkastaja(11);
        Pelilauta lauta = new Pelilauta(11,t, Color.RED, Color.BLUE);
        lauta.alustaLauta();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lauta);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
    

