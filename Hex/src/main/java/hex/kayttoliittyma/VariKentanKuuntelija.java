
package hex.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * PeliAlkaa -näkymän JComboBox -värinvalintakomponenttien kuuntelija. Kuuntelijan
 * tehtävänä on päivittää JComboBoxit siten, että pelaajilla ei voi olla sama väri,
 * mutta muuten väri on valittavissa aina vapaasti kaikista vaihtoehdoista.
 */
public class VariKentanKuuntelija implements ActionListener{
    
    private JComboBox toinenKentta;
    private String[] oletusVarit;
    
    /**
     * Konstruktori, jolle annetaan parametreina toisen pelaajan vastaava JComboBox-valikko
     * ja värivaihtoehdot.
     * 
     * @param toinenKentta toisen pelaajan värivalikko
     * @param varit valittavissa olevat värit
     */
    public VariKentanKuuntelija(JComboBox toinenKentta, String[] varit) {
        this.toinenKentta = toinenKentta;
        this.oletusVarit = varit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String toinenVari = (String)this.toinenKentta.getSelectedItem();
        JComboBox lahde = (JComboBox)ae.getSource();
        String valittuVari = (String)lahde.getSelectedItem();
        this.toinenKentta.setModel(new DefaultComboBoxModel(this.oletusVarit));
        this.toinenKentta.removeItem(valittuVari);
        this.toinenKentta.setSelectedItem(toinenVari);
        
    }
}
