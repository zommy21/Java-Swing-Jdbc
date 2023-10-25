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

public class Delete_Book extends JFrame {

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
					Delete_Book frame = new Delete_Book();
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
	public Delete_Book() {
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
					"BOOK_ID", "CATEGORY", "NAME", "AUTHOR", "COPIES"
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
					String sql = "delete from books where Book_id =? or Name=?";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, delete);
		            statement.setString(2, delete);
					
					// Step 3 : Execute a query SQL statement
		            res = statement.executeUpdate();
		            
		            // Step 4 : Process the result set
		            if(res > 0) {
		            	JOptionPane.showMessageDialog(null,"Delete succesfully !");
		            }else JOptionPane.showMessageDialog(null,"Couldn't found the book !");
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
		
		btnNewButton_1 = new JButton("Show books");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				try {
					// Step 1 : Create a connection
					Connection connection = database.JdbcUtil.getConnection();
					database.JdbcUtil.printInfo(connection);
					// Step 2 : Create a statement
					String sql = "select * from books";
					
					PreparedStatement statement = connection.prepareStatement(sql);
					
					// Step 3 : Execute a query SQL statement
		            ResultSet rs = statement.executeQuery();
		            
		            // Step 4 : Process the result set
		            while(rs.next()) {
		            	String Book_id = rs.getString("BOOK_ID");
		            	String category = rs.getString("CATEGORY");
		            	String Name = rs.getString("NAME");
		            	String Author = rs.getString("AUTHOR");
		            	int Copies = rs.getInt("COPIES");
		            	model.addRow(new Object[] {Book_id,category,Name,Author,Copies});
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
		
		lblNewLabel_1 = new JLabel("ENTER BOOK ID OR NAME TO DELTE");
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
