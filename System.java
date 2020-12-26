import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class System extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System frame = new System();
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
	public System() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblAdminPanel.setBounds(318, 16, 147, 20);
		contentPane.add(lblAdminPanel);
		
		JButton btnNewButton = new JButton("Staff Panel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff s=new Staff();
				s.setVisible(true);		
			}
		});
		btnNewButton.setBounds(318, 148, 147, 42);
		contentPane.add(btnNewButton);
		
		JButton btnCheckStatus = new JButton("Doctor's Panel");
		btnCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctor d=new doctor();
				d.setVisible(true);
			}
		});
		btnCheckStatus.setBounds(318, 284, 153, 42);
		contentPane.add(btnCheckStatus);
	}
}
