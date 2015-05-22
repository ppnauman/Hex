package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Yliluokka kuvaa pelilaudan monikulmiota.
 */
public abstract class Monikulmio {
    private int paikka;
    private int x;
    private int y;
    private Color vari;

    
    /**
     * Monikulmion konstruktori, jossa 
     *
     * @param paikkaIndeksi sijainti pelilaudalla (0..ruutujen km)
     * @param x komponentin absoluuttinen sijainti x-akselilla
     * @param y komponentin absoluuttinen sijainti y-akselilla
     */
    public Monikulmio(int paikkaIndeksi, int x, int y) {
        this.paikka = paikkaIndeksi;
        this.x = x;
        this.y = y;
        this.vari = Color.LIGHT_GRAY;
    }
    

    /**
     * Vaihtaa Monikulmion värin parametrina annetun Color-olion mukaiseksi.
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
     * Palauttaa Monikulmion 'bounding boxin' absoluuttisen sijainnin x-akselilla.
     *
     * @return x-koordinaatti
     */
    public int haeX() {
        return this.x;
    }
    
     /**
     * Palauttaa Monikulmion 'bounding boxin' absoluuttisen sijainnin y-akselilla.
     * 
     * @return y-koordinaatti
     */
    public int haeY() {
        return this.y;
    }
    
    /**
     * Palauttaa Monikulmion paikan pelilaudalla kokonaislukuindeksinä ilmaistuna (0..ruutujen lkm).
     * 
     * @return paikka indeksinä
     */
    public int haePaikkaIndeksi() {
        return this.paikka;
    }
}
