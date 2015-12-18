package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import controller.RunListener;
import model.DataSet;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelpScreen extends JFrame {

	private JPanel contentPane;
	private ActionListener listener;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HelpScreen frame = new HelpScreen(DataSet dataSet);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HelpScreen(DataSet dataSet) {
		
		listener = new RunListener(this, dataSet);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		

		panel.setLayout( new BorderLayout() );
		scrollPane.setViewportView(textArea);
		panel.add( scrollPane, BorderLayout.CENTER );
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(listener);



		//JButton btnNewButton = new JButton("Close");
		//btnNewButton.addActionListener(listener);

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
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addContainerGap())
		);


		contentPane.setLayout(gl_contentPane);

		this.setVisible(true);

	}
}
