package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Yliluokka kuvaa pelilaudan monikulmiota.
 */
public abstract class Monikulmio {
    private int paikka;
    int xBound;
    int yBound;
    private Color vari;

    
    /**
     * Luo uuden harmaan Monikulmion, jonka kulmien paikkakoordinaatit annetaan
     * konstruktorin parametreina.
     *
     * @param xKoord - x-koordinaatit
     * @param yKoord - y-koordinaatit
     */
    public Monikulmio(int paikka, int xBound, int yBound) {
        this.paikka = paikka;
        this.vari = Color.LIGHT_GRAY;
        this.xBound = xBound;
        this.yBound = yBound;   
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
     * Vaihtaa Monikulmion värisävyä tummemmaksi.
     */
    public void tummennaVaria() {
        this.vari = this.vari.darker();
    }

    /**
     * Palauttaa Monikulmion tämän hetkisen värin.
     * 
     * @return väri
     */
    public Color haeVari() {
        return this.vari;
    }
    
    
    public int haeXbound() {
        return this.xBound;
    }
    
    public int haeYbound() {
        return this.yBound;
    }
    
    public int haePaikka() {
        return this.paikka;
    }
}
