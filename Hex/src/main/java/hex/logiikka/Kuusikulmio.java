package hex.logiikka;

import java.awt.Graphics;

/**
 * Pelilaudan Kuusikulmion kuvaava aliluokka.
 *
 */
public class Kuusikulmio extends Monikulmio {

    /**
     * Konstruktori luo uuden harmaan Kuusikulmion, jonka sijainti on ilmaistu
     * x- ja y-koordinaatteina.
     *
     * @param xKoord x-koordinaattien taulukko
     * @param yKoord y-koordinaattien taulukko
     */
    public Kuusikulmio(int[] xKoord, int[] yKoord) {
        super(xKoord, yKoord);
    }

    /**
     * Korvaa yliluokan samannimisen abstraktin metodin ja piirtää täytetyn
     * Kuusikulmion parametrina annettussa grafiikkakontekstissa.
     *
     * @param graphics
     */
    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(super.haeVari());
        graphics.fillPolygon(super.haeXt(), super.haeYt(), 6);
    }

}
