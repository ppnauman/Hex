

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
 * tapahtuvia hiiren toimintoja. Hiiren nappulaa (vasen tai oikea) painettaessa ko. ruutu varataan
 * vuorossa olevalle pelaajalle. Kun hiiri on vapaassa peliruudussa, ruudun värisävy tummenee
 * merkiksi osoittimen senhetkisestä sijainnista pelilaudalla.
 */
public class KuusikRuudunKuuntelija implements MouseListener {
    
    private HexPinta peli;
    private Kayttoliittyma kayttis;
    
    /**
     * Konstruktori, jonka parametreina annetaan HexPinta -rajapinnan toteuttava logiikkaolio,
     * jonka avulla kuuntelija kommunikoi pelilogiikan kanssa ja pelin 'peliikkuna' eli Kayttoliittyma -olio.
     * @param peli kayttöliittymän ja pelilogiikan välinen rajapintaolio
     * @param kayttis peli-ikkuna -olio
     */
    public KuusikRuudunKuuntelija(HexPinta peli, Kayttoliittyma kayttis) {
        this.peli = peli;
        this.kayttis = kayttis;
    }
    
    @Override
    public void mousePressed (MouseEvent me) {
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        Color variVuorossa = peli.variNytVuorossa();
        if(peli.asetaKuusikulmio(tamaRuutu.haePaikkaIndeksi(), variVuorossa)) {
            tamaRuutu.asetaVari(variVuorossa);
            tamaRuutu.repaint();
            String voittaja = peli.tarkistaVoittaja();
            if ( voittaja != null) {
                PeliPaattynyt peliPaattynyt = new PeliPaattynyt(voittaja, variVuorossa, this.kayttis.haeKehys());
                SwingUtilities.invokeLater(peliPaattynyt);
                this.kayttis.poistaKuuntelijat();
            }
            peli.vaihdaVuoroa();
            this.kayttis.kirjoitaInfoon(peli.variNytVuorossa(), peli.nimiNytVuorossa() + " – it's your move.");
        } else {
            this.kayttis.kirjoitaInfoon(peli.variNytVuorossa(), peli.nimiNytVuorossa() + " – position already occupied. Try again.");
        }
    }
    
   
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        if(tamaRuutu.haeRuudunVari() == peli.pelaaja1vari() || tamaRuutu.haeRuudunVari() == peli.pelaaja2vari()) return;
        tamaRuutu.tummennaVari();
        tamaRuutu.repaint();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        MonikRuutu tamaRuutu = (MonikRuutu)me.getSource();
        if(tamaRuutu.haeRuudunVari() == peli.pelaaja1vari() || tamaRuutu.haeRuudunVari() == peli.pelaaja2vari()) return;
        tamaRuutu.vaalennaVari();
        tamaRuutu.repaint();
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

}
