
package hex.logiikka;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Koordinoi peliä.
 * 
 */
public class Peli{ //implements HexPinta{
    private Tarkastaja tarkastaja;
    private Pelilauta lauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja vuorossa;
    
    public Peli(int pelinKoko, String nimi1, String nimi2, Color vari1, Color vari2) {
        this.tarkastaja = new Tarkastaja(pelinKoko);
        this.lauta = new Pelilauta(pelinKoko, this.tarkastaja, vari1, vari2);
        this.pelaaja1 = new Pelaaja(nimi1, vari1);
        this.pelaaja2 = new Pelaaja(nimi2, vari2);
        this.vuorossa = this.pelaaja1;
    }
    
    public void vaihdaVuoroa() {
        if(this.vuorossa == this.pelaaja1) {
            this.vuorossa = pelaaja2;
        } else {
            this.vuorossa = pelaaja1;
        }
    }
    
    
    public Color variNytVuorossa() {
        return this.vuorossa.haeVari();
    }
    
    /**
     * Asettaa pelilaudalle uuden, vuorossa olevan pelaajan väriä vastaavan kuusikulmion.
     * Mikäli ruutu on jo varattu, palauttaa totuusarvon false. Jos kulmio asetettiin,
     * palauttaa true tietona graafiselle käyttöliittymälle.
     * @param paikkaIndeksi - paikka pelilaudalla.
     */
    
    public boolean asetaKuusikulmio(int paikkaIndeksi, Color variNytVuorossa) {
        boolean ruutuVarattu = this.lauta.onkoRuutuVarattu(paikkaIndeksi);
        if(!ruutuVarattu) {
            this.lauta.asetaKulmio(paikkaIndeksi, this.vuorossa.haeVari());
        }
        return ruutuVarattu;
    } 
}
