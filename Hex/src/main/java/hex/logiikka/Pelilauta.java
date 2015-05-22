
package hex.logiikka;

import java.awt.Color;


/**
 *Luokka kuvaa kuusikulmioista koostuvan pelilaudan ja sillä vallitsevan tilanteen.
 *Laudan ohella luokka tuntee pelaajien värit.
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
    
    
    //Kuusikulmion laudan tiettyyn paikkaan generoiva apumetodi, joka osallistuu
    //laudan alustukseen.
    private void luoKuusikulmio(int i, int j) {
        int x = i*(26+3)+j*(52+3);
        int y = i*(45+3);
        int paikkaIndeksi = pelilauta.length*i+j;
        this.pelilauta[i][j] = new Kuusikulmio(paikkaIndeksi, x,y);
    }
    
   
    //Viisikulmion generoiva apumetodi, joka osallistuu laudan alustukseen
    private void luoViisikulmio(int i, int j, Color vari) {  
    }
    
    
    
    /**
     * Palauttaa pelilaudan Monikulmion.
     * 
     */
    public Monikulmio haeMonikulmio(int i, int j) {
        return this.pelilauta[i][j];
    }
    
    
    /**
     * Palauttaa pelilaudan kaksiulotteisena taulukkona.
     * @return pelilauta
     */
    public Monikulmio[][] haePelilauta() {
        return this.pelilauta;
    }
    

}
