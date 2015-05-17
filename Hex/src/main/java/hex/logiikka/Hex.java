/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hex.logiikka;

/**
 *
 * @author ppnauman
 */
public class Hex {
    
    public static void main (String[] args) {
        
        //testituloste: testataan union-find -rakenteen konstruktorin toimintaa
        HexTarkastaja t = new HexTarkastaja(11);

        System.out.println(t);
        
        String s = t.ketjujenKoot();
        System.out.println(s);
       
    }
}
    

