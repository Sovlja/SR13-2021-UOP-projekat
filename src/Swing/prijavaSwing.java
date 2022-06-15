package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class prijavaSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField_1;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prijavaSwing frame = new prijavaSwing();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prijavaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(prijavaSwing.class.getResource("/images/library-logo.png")));
		setTitle("Prijava - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 292, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(prijavaSwing.class.getResource("/images/devojka-sa-knjigama (1).jpg")));
		lblNewLabel_1.setBounds(0, 0, 292, 437);
		panel.add(lblNewLabel_1);
		
		Button button = new Button("Prijava");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(366, 351, 243, 36);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(346, 222, 283, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Korisni\u010Dko ime");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(346, 197, 121, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Korisni\u010Dka \u0161ifra");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(346, 269, 94, 14);
		contentPane.add(lblEmail);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(346, 294, 283, 36);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("PRIJAVITE SE NA VA\u0160 NALOG!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(346, 11, 283, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(prijavaSwing.class.getResource("/images/avatar.png")));
		lblNewLabel_3.setBounds(421, 58, 128, 128);
		contentPane.add(lblNewLabel_3);
	}
}
