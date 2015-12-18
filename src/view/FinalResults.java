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
	public FinalResults(String panelContent, DataSet dataSet, String query) throws BadLocationException {

		this.dataSet = dataSet;
<<<<<<< HEAD

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
		
<<<<<<< HEAD
=======
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
>>>>>>> master
>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		listener = new RunListener(this, dataSet);

		JPanel panel = new JPanel();
<<<<<<< Updated upstream
		JScrollPane scrollPane = new JScrollPane();
		JTextArea textArea = new JTextArea(panelContent);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		Highlighter highlighter = textArea.getHighlighter();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19
		int index = panelContent.indexOf(query);
		while ( index >= 0 ) {
			int len = query.length();
			highlighter.addHighlight(index, index+len, DefaultHighlighter.DefaultPainter);
			index = panelContent.indexOf(query, index+len);
		}
<<<<<<< HEAD
=======

		panel.setLayout( new BorderLayout() );
		scrollPane.getViewport().add( textArea );
		panel.add( scrollPane, BorderLayout.CENTER );



		//JButton btnNewButton = new JButton("Close");
		//btnNewButton.addActionListener(listener);

=======
	      HighlightPainter painter = 
	             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
	      int p0 = panelContent.indexOf("date");
	      int p1 = p0 + "date".length();
	      highlighter.addHighlight(p0, p1, painter );
	      
	      panel.setLayout( new BorderLayout() );
	      scrollPane.getViewport().add( textArea );
			panel.add( scrollPane, BorderLayout.CENTER );
		
>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19

		panel.setLayout( new BorderLayout() );
		scrollPane.getViewport().add( textArea );
		panel.add( scrollPane, BorderLayout.CENTER );
		scrollPane.getViewport().add( textArea );
		panel.setLayout(new BorderLayout());
		panel.add( scrollPane, BorderLayout.CENTER );
		
=======
		
	
		
		
		JTextArea textArea = new JTextArea(panelContent);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setViewportView(textArea);
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setBounds(5, 5, 100, 100);
//		panel.add(scrollPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add( textArea );
		panel.setLayout(new BorderLayout());
		panel.add( scrollPane, BorderLayout.CENTER );
		
		
>>>>>>> Stashed changes
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(listener);
		
>>>>>>> master
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(21)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
<<<<<<< HEAD
=======
										//.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19
										))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
<<<<<<< HEAD
=======
						//.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19
						.addGap(12)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
						.addContainerGap())
				);

<<<<<<< HEAD
=======

>>>>>>> d0947156a8b2c7c826858b146f4c028cd2720e19
		contentPane.setLayout(gl_contentPane);

		this.setVisible(true);

	}
}
