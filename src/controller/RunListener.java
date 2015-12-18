package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.DataSet;
import model.Results;
import search.Search;
import view.FirstResults;
import view.SearchEngine;

//import model.DataModel;

public class RunListener implements ActionListener {

	private JFrame view;
	private DataSet dataSet; 
	
	public RunListener(JFrame view, DataSet dataSet) {
		this.dataSet = dataSet;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
		case "Go":
			//insert method to be called to display the data
			//Testing
			
			SearchEngine searchEngine = (SearchEngine) view;
			
			String searchTerm = searchEngine.getTextField().getText().toString();
			
			Results results = new Results();
			results.setResults(new Search().searchForQuery(searchTerm));
			
			new FirstResults(results, dataSet, searchTerm).setVisible(true);
			
			view.setVisible(false);
			view.dispose();
			
			System.out.println("Go Button Pressed");
			break;
		case "Home":
			new SearchEngine(dataSet).setVisible(true);
			view.setVisible(false);
			view.dispose();
			System.out.println("Home Button Pressed");
			break;
		case "Close":
<<<<<<< Updated upstream
=======
			//new FirstResults().setVisible(true);
			//Testing
>>>>>>> Stashed changes
			view.setVisible(false);
			view.dispose();
			System.out.println("Back Button Pressed");
			
		}
	}


}
