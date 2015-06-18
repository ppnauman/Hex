
package hex.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * PeliPaattynyt -näkymän 'PlayAgain' -nappiin liittyvä tapahtumankuuntelija, jonka
 * avulla suljetaan nykyiset käyttöliittymäikkunat ja aloitetaan uusi peli.
 */
public class UudelleenNapinKuuntelija implements ActionListener {
    
    private JFrame peli;
    private JFrame peliPaattynyt;
    
    /**
     * Konstruktori, jonka parametreina annetaan pelin pääikkunan ja pelin lopetusikkunan
     * JFrame -kehysoliot.
     * 
     * @param peli pelin pääikkunan kehysolio
     * @param peliPaattynyt pelin lopetusikkunan kehysolio
     */
    public UudelleenNapinKuuntelija(JFrame peli, JFrame peliPaattynyt) {
        this.peli = peli;
        this.peliPaattynyt = peliPaattynyt;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        SwingUtilities.invokeLater(new PeliAlkaa());
        this.peli.dispose();
        this.peliPaattynyt.dispose();
    }
    
}
