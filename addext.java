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

public class addext extends JFrame {

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
					addext frame = new addext();
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
	public addext() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("External Reports Details");
		lblNewLabel.setBounds(259, 16, 204, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPatientsId = new JLabel("Patient's ID");
		lblPatientsId.setBounds(68, 52, 137, 20);
		contentPane.add(lblPatientsId);
		
		textField = new JTextField();
		textField.setBounds(301, 52, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescriptionincludeExterna = new JLabel("Description (include external urls)");
		lblDescriptionincludeExterna.setBounds(30, 122, 238, 20);
		contentPane.add(lblDescriptionincludeExterna);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 119, 403, 59);
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
				String sql = "INSERT INTO extreports VALUES (?,?)";
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
		btnAttach.setBounds(259, 199, 115, 29);
		contentPane.add(btnAttach);
	}

}
