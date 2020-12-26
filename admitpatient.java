import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.lang.System.out;
public class admitpatient extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/admins";
	static String id=null;
	static  String name=null;
	static String age=null;
	static String gender=null;
	static  String Contact=null;
	static String BloodType=null;
	static String address=null;
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	static final String USER = "root";
	static final String PASS = "";

	
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					//String sql = "INSERT INTO patient" + "VALUES ("+id+","+name+", "+age+","+gender+", "+Contact+", "+BloodType+","+address+")";
					
					admitpatient frame = new admitpatient();
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
	public admitpatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientAdmittanceForm = new JLabel("Patient Admittance Form");
		lblPatientAdmittanceForm.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPatientAdmittanceForm.setBounds(302, 16, 271, 20);
		contentPane.add(lblPatientAdmittanceForm);
		
		JLabel lblNameOfPatient = new JLabel("Name of Patient");
		lblNameOfPatient.setBounds(58, 91, 133, 20);
		contentPane.add(lblNameOfPatient);
		
		textField = new JTextField();
		textField.setBounds(206, 88, 240, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAgeOfPatient = new JLabel("Age of Patient");
		lblAgeOfPatient.setBounds(58, 139, 133, 20);
		contentPane.add(lblAgeOfPatient);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 136, 240, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(77, 192, 83, 20);
		contentPane.add(lblGender);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 189, 98, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(58, 247, 115, 20);
		contentPane.add(lblContactNumber);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 244, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setBounds(71, 304, 89, 20);
		contentPane.add(lblBloodType);
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 301, 151, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(77, 353, 69, 20);
		contentPane.add(lblAddress);
		
		textField_5 = new JTextField();
		textField_5.setBounds(206, 350, 563, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(504, 91, 69, 20);
		contentPane.add(lblId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(557, 88, 229, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		name = textField.getText();
		age = textField_1.getText();
		gender = textField_2.getText();
		Contact = textField_3.getText();
		BloodType = textField_4.getText();
		address = textField_5.getText();
		id=textField_6.getText();
		
		JButton btnAdmitPatient = new JButton("Admit Patient!");
		btnAdmitPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//JOptionPane.showMessageDialog(contentPane,"You have successfully added data");	
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
				String sql = "INSERT INTO patient VALUES (?,?,?,?,?,?,?)";
				try {
					PreparedStatement test =conn.prepareStatement(sql);
					test.setString(1,textField_6.getText());
					test.setString(2,textField.getText());
					test.setString(3,textField_1.getText());
					test.setString(4,textField_2.getText());
					test.setString(5,textField_3.getText());
					test.setString(6,textField_4.getText());
					test.setString(7,textField_5.getText());
					test.executeUpdate();
					JOptionPane.showMessageDialog(contentPane,"Execution Successful!");	
					
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		btnAdmitPatient.setBounds(319, 416, 146, 29);
		contentPane.add(btnAdmitPatient);
		
		
	}
	
}
