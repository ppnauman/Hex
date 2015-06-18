
package hex.logiikka;

import java.awt.Color;


/**
 * Aliluokka kuvaa pelilaudan reunalla sijaitsevan viisikulmion. Viisikulmiot reunustavat pelilaudalla 
 * kuusikulmaisia peliruutuja toimien 'apuruutuina'. Viisikulmio tietää paikkansa pelilaudalla indeksin
 * muodossa. Viisikulmioiden värit asetetaan luomishetkellä pelaajien värien mukaisiksi. Viisikulmion
 * väriä ei pysty vaihtamaan asetaVari(Color uusiVari) -metodilla siten kuin kuusikulmion.
 * 
 */
public class Viisikulmio extends Monikulmio {
    
    
    /**
     * Konstruktori luo uuden Viisikulmion ja asettaa sille paikkatiedon ja värin.
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen lkm-1, numerointi alkaa pelilaudan
     * vasemmasta yläkulmasta ja etenee vasemmalta oikealle, rivi kerrallaan).
     */
    public Viisikulmio(int paikkaIndeksi, Color vari) {
        super(paikkaIndeksi, vari);
    }
    
    @Override
    public void asetaVari(Color uusiVari) {
    }
}