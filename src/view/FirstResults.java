package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ResultsListener;
import controller.RunListener;
import model.DataSet;
import model.Results;

public class FirstResults extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;
	public MouseListener catListener;
	public MouseListener resListener;
	
	private Results results;
	private List<String> categoryList;
	
	private JList res;
	
	private JScrollPane resPane;
	
	private DataSet dataSet;
	
	private List<String> fileNames;
	
	private String searchTerm;

	/**
	 * Create the frame.
	 */
	public FirstResults(Results results, DataSet dataSet, String searchTerm) {
		
		this.searchTerm = searchTerm;
		fileNames = new ArrayList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		listener = new RunListener(this, dataSet);
		
		this.results = results;
		categoryList = results.getKeys();
		
		JList<String> cat = new JList(categoryList.toArray());

		JScrollPane catPane = new JScrollPane(cat);
		
		res = new JList();
		
		resPane = new JScrollPane(res);
		
		resListener = new ResultsListener(this, categoryList, dataSet, 2);
		catListener = new ResultsListener(this, categoryList, dataSet, 1);

		res.addMouseListener(resListener);
		cat.addMouseListener(catListener);

		JButton button = new JButton("Home");
		button.addActionListener(listener);
		
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
		
		System.out.println("In Set Res");
		
		System.out.println("FileNames: " + fileNames.toString());
		
		//res = new JList();
		
		res.setListData(fileNames.toArray());
		
		this.repaint();
		
	}
	
	public void setFileName(List<String> fileNames) {
		
		this.fileNames = fileNames;
		
	}
	
	public List<String> getFileNames() {
		
		return fileNames;
		
	}
	
	public String getQuery(){
		return searchTerm;
	}
	
}
