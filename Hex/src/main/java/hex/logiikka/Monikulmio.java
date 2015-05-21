package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Yliluokka kuvaa pelilaudan monikulmiota.
 */
public abstract class Monikulmio {
    private int paikka;
    private int[] x;
    private int[] y;
    private Color vari;

    /**
     * Luo uuden Monikulmion, jonka kulmien paikkakoordinaatit annetaan
     * konstruktorin parametreina.
     *
     * @param xKoord - x-koordinaatit
     * @param yKoord - y-koordinaatit
     */
    public Monikulmio(int paikka, int[] xKoord, int[] yKoord) {
        this.x = xKoord;
        this.y = yKoord;
        this.paikka = paikka;
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
    
    public int[] haeXt() {
        return this.x;
    }
    
    public int[] haeYt() {
        return this.y;
    }
    
    public int haePaikka() {
        return this.paikka;
    }
    

    
    /**
     * Abstrakti metodi, jonka tehtävä on piirtää Monikulmio näytölle
     * parametrina annetussa grafiikkakontekstissa.
     *
     * @param graphics
     */
    public abstract void piirra(Graphics graphics);
    
    
    
    /**
     * Palauttaa merkkijonoesityksen monikulmion sijainnista.
     * @return paikkakoordinaatit
     */
    @Override
    public String toString() {
        String str ="x: "; 
        for (int i=0; i<this.x.length; i++) {
            str += this.x[i] + "," ;
        }
        str+="\ny: ";
        for(int i=0; i<this.y.length; i++) {
            str += this.y[i] + "," ;
        }
        return str;
    }
}
