import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import static java.lang.System.out;
public class Login extends JFrame {

	private JPanel Content;
	private JTextField Uname;
	private JPasswordField Pword;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/admins";
	static final String USER = "root";
	static final String PASS = "";
	static String first = null;
	static String last = null;
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		out.println("Connected database successfully...");
		out.println("Creating statement...");
	    stmt = conn.createStatement();
	    String sql = "SELECT username,password FROM adminscredentials";
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()){
	    first = rs.getString("username");
	    last = rs.getString("password");
	    	            }
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 425);
		Content = new JPanel();
		Content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Content);
		Content.setLayout(null);
		
		JLabel lblHospitalManagementSystem = new JLabel("Hospital Management System");
		lblHospitalManagementSystem.setBounds(203, 16, 260, 20);
		Content.add(lblHospitalManagementSystem);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setBounds(274, 52, 84, 20);
		Content.add(lblUserLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(71, 131, 114, 20);
		Content.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(71, 207, 69, 20);
		Content.add(lblPassword);
		
		Uname = new JTextField();
		Uname.setBounds(240, 128, 223, 26);
		Content.add(Uname);
		Uname.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = Uname.getText();
				String password = Pword.getText();
				if (username.equals(first) && password.equals(last))
				{
				 JOptionPane.showMessageDialog(Content,"You have successfully Logged in");	
				 System ss=new System();
				 ss.setVisible(true);
				}
				else
				{
				JOptionPane.showMessageDialog(Content, "Invalid Credentials!");	
				
				}
				
				
			}
		});
		btnLogin.setBounds(225, 271, 115, 29);
		Content.add(btnLogin);
		
		Pword = new JPasswordField();
		Pword.setBounds(240, 204, 223, 26);
		Content.add(Pword);
	}
}
