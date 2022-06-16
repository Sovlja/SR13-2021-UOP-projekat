package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
import projekat.Bibliotekar;
import projekat.Pol;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComboBox;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class bibliotekariSwing extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField jmbgField;
	private JTextField addressField;
	private JTextField idField;
	private JTextField wageField;
	private JTextField usernameField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton btnUkloniBibliotekara;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingBibliotekari;
	private DefaultTableModel model;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bibliotekariSwing frame = new bibliotekariSwing();
					frame.setVisible(true);
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
	@SuppressWarnings("unchecked")
	public bibliotekariSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(bibliotekariSwing.class.getResource("/images/library-logo.png")));
		setTitle("Bibliotekari - Biblioteka");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 804);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(204, 204, 255));
		setJMenuBar(menuBar);
		
		JMenu admin = new JMenu("Admin");
		admin.setForeground(new Color(0, 0, 0));
		menuBar.add(admin);
		
		JMenuItem mojProfil = new JMenuItem("Moj profil");
		admin.add(mojProfil);
		
		JMenu zaposleni = new JMenu("Zaposleni");
		admin.add(zaposleni);
		
		JMenuItem bibliotekari = new JMenuItem("Bibliotekari");
		zaposleni.add(bibliotekari);
		
		JMenuItem admini = new JMenuItem("Administratori");
		zaposleni.add(admini);
		
		JMenu skladište = new JMenu("Skladi\u0161te");
		admin.add(skladište);
		
		JMenuItem knjige = new JMenuItem("Knjige");
		skladište.add(knjige);
		
		JMenuItem članarine = new JMenuItem("\u010Clanarine");
		skladište.add(članarine);
		
		JMenuItem žanrovi = new JMenuItem("\u017Danrovi");
		skladište.add(žanrovi);
		
		JMenuItem odjava = new JMenuItem("Odjavi se");
		admin.add(odjava);
		
		JMenu članovi = new JMenu("\u010Clanovi");
		članovi.setForeground(Color.BLACK);
		menuBar.add(članovi);
		
		JMenuItem listaČlanova = new JMenuItem("Lista \u010Dlanova");
		članovi.add(listaČlanova);
		
		JMenuItem iznajmljivanja = new JMenuItem("Iznajmljivanja");
		članovi.add(iznajmljivanja);
		
		JMenu info = new JMenu("Informacije");
		info.setForeground(Color.BLACK);
		menuBar.add(info);
		
		JMenuItem kakoDa = new JMenuItem("Kako da...?");
		info.add(kakoDa);
		
		JMenuItem oNama = new JMenuItem("O nama");
		info.add(oNama);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 153));
		panel.setBounds(0, 0, 1139, 765);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel name = new JLabel("IME:");
		name.setForeground(new Color(255, 255, 255));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setBounds(23, 139, 112, 30);
		panel.add(name);
		
		JLabel surname = new JLabel("PREZIME:");
		surname.setForeground(new Color(255, 255, 255));
		surname.setHorizontalAlignment(SwingConstants.RIGHT);
		surname.setBounds(23, 180, 112, 30);
		panel.add(surname);
		
		JLabel jmbg = new JLabel("JMBG:");
		jmbg.setForeground(new Color(255, 255, 255));
		jmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		jmbg.setBounds(23, 221, 112, 30);
		panel.add(jmbg);
		
		JLabel address = new JLabel("ADRESA:");
		address.setForeground(new Color(255, 255, 255));
		address.setHorizontalAlignment(SwingConstants.RIGHT);
		address.setBounds(362, 139, 112, 30);
		panel.add(address);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(362, 180, 112, 30);
		panel.add(id);
		
		JLabel wage = new JLabel("PLATA:");
		wage.setForeground(new Color(255, 255, 255));
		wage.setHorizontalAlignment(SwingConstants.RIGHT);
		wage.setBounds(362, 221, 112, 30);
		panel.add(wage);
		
		JLabel username = new JLabel("KORISNI\u010CKO IME:");
		username.setForeground(new Color(255, 255, 255));
		username.setHorizontalAlignment(SwingConstants.RIGHT);
		username.setBounds(732, 139, 112, 30);
		panel.add(username);
		
		JLabel password = new JLabel("KORISNI\u010CKA \u0160IFRA:");
		password.setForeground(new Color(255, 255, 255));
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setBounds(732, 180, 112, 30);
		panel.add(password);
		
		JLabel gender = new JLabel("POL:");
		gender.setForeground(new Color(255, 255, 255));
		gender.setHorizontalAlignment(SwingConstants.RIGHT);
		gender.setBounds(732, 221, 112, 30);
		panel.add(gender);
		
		nameField = new JTextField();
		nameField.setBounds(140, 139, 144, 30);
		panel.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(140, 180, 144, 30);
		panel.add(surnameField);
		
		jmbgField = new JTextField();
		jmbgField.setColumns(10);
		jmbgField.setBounds(140, 221, 144, 30);
		panel.add(jmbgField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(479, 139, 144, 30);
		panel.add(addressField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(479, 180, 144, 30);
		panel.add(idField);
		
		wageField = new JTextField();
		wageField.setColumns(10);
		wageField.setBounds(479, 221, 144, 30);
		panel.add(wageField);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(849, 139, 144, 30);
		panel.add(usernameField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 347, 1089, 311);
		panel.add(scrollPane);
		
		@SuppressWarnings("rawtypes")
		JComboBox polovi = new JComboBox();
		polovi.setBounds(849, 221, 144, 30);
		polovi.setSelectedItem("Izaberite pol");
		polovi.addItem(Pol.OSTALO);
		polovi.addItem(Pol.MUŠKI);
		polovi.addItem(Pol.ŽENSKI);
		panel.add(polovi);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				surnameField.setText(model.getValueAt(i, 1).toString());
				jmbgField.setText(model.getValueAt(i, 2).toString());
				addressField.setText(model.getValueAt(i, 3).toString());
				nameField.setText(model.getValueAt(i, 4).toString());
				wageField.setText(model.getValueAt(i, 5).toString());
				usernameField.setText(model.getValueAt(i, 6).toString());
				passwordField.setText(model.getValueAt(i, 7).toString());
				polovi.setSelectedItem(model.getValueAt(i, 7).toString());								
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "PREZIME", "JMBG", "ADRESA", "IME", "PLATA", "KORISNIČKO IME", "KORISNIČKA ŠIFRA", "POL"};
		final Object[] row = new Object[9];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		
		try {
			File bibliotekarFile = new File("src/txt/bibliotekari.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekarFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String ime = splitovanRed[0];
				row[4] = ime;
				
				String prezime = splitovanRed[1];
				row[1] = prezime;
				
				String JMBG = splitovanRed[2];
				row[2] = JMBG;
				
				String adresa = splitovanRed[3];
				row[3] = adresa;
				
				String ID = splitovanRed[4];
				row[0] = ID;
				
				double plataDouble = Double.parseDouble(splitovanRed[5]);
				row[5] = plataDouble;
				
				String korisničkoIme = splitovanRed[6];
				row[6] = korisničkoIme;
				
				String lozinka = splitovanRed[7];
				row[7] = lozinka;
				
				Pol pol = Pol.valueOf(splitovanRed[8]);
				row[8] = pol;
		
				model.addRow(row);
				
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj bibliotekara");
		Biblioteka biblioteka = new Biblioteka();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().equals("") || surnameField.getText().equals("") || jmbgField.getText().equals("") || 
					addressField.getText().equals("") || idField.getText().equals("") || wageField.getText().equals("") || 
					usernameField.getText().equals("") || passwordField.getText().equals("") || polovi.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					
				}
				else {
					
					for(Bibliotekar bibliotekar : biblioteka.bibliotekari){
						
						if(bibliotekar.getJMBG().contains(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Bibliotekar sa prosleđenim ID-ijem već postoji!");
							break;
						}
						
						if(bibliotekar.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Bibliotekar sa prosleđenim ID-ijem već postoji!");
							
						}
						
						if(bibliotekar.getKorisničkoIme().equals(usernameField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Korisničko ime koje ste uneli je već zauzeto!");
							
						}
						
					}	
					row[0] = idField.getText();
					row[1] = surnameField.getText();
					row[2] = jmbgField.getText();
					row[3] = addressField.getText();
					row[4] = nameField.getText();
					row[5] = wageField.getText();
					row[6] = usernameField.getText();
					row[7] = passwordField.getText();
					row[8] = polovi.getSelectedItem();
					model.addRow(row);
					
					JOptionPane.showMessageDialog(null, "Bibliotekar uspešno dodat u listu!");
					
					nameField.setText("");
					surnameField.setText("");
					jmbgField.setText("");
					addressField.setText("");
					idField.setText("");
					wageField.setText("");
					usernameField.setText("");
					passwordField.setText("");
					polovi.setSelectedItem(Pol.OSTALO);	
					
				}
					
			}
		});
		addButton.setBounds(34, 683, 177, 42);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj bibliotekara");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.setValueAt(idField.getText(), i, 0);
						model.setValueAt(surnameField.getText(), i, 1);
						model.setValueAt(jmbgField.getText(), i, 2);
						model.setValueAt(addressField.getText(), i, 3);
						model.setValueAt(nameField.getText(), i, 4);
						model.setValueAt(wageField.getText(), i, 5);
						model.setValueAt(usernameField.getText(), i, 6);
						model.setValueAt(passwordField.getText(), i, 7);
						model.setValueAt(polovi.getSelectedItem(), i, 8);
						JOptionPane.showMessageDialog(null, "Bibliotekar je uspešno ažuriran!");																	
					}
					JOptionPane.getRootFrame().dispose();
					nameField.setText("");
					surnameField.setText("");
					jmbgField.setText("");
					addressField.setText("");
					idField.setText("");
					wageField.setText("");
					usernameField.setText("");
					passwordField.setText("");
					polovi.setSelectedItem(Pol.OSTALO);
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite bibliotekara za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(243, 683, 177, 42);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		btnUkloniBibliotekara = new JButton("Ukloni bibliotekara");
		btnUkloniBibliotekara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati bibliotekara?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.removeRow(i);
						nameField.setText("");
						surnameField.setText("");
						jmbgField.setText("");
						addressField.setText("");
						idField.setText("");
						wageField.setText("");
						usernameField.setText("");
						passwordField.setText("");
						polovi.setSelectedItem(Pol.OSTALO);
						JOptionPane.showMessageDialog(null, "Bibliotekar je uspešno obrisan!");												
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite bibliotekara za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		btnUkloniBibliotekara.setBounds(450, 683, 177, 42);
		panel.add(btnUkloniBibliotekara);
		
		cancelButton = new JButton("Iza\u0111i");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite izaći?","Upozorenje", dialogButton);
				
				if(dialogResult == 0) {
					dispose();					
				}
				else {
					JOptionPane.getRootFrame().dispose();
				}
			}
		});
		cancelButton.setBounds(926, 683, 177, 42);
		panel.add(cancelButton);
		
		clearButton = new JButton("Obriši unos");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				surnameField.setText("");
				jmbgField.setText("");
				addressField.setText("");
				idField.setText("");
				wageField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				polovi.setSelectedItem(Pol.OSTALO);
			}
		});
		clearButton.setBounds(903, 282, 177, 42);
		panel.add(clearButton);
		
		headingBibliotekari = new JLabel("~BIBLIOTEKARI~");
		headingBibliotekari.setForeground(new Color(255, 255, 255));
		headingBibliotekari.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingBibliotekari.setHorizontalAlignment(SwingConstants.CENTER);
		headingBibliotekari.setBounds(215, 38, 692, 90);
		panel.add(headingBibliotekari);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(849, 180, 144, 30);
		panel.add(passwordField);
		
	}
}