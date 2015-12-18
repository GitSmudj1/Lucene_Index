package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DataSet;
import view.HelpScreen;
import view.SearchEngine;

public class HelpListener implements ActionListener {
	
	SearchEngine view;
	DataSet dataSet;
	
	public HelpListener(SearchEngine view, DataSet dataSet) {
		
		this.view = view;
		this.dataSet = dataSet;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new HelpScreen(dataSet).setVisible(true);
		view.setVisible(false);
		view.dispose();
		
	}

}
