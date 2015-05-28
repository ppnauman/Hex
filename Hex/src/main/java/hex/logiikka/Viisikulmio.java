
package hex.logiikka;

import java.awt.Color;


/**
 * Aliluokka kuvaa pelilaudan Viisikulmion. Viisikulmiot reunustavat pelilaudalla 
 * Kuusikulmaisia 'peliruutuja' toimien 'apuruutuina'. Viiskulmio tietää paikkansa pelilaudalla indeksin
 * muodossa. Viisikulmioiden värit asetetaan luomishetkellä pelaajien värien mukaisiksi. Viiskulmion
 * väriä ei pysty vaihtamaan asetaVari(Color uusiVari) -metodilla, kuten kuusikulmion.
 * 
 */
public class Viisikulmio extends Monikulmio {
    
    
    /**
     * Konstruktori luo uuden Viisikulmion ja asettaa sille paikkatiedon ja värin.
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen lkm-1)
     */
    public Viisikulmio(int paikkaIndeksi, Color vari) {
        super(paikkaIndeksi, vari);
    }
    
    @Override
    public void asetaVari(Color uusiVari) {
    }
}