
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
    
   
    
    /**
     * Luo uuden, Monikulmioista koostuvan pelilaudan.
     * 
     * @param laudanKoko 
     */
    public Pelilauta(int laudanKoko, Color vari1, Color vari2) {
           this.pelilauta = new Monikulmio[laudanKoko+2][laudanKoko+2];
           this.vari1 = vari1;
           this.vari2 = vari2;
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
        int [] x = { 0, 0, 26 , 52, 52, 26 };
        int [] y = { 45, 15, 0, 15, 45, 60 };
        int xBound = i*(26+3)+j*(52+3);
        int yBound = i*(45+3);
        this.pelilauta[i][j] = new Kuusikulmio((pelilauta.length*i+j), xBound, yBound);
    }
    
   
    //Viisikulmion generoiva metodi
    private void luoViisikulmio(int i, int j, Color vari) {  
    }
    
    
    
    /**
     * Palauttaa pelilaudan Monikulmion.
     * 
     */
    public Monikulmio haeMonikulmio(int i, int j) {
        return this.pelilauta[i][j];
    }
    
    
    public Monikulmio[][] haePelilauta() {
        return this.pelilauta;
    }
    

}
