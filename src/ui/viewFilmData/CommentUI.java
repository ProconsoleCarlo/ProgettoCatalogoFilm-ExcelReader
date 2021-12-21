package ui.viewFilmData;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.GridBagBuilder;

public class CommentUI extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
		
	public CommentUI(Object date, String comment) {
		super();
		realize(date, comment);
	}

	/*
	 * Cercare di fare le misure dinamiche, nel senso che sono in funzione della dimensione del pannello in cui si trova
	 * settando come minimumSize quella che setto per ora come preferred
	 */
	private void realize(Object date, String comment) {
		JLabel dateLabel = new JLabel((String)date);
		bagBuilder.add(dateLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		JLabel commentLabel = new JLabel(comment);
		bagBuilder.add(commentLabel, 1, 0, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}	
}
