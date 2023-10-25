package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class Remove_Staff extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove_Staff frame = new Remove_Staff();
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
	public Remove_Staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"STAFF_ID", "NAME", "CONTACT"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 24, 764, 280);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete = textField.getText();
				int res = 0 ;
				
				try {
					// Step 1 : Create a connection
					Connection connection = database.JdbcUtil.getConnection();
					database.JdbcUtil.printInfo(connection);
					// Step 2 : Create a statement
					String sql = "delete from staffs where Staff_id =?";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, delete);
					
					// Step 3 : Execute a query SQL statement
		            res = statement.executeUpdate();
		            
		            // Step 4 : Process the result set
		            if(res > 0) {
		            	JOptionPane.showMessageDialog(null,"Delete succesfully !");
		            }else JOptionPane.showMessageDialog(null,"Couldn't found the staff !");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
			
		btnNewButton.setBounds(130, 402, 140, 48);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("CANCEL");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(423, 402, 140, 48);
		contentPane.add(btnBack);
		
		btnNewButton_1 = new JButton("Show Staffs ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				try {
					// Step 1 : Create a connection
					Connection connection = database.JdbcUtil.getConnection();
					database.JdbcUtil.printInfo(connection);
					// Step 2 : Create a statement
					String sql = "select * from staffs";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					
					// Step 3 : Execute a query SQL statement
		            ResultSet rs = statement.executeQuery();
		            
		            // Step 4 : Process the result set
		            while(rs.next()) {
		            	String Staff_id = rs.getString("STAFF_ID");
		            	String Name = rs.getString("NAME");
		            	String Contact = rs.getString("CONTACT");
		            	model.addRow(new Object[] {Staff_id,Name,Contact});
		            }
		            rs.close();
		            statement.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(0, 0, 119, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("ENTER STAFF ID TO DELTE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 341, 353, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(383, 331, 307, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel.setBounds(0, 0, 764, 461);
		contentPane.add(lblNewLabel);
	}
}
