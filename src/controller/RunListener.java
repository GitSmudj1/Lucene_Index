package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FirstResults;
import view.SearchEngine;

//import model.DataModel;

public class RunListener implements ActionListener{

//	private DataModel model;
//	
//	public RunListener(DataModel m){
//		model = m;
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()){
		case "Go":
			new FirstResults().setVisible(true);
			//insert method to be called to display the data
			//Testing
			System.out.println("Go Button Pressed");
			break;
		case "Home":
			new SearchEngine().setVisible(true);
			//Testing
			System.out.println("Home Button Pressed");
			break;
		case "Back":
			new FirstResults().setVisible(true);
			//Testing
			System.out.println("Back Button Pressed");
			
		}
	}


}
