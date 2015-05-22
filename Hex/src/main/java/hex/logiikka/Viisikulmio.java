
package hex.logiikka;

import java.awt.Color;


/**
 * Aliluokka kuvaa pelilaudan Viisikulmion. Viisikulmiot reunustavat pelilaudalla 
 * Kuusikulmaisia 'peliruutuja'.
 * 
 */
public class Viisikulmio extends Monikulmio {
    
    
    /**
     * Konstruktori luo uuden Viisikulmion, jonka 'bounding boxin'
     * sijainti grafiikkakontekstissa on ilmaistu x- ja y-koordinaatteina.
     * Lisäksi viisikulmio tietää paikkansa pelilaudalla indeksin muodossa.
     * Viisikulmiolla on aina pelin pelaajaa vastaava väri.
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen lkm-1)
     * @param x komponentin absoluuttinen sijainti x-akselilla
     * @param y komponentin absoluuttinen sijainti y-akselilla
     */
    public Viisikulmio(int paikkaIndeksi, int x, int y, Color vari) {
        super(paikkaIndeksi, x, y);
        super.asetaVari(vari);
    }
}