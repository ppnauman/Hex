
package hex.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *Pelin ratkettua avautuva graafinen ikkuna, joka ilmoittaa pelin voittajan.
 * Pelaajan on mahdollista valita haluaako hän aloittaa uuden pelin,
 * vai poistua ohjelmasta.
 */
public class PeliPaattynyt implements Runnable {
    private JFrame kehys;
    private JFrame peli;
    private String voittaja;
    private Color vari;
    private Kayttoliittyma kayttis;

    /**
     * Konstruktori, jolle annetaan parametreina pelin voittaneen pelaajan nimi,
     * väri ja pelin pääikkunan (Kayttoliittyma-olion) JFrame kehys.
     * 
     * @param voittaja pelin voittajan nimi
     * @param vari pelin voittajan väri
     * @param peli peli-ikkunan komponenttikehys
     */
    public PeliPaattynyt(String voittaja, Color vari, JFrame peli) {
        this.voittaja = voittaja;
        this.vari = vari;
        this.peli = peli;
    }

    @Override
    public void run() {
        kehys = new JFrame("Game Over");
        asetaKehyksenPaikka();
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
        
        JLabel viesti = new JLabel(voittaja + " – you won the game!");
        viesti.setHorizontalAlignment(SwingConstants.CENTER);
        viesti.setVerticalAlignment(SwingConstants.CENTER);
        viesti.setForeground(vari);
        
        
        c.fill=GridBagConstraints.BOTH;
        
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=3;
        c.weightx=1.0;
        c.weighty=1.0;
        container.add(viesti, c);
        
        JButton uusiPeli = new JButton("PlayAgain");
        uusiPeli.addActionListener(new UudelleenNapinKuuntelija(this.peli, this.kehys));
        c.fill=GridBagConstraints.HORIZONTAL;
        c.weighty=0.0;
        c.ipady=0;
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=1;
        c.anchor=GridBagConstraints.PAGE_END;
        container.add(uusiPeli, c);
        
        
        JButton lopetus = new JButton("Exit");
        lopetus.addActionListener(new LopetusNapinKuuntelija());
        c.gridx=2;
        c.gridy=1;
        c.gridwidth=1;
        container.add(lopetus, c);
    }
    
    //ikkunan sijainti näytöllä
    private void asetaKehyksenPaikka() {
        Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
        int y = (naytonKoko.height-200)/2;
        int x = (naytonKoko.width-400)/2;
        kehys.setLocation(x, y);
        kehys.setPreferredSize(new Dimension(400,200));
    }
   
    
}
