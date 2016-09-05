
package kr.or.bookdream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Category {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JList list1;
	private JList list2;
	private JScrollPane jsp1;
	private JScrollPane jsp2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category window = new Category();
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
	public Category() {
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
		
		list1 = new JList();
//		list1.setBounds(40, 70, 450, 400);
//		frame.getContentPane().add(list1);
		
		jsp1 = new JScrollPane(list1);
		jsp1.setBounds(40, 70, 450, 400);
		frame.getContentPane().add(jsp1);
		
		tf1 = new JTextField();
		tf1.setBounds(40, 500, 450, 40);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JButton btnINS1 = new JButton("INS");
		btnINS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnINS1.setBounds(40, 570, 200, 40);
		frame.getContentPane().add(btnINS1);
		
		JButton btnDEL1 = new JButton("DEL");
		btnDEL1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDEL1.setBounds(290, 570, 200, 40);
		frame.getContentPane().add(btnDEL1);
		
		list2 = new JList();
//		list2.setBounds(520, 70, 450, 400);
//		frame.getContentPane().add(list2);
		
		jsp2 = new JScrollPane(list2);
		jsp2.setBounds(520, 70, 450, 400);
		frame.getContentPane().add(jsp2);
		
		tf2 = new JTextField();
		tf2.setBounds(520, 500, 450, 40);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JButton btnINS2 = new JButton("INS");
		btnINS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnINS2.setBounds(520, 570, 200, 40);
		frame.getContentPane().add(btnINS2);
		
		JButton btnDEL2 = new JButton("DEL");
		btnDEL2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDEL2.setBounds(767, 570, 200, 40);
		frame.getContentPane().add(btnDEL2);
	}
}
