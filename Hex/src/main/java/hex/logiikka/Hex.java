
package hex.logiikka;

import java.awt.Graphics;

/**
 *
 * @author ppnauman
 */
public class Hex {
    
    public static void main (String[] args) {
        
        //testituloste: testataan union-find -rakenteen konstruktorin toimintaa
        HexTarkastaja t = new HexTarkastaja(11);

        System.out.println(t);
        
        String s = t.ketjujenKoot();
        System.out.println(s);
        
        //testituloste monikulmiolle
        int [] x = {10,10,15,20,20,15,};
        int [] y = {100,110,115,110,100,95,};
        Kuusikulmio k = new Kuusikulmio(x,y);
        System.out.println(k.haeVari());
        k.tummennaVaria();
        System.out.println(k.haeVari());
        
        
    }
}
    

