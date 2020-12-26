import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PrescribeTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/admins";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescribeTest frame = new PrescribeTest();
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
	public PrescribeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTestPrescriptionPanel = new JLabel("Test Prescription Panel");
		lblTestPrescriptionPanel.setBounds(280, 16, 206, 20);
		contentPane.add(lblTestPrescriptionPanel);
		
		JLabel lblTestName = new JLabel("Test Name");
		lblTestName.setBounds(48, 96, 94, 20);
		contentPane.add(lblTestName);
		
		textField = new JTextField();
		textField.setBounds(216, 93, 346, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(48, 204, 91, 20);
		contentPane.add(lblDescription);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 196, 346, 75);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(48, 156, 69, 20);
		contentPane.add(lblCost);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 154, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblResult = new JLabel("Result ");
		lblResult.setBounds(48, 303, 69, 20);
		contentPane.add(lblResult);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 300, 51, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				out.println("Connected database successfully...");
				out.println("Creating statement...");
				try {
					stmt = conn.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String sql = "INSERT INTO test VALUES (?,?,?,?)";
				try {
					PreparedStatement test =conn.prepareStatement(sql);
					test.setString(1,textField.getText());
					test.setString(2,textField_2.getText());
					test.setString(3,textField_1.getText());
					test.setString(4,textField_3.getText());
					
					test.executeUpdate();
					JOptionPane.showMessageDialog(contentPane,"Execution Successful!");	
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		btnSchedule.setBounds(315, 326, 115, 29);
		contentPane.add(btnSchedule);
	}

}
