
package hex.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ppnauman
 */
public class UudelleenNapinKuuntelija implements ActionListener {
    
    private JFrame peli;
    private JFrame peliPaattynyt;
    
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
