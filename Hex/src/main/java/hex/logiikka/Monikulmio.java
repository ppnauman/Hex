package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Yliluokka, joka kuvaa pelilaudan monikulmiota.
 */
public abstract class Monikulmio {
    private int paikka;
    private Color vari;
    
    /**
     * Monikulmion konstruktori, jossa 
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen km)
     */
    public Monikulmio(int paikkaIndeksi, Color vari) {
        this.paikka = paikkaIndeksi;
        this.vari = vari;
    }
    
    /**
     * Vaihtaa monikulmion värin parametrina annetun Color-olion mukaiseksi.
     * 
     * @param uusiVari - uusi väri
     */
    public void asetaVari(Color uusiVari) {
        this.vari = uusiVari;
    }

    /**
     * Palauttaa Monikulmion tämän hetkisen värin.
     * 
     * @return väri
     */
    public Color haeVari() {
        return this.vari;
    }
    
    /**
     * Palauttaa Monikulmion paikan pelilaudalla kokonaislukuindeksinä ilmaistuna (0..ruutujen lkm-1).
     * 
     * @return paikka indeksinä
     */
    public int haePaikkaindeksi() {
        return this.paikka;
    }
}
