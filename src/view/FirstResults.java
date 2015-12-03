package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ResultsListener;
import controller.RunListener;
import model.Results;

public class FirstResults extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;
	private MouseListener ml;
	
	private Results results;
	private List<String> categoryList;
	
	private JList res;

	/**
	 * Create the frame.
	 */
	public FirstResults(Results results) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		listener = new RunListener(this);
		

		String label[] = { "Title", "Date", "Author"};

		String labelTitle[] = { "Title1", "Title2", "Title3"};
		
		String labelDate[] = { "Date1", "Date2", "Date3"};
		
		String labelAuthor[] = { "Author1", "Author2", "Author3"};
		
		this.results = results;
		categoryList = results.getKeys();
		
		System.out.println("Cat List: " + categoryList.toString());
		
		JList cat = new JList(categoryList.toArray());
		res = new JList();

		JScrollPane catPane = new JScrollPane(cat);
		JScrollPane resPane = new JScrollPane(res);
		
		ml = new ResultsListener(this, categoryList);

		cat.addMouseListener(ml);
//		list.addMouseListener(new MouseAdapter() {
//		    public void mouseClicked(MouseEvent evt) {
//		        JList list = (JList)evt.getSource();
//		        if (evt.getClickCount() == 2) {
//
//		            // Double-click detected
//		            int index = list.locationToIndex(evt.getPoint());
//		            System.out.println(index);
//		            if(index == 0){
//		            	scrollPane_1.setViewportView(titleList);
//		            }
//		            if(index == 1){
//		            	scrollPane_1.setViewportView(dateList);
//		            }
//		            if(index == 2){
//		            	scrollPane_1.setViewportView(authorList);
//		            }
//		            
//		        } else if (evt.getClickCount() == 3) {
//
//		            // Triple-click detected
//		            int index = list.locationToIndex(evt.getPoint());
//		        }
//		    }
//		});





		JButton button = new JButton("Home");
		button.addActionListener(listener);
//		(new ActionListener() 
//		{
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new SearchEngine().setVisible(true);
//
//
//			}
//		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(20)
										.addComponent(catPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(resPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(24, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(resPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addComponent(catPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);

	}
	
	public Results getResults() {
		
		return results;
		
	}
	
	public void setRes(List<String> fileNames) {
		res = new JList(fileNames.toArray());
	}
	
}
