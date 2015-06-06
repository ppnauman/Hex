
package hex.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Tapahtumankuuntelija PeliPaattynyt -luokan 'Exit' -napille. Sulkee
 * käynnissä olevan Java virtuaalikoneen.
 */
public class LopetusKuuntelija implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
