package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LibraryView extends JFrame {

	private JPanel contentPane;
	public JTextField txtusername;
	public JTextField txtpassword;
	public JLabel lblNewLabel;
	public JLabel lblUsername ;
	public JButton btnLogin;
	public JLabel lblNewLabel_1;
	public JLabel lblPassword ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryView frame = new LibraryView();
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
	public LibraryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = 	new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setBounds(200, 28, 425, 63);
		contentPane.add(lblNewLabel);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUsername.setBounds(134, 143, 152, 63);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPassword.setBounds(134, 248, 152, 63);
		contentPane.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(257, 155, 262, 40);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(257, 260, 262, 40);
		contentPane.add(txtpassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = txtusername.getText();
				String Password = txtpassword.getText();
				
				try {
					// Step 1 : Create a connection
					Connection connection = database.JdbcUtil.getConnection();
					database.JdbcUtil.printInfo(connection);
					// Step 2 : Create a statement
					String sql = "select * from admin where User_id =?";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1,Username);
					
					// Step 3 : Execute a query SQL statement
		            ResultSet rs = statement.executeQuery();
		            
		            // Step 4 : Process the result set
		            if(rs.next()) {
		            	
		            	String pwrd = rs.getString("Password");
		            	
		            	if(pwrd.equals(Password)) {
		            		Dashboard db = new Dashboard();
							db.setVisible(true);
							dispose();
		            	}
		            	else JOptionPane.showMessageDialog(null,"Password is incorrect !");
		            	
		            }else JOptionPane.showMessageDialog(null,"Username is incorrect !");
		            
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(329, 322, 98, 31);
		contentPane.add(btnLogin);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel_1.setBounds(0, 0, 784, 461);
		contentPane.add(lblNewLabel_1);
	}
}
