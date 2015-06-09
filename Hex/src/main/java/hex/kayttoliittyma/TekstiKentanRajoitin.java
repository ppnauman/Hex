
package hex.kayttoliittyma;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ppnauman
 */
public class TekstiKentanRajoitin extends PlainDocument {
    
    private int pituusRaja;
    
    public TekstiKentanRajoitin(int pituusRaja) {
        super();
        this.pituusRaja = pituusRaja;
    }
    
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= pituusRaja) {
      super.insertString(offset, str, attr);
    }
  }
    
    
            
           
}
