

package hex.kayttoliittyma;

import hex.logiikka.HexPinta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *Pelin pääikkuna, johon piirtyy ja päivittyy kuva pelilaudasta.
 *Pelaajat lisäävät vuorollaan pelilaudalle kuusikulmioita hiiren avulla.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame kehys;
    private HexPinta peli;
    private Dimension naytonKoko;
    private JLabel info;
    private MouseListener ruudunKuuntelija;
    
    /**
     * Konstruktori, jolle annetaan parametrina HexPinta -rajapinnan toteuttava
     * logiikkaolio, jonka avulla Käyttöliittymä voi kommunikoida sovelluslogiikan kanssa.
     * 
     * @param peli 
     */
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
        
        luoInfo(container);
        luoMonikulmiot(container, lev, kork, rako);
        
      
    }
    
    /**
     * Asettaa peli-ikkunaan, pelilaudan yläreunassa sijaitsevaan info-palkkiin parametrina
     * annetun tekstin parametrina annetulla värillä.
     * 
     * @param vari tulosteen väri
     * @param teksti tulostettava teksti
     */
    public void kirjoitaInfoon(Color vari, String teksti) {
        this.info.setForeground(vari);
        this.info.setText(teksti);
    }
    
    /*asettaa peli-ikkunan korkeudeksi 90% näytön korkeudesta, leveydeksi
    1,3krt korkeuden verran
    ja sijoittaa peli-ikkunan keskelle näyttöä.*/
    private void asetaKehyksenPaikka (JFrame kehys) {
        int korkeus = (int)naytonKoko.height/10*9;
        int leveys = korkeus/10*13;
        int y = (naytonKoko.height-korkeus)/2;
        int x = (naytonKoko.width-leveys)/2;
        kehys.setLocation(x, y);
        kehys.setPreferredSize(new Dimension(leveys,korkeus));
    }
    
    //luo pelilaudan eli sen muodostavat MonikRuutu -oliot ja lisää ne parametrina annettavaan oliosäiliöön
    private void luoMonikulmiot(Container container, int lev, int kork, int rako) {
                
        //luodaan muodot
        Polygon kuusik = kuusik(lev, kork);
        Polygon vasViisik = vasViisik(lev, kork);
        Polygon oikViisik = oikViisik(lev, kork);
        Polygon alaViisik = alaViisik(lev, kork);
        Polygon ylaViisik = ylaViisik(lev, kork);
        Polygon vasYlakulma = vasYlakulma(lev,kork);
        Polygon vasAlakulma = vasAlakulma(lev,kork);
        Polygon oikYlakulma = oikYlakulma(lev,kork);
        Polygon oikAlakulma = oikAlakulma(lev,kork);
        
        //luodaan kulmikkaat JButton-objektit, yksi jokaista laudan peliruutua kohti.
        int paikka = 0;
        ruudunKuuntelija = new KuusikRuudunKuuntelija(this.peli, this);
        for (int i = 0; i < peli.laudanKoko(); i++) {
            for (int j = 0; j < peli.laudanKoko(); j++) {
                MonikRuutu ruutu;
                if(i==0 && j==0 ) {
                    ruutu = new MonikRuutu(paikka, vasYlakulma, peli.pelaaja1vari());
                }
                else if(i==peli.laudanKoko()-1 && j==0) {
                    ruutu = new MonikRuutu(paikka, vasAlakulma, peli.pelaaja1vari());
                }
                else if(i==0 && j==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, oikYlakulma, peli.pelaaja1vari());
                }
                else if(i==peli.laudanKoko()-1 && j==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, oikAlakulma, peli.pelaaja1vari());
                }
                else if(j==0) {
                    ruutu = new MonikRuutu(paikka, vasViisik, peli.pelaaja1vari());
                }
                else if(j==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, oikViisik, peli.pelaaja1vari());
                }
                else if(i==0) {
                    ruutu = new MonikRuutu(paikka, ylaViisik, peli.pelaaja2vari());
                }
                else if(i==peli.laudanKoko()-1) {
                    ruutu = new MonikRuutu(paikka, alaViisik, peli.pelaaja2vari());
                }
                else {
                    ruutu = new MonikRuutu(paikka, kuusik, Color.LIGHT_GRAY);
                    ruutu.addMouseListener(ruudunKuuntelija);
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
    
    private Polygon vasYlakulma(int leveys, int korkeus) {
        int[] x = { leveys, leveys, leveys/2,};
        int[] y = { korkeus/4, korkeus-korkeus/4, korkeus };
        return new Polygon(x, y, 3);
    }
    
    private Polygon vasAlakulma(int leveys, int korkeus) {
        int[] x = { 0, leveys/2, leveys, leveys, };
        int[] y = { korkeus/4, 0, korkeus/4, korkeus-korkeus/4, };
        return new Polygon(x, y, 4);
    }
    
    private Polygon oikYlakulma(int leveys, int korkeus) {
        int[] x = { 0, 0, leveys, leveys/2,};
        int[] y = { korkeus-korkeus/4, korkeus/4, korkeus-korkeus/4, korkeus };
        return new Polygon(x, y, 4);
    }
    
    private Polygon oikAlakulma(int leveys, int korkeus) {
        int[] x = { 0, 0, leveys/2, };
        int[] y = { korkeus-korkeus/4, korkeus/4, 0, };
        return new Polygon(x, y, 3);
    }
    
    private void luoInfo(Container container) {
        info = new JLabel(peli.nimiNytVuorossa()+" – it's your move");
        container.add(info);
        info.setForeground(peli.variNytVuorossa());
        Font f = new Font("Sans",Font.BOLD, 14);
        info.setFont(f);
        info.setBounds(60, 62, 500, 28);
    }
    
    private int maaritaKulmionKork() {
        if(this.naytonKoko.height > 800) {
            return 68;
        }
        else if(this.naytonKoko.height < 800 && this.naytonKoko.height > 600) {
            return 48;
        }
        else {
            return 36;
        }
    }
    
    private Rectangle ruudunPaikka(int i, int j, int kork, int lev, int rako) {
        int x = 15 + i*(lev/2+rako/2) + j*(lev+rako);
        int y = 80 + i*(kork/4*3+rako);
        return new Rectangle (x, y, lev, kork);
    }
    
    /**
     * Poistaa tapahtumankuuntelijat kaikilta Kayttoliittyma-ikkunan komponenteilta
     * eli 'jäädyttää' tilanteen pelilaudalla. Käytetään esim. silloin kun peli
     * on ratkennut, eikä haluta pelaajien enää lisäävään kuusikulmioita Kayttoliittyma-
     * ikkunan kautta.
     */
    public void poistaKuuntelijat() {
        Component[] komp = this.kehys.getContentPane().getComponents();
        for(int i=0; i<komp.length; i++) {
            komp[i].removeMouseListener(ruudunKuuntelija);
        }
    }
    
    /**
     * Palauttaa Kayttoliittyma:n JLabel -tyyppisen infokenttäkomponentin.
     * @return käyttöliittymän infokenttä
     */
    public JLabel haeInfo() {
        return this.info;
    }
    
    /**
     * Palauttaa Kayttoliittyma:n JFrame- kehyksen.
     * @return Kayttoliittyma:n JFrame säiliö
     */
    public JFrame haeKehys() {
        return kehys;
    }
    

}
