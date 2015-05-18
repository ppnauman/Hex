
package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 *Kuvaa pelilaudan reunalla sijaitsevan Viisikulmion.
 * 
 */
public class Viisikulmio extends Monikulmio {
    
    
    /**
     * Luo uuden värillisen viisikulmion jonka paikka on ilmaistu
     * x- ja y-koordinaatteina.
     * 
     * @param xKoord - x-koordinaatit
     * @param yKoord - y-koordinaatit
     * @param vari viisikulmion väri
     */
    public Viisikulmio(int[] xKoord, int[] yKoord, Color vari) {
        super(xKoord, yKoord);
        super.asetaVari(vari);
    }
    
    /**
     * Korvaa yliluokan abstraktin metodin ja piirtää täytetyn Viisikulmion
     * parametrina annetussa grafiikkakontekstissa.
     * 
     * @param graphics grafiikkakonteksti
     */
    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(super.haeVari());
        graphics.fillPolygon(super.haeXt(), super.haeYt(), 5);
    }
}
