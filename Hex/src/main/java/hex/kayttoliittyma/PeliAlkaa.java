
package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *Ohjelman käynnistyessä avautuva graafinen ikkuna, jossa pelaajat
 * syöttävät pelaajanimensä ja valitsevat haluamansa värin.
 */
public class PeliAlkaa implements Runnable {
    private JFrame kehys;
    
    @Override
    public void run() {
        kehys = new JFrame("Game of Hex ***new game***");
        kehys.setPreferredSize(new Dimension(400, 400));
        kehys.setLayout(new GridBagLayout());
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        //sisältö
        luoKomponentit(kehys.getContentPane());

        kehys.pack();
        kehys.setVisible(true);
    }
    
    //luo JFrame -kehyksen komponentit
    private void luoKomponentit(Container container) {
        
        //taustaväri
        container.setBackground(Color.BLACK);
        
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel nimiPelaaja1 = new JLabel("Player 1 name: ");
        nimiPelaaja1.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setForeground(Color.LIGHT_GRAY);
        c.gridx=0;
        c.gridy=0;
        container.add(nimiPelaaja1,c);
        
        
        JTextField nimiKentta1 = new JTextField("");
        Dimension tekstikentanKoko = new Dimension(250,25);
        nimiKentta1.setPreferredSize(tekstikentanKoko);
        c.gridy=1;
        container.add(nimiKentta1,c);

        String[] varit = { "Red", "Blue", "White", "Green", "Pink", "Yellow", "Cyan", "Brown" };
        JComboBox varikentta1 = new JComboBox(varit);
        varikentta1.setPreferredSize(tekstikentanKoko);
        c.gridy=2;
        container.add(varikentta1, c);
        
        JLabel nimiPelaaja2 = new JLabel("Player 2 name: ");
        nimiPelaaja2.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setForeground(Color.LIGHT_GRAY);
        c.gridy=3;
        container.add(nimiPelaaja2,c);
        
        JTextField nimiKentta2 = new JTextField("");
        nimiKentta2.setPreferredSize(tekstikentanKoko);
        c.gridy=4;
        container.add(nimiKentta2,c);
        
    
        
   
    }
}
