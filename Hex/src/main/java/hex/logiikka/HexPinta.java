
package hex.logiikka;

import java.awt.Color;

/**
 * API, joka määrittelee pelilogiikasta käyttöliittymälle näkyvät metodit.
 * 
 * Kahdelle pelaajalle suunniteltua
 * pelilogiikkaa
 * voidaan käyttää minkä tahansa sopivan Hex-käyttöliittymän kanssa näiden metodien avulla, olettaen
 * että käyttöliittymän ruutujen paikat on indeksoitu alkaen laudan vasemmasta yläkulmasta (paikkaIndeksi=0)
 * ja jatkuen vasemmalta oikealle, rivi kerrallaan.
 * 
 * Vastaavasti, olemassaolevaa käyttöliittymää ei tarvitse muokata pelilogiikan sisäisten muutosten yhteydessä,
 * edellyttäen että pelilogiikan luokka toteuttaa tämän rajapinnan. 
 */
public interface HexPinta {
    
    /**
     * Palauttaa pelilaudan koon eli sen yhdellä sivustalla olevien peliruutujen
     * lukumäärän, lautaa reunustavat apumonikulmiot mukaan lukien.
     * @return pelilaudan sivun pituus ruutuina
     */
    int laudanKoko();
    
    /**
     * Vaihtaa vuoron nykyiseltä pelaajalta pelin toiselle pelaajalle.
     */
    void vaihdaVuoroa();
    
    /**
     * Palauttaa parametrina annetussa laudan paikassa olevan monikulmion
     * tämänhetkisen värin.
     * 
     * @param paikkaIndeksi - monikulmion paikka pelilaudalla kokonaislukuindeksinä
     * @return monikulmion väri
     */
    Color monikulmionVari(int paikkaIndeksi);
    
    /**
     * Palauttaa pelaaja1:n värin.
     * 
     * @return pelaaja1:n väri
     */
    Color pelaaja1vari();
    
    /**
     * Palauttaa pelaaja2:n värin.
     * 
     * @return pelaaja2:n väri 
     */
    Color pelaaja2vari();
    
    /**
     * Palauttaa vuorossa olevan pelaajan värin.
     *
     * @return väri
     */
    Color variNytVuorossa();
    
    /**
     * Palauttaa kutsumishetkellä vuorossa olevan pelaajaolion nimen.
     * 
     * @return vuorossa olevan pelaajan nimi
     */
    String nimiNytVuorossa();
    
    /**
     * Asettaa pelilaudalle uuden, tällä hetkellä vuorossa olevan pelaajan väriä vastaavan
     * kuusikulmion. Mikäli ruutu on jo varattu, palauttaa totuusarvon 'false'.
     * Jos kulmio asetettiin, palauttaa 'true' tietona graafiselle
     * käyttöliittymälle.
     *
     * @param paikkaIndeksi - kuusikulmion paikka pelilaudalla kokonaislukuindeksinä
     * @param variNytVuorossa - kuusikulmiolle asetettava väri
     * 
     * @return voitiinko kuusikulmio asettaa true > kyllä false > ei
     */
    boolean asetaKuusikulmio(int paikkaIndeksi, Color variNytVuorossa);
    

   
    /**
     * Tarkistaa onko peli ratkennut. Mikäli peli on ratkennut, palauttaa
     * voittajan nimen merkkijonoesityksenä. Jos peli ei ole ratkennut,
     * palauttaa null-arvon.
     *
     * @return voittajan nimi
     */
    String tarkistaVoittaja();
       
}
