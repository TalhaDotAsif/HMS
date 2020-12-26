import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Prognosis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
					Prognosis frame = new Prognosis();
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
	public Prognosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrognosis = new JLabel("Prognosis");
		lblPrognosis.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPrognosis.setBounds(318, 16, 148, 33);
		contentPane.add(lblPrognosis);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(122, 97, 109, 20);
		contentPane.add(lblPatientId);
		
		textField = new JTextField();
		textField.setBounds(296, 94, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrognosis_1 = new JLabel("Prognosis");
		lblPrognosis_1.setBounds(122, 170, 69, 20);
		contentPane.add(lblPrognosis_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(296, 167, 371, 72);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAttach = new JButton("Attach");
		btnAttach.addActionListener(new ActionListener() {
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
				String sql = "INSERT INTO prognosis VALUES (?,?)";
				try {
					PreparedStatement test =conn.prepareStatement(sql);
					test.setString(1,textField.getText());
					test.setString(2,textField_1.getText());
					
					
					test.executeUpdate();
					JOptionPane.showMessageDialog(contentPane,"Execution Successful!");	
					
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			
			}
		});
		btnAttach.setBounds(260, 314, 115, 29);
		contentPane.add(btnAttach);
	}

}
