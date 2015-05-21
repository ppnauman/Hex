/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ppnauman
 */
package hex.kayttoliittyma;
 
import hex.logiikka.Kuusikulmio;
import hex.logiikka.Pelilauta;
import java.awt.Container;
import java.awt.Dimension;
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
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
 
        frame.pack();
        frame.setVisible(true);
    }
 
    private void luoKomponentit(Container container) {
        
                int [] x = this.lauta.haeRuutu(1, 1).haeXt();
                int[] y = this.lauta.haeRuutu(1, 1).haeYt();
                KuusikRuutu hexButt = new KuusikRuutu(x,y);
                hexButt.addMouseListener(new KuusikRuudunKuuntelija());
                container.add(hexButt);
                hexButt.setBounds(0,0,52,60);
                
        }
        
    
 
    
 
    public JFrame getFrame() {
        return frame;
    }
}
