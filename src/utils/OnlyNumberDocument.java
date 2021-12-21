package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * A plainDocument that permit to add only number in a textField.
 * It uses the method insertString of PlainDocument
 * @author Carlo Bobba
 */
public class OnlyNumberDocument extends PlainDocument{

	private static final long serialVersionUID = 1L;
	@Override
	public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
		try {
			if(Integer.parseInt(arg1) >= 0){
				super.insertString(arg0, arg1, arg2);
			}
		} catch (Exception e) {
			return;
		}
	}
}
