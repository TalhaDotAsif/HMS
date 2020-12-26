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

public class Staff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffPanel = new JLabel("Staff Panel");
		lblStaffPanel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblStaffPanel.setBounds(341, 16, 164, 36);
		contentPane.add(lblStaffPanel);
		
		JButton btnAdmitPatients = new JButton("Admit Patients");
		btnAdmitPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admitpatient ap=new admitpatient();
				ap.setVisible(true);
				
			}
		});
		btnAdmitPatients.setBounds(133, 105, 171, 29);
		contentPane.add(btnAdmitPatients);
		
		JButton btnGenerateFees = new JButton("Generate Fees");
		btnGenerateFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateFees genf = new GenerateFees();
				genf.setVisible(true);
			}
		});
		btnGenerateFees.setBounds(528, 105, 183, 29);
		contentPane.add(btnGenerateFees);
		
		JButton btnNewButton = new JButton("Current Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Status s=new Status();
				s.setVisible(true);		
			}
		});
		btnNewButton.setBounds(133, 229, 171, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prescribe Tests");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrescribeTest pt = new PrescribeTest();
				pt.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(528, 229, 183, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnAppointDoctor = new JButton("Appoint Doctor");
		btnAppointDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AppointDoc app= new AppointDoc();
			app.setVisible(true);
			}
		});
		btnAppointDoctor.setBounds(133, 351, 171, 29);
		contentPane.add(btnAppointDoctor);
		
		JButton btnNewButton_2 = new JButton("Add External Reports");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addext ae= new addext();
				ae.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(528, 351, 183, 29);
		contentPane.add(btnNewButton_2);
	}

}
