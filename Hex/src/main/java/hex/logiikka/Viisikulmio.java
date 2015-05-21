
package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Aliluokka kuvaa pelilaudan Viisikulmion. Viisikulmiot reunustavat pelilaudalla 
 * Kuusikulmaisia 'peliruutuja'.
 * 
 */
public class Viisikulmio extends Monikulmio {
    
    
    /**
     * Luo uuden värillisen viisikulmion jonka paikka grafiikkakontekstissa
     * on ilmaistu x- ja y-koordinaatteina.
     * 
     * @param xKoord - X-koordinaattien taulukko
     * @param yKoord - Y-koordinaattien taulukko
     * @param vari viisikulmion väri
     */
    public Viisikulmio(int paikka, int xBound, int yBound, Color vari) {
        super(paikka, xBound, yBound);
        super.asetaVari(vari);
    }
}