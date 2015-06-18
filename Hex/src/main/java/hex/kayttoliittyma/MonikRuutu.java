
package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JButton;

/**
 * Muodoltaan monikulmaisen Swing JButtonin kuvaava aliluokka. Kuusikulmaisia
 * JButton -olioita käytetään kuvaamaan käyttöliittymässä pelilaudan kuusikulmaisia
 * peliruutuja. Viisikulmaista ruutua käytetään pelilaudan reunustoilla. Lisäksi kolmi-
 * ja nelikulmaisia ruutuja piirretään käyttöliittymässä pelilaudan kulmapaikkoihin.
 */
public class MonikRuutu extends JButton {
    
    private Polygon muoto;
    private Color vari;
    private int paikkaIndeksi;
    
    /**
     * Konstruktori, jolle annetaan parametreina peliruudun paikkaIndeksi, monikulmainen
     * muoto ja väri.
     * 
     * @param paikkaIndeksi kyseisen ruudun paikkaIndeksi pelilaudalla. Indeksointi alkaa laudan
     * vasemmasta yläkulmasta (paikkaIndeksi = 0) ja jatkuu vasemmalta oikealle rivi kerrallaan)
     * @param muoto ruudun monikulmainen muoto
     * @param vari ruudun väri
     */
    public MonikRuutu (int paikkaIndeksi, Polygon muoto, Color vari) {
        super();
        this.paikkaIndeksi = paikkaIndeksi;
        this.muoto = muoto;
        this.vari = vari;
        setContentAreaFilled(false);
        setBorderPainted(false);  
    }
    
    /**
     * Tummentaa käyttöliittymän ruudun väriä käyttäen Color.darker() metodia.
     */
    public void tummennaVari() {
        this.vari = this.vari.darker();
    }
    
    /**
     * Vaalentaa käyttöliittymän ruudun väriä käyttäen Color.brighter() metodia.
     */
    public void vaalennaVari() {
        this.vari = this.vari.brighter();
    }
    
    /**
     * Palauttaa käyttöliittymän ruudun värin kutsuhetkellä.
     * 
     * @return ruudun väri 
     */
    public Color haeRuudunVari() {
        return this.vari;
    }
    
    /**
     * Asettaa käyttöliittymän ruudulle uuden värin.
     * @param uusiVari uusi väri
     */
    public void asetaVari(Color uusiVari) {
        this.vari = uusiVari;
    }
    
    /**
     * Palauttaa käyttöliittymän ruudun paikkaIndeksin.
     * @return paikkaIndeksi
     */
    public int haePaikkaIndeksi() {
        return this.paikkaIndeksi;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(this.vari);
        graphics.fillPolygon(this.muoto);
        //super.paintComponent(graphics);

    }


    @Override
    public boolean contains(int x, int y) {
        return muoto.contains(x, y);
    }
    
    @Override
    public boolean contains(Point P) {
        return muoto.contains(P);
    }
            
            
}
