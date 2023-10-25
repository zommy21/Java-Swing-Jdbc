package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setBounds(300, 11, 136, 30);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 22));
		contentPane.add(lblDashboard);
		
		JButton btnNewButton = new JButton("BOOK AVAILABLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book_Available books = new Book_Available();
				books.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(92, 83, 194, 47);
		contentPane.add(btnNewButton);
		
		JButton btnAddBook = new JButton("ADD BOOK");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Book books = new Add_Book();
				books.setVisible(true);
			}
		});
		btnAddBook.setForeground(Color.BLACK);
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddBook.setBounds(92, 179, 194, 47);
		contentPane.add(btnAddBook);
		
		JButton btnRemoveBook = new JButton("REMOVE BOOK");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_Book books = new Delete_Book();
				books.setVisible(true);
			}
		});
		btnRemoveBook.setForeground(Color.BLACK);
		btnRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveBook.setBounds(92, 279, 194, 47);
		contentPane.add(btnRemoveBook);
		
		JButton btnStaffDetails = new JButton("STAFF DETAILS");
		btnStaffDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_Details staffs = new Staff_Details();
				staffs.setVisible(true);
			}
		});
		btnStaffDetails.setForeground(Color.BLACK);
		btnStaffDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStaffDetails.setBounds(450, 83, 194, 47);
		contentPane.add(btnStaffDetails);
		
		JButton btnNewButton_1_1 = new JButton("ADD STAFF");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Staff staffs = new Add_Staff();
				staffs.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(450, 179, 194, 47);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("REMOVE STAFF");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Staff staffs = new Remove_Staff();
				staffs.setVisible(true);
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(450, 279, 194, 47);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("EDIT ADMIN");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit_Admin admin = new Edit_Admin();
				admin.setVisible(true);
			}
		});
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_1_1.setBounds(265, 377, 194, 47);
		contentPane.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel.setBounds(0, 0, 764, 461);
		contentPane.add(lblNewLabel);
	}
}
