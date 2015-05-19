
package hex.logiikka;

import java.awt.Color;
import java.awt.Graphics;

/**
 *Luokka kuvaa kuusikulmioista koostuvan pelilaudan ja sillä vallitsevan tilanteen.
 * 
 */
public class Pelilauta {
    
    private Monikulmio[][] pelilauta;
    private Color vari1;
    private Color vari2;
    private int naytonKorkeus;
   
    
    /**
     * Luo uuden, Monikulmioista koostuvan pelilaudan.
     * 
     * @param laudanKoko 
     */
    public Pelilauta(int laudanKoko, Color vari1, Color vari2, int naytonKorkeus) {
           this.pelilauta = new Monikulmio[laudanKoko+2][laudanKoko+2];
           this.vari1 = vari1;
           this.vari2 = vari2;
           this.naytonKorkeus = naytonKorkeus;
    }
    
    /**
     * Luo laudalle uudet monikulmiot eli alustaa uuden laudan
     * tai resetoi olemassaolevan pelilaudan.
     */
    public void alustaLauta() {
        for(int i=0; i<this.pelilauta.length; i++) {
            for(int j=0; j<this.pelilauta.length; j++) {
                //vasemmalle ja oikealle pelaaja1:n viisikulmiot, ylös ja alas pelaajan2
                if( j==0 || j==this.pelilauta.length-1 ) {
                    luoViisikulmio(i,j,vari1);
                } else if ( i==0 || i==this.pelilauta.length-1) {
                    luoViisikulmio(i,j,vari2);
                } else {
                    luoKuusikulmio(i,j);
                }
            }
        }
    }
    
    
    //Kuusikulmion generoiva metodi
    private void luoKuusikulmio(int i, int j) {
        int [] x = new int[6];
        int [] y = new int[6];
        //alustavaa säätöä..
        for(int kulma = 0; kulma < 6; kulma++){
            x[kulma] = 
        }
        
        
        this.pelilauta[i][j] = new Kuusikulmio(x, y);
    }
    
    
    //Viisikulmion generoiva metodi
    private void luoViisikulmio(int i, int j, Color vari) {
        this.pelilauta[i][j] = new Viisikulmio();
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
