package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.event.MouseInputListener;

import model.DataModel;
import view.FirstResults;

public class ResultsListener implements MouseListener{

	private FirstResults list;
	@Override
	public void mouseClicked(MouseEvent evt) {

		JList list = (JList)evt.getSource();
		if (evt.getClickCount() == 2){
			//Double-click detection
			int index = list.locationToIndex(evt.getPoint());
			System.out.println(index);
			
			if(index == 0){
				DataModel.getTitle();
			}
			if(index == 1){
            	DataModel.getDate();
            }
            if(index == 2){
            	DataModel.getAgency();
            }
            
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
