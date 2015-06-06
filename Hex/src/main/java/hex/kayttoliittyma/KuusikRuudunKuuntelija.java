

package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Hiirenkuuntelijaluokka, joka seuraa pelilaudan kuusikulmaisissa peliruuduissa
 * tapahtuvia hiiren toimintoja. Vasenta nappulaa painettaessa ko. ruutu varataan
 * vuorossa olevalle pelaajalle. Kun hiiri on peliruudussa, ruudun värisävy tummenee
 * merkiksi osoittimen senhetkisestä sijainnista pelilaudalla.
 */

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
        if(peli.asetaKuusikulmio(tamaRuutu.haePaikkaIndeksi(), peli.variNytVuorossa())) {
            tamaRuutu.asetaVari(this.peli.variNytVuorossa());
            tamaRuutu.repaint();
            
            String voittaja = peli.tarkistaVoittaja();
            if ( voittaja != null) {
                PeliPaattynyt peliPaattynyt = new PeliPaattynyt(voittaja, peli.variNytVuorossa());
                SwingUtilities.invokeLater(peliPaattynyt);
            }
            
            peli.vaihdaVuoroa();
            this.info.setForeground(peli.variNytVuorossa());
            this.info.setText(peli.nimiNytVuorossa() + " – it's your move");
        } else {
            this.info.setText(peli.nimiNytVuorossa() + " – position occupied. Try again. ");
        }
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
