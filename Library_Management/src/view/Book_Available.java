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

public class Book_Available extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Available frame = new Book_Available();
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
	public Book_Available() {
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
		scrollPane.setBounds(0, 28, 764, 326);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("FETCH");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(116, 379, 140, 48);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(452, 379, 140, 48);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel.setBounds(0, 0, 764, 461);
		contentPane.add(lblNewLabel);
	}
}
