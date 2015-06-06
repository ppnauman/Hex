/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author perttu
 */
public class PeliPaattynyt implements Runnable {
    private JFrame kehys;
    private String voittaja;
    private Color vari;

    public PeliPaattynyt(String voittaja, Color vari) {
        this.voittaja = voittaja;
        this.vari = vari;
    }

    @Override
    public void run() {
        kehys = new JFrame("Game Over");
        kehys.setPreferredSize(new Dimension(400, 200));
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
        
        JLabel viesti = new JLabel(voittaja + " you've won the game!");
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
        c.fill=GridBagConstraints.HORIZONTAL;
        c.weighty=0.0;
        c.ipady=0;
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=1;
        c.anchor=GridBagConstraints.PAGE_END;
        container.add(uusiPeli, c);
        
        JButton tilasto = new JButton("ShowStats");
        c.gridx=1;
        c.gridy=1;
        c.gridwidth=1;
        container.add(tilasto, c);
        
        JButton lopetus = new JButton("Exit");
        lopetus.addActionListener(new LopetusKuuntelija());
        c.gridx=2;
        c.gridy=1;
        c.gridwidth=1;
        container.add(lopetus, c);
        
        
   
    }
}
