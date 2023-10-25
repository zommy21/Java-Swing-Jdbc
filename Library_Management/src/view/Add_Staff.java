package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Add_Staff extends JFrame {

	private JPanel contentPane;
	private JTextField textbookid;
	private JTextField textcategory;
	private JTextField textname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Staff frame = new Add_Staff();
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
	public Add_Staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("STAFF ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(82, 109, 177, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NAME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(82, 181, 177, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONTACT");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(82, 253, 177, 39);
		contentPane.add(btnNewButton_2);
		
		textbookid = new JTextField();
		textbookid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textbookid.setBounds(303, 109, 331, 39);
		contentPane.add(textbookid);
		textbookid.setColumns(10);
		
		textcategory = new JTextField();
		textcategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textcategory.setColumns(10);
		textcategory.setBounds(303, 181, 331, 39);
		contentPane.add(textcategory);
		
		textname = new JTextField();
		textname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textname.setColumns(10);
		textname.setBounds(303, 253, 331, 39);
		contentPane.add(textname);
		
		JButton btnNewButton_5 = new JButton("ADD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffid = textbookid.getText();
				String name = textcategory.getText();
				String contact = textname.getText();
				int res = 0 ;
				
				try {
					// Step 1 : Create a connection
					Connection connection = database.JdbcUtil.getConnection();
					database.JdbcUtil.printInfo(connection);
					// Step 2 : Create a statement
					String sql = "insert into staffs(Staff_id,Name,Contact) values(?,?,?)";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, staffid);
		            statement.setString(2, name);
		            statement.setString(3, contact);
					
					// Step 3 : Execute a query SQL statement
		            res = statement.executeUpdate();
		            
		            // Step 4 : Process the result set
		            if(res > 0) {
		            	JOptionPane.showMessageDialog(null,"Add succesfully !");
		            }else JOptionPane.showMessageDialog(null,"Add failed !");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5.setBounds(160, 390, 135, 39);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("CANCEL");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1.setBounds(412, 390, 135, 39);
		contentPane.add(btnNewButton_5_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel.setBounds(0, 0, 764, 461);
		contentPane.add(lblNewLabel);
	}
}
