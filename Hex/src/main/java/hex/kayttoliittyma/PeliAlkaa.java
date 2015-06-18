
package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *Ohjelman käynnistyessä ensimmäisenä avautuva graafinen ikkuna, jossa pelaajat
 * syöttävät pelaajanimensä ja valitsevat haluamansa värin.
 */
public class PeliAlkaa implements Runnable {
    
    private JFrame kehys;
    
    @Override
    public void run() {
        kehys = new JFrame("Game of Hex – new game");
        kehys.setPreferredSize(new Dimension(400, 500));
        kehys.setLayout(new GridBagLayout());
        kehys.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        //sisältö
        luoKomponentit(kehys.getContentPane());

        kehys.pack();
        kehys.setVisible(true);
    }
    
    //luo JFrame -kehyksen komponentit
    private void luoKomponentit(Container sailio) {
    
        asetaTaustaVari(sailio);
        GridBagConstraints c = new GridBagConstraints();
        ImageIcon ikoni= new ImageIcon("/home/perttu/Työpöytä/goh.jpg");
        JLabel otsake = new JLabel(ikoni);
        c.ipady=30;
        c.gridy = 0;
        c.gridx = 0;
        
        sailio.add(otsake, c);
        
        JLabel nimiPelaaja1 = new JLabel("Player 1 name & color");
        nimiPelaaja1.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setForeground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,110,5,110);
        c.ipady=0;
        c.gridx=0;
        c.gridy=1;
        sailio.add(nimiPelaaja1,c);
        
        
        JTextField nimiKentta1 = new JTextField("");
        nimiKentta1.setDocument(new TekstiKentanRajoitin(22));
        Dimension tekstikentanKoko = new Dimension(150,25);
        nimiKentta1.setPreferredSize(tekstikentanKoko);
        c.gridy=2;
        sailio.add(nimiKentta1,c);

        String[] varit = { "Red", "Blue", "White", "Green", "Pink", "Yellow", "Cyan", "Orange" };
        JComboBox varikentta1 = new JComboBox(varit);
        JComboBox varikentta2 = new JComboBox(varit);
        varikentta2.setPreferredSize(tekstikentanKoko);
        varikentta2.setSelectedItem("Blue");
        varikentta2.removeItem("Red");
        varikentta1.setPreferredSize(tekstikentanKoko);
        varikentta1.removeItem("Blue");
        varikentta1.addActionListener(new VariKentanKuuntelija(varikentta2, varit));
        c.gridy=3;
        sailio.add(varikentta1, c);
        
        JLabel nimiPelaaja2 = new JLabel("Player 2 name & color");
        nimiPelaaja2.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setForeground(Color.LIGHT_GRAY);
        c.insets=new Insets(20,110,5,110);
        c.gridy=4;
        sailio.add(nimiPelaaja2,c);
        
        JTextField nimiKentta2 = new JTextField("");
        nimiKentta2.setDocument(new TekstiKentanRajoitin(22));
        nimiKentta2.setPreferredSize(tekstikentanKoko);
        c.gridy=5;
        c.insets=new Insets(5,110,5,110);
        sailio.add(nimiKentta2,c);
        
        
        varikentta2.addActionListener(new VariKentanKuuntelija(varikentta1, varit));
        c.gridy=6;
        sailio.add(varikentta2, c);
        
        JButton pelaa = new JButton("Play");
        pelaa.setPreferredSize(new Dimension(tekstikentanKoko));
        pelaa.addActionListener(new PelaaNapinKuuntelija(kehys, nimiKentta1, nimiKentta2, varikentta1, varikentta2));
        c.insets=new Insets(30,110,20,110);
        c.gridy=7;
        sailio.add(pelaa, c);
        
        
        asetaKehyksenPaikka();
    }
    
    private void asetaTaustaVari(Container sailio) {
        sailio.setBackground(Color.BLACK);
    }
    
    private void asetaKehyksenPaikka() {
       Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (naytonKoko.width-400)/2;
       int y = (naytonKoko.height-500)/2;
       this.kehys.setLocation(x,y);
        
    }
}
