package hex.logiikka;

import java.awt.Graphics;

/**
 * Pelilaudan Kuusikulmion eli 'peliruudun' kuvaava aliluokka.
 *
 */
public class Kuusikulmio extends Monikulmio {

    
    
    /**
     * Konstruktori luo uuden harmaan Kuusikulmion, jonka kulmien
     * sijainnit grafiikkakontekstissa on ilmaistu x- ja y-koordinaatteina.
     *
     * @param xKoord x-koordinaattien taulukko
     * @param yKoord y-koordinaattien taulukko
     */
    public Kuusikulmio(int paikka, int[] xKoord, int[] yKoord) {
        
        super(paikka, xKoord, yKoord);
        
    }
    
    


}
