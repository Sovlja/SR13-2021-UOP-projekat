package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Toolkit;

import projekat.Bibliotekar;
import projekat.Biblioteka;


@SuppressWarnings("serial")
public class prijavaSwing extends JFrame {

	private JPanel contentPane;
	private JTextField usernameUnos;
	private JPasswordField lozinkaUnos;
	
	
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

	
	public prijavaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(prijavaSwing.class.getResource("/images/library-logo.png")));
		setTitle("Prijava - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 473);
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
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = usernameUnos.getText().trim();
				String lozinka = new String(lozinkaUnos.getPassword()).trim();
				
				if(username.equals("") || lozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu!", "Greška", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Biblioteka b = new Biblioteka();
					Bibliotekar prijavljeni = b.loginBibliotekar(username, lozinka);
					if(prijavljeni.getKorisničkoIme().equals(String.valueOf(username)) || prijavljeni.getLozinka().equals(String.valueOf(lozinka))) {
						JOptionPane.showMessageDialog(null, "Uspešna prijava!");
						dispose();
						naslovnaSwing.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Pogrešni login podaci.", "Greška", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(366, 351, 243, 36);
		contentPane.add(button);
		
		usernameUnos = new JTextField(20);
		usernameUnos.setBounds(346, 222, 283, 36);
		contentPane.add(usernameUnos);
		usernameUnos.setColumns(10);
		
		JLabel lblUsername = new JLabel("Korisni\u010Dko ime");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(346, 197, 121, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Korisni\u010Dka \u0161ifra");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(346, 269, 94, 14);
		contentPane.add(lblEmail);
		
		lozinkaUnos = new JPasswordField(20);
		lozinkaUnos.setBounds(346, 294, 283, 36);
		contentPane.add(lozinkaUnos);
		
		JLabel naslovnica = new JLabel("PRIJAVITE SE NA VA\u0160 NALOG!");
		naslovnica.setHorizontalAlignment(SwingConstants.CENTER);
		naslovnica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		naslovnica.setBounds(346, 11, 283, 36);
		contentPane.add(naslovnica);
		
		JLabel avatar = new JLabel("New label");
		avatar.setIcon(new ImageIcon(prijavaSwing.class.getResource("/images/avatar.png")));
		avatar.setBounds(421, 58, 128, 128);
		contentPane.add(avatar);
	}
}

