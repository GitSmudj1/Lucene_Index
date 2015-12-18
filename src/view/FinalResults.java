package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Scrollable;

import controller.RunListener;
import controller.ToggleListener;
import model.DataSet;
import javax.swing.JScrollPane;

import javax.swing.*;

public class FinalResults extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;

	private DataSet dataSet;

	/**
	 * Create the frame.
	 * @throws BadLocationException 
	 */
	public FinalResults(String fullDoc, String partDoc, DataSet dataSet, String[] query, String fileName, boolean isFullDoc) throws BadLocationException {

		this.dataSet = dataSet;
		this.setTitle(fileName);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		listener = new RunListener(this, dataSet);

		JPanel panel = new JPanel();
		JButton toggleButton = new JButton();
		
		if(isFullDoc) {
			toggleButton.setText("Full Doc");
		} else {
			toggleButton.setText("Category");
		}
		
		toggleButton.addActionListener(new ToggleListener(this, fullDoc, partDoc, dataSet, query, fileName, isFullDoc));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextArea textArea = new JTextArea();
		
		String textAreaContent = "";
		
		if(isFullDoc) {
			textAreaContent = fullDoc;
		} else {
			textAreaContent = partDoc;
		}
		
		textArea.setText(textAreaContent);
		
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		Highlighter highlighter = textArea.getHighlighter();

		for(int i = 0; i < query.length; i++) {
			
			String termLowerCase = query[i].toLowerCase();
			String termUpperCase = termLowerCase.toUpperCase();
			String termMixedCase = termLowerCase.substring(0, 1).toUpperCase() + termLowerCase.substring(1);
			
			String terms[] = {termLowerCase, termUpperCase, termMixedCase};
			
			for(int j = 0; j < terms.length; j++) {
				
				String currentTerm = terms[j];
				
				System.out.println("The Current Term: " + currentTerm);
		
				int index = textAreaContent.indexOf(currentTerm);
				while ( index >= 0 ) {
					int len = currentTerm.length();
					highlighter.addHighlight(index, index+len, DefaultHighlighter.DefaultPainter);
					index = textAreaContent.indexOf(currentTerm, index+len);
				}
			
			}
		
		}

		panel.setLayout( new BorderLayout() );
		scrollPane.setViewportView(textArea);
		panel.add( scrollPane, BorderLayout.CENTER );
		scrollPane.setViewportView(textArea);
		panel.setLayout(new BorderLayout());
		panel.add( scrollPane, BorderLayout.CENTER );

		
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(listener);
		
		


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toggleButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(toggleButton)))
					.addContainerGap())
		);


		contentPane.setLayout(gl_contentPane);

		this.setVisible(true);

	}
}
