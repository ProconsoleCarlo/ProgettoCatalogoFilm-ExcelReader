package utils;

import java.awt.GridBagConstraints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class JComponentList extends JScrollPane{


	private static final long serialVersionUID = 1L;
	private static JPanel panel = new JPanel();
	private GridBagBuilder bagBuilder = new GridBagBuilder(panel);
	
	public static int HORIZONTAL = 0;
	public static int VERTICAL = 1;
	private int elementsAligment = VERTICAL;
	private ArrayList<JComponent> listElements;
	
	public JComponentList() {
		super(panel);
	}
	public JComponentList(ArrayList<JComponent> listElements) {
		super(panel);
		setListElements(listElements);
	}
	
	public void setListElements(ArrayList<JComponent> listElements) {
		this.listElements = listElements;
		realize();
	}
	public void setElementsAligment(int elementsAligment) {
		this.elementsAligment = elementsAligment;
	}
	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize() {
		try {
			for (int i = 0; i < listElements.size(); i++) {
				//Caso verticale
				final int index = i;
				listElements.get(i).addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						System.err.println(listElements.get(index));
					}
				});
				if (elementsAligment == VERTICAL) {
					bagBuilder.add(listElements.get(i), 0, i, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
				}else if (elementsAligment == HORIZONTAL) {
					bagBuilder.add(listElements.get(i), i, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
				}
				
			}
		} catch (NullPointerException e) {
			//TODO System.err.println("None element in the list");
		}
	}
}
