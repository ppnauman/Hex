

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
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        tamaRuutu.asetaVari(Color.RED);
        tamaRuutu.repaint();
    }
    
   
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        tamaRuutu.tummennaVari();
        tamaRuutu.repaint();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        if(tamaRuutu.haeRuudunVari() == Color.RED) return;
        tamaRuutu.vaalennaVari();
        tamaRuutu.repaint();
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

}
