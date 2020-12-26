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

public class AppointDoc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					AppointDoc frame = new AppointDoc();
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
	public AppointDoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAppointmentSchedule = new JLabel("Appointment Schedule");
		lblAppointmentSchedule.setBounds(283, 16, 232, 20);
		contentPane.add(lblAppointmentSchedule);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(72, 92, 87, 20);
		contentPane.add(lblPatientId);
		
		textField = new JTextField();
		textField.setBounds(283, 89, 263, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDoctorsName = new JLabel("Doctor's Name");
		lblDoctorsName.setBounds(54, 151, 119, 20);
		contentPane.add(lblDoctorsName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 148, 263, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(54, 211, 105, 20);
		contentPane.add(lblSpecialization);
		
		textField_2 = new JTextField();
		textField_2.setBounds(283, 208, 263, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(54, 269, 94, 20);
		contentPane.add(lblAvailability);
		
		textField_3 = new JTextField();
		textField_3.setBounds(283, 266, 69, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setBounds(54, 318, 69, 20);
		contentPane.add(lblFees);
		
		textField_4 = new JTextField();
		textField_4.setBounds(280, 315, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
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
				String sql = "INSERT INTO doctors VALUES (?,?,?,?,?)";
				try {
					PreparedStatement test =conn.prepareStatement(sql);
					
					test.setString(1,textField.getText());
					test.setString(2,textField_1.getText());
					test.setString(3,textField_2.getText());
					test.setString(4,textField_3.getText());
					test.setString(5,textField_4.getText());
				
					test.executeUpdate();
					JOptionPane.showMessageDialog(contentPane,"Execution Successful!");	
					
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			
			
			}
		});
		btnSchedule.setBounds(569, 314, 115, 29);
		contentPane.add(btnSchedule);
	}

}
