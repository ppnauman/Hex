/**
 * Pelin pääikkuna.
 *
 * @author ppnauman
 */
package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame kehys;
    private HexPinta peli;
    private Dimension naytonKoko;

    public Kayttoliittyma(HexPinta peli) {
        this.peli = peli;
        this.naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
    }

    @Override
    public void run() {
        kehys = new JFrame("Game of Hex");
        
        //absoluuttinen asettelu
        kehys.setLayout(null);
        asetaKehyksenPaikka(kehys);
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
        
        //monikulmioiden mitat
        int kork = maaritaKulmionKork();
        int lev = (int)(kork/2.0*Math.sqrt(3.0));
        //ja niiden väliin jäävän raon koko
        int rako = Math.max(1, kork/20);
        
        luoMonikulmiot(container, lev, kork, rako);
      
    }
    
    
    /*asettaa peli-ikkunan leveydeksi 80% näytön leveydestä, korkeudeksi 90% näytön korkeudesta
    ja sijoittaa ikkunan keskelle näyttöä.*/
    private void asetaKehyksenPaikka (JFrame kehys) {
        int korkeus = (int)naytonKoko.height/10*9;
        int leveys = (int)naytonKoko.width/10*8;
        int y = naytonKoko.height/20;
        int x = naytonKoko.width/10;
        kehys.setLocation(x, y);
        kehys.setPreferredSize(new Dimension(leveys,korkeus));
    }
    
    private void luoMonikulmiot(Container container, int lev, int kork, int rako) {
                
        //luodaan muodot
        Polygon kuusik = kuusik(lev, kork);
        Polygon vasViisik = vasViisik(lev, kork);
        Polygon oikViisik = oikViisik(lev, kork);
        Polygon alaViisik = alaViisik(lev, kork);
        Polygon ylaViisik = ylaViisik(lev, kork);
        
        //luodaan kulmikkaat JButton-objektit
        int paikka = 0;
        for (int i = 0; i < peli.laudanKoko(); i++) {
            for (int j = 0; j < peli.laudanKoko(); j++) {
                MonikRuutu ruutu;
                if(j==0) {
                    ruutu = new MonikRuutu(paikka, vasViisik, Color.BLUE);
                }
                else if(j==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, oikViisik, Color.BLUE);
                }
                else if(i==0) {
                    ruutu = new MonikRuutu(paikka, ylaViisik, Color.RED);
                }
                else if(i==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, alaViisik, Color.RED);
                }
                else {
                    ruutu = new MonikRuutu(paikka, kuusik, Color.LIGHT_GRAY);
                    ruutu.addMouseListener(new KuusikRuudunKuuntelija());
                }
                container.add(ruutu);
                ruutu.setBounds(ruudunPaikka(i, j, kork, lev, rako));
                paikka++;
            } 
        }
    }
    
    private Polygon kuusik(int leveys, int korkeus) {
       int[] x = { 0, 0, leveys/2, leveys, leveys, leveys/2, };
       int[] y = { korkeus-korkeus/4, korkeus/4, 0, korkeus/4, korkeus-korkeus/4, korkeus };
       return new Polygon(x, y, 6);
    }
    
    private Polygon vasViisik(int leveys, int korkeus) {
        int[] x = { 0, leveys/2, leveys, leveys, leveys/2, };
        int[] y = { korkeus/4, 0, korkeus/4, korkeus/4*3, korkeus };
        return new Polygon(x, y, 5);
    }
    
    private Polygon oikViisik(int leveys, int korkeus) {
        int[] x = { 0, 0, leveys/2, leveys, leveys/2, };
        int[] y = { korkeus/4*3, korkeus/4, 0, korkeus/4*3, korkeus };
        return new Polygon(x, y, 5);
    }
    
    private Polygon alaViisik(int leveys, int korkeus) {
        int[] x = { 0, 0, leveys/2, leveys, leveys, };
        int[] y = { korkeus/4*3, korkeus/4, 0, korkeus/4, korkeus/4*3, };
        return new Polygon(x, y, 5);
    }
    
    private Polygon ylaViisik(int leveys, int korkeus) {
        int[] x = { 0, 0, leveys, leveys, leveys/2, };
        int[] y = { korkeus/4*3, korkeus/4, korkeus/4, korkeus/4*3, korkeus };
        return new Polygon(x, y, 5);
    }
    
    private int maaritaKulmionKork() {
        if(this.naytonKoko.height > 800) {
            return 68;
        }
        else if(this.naytonKoko.height < 800 && this.naytonKoko.height > 600) {
            return 48;
        }
        else {
            return 40;
        }
    }
    
    private Rectangle ruudunPaikka(int i, int j, int kork, int lev, int rako) {
        int x = i*(lev/2+rako/2) + j*(lev+rako);
        int y = i*(kork/4*3+rako);
        return new Rectangle (x, y, lev, kork);
    }
    
    //palauttaa JFrame -kehysolion
    public JFrame haeKehys() {
        return kehys;
    }
    

}
