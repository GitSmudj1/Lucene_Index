package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.BadLocationException;

import model.DataSet;
import view.FinalResults;

public class ToggleListener implements ActionListener {
	
	String fullDoc;
	String partDoc;
	DataSet dataSet;
	String[] query;
	String fileName;
	boolean isFullDoc;
	
	FinalResults view;
	
	public ToggleListener(FinalResults view, String fullDoc, String partDoc, DataSet dataSet, String[] query, String fileName, boolean isFullDoc) {
		
		this.view = view;
		
		this.fullDoc = fullDoc;
		this.partDoc = partDoc;
		this.dataSet = dataSet;
		this.query = query;
		this.fileName = fileName;
		this.isFullDoc = !isFullDoc;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			new FinalResults(fullDoc, partDoc, dataSet, query, fileName, isFullDoc);
			
			view.setVisible(false);
			view.dispose();
			
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
