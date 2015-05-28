package hex.logiikka;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Luokka kuvaa kuusikulmioista koostuvan pelilaudan ja sillä vallitsevan
 * tilanteen. Laudan ohella luokka tuntee pelaajien värit.
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
        this.pelilauta = new Monikulmio[laudanKoko + 2][laudanKoko + 2];
        this.vari1 = vari1;
        this.vari2 = vari2;
    }

    /**
     * Luo laudalle uudet monikulmiot eli alustaa uuden laudan tai resetoi
     * olemassaolevan pelilaudan.
     */
    public void alustaLauta() {
        for (int i = 0; i < this.pelilauta.length; i++) {
            for (int j = 0; j < this.pelilauta.length; j++) {
                //vasemmalle ja oikealle pelaaja1:n viisikulmiot, ylös ja alas pelaajan2
                if (j == 0 || j == this.pelilauta.length - 1) {
                    luoViisikulmio(i, j, vari1);
                } else if (i == 0 || i == this.pelilauta.length - 1) {
                    luoViisikulmio(i, j, vari2);
                } else {
                    luoKuusikulmio(i, j);
                }
            }
        }
    }

    /**
     * Palauttaa laudan koon (sivun pituuden) reunustavat viisikulmiot mukaanlukien.
     * @return pelilaudan koko
     */
    public int koko() {
        return this.pelilauta.length;
    }
    
    //Kuusikulmion laudan tiettyyn paikkaan generoiva apumetodi, joka osallistuu
    //laudan alustukseen.
    private void luoKuusikulmio(int i, int j) {
        this.pelilauta[i][j] = new Kuusikulmio(paikkaIndeksi(i,j), Color.LIGHT_GRAY);
    }

    //Viisikulmion generoiva apumetodi, joka osallistuu laudan alustukseen
    private void luoViisikulmio(int i, int j, Color vari) {
        this.pelilauta[i][j] = new Viisikulmio(paikkaIndeksi(i,j), vari);
    }

    /**
     * Tarkistaa onko pelilaudan indeksissä sijaitseva ruutu varattu. Vapaan
     * ruudun väri on vaalean harmaa.
     *
     * @param paikkaIndeksi
     * @return true = varattu, false = vapaa
     */
    public boolean onkoRuutuVarattu(int paikkaIndeksi) {
        return (this.haeKulmioIndeksilla(paikkaIndeksi).haeVari() != Color.LIGHT_GRAY);
    }

    /**
     * Varaa pelilaudan monikulmion parametrina annettavalle pelaajalle eli ts.
     * asettaa Monikulmion väriksi annetun värin. Metodi palauttaa
     * kokonaislukutaulukon, jossa ovat saman väristen naapuriruutujen
     * paikkaIndeksit.
     */
    public ArrayList<Integer> asetaKulmio(int paikkaIndeksi, Color variNytVuorossa) {
        this.haeKulmioIndeksilla(paikkaIndeksi).asetaVari(variNytVuorossa);
        return tutkiNaapurit(paikkaIndeksi, variNytVuorossa);
    }

    /* Palauttaa SAMANVÄRISTEN naapuriruutujen indeksit ArrayList -oliossa. Koska metodia kutsutaan
     vain kuusikulmaisten (laudan sisällä olevien) ruutujen yhteydessä,
     on kullakin ruudulla naapureita aina kaikkiaan 6kpl.
     */
    private ArrayList<Integer> tutkiNaapurit(int paikkaIndeksi, Color vari) {
        int w = this.pelilauta.length;
        int[] naapurit = {paikkaIndeksi - 1, paikkaIndeksi + 1, paikkaIndeksi - w,
            paikkaIndeksi + w, paikkaIndeksi + w - 1, paikkaIndeksi - w + 1};
        ArrayList<Integer> samanvariset = new ArrayList();
        for (int i = 0; i < 6; i++) {
            if (this.haeKulmioIndeksilla(naapurit[i]).haeVari() == vari) {
                samanvariset.add(naapurit[i]);
            }
        }
        return samanvariset;
    }

    /**
     * Palauttaa pelilaudan Monikulmion.
     *
     */
    public Monikulmio haeMonikulmio(int i, int j) {
        return this.pelilauta[i][j];
    }

    /**
     * Hakee laudalta Monikulmio-olion paikkaIndeksin(=kokonaisluku)
     * perusteella, pelin koosta riippumatta.
     *
     * @param paikkaIndeksi
     * @return laudan Monikulmio-olio.
     */
    public Monikulmio haeKulmioIndeksilla(int paikkaIndeksi) {
        int i = paikkaIndeksi / this.pelilauta.length;
        int j = paikkaIndeksi % this.pelilauta.length;
        return this.pelilauta[i][j];
    }
    
    private int paikkaIndeksi(int i, int j) {
        return pelilauta.length*i+j;
    }

    /**
     * Palauttaa pelilaudan kaksiulotteisena taulukkona.
     *
     * @return pelilauta
     */
    public Monikulmio[][] haePelilauta() {
        return this.pelilauta;
    }

}
