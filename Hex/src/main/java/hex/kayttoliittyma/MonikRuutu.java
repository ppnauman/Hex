
package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JButton;

/**
 * Kuusikulmaisen Swing JButtonin kuvaava aliluokka.
 * 
 */
public class MonikRuutu extends JButton {
    
    private Polygon muoto;
    private Color vari;
    private int paikkaIndeksi;
    
    
    public MonikRuutu (int paikkaIndeksi, Polygon muoto, Color vari) {
        super();
        this.paikkaIndeksi = paikkaIndeksi;
        this.muoto = muoto;
        this.vari = vari;
        setContentAreaFilled(false);
        setBorderPainted(false);  
    }
    
    public void tummennaVari() {
        this.vari = this.vari.darker();
    }
    
    public void vaalennaVari() {
        this.vari = this.vari.brighter();
    }
    
    public Color haeRuudunVari() {
        return this.vari;
    }
    
    
    public void asetaVari(Color uusiVari) {
        this.vari = uusiVari;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(this.vari);
        graphics.fillPolygon(this.muoto);
        //super.paintComponent(graphics);

    }

    /*@Override
    protected void paintBorder(Graphics graphics) {
        graphics.setColor(this.vari);
        graphics.drawPolygon (this.muoto);
    }*/

    @Override
    public boolean contains(int x, int y) {
        return muoto.contains(x, y);
    }
    
    @Override
    public boolean contains(Point P) {
        return muoto.contains(P);
    }
            
            
}
