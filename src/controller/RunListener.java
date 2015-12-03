package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Results;
import search.Search;
import view.FirstResults;
import view.SearchEngine;

//import model.DataModel;

public class RunListener implements ActionListener {

	JFrame view;
	
	public RunListener(JFrame view) {
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
			
			new FirstResults(results).setVisible(true);
			
			view.setVisible(false);
			view.dispose();
			
			System.out.println("Go Button Pressed");
			break;
		case "Home":
			new SearchEngine().setVisible(true);
			//Testing
			System.out.println("Home Button Pressed");
			break;
		case "Back":
			//new FirstResults().setVisible(true);
			//Testing
			System.out.println("Back Button Pressed");
			
		}
	}


}
