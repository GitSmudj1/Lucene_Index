package controller;

import model.DataSet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.MouseInputListener;

import view.FirstResults;

public class ResultsListener implements MouseListener{

	private FirstResults list;
	private JFrame view;
	private List<String> categoryList;
	
	public ResultsListener(JFrame view, List<String> categorylist) {
		this.view = view;
		this.categoryList = categoryList;
		
		System.out.println("Cat List: " + categoryList.toString());
		
	}
	
	public void mouseClicked(MouseEvent evt) {

		JList list = (JList)evt.getSource();
		if (evt.getClickCount() == 2){
			//Double-click detection
			int index = list.locationToIndex(evt.getPoint());
			System.out.println(index);
			
			String selectedCat = categoryList.get(index);
			
			System.out.println("Category: " + selectedCat);
			
			FirstResults fResults = (FirstResults) view;
			
			List<String> fileNames = fResults.getResults().getResults(selectedCat);
			
			fResults.setRes(fileNames);
			
//			if(index == 0){
//				DataModel.getTitle();
//			}
//			if(index == 1){
//            	DataModel.getDate();
//            }
//            if(index == 2){
//            	DataModel.getAgency();
//            }
            
        } else if (evt.getClickCount() == 3) {

            // Triple-click detected
            int index = list.locationToIndex(evt.getPoint());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
