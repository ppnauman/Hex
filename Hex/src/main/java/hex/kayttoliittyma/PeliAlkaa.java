
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
        
        ImageIcon goh = new ImageIcon("/home/ppnauman/goh.jpg");
        JLabel otsake = new JLabel(goh);
        c.gridy = 0;
        c.gridx = 0;
        
        container.add(otsake, c);
        
        JLabel nimiPelaaja1 = new JLabel("Player 1 name and color: ");
        nimiPelaaja1.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja1.setForeground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,100,0,100);
        c.gridx=0;
        c.gridy=1;
        container.add(nimiPelaaja1,c);
        
        
        JTextField nimiKentta1 = new JTextField("");
        Dimension tekstikentanKoko = new Dimension(250,25);
        nimiKentta1.setPreferredSize(tekstikentanKoko);
        c.gridy=2;
        container.add(nimiKentta1,c);

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
        container.add(varikentta1, c);
        
        JLabel nimiPelaaja2 = new JLabel("Player 2 name and color: ");
        nimiPelaaja2.setHorizontalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setVerticalAlignment(SwingConstants.CENTER);
        nimiPelaaja2.setForeground(Color.LIGHT_GRAY);
        c.gridy=4;
        container.add(nimiPelaaja2,c);
        
        JTextField nimiKentta2 = new JTextField("");
        nimiKentta2.setPreferredSize(tekstikentanKoko);
        c.gridy=5;
        container.add(nimiKentta2,c);
        
        
        varikentta2.addActionListener(new VariKentanKuuntelija(varikentta1, varit));
        c.gridy=6;
        container.add(varikentta2, c);
        
        JButton pelaa = new JButton("Play");
        pelaa.setPreferredSize(new Dimension(tekstikentanKoko));
        pelaa.addActionListener(new PelaaNapinKuuntelija(kehys, nimiKentta1, nimiKentta2, varikentta1, varikentta2));
        c.insets=new Insets(20,100,20,100);
        c.gridy=7;
        container.add(pelaa, c);
        
        
        asetaKehyksenPaikka();
    
        
   
    }
    
    private void asetaKehyksenPaikka() {
       Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (naytonKoko.width-400)/2;
       int y = (naytonKoko.height-400)/2;
       this.kehys.setLocation(x,y);
        
    }
}
