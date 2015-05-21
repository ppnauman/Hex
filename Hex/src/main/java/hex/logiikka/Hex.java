
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
        
        
        
        /*
        //testituloste: testataan union-find -rakenteen konstruktorin toimintaa
        HexTarkastaja t = new HexTarkastaja(11);

        System.out.println(t);
        
        String s = t.ketjujenKoot();
        System.out.println(s);
        
        //testituloste monikulmiolle
        int [] x = {10,10,15,20,20,15,};
        int [] y = {100,110,115,110,100,95,};
        Kuusikulmio k = new Kuusikulmio(1,x,y);
        System.out.println(k.haeVari());
        k.tummennaVaria();
        System.out.println(k.haeVari());
        
        */
    }
}
    

