

package hex.logiikka;

/**
 * Pelin pelaajan kuvaava luokka.
 */

public class Pelaaja {
    
    private String nimi;
    private String vari;
    
    /**
     * Konstruktori luo uuden pelaajan ja asettaa tälle nimen ja värin.
     * @param nimi Pelaajan nimi
     * @param vari Pelaajan väri
     */
    
    public Pelaaja (String nimi, String vari) { 
        this.nimi = nimi;
        this.vari = vari;  
    }
    
    
    /**
     * Pelaajan nimen palauttava metodi.
     * @return pelaajan nimi
     */
    
    public String haeNimi() {
        return this.nimi;
    }
    
    
    /**
     * Pelaajan värin palauttava metodi.
     * @return pelaajan väri
     */
    
    public String haeVari() {
        
        return this.vari;
    }
}
