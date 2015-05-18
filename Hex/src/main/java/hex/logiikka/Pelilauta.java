
package hex.logiikka;

import java.awt.Graphics;

/**
 *Luokka kuvaa kuusikulmioista koostuvan pelilaudan ja sillä vallitsevan pelitilanteen.
 * 
 */
public class Pelilauta {
    
    private Monikulmio[][] pelilauta;
    
    public Pelilauta() {
           
    }
    
    
    /**
     * Piirtää pelilaudan monikulmiot parametrina annetussa grafiikkakontekstissa.
     * 
     * @param graphics -grafiikkakonteksti
     */
    public void piirraLauta(Graphics graphics) {
        for(int i=0; i < pelilauta.length; i++) {
            for(int j=0; j<pelilauta[0].length; j++) {
                pelilauta[i][j].piirra(graphics);
            }
        }
    }
}
