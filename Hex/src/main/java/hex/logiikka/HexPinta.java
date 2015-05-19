
package hex.logiikka;

import java.awt.Color;

/**
 * API joka määrittää pelilogiikan käyttöliittymälle tarjoamat toiminnot
 * 
 */
public interface HexPinta {
    
    void luoPelaaja(String nimi, Color vari);
    
    void lisaaKuusikulmio();
       
}
