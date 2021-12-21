package tests;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.JComponentList;

public class TestJComponentList {

	public static void main(String[] args) throws Exception {
		
		JComponentList componentList = new JComponentList();
		ArrayList<JComponent> list = new ArrayList<>();
		Collections.addAll(list, 
				new JLabel("Diane Kruger"), 
				new JLabel("Penelope Cruz"), 
				new JLabel("Alexandra Daddario"), 
				new JLabel("Kate Hudson"), 
				new JLabel("Logan Lerman"),
				new JLabel("Matthew McConaughey"));
		componentList.setListElements(list);
		JFrame frame = new JFrame();
		frame.setSize(640, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(componentList);
//		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());
		frame.setVisible(true);
	}
	
	

}
