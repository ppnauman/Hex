
package hex.logiikka;

import java.awt.Color;


/**
 * API joka tulee määrittelemään pelilogiikan käyttöliittymälle näkyvät metodit
 * 
 */
public interface HexPinta {
    
    /**
     * 
     * @param paikkaIndeksi
     * @param variNytVuorossa
     * @return 
     */
    boolean asetaKuusikulmio(int paikkaIndeksi, Color variNytVuorossa);
    
    /**
     * 
     * @return 
     */
    Color variNytVuorossa();
   
    /**
     * 
     * @return 
     */
    String tarkistaVoittaja();
    
    
    
   
    
   
    
    
}
