package hex.logiikka;


/**
 * Pelilaudan Kuusikulmion eli 'peliruudun' kuvaava aliluokka.
 *
 */
public class Kuusikulmio extends Monikulmio {


    /**
     * Konstruktori luo uuden Kuusikulmion, jonka 'bounding boxin'
     * sijainti grafiikkakontekstissa on ilmaistu x- ja y-koordinaatteina.
     * Lisäksi kuusikulmio tietää paikkansa pelilaudalla indeksin muodossa.
     * Yliluokan konstruktorin mukaisesti oletusväri on LIGHT_GRAY.
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen lkm-1)
     * @param x komponentin absoluuttinen sijainti x-akselilla
     * @param y komponentin absoluuttinen sijainti y-akselilla
     */
    public Kuusikulmio(int paikkaIndeksi, int x, int y) {
        
        super(paikkaIndeksi, x, y);
        
    }

}
