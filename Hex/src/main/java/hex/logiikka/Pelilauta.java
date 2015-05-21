
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
        laskeXkoord_6(i,j,x);
        int [] y = new int[6];
        laskeYkoord_6(i,j,y);
        this.pelilauta[i][j] = new Kuusikulmio((pelilauta.length*i+j), x, y);
    }
    
    
    //6.k:n x-koordinaatit laskeva apumetodi
    private void laskeXkoord_6(int i, int j, int[] x) {
        int rako = 3;
        int leveys = (int)(Math.sqrt(3.0)*30.0);
        int puoliLeveys = (int)((Math.sqrt(3.0)*30.0)/2.0);
        x[0] = x[1] = j*(leveys+rako) + i*(puoliLeveys+rako) ;
        x[2] = x[0] + puoliLeveys;
        x[3] = x[4] = x[0] + leveys;
        x[5] = x[2];  
    }
    
    //6.k:n y-koordinaatit laskeva apumetodi
    private void laskeYkoord_6(int i, int j, int[] y) {
        int rako = 3;
        int korkeus = 60;
        int rivinKorkeus = 3/4*korkeus;
        y[0] = y[4] = 30+rako + i*(45+rako);
        y[1] = y[3] = y[0] -30;
        y[2] = y[1] -15;
        y[5] = y[4]+15;
    }
    
    
    //Viisikulmion generoiva metodi
    private void luoViisikulmio(int i, int j, Color vari) {
       
    }
    
    /**
     * Palauttaa pelilaudan Monikulmion.
     * 
     */
    public Monikulmio haeRuutu(int i, int j) {
        return this.pelilauta[i][j];
    }
    
    /**
     * Piirtää pelilaudan monikulmiot parametrina annetussa grafiikkakontekstissa.
     * 
     * @param graphics -grafiikkakonteksti
     */
    public void piirraLauta(Graphics graphics) {
        for(int i=0; i < pelilauta.length; i++) {
            for(int j=0; j<pelilauta[0].length; j++) {
                if(pelilauta[i][j]!= null) {
                    pelilauta[i][j].piirra(graphics);
                }
                
            }
        }
    }
}
