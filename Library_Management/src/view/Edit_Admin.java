package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Edit_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEdit;
	private JTextField txtEnterUpdatedValue;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Admin frame = new Edit_Admin();
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
	public Edit_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEdit = new JTextField();
		txtEdit.setEditable(false);
		txtEdit.setText("EDIT");
		txtEdit.setHorizontalAlignment(SwingConstants.LEFT);
		txtEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEdit.setBounds(231, 31, 52, 28);
		contentPane.add(txtEdit);
		txtEdit.setColumns(10);
		
		JComboBox columnlist = new JComboBox();
		columnlist.setFont(new Font("Tahoma", Font.BOLD, 18));
		columnlist.setModel(new DefaultComboBoxModel(new String[] {"User_id", "Name", "Password", "Contact"}));
		columnlist.setBounds(231, 71, 233, 33);
		contentPane.add(columnlist);
		
		txtEnterUpdatedValue = new JTextField();
		txtEnterUpdatedValue.setText("ENTER UPDATED VALUE");
		txtEnterUpdatedValue.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterUpdatedValue.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEnterUpdatedValue.setEditable(false);
		txtEnterUpdatedValue.setColumns(10);
		txtEnterUpdatedValue.setBounds(231, 138, 238, 28);
		contentPane.add(txtEnterUpdatedValue);
		
		textField = new JTextField();
		textField.setBounds(200, 205, 302, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String column = columnlist.getSelectedItem().toString();
					String text = textField.getText();
					int res = 0 ;
					
					try {
						// Step 1 : Create a connection
						Connection connection = database.JdbcUtil.getConnection();
						database.JdbcUtil.printInfo(connection);
						// Step 2 : Create a statement 
						String sql = "update admin set " + column + "=?;";
						
						PreparedStatement statement = connection.prepareStatement(sql);  
						statement.setString(1,text);
						
						// Step 3 : Execute a query SQL statement
						res = statement.executeUpdate();
			            
			            // Step 4 : Process the result set
						if (res > 0) {
							JOptionPane.showMessageDialog(null, "Update successfully !");
			            } else {
			            	JOptionPane.showMessageDialog(null, "Update failed !");
			            }
						textField.setText("");
						} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
						}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(128, 322, 129, 50);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(443, 322, 129, 50);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Desktop\\code\\Library_Management\\src\\view\\background.jpg.jpg"));
		lblNewLabel.setBounds(0, 0, 764, 461);
		contentPane.add(lblNewLabel);
	}
}
