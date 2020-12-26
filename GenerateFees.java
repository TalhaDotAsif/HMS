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

public class GenerateFees extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
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
					GenerateFees frame = new GenerateFees();
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
	public GenerateFees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFeeGenerationPanel = new JLabel("Fee Generation Panel");
		lblFeeGenerationPanel.setBounds(323, 16, 211, 20);
		contentPane.add(lblFeeGenerationPanel);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(63, 75, 94, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(211, 72, 187, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBillId = new JLabel("Bill ID");
		lblBillId.setBounds(63, 129, 69, 20);
		contentPane.add(lblBillId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 126, 187, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDoctorsFee = new JLabel("Doctor's Fee");
		lblDoctorsFee.setBounds(63, 191, 108, 20);
		contentPane.add(lblDoctorsFee);
		
		textField_2 = new JTextField();
		textField_2.setBounds(211, 188, 187, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTestsFee = new JLabel("Test's Fee");
		lblTestsFee.setBounds(63, 253, 69, 20);
		contentPane.add(lblTestsFee);
		
		textField_3 = new JTextField();
		textField_3.setBounds(211, 250, 187, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMedicineFee = new JLabel("Medicine Fee");
		lblMedicineFee.setBounds(63, 308, 94, 20);
		contentPane.add(lblMedicineFee);
		
		textField_4 = new JTextField();
		textField_4.setBounds(211, 305, 187, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblWardFee = new JLabel("Ward Fee");
		lblWardFee.setBounds(63, 368, 69, 20);
		contentPane.add(lblWardFee);
		
		textField_5 = new JTextField();
		textField_5.setBounds(208, 365, 190, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblServiceFee = new JLabel("Service Fee");
		lblServiceFee.setBounds(63, 414, 94, 20);
		contentPane.add(lblServiceFee);
		
		textField_6 = new JTextField();
		textField_6.setBounds(211, 411, 187, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(476, 75, 69, 20);
		contentPane.add(lblTax);
		
		textField_7 = new JTextField();
		textField_7.setBounds(584, 72, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnGenerateFeeChallan = new JButton("Generate Fee Challan");
		btnGenerateFeeChallan.addActionListener(new ActionListener() {
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
				String sql = "INSERT INTO fees VALUES (?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement test =conn.prepareStatement(sql);
					test.setString(1,textField.getText());
					test.setString(2,textField_1.getText());
					test.setString(3,textField_2.getText());
					test.setString(4,textField_3.getText());
					test.setString(5,textField_4.getText());
					test.setString(6,textField_5.getText());
					test.setString(7,textField_6.getText());
					test.setString(8,textField_7.getText());
					test.executeUpdate();
					JOptionPane.showMessageDialog(contentPane,"Execution Successful!");	
					
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		btnGenerateFeeChallan.setBounds(549, 156, 181, 29);
		contentPane.add(btnGenerateFeeChallan);
	}
}
