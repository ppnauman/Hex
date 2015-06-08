package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import hex.logiikka.Peli;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Tapahtumankuuntelija, joka vastaa pelin käynnistämisestä kun pelaajatiedot on
 * syötetty ja pelaaja painaa PeliAlkaa -näkymän 'play'-nappulaa.
 */
public class PelaaNapinKuuntelija implements ActionListener {

    private JTextField nimiKentta1;
    private JTextField nimiKentta2;
    private JComboBox varikentta1;
    private JComboBox varikentta2;
    private JFrame kehys;
    
    public PelaaNapinKuuntelija(JFrame kehys, JTextField nimiKentta1, JTextField nimiKentta2, JComboBox varikentta1, JComboBox varikentta2) {
        
        this.kehys = kehys;
        this.nimiKentta1 = nimiKentta1;
        this.nimiKentta2 = nimiKentta2;
        this.varikentta1 = varikentta1;
        this.varikentta2 = varikentta2;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        HexPinta peli = new Peli(11, nimiKentta1.getText(), nimiKentta2.getText(), vari((String)varikentta1.getSelectedItem()),
                vari((String)varikentta2.getSelectedItem()));
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
        kehys.dispose();
    }

    private Color vari(String variMerkkijono) {
        switch(variMerkkijono) {
            case "Red" :
                return Color.RED;
            case "Blue" :
                return Color.BLUE;
            case "White" :
                return Color.WHITE;
            case "Green" :
                return Color.GREEN;
            case "Pink" :
                return Color.PINK;
            case "Yellow" :
                return Color.YELLOW;
            case "Cyan" :
                return Color.CYAN;
            case "Orange" :
                return Color.ORANGE;
            default :
                return null;
        }
    }
}
