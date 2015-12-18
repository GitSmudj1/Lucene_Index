package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.HelpListener;
import controller.RunListener;
import model.DataSet;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchEngine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ActionListener listener;
	
	private DataSet dataSet;

	/**
	 * Create the frame.
	 */
	public SearchEngine(DataSet dataSet) {
		
		this.dataSet = dataSet;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		listener = new RunListener(this, dataSet);
		
		JPanel panel = new JPanel();
		//panel.setLayout(BorderLayout.CENTER );
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Federal Register Data Searcher");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		textField = new JTextField();
		textField.setToolTipText("Search...");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go");
		
		JButton button = new JButton("Help");
		button.addActionListener(new HelpListener(this, dataSet));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(129, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(121))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(178))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(57)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnNewButton.addActionListener(listener);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JTextField getTextField() {
		return textField;
	}
}
