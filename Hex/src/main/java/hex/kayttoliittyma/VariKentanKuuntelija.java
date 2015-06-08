
package hex.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 */
public class VariKentanKuuntelija implements ActionListener{
    
    private JComboBox toinenKentta;
    private String[] oletusVarit;
    
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
