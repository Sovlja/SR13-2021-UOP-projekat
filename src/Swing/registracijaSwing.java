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
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Toolkit;

import projekat.Bibliotekar;
import projekat.Administrator;
import projekat.Biblioteka;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class registracijaSwing extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	
	int xx,xy;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField jmbgField;
	private JTextField addressField;
	private JTextField wageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registracijaSwing frame = new registracijaSwing();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public registracijaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(registracijaSwing.class.getResource("/images/library-logo.png")));
		setTitle("Registracija - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Registracija");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				String username = usernameField.getText().toString();
				String password = passwordField.getText().toString();
				
				Biblioteka b = new Biblioteka();
				
				b.ucitajAdministratore();
				b.ucitajBibliotekare();
				
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas da se prijavite!");
				}
				else{
					for(Administrator a : b.admini) {
						if(a.getKorisničkoIme().equals(username) && a.getLozinka().equals(password)) {
							JOptionPane.showMessageDialog(null, "Uspešna prijava!");
							dispose();
							naslovnaAdminSwing.main(null);
							return;
						}
						else {
							for(Bibliotekar bib : b.bibliotekari) {
								if(bib.getKorisničkoIme().equals(username) && bib.getLozinka().equals(password)) {
									JOptionPane.showMessageDialog(null, "Uspešna prijava!");
									dispose();
									naslovnaSwing.main(null);
									return;
								}
								else {
									JOptionPane.showMessageDialog(null, "Unesite validne podatke za prijavu!");
									return;
								}
							}
						}
					}
					
					
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(219, 388, 243, 36);
		contentPane.add(button);
		
		usernameField = new JTextField(20);
		usernameField.setBounds(366, 91, 283, 36);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel username = new JLabel("Korisničko ime:");
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(366, 66, 121, 14);
		contentPane.add(username);
		
		JLabel password = new JLabel("Korisnička šifra:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(366, 138, 121, 14);
		contentPane.add(password);
		
		passwordField = new JPasswordField(20);
		passwordField.setBounds(366, 163, 283, 36);
		contentPane.add(passwordField);
		
		JLabel naslovnica = new JLabel("REGISTRACIJA ADMINISTRATORA!");
		naslovnica.setHorizontalAlignment(SwingConstants.CENTER);
		naslovnica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		naslovnica.setBounds(34, 11, 615, 36);
		contentPane.add(naslovnica);
		
		JLabel name = new JLabel("Ime:");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(34, 66, 79, 14);
		contentPane.add(name);
		
		nameField = new JTextField(10);
		nameField.setBounds(34, 91, 283, 36);
		contentPane.add(nameField);
		
		JLabel surname = new JLabel("Prezime:");
		surname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surname.setBounds(34, 138, 68, 14);
		contentPane.add(surname);
		
		surnameField = new JTextField(10);
		surnameField.setBounds(34, 163, 283, 36);
		contentPane.add(surnameField);
		
		JLabel jmbg = new JLabel("JMBG:");
		jmbg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jmbg.setBounds(34, 210, 68, 14);
		contentPane.add(jmbg);
		
		jmbgField = new JTextField(10);
		jmbgField.setBounds(34, 235, 283, 36);
		contentPane.add(jmbgField);
		
		JLabel address = new JLabel("Adresa:");
		address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address.setBounds(34, 282, 68, 14);
		contentPane.add(address);
		
		addressField = new JTextField(10);
		addressField.setBounds(34, 307, 283, 36);
		contentPane.add(addressField);
		
		JLabel gender = new JLabel("Pol:");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(366, 284, 121, 14);
		contentPane.add(gender);
		
		wageField = new JTextField(10);
		wageField.setBounds(366, 237, 283, 36);
		contentPane.add(wageField);
		
		JLabel wage = new JLabel("Plata:");
		wage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wage.setBounds(366, 212, 121, 14);
		contentPane.add(wage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(366, 307, 283, 36);
		contentPane.add(comboBox);
	}
}

