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

public class doctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor frame = new doctor();
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
	public doctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorsPanel = new JLabel("Doctor's Panel");
		lblDoctorsPanel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblDoctorsPanel.setBounds(337, 16, 161, 48);
		contentPane.add(lblDoctorsPanel);
		
		JButton btnGeneratePrognosis = new JButton("Generate Prognosis");
		btnGeneratePrognosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prognosis p=new Prognosis();
				p.setVisible(true);
			}
		});
		btnGeneratePrognosis.setBounds(319, 125, 179, 48);
		contentPane.add(btnGeneratePrognosis);
		
		JButton btnNewButton = new JButton("Prescribe Medicine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prescribemeds pm=new prescribemeds();
				pm.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(319, 290, 179, 51);
		contentPane.add(btnNewButton);
	}

}
