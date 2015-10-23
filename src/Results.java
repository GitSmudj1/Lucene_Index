

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class Results extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Results() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
		);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Result1", null, panel_2, null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Content of results1");
		panel_2.add(textPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Result2", null, panel, null);
		
		JTextPane textPane1 = new JTextPane();
		textPane1.setText("Content of results2");
		panel.add(textPane1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Result3", null, panel_1, null);
		contentPane.setLayout(gl_contentPane);
		
		JTextPane textPane2 = new JTextPane();
		textPane2.setText("Content of results3");
		panel_1.add(textPane2);
		
		
		
		
		
	}
}
