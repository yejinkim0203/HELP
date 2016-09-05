
package kr.or.bookdream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CategoryDB {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JList list1;
	private JList list2;
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	private Vector<Category1> vc1;//DB 가져온 정보
	private Vector<String> cat1; // DB 정보 중 NAME 만
	private Vector<Category2> vc2;
	private Vector<String> cat2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryDB window = new CategoryDB();
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
	public CategoryDB() {
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
		
		vc1= new Vector<Category1>();
		cat1 = new Vector<String>();
		
		list1 = new JList(cat1);
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
				String input_text = tf1.getText();
//				cat1.addElement(input_text);
				insCatagory1(input_text);
				CallDB();
				list1.updateUI();
				
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
		
		vc2= new Vector<Category2>();
		cat2 = new Vector<String>();
		
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
	CallDB();
	}
	
	
	public void CallDB(){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery("select no, name from category1 order by no");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vc1.removeAllElements();
		cat1.clear();
		try {
			while(rs.next()){
				vc1.add(new Category1(rs.getInt("no"), rs.getString("name")));
				cat1.add(rs.getString("name"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insCatagory1(String name){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		String sql = "insert into category1(name) values(?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		public void insCatagory2(int no, String name){
			DBConn dbconn = new DBConn();
			Connection conn = dbconn.getConnection();
			String sql = "insert into category2(name,category1_no) values(?,?)";
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.setInt(2, no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.setString(1, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
