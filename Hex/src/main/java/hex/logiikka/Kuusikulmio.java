package hex.logiikka;

import java.awt.Color;


/**
 * Pelilaudan Kuusikulmion eli peliruudun kuvaava aliluokka.
 *
 */
public class Kuusikulmio extends Monikulmio {


    /**
     * Konstruktori luo uuden Kuusikulmion, joka tietää värinsä ja paikkansa pelilaudalla indeksin muodossa.
     * Yliluokan konstruktorin mukaisesti kuusikulmion oletusväri on LIGHT_GRAY,
     * mikä on vapaille peliruuduille varattu väri.
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen lkm-1, numerointi alkaa pelilaudan
     * vasemmasta yläkulmasta ja etenee oikealta vasemmale, rivi kerrallaan)
     * @param vari kuusikulmion väri
     */
    public Kuusikulmio(int paikkaIndeksi, Color vari) {
        
        super(paikkaIndeksi, vari);
        
    }
}
