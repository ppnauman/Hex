/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    @Override
    public void mousePressed (MouseEvent me) {
        KuusikRuutu tamaRuutu = (KuusikRuutu)me.getSource();
        tamaRuutu.asetaVari(Color.PINK);
        tamaRuutu.repaint();
    }
    
   

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }

    public void mouseClicked(MouseEvent e) {
        
    }

}
