
package hex.logiikka;

import java.awt.Color;


/**
 * API joka tulee määrittelemään pelilogiikan käyttöliittymälle näkyvät metodit
 * 
 */
public interface HexPinta {
    
    /**
     * 
     * @return 
     */
    int laudanKoko();
    
    /**
     * Vaihtaa vuoron pelin toiselle pelaajalle.
     */
    void vaihdaVuoroa();
    
    Color monikulmionVari(int paikkaIndeksi);
    /**
     * Pelaajan nro 1 väri.
     * @return väri1
     */
    Color pelaaja1vari();
    
    /**
     * Pelaajan nro 2 väri.
     * @return väri2
     */
    Color pelaaja2vari();
    
        /**
     * 
     * @return 
     */
    Color variNytVuorossa();
    
    String nimiNytVuorossa();
    
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
    String tarkistaVoittaja();
    
    
    
   
    
   
    
    
}
