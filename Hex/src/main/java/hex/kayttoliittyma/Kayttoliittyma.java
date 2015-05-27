/**
 * ALUSTAVAA KOKEILUA
 *
 * @author ppnauman
 */
package hex.kayttoliittyma;

import hex.logiikka.Pelilauta;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    //private Piirtoalusta piirtoalusta;
    private Pelilauta lauta;

    public Kayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
    }

    @Override
    public void run() {
        frame = new JFrame("Game of Hex");
        
        
        frame.setLayout(null);
        asetaPaikka(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        int[] x = {0, 0, 26, 52, 52, 26};
        int[] y = {45, 15, 0, 15, 45, 60};
        container.setBackground(Color.BLACK);
        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                KuusikRuutu hexButt = new KuusikRuutu(x, y);
                hexButt.addMouseListener(new KuusikRuudunKuuntelija());
                container.add(hexButt);
                hexButt.setBounds(this.lauta.haeMonikulmio(i, j).haeX(), this.lauta.haeMonikulmio(i, j).haeY(), 52, 60);
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
    
    /*asettaa peli-ikkunan leveydeksi 80% näytön leveydestä, korkeudeksi 90% näytön korkeudesta
    ja asettaa ikkunan keskelle näyttöä.*/
    private void asetaPaikka (JFrame kehys) {
        Dimension naytonKoko = Toolkit.getDefaultToolkit().getScreenSize();
        int korkeus = (int)naytonKoko.height/10*9;
        int leveys = (int)naytonKoko.width/10*8;
        int y = naytonKoko.height/100*5;
        int x = naytonKoko.width/100*10;
        kehys.setLocation(x, y);
        kehys.setPreferredSize(new Dimension(leveys,korkeus));
    }
    

}
