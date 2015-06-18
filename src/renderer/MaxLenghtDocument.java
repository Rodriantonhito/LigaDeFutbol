
package renderer;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MaxLenghtDocument extends PlainDocument{

    private int maxLength;
    
    
    public MaxLenghtDocument(int maxLength){
        this.maxLength = maxLength;
    }
   
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
    
        if(getLength() + str.length() <= maxLength){
            super.insertString(offs, str, a);
        }
    }
    
    
}
