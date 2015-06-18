package hex.logiikka;

import java.awt.Color;

/**
 * Pelin pelaajaa kuvaava luokka.
 */
public class Pelaaja {

    private String nimi;
    private Color vari;

    /**
     * Konstruktori luo uuden pelaajan ja asettaa tälle nimen ja värin.
     *
     * @param nimi Pelaajan nimi
     * @param vari Pelaajan väri
     */
    public Pelaaja(String nimi, Color vari) {
        this.nimi = nimi;
        this.vari = vari;
    }

    /**
     * Pelaajan nimen palauttava metodi.
     *
     * @return pelaajan nimi
     */
    public String haeNimi() {
        return this.nimi;
    }

    /**
     * Pelaajan värin palauttava metodi.
     *
     * @return pelaajan väri
     */
    public Color haeVari() {

        return this.vari;
    }
}
