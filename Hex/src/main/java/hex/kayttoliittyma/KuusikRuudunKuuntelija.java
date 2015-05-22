

package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *Testing....
 * @author ppnauman
 */
public class KuusikRuudunKuuntelija implements MouseListener {
    
    
    
    public KuusikRuudunKuuntelija() {
        
    }
    //testausta vain
    @Override
    public void mousePressed (MouseEvent me) {
        KuusikRuutu tamaRuutu = (KuusikRuutu)me.getSource();
        tamaRuutu.asetaVari(Color.PINK);
        tamaRuutu.repaint();
    }
    
   
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

}
