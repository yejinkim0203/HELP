package kr.or.bookdream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HomeMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMain window = new HomeMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(40, 80, 450, 500);
		frame.getContentPane().add(tabbedPane);
		
		JPanel myPanel = new JPanel();
		tabbedPane.addTab("New tab", null, myPanel, null);
		
		JPanel historyPanel = new JPanel();
		tabbedPane.addTab("New tab", null, historyPanel, null);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("New tab", null, homePanel, null);
		
		JPanel detailPanel = new JPanel();
//		detailPanel.setBounds(520, 100, 450, 480);

		detailPanel.setLayout(new BorderLayout());
		detailPanel.add(new HomeDetail());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 200, 400, 350);
		frame.getContentPane().add(scrollPane);
		
//		JPanel detailPanel = new JPanel();
//		detailPanel.setBounds(520, 100, 450, 480);
//		frame.getContentPane().add(detailPanel);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(520, 100, 450, 480);
		scrollPane1.setViewportView(detailPanel);
		frame.getContentPane().add(scrollPane1);
		
	}
	
}

