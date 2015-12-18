package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.text.BadLocationException;

import model.DataSet;
import model.Doc;
import view.FinalResults;
import view.FirstResults;

public class ResultsListener implements MouseListener {

	private FirstResults list;
	private JFrame view;
	private DataSet dataSet;
	private String selectedCat;
	private List<String> categoryList = new ArrayList<String>();
	private List<String> fileNames;
	private int pane = 0;
	
	public ResultsListener(JFrame view, List<String> categoryList, DataSet dataSet, int pane) {
		
		this.pane = pane;
		
		this.dataSet = dataSet;
		this.view = view;
		this.categoryList = categoryList;
		
		System.out.println("Cat List: " + categoryList.toString());
		
	}
	
	public void mouseClicked(MouseEvent evt) {
		
		FirstResults fResults = (FirstResults) view;
		
		if(pane == 2) {
			
			System.out.println("pane 2");
		
			if(evt.getClickCount() == 1) {
				
				JList eventList = (JList)evt.getSource();
				
				int index = eventList.locationToIndex(evt.getPoint());
				
				System.out.println("Index: " + index);
				
				String selectedFile = fResults.getFileNames().get(index);
				
				Doc result = dataSet.getArticle(selectedFile);
				
				try {
					new FinalResults(result.getEntireDoc(), dataSet, fResults.getQuery());
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				
			}
			
		} else if (pane == 1) {
			
			System.out.println("pane 1");
			
			if (evt.getClickCount() == 1) {
				
				JList eventList = (JList)evt.getSource();
				
				int index = eventList.locationToIndex(evt.getPoint());
				
				selectedCat = categoryList.get(index);
				
				System.out.println("Category: " + selectedCat);
				
				fileNames = new ArrayList<String>();
				
				fileNames = fResults.getResults().getResults(selectedCat);
				
				fResults.setFileName(fileNames);
				fResults.setRes(fileNames);
				
	            
	        }
			
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
