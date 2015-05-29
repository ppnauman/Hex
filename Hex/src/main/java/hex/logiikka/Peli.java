package hex.logiikka;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Koordinoi peliä ja toteuttaa käyttöliittymälle näkyvän rajapinnan (ns.
 * fasaadi-luokka).
 */
public class Peli implements HexPinta {

    private Tarkastaja tarkastaja;
    private Pelilauta lauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja vuorossa;

    public Peli(int pelinKoko, String nimi1, String nimi2, Color vari1, Color vari2) {
        this.tarkastaja = new Tarkastaja(pelinKoko);
        this.lauta = new Pelilauta(pelinKoko, vari1, vari2);
        this.lauta.alustaLauta();
        this.pelaaja1 = new Pelaaja(nimi1, vari1);
        this.pelaaja2 = new Pelaaja(nimi2, vari2);
        this.vuorossa = this.pelaaja1;
    }

    /**
     * Vaihtaa vuoron pelaajalta toiselle.
     */
    @Override
    public void vaihdaVuoroa() {
        if (this.vuorossa == this.pelaaja1) {
            this.vuorossa = pelaaja2;
        } else {
            this.vuorossa = pelaaja1;
        }
    }

    /**
     * Palauttaa vuorossa olevan pelaajan värin.
     *
     * @return väri
     */
    @Override
    public Color variNytVuorossa() {
        return this.vuorossa.haeVari();
    }
   
    @Override
    public int laudanKoko() {
        return this.lauta.koko();
    }

    /**
     * Asettaa pelilaudalle uuden, vuorossa olevan pelaajan väriä vastaavan
     * kuusikulmion. Mikäli ruutu on jo varattu, palauttaa totuusarvon false.
     * Jos kulmio asetettiin, palauttaa true tietona graafiselle
     * käyttöliittymälle.
     *
     * @param paikkaIndeksi - paikka pelilaudalla kokonaislukuindeksinä
     * @param variNytVuorossa - kuusikulmiolle asetettava väri
     * 
     * @return voitiinko kuusikulmio asettaa true > kyllä false > ei
     */
    @Override
    public boolean asetaKuusikulmio(int paikkaIndeksi, Color variNytVuorossa) {
        boolean onkoVapaa = this.lauta.onkoRuutuVapaa(paikkaIndeksi);
        if (onkoVapaa) {
            ArrayList<Integer> yhdistettavatNaapurit = 
                    this.lauta.asetaKulmio(paikkaIndeksi, this.vuorossa.haeVari());
            this.tarkastaja.yhdistaUseatKetjut(paikkaIndeksi, yhdistettavatNaapurit);
        }
        return onkoVapaa;
    }

    /**
     * Tarkistaa onko peli ratkennut. Mikäli peli on ratkennut, palauttaa
     * voittajan nimen merkkijonoesityksenä. Jos peli ei ole ratkennut,
     * palauttaa null-arvon.
     *
     * @return voittajan nimi
     */
    @Override
    public String tarkistaVoittaja() {
        int voittaja = this.tarkastaja.voittajanTarkistus();
        if(voittaja == 1) return this.pelaaja1.haeNimi();
        if(voittaja == 2) return this.pelaaja2.haeNimi();
        return null;
    }
    
    @Override
    public Color monikulmionVari(int paikkaIndeksi) {
        return this.lauta.haeKulmioIndeksilla(paikkaIndeksi).haeVari();
    }
    
    @Override
    public Color pelaaja1vari() {
        return this.pelaaja1.haeVari();
    }
    
    @Override
    public Color pelaaja2vari() {
        return this.pelaaja2.haeVari();
    }
    
    @Override
    public String nimiNytVuorossa() {
        return this.vuorossa.haeNimi();
    }
}
