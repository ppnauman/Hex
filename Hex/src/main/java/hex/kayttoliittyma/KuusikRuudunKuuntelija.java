

package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
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
    private Kayttoliittyma kayttis;
    
    public KuusikRuudunKuuntelija(HexPinta peli, Kayttoliittyma kayttis) {
        this.peli = peli;
        this.kayttis = kayttis;
    }
    
    @Override
    public void mousePressed (MouseEvent me) {
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        if(peli.asetaKuusikulmio(tamaRuutu.haePaikkaIndeksi(), peli.variNytVuorossa())) {
            tamaRuutu.asetaVari(this.peli.variNytVuorossa());
            tamaRuutu.repaint();
            String voittaja = peli.tarkistaVoittaja();
            if ( voittaja != null) {
                PeliPaattynyt peliPaattynyt = new PeliPaattynyt(voittaja, peli.variNytVuorossa(), this.kayttis.haeKehys());
                SwingUtilities.invokeLater(peliPaattynyt);
                this.kayttis.poistaKuuntelijat();
            }
            peli.vaihdaVuoroa();
            this.kayttis.haeInfo().setForeground(peli.variNytVuorossa());
            this.kayttis.haeInfo().setText(peli.nimiNytVuorossa() + " – it's your move.");
        } else {
            this.kayttis.haeInfo().setText(peli.nimiNytVuorossa() + " – position occupied. Try again. ");
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
