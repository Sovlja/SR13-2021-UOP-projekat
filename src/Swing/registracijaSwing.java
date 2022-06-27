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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Toolkit;

import projekat.Bibliotekar;
import projekat.Pol;
import projekat.Administrator;
import projekat.Biblioteka;
import javax.swing.JComboBox;
import java.util.regex.*;

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
	private Biblioteka b;
	private JTextField idField;
	
	
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
		this.b = new Biblioteka();
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
		
		
		
		JComboBox<Pol> poloviBox = new JComboBox<Pol>();
		poloviBox.setBounds(366, 307, 283, 36);
		poloviBox.addItem(Pol.OSTALO);
		poloviBox.addItem(Pol.MUŠKI);
		poloviBox.addItem(Pol.ŽENSKI);
		contentPane.add(poloviBox);
		
		
		Button button = new Button("Registracija");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				String ID = idField.getText().toString();
				String name = nameField.getText().toString();
				String surname = surnameField.getText().toString();
				String JMBG =  jmbgField.getText().toString();
				String address = addressField.getText().toString();
				String username = usernameField.getText().toString();
				String password = passwordField.getText().toString();
				String wage = wageField.getText().toString();
				String pol = poloviBox.getSelectedItem().toString();
				
				
				if(name.equals("") || surname.equals("") || JMBG.equals("") || address.equals("") || username.equals("") || password.equals("") || wage.equals("") || poloviBox.getSelectedItem().equals(null)) {
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite formu za registraciju!");
				}
				else{
					if(JMBG.length() != 13) {
						JOptionPane.showMessageDialog(null, "JMBG mora imati 13 cifara!");
						jmbgField.setText("");
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "Uspešna registracija!");
						dispose();
						
						String adminLinija = "";
						
						adminLinija += name + "|" + surname + "|" + JMBG + "|" + address + "|" + ID + "|" +
								wage + "|" + username + "|" + password + "|" + pol + "|" + "false" + "\n" ;
						
						try {
							File adminFile = new File("src/txt/administratori.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(adminFile, true));
							writer.write(adminLinija);
							writer.close();
							
						}catch(IOException e1){
							System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
						}
						
						
						
						
						naslovnaAdminSwing.main(null);
					}
					
					
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(390, 388, 243, 36);
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
		
		idField = new JTextField(10);
		idField.setBounds(34, 388, 283, 36);
		contentPane.add(idField);
		
		JLabel id = new JLabel("ID:");
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setBounds(34, 363, 68, 14);
		contentPane.add(id);
		
		
	}
}

