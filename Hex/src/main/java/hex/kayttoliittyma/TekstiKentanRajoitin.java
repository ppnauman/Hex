
package hex.kayttoliittyma;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Javan PlainDocument -luokan aliluokka, joka kuvaa pituudeltaan rajoitetun dokumentin.
 * Tätä luokkaa käytetään käyttöliittymän JTextField -tyyppisten tekstikenttien pituuden rajaamiseen.
 */
public class TekstiKentanRajoitin extends PlainDocument {
    
    private int pituusRaja;
    
    /**
     * Konstruktori, jonka parametrina annetaan kentän haluttu maksimipituus merkkeinä.
     * 
     * @param pituusRaja maksimipituus merkkeinä
     */
    public TekstiKentanRajoitin(int pituusRaja) {
        super();
        this.pituusRaja = pituusRaja;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= pituusRaja) {
            super.insertString(offset, str, attr);
        }
    }             
}
