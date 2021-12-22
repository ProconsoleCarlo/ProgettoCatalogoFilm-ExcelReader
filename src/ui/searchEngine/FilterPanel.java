package ui.searchEngine;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.GridBagBuilder;

public class FilterPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridBagBuilder bagBuilder = new GridBagBuilder(this);
	private static int textLabelWidth = 200;
	private static int filterOptionsWidth = 100;
	private static int textFieldWidth = 200;
	private String filterName;
	private JTextField filterTextField = new JTextField();
	private JComboBox<String> filterOptionsComboBox;
	
	public FilterPanel(String filter) {
		realize(filter);
	}
	
	public String getFilterValue() {
		if (filterOptionsComboBox != null) {
			return filterName+":"+filterOptionsComboBox.getSelectedItem()+":"+filterTextField.getText();
		}else {
			return filterName+":"+":"+filterTextField.getText();
		}
	}
	
	private void realize(String filter) {
		String[] filterParameters = filter.split(":");
		filterName = filterParameters[0];
		
		JLabel filterLabel = new JLabel(filterParameters[0]);
		filterLabel.setPreferredSize(new Dimension(textLabelWidth, (int)filterLabel.getPreferredSize().getHeight()));
		bagBuilder.add(filterLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		
		if (filterParameters.length > 1) {
			String[] filterOptions = filterParameters[1].split(",");
			filterOptionsComboBox = new JComboBox<>(filterOptions);
			filterOptionsComboBox.setPreferredSize(new Dimension(filterOptionsWidth, (int)filterOptionsComboBox.getPreferredSize().getHeight()));
			bagBuilder.add(filterOptionsComboBox, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		}else {
			JLabel fillerLabel = new JLabel();
			fillerLabel.setPreferredSize(new Dimension(filterOptionsWidth, (int)fillerLabel.getPreferredSize().getHeight()));
			bagBuilder.add(fillerLabel, 1, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		}
		
		filterTextField.setPreferredSize(new Dimension(textFieldWidth, (int)filterTextField.getPreferredSize().getHeight()));
		bagBuilder.add(filterTextField, 2, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
	}

}
