

package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class KuusikRuudunKuuntelija implements MouseListener {
    
    private HexPinta peli;
    private JLabel info;
    
    public KuusikRuudunKuuntelija(HexPinta peli, JLabel info) {
        this.peli = peli;
        this.info = info;
    }
    
    @Override
    public void mousePressed (MouseEvent me) {
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        tamaRuutu.asetaVari(this.peli.variNytVuorossa());
        tamaRuutu.repaint();
        this.peli.vaihdaVuoroa();
        this.info.setForeground(peli.variNytVuorossa());
        this.info.setText(peli.nimiNytVuorossa()+" - it's your move");
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
