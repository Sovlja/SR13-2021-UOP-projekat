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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class bibliotekariSwing extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton btnUkloniBibliotekara;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingBibliotekari;
	private DefaultTableModel model;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField jmbgField;
	private JTextField addressField;
	private JTextField idField;
	private JTextField wageField;
	private JTextField usernameField;
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
		bibliotekari.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bibliotekariSwing.main(null);
				dispose();
			}
		});
		zaposleni.add(bibliotekari);
		
		JMenuItem admini = new JMenuItem("Administratori");
		admini.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				adminiSwing.main(null);
				dispose();
			}
		});
		zaposleni.add(admini);
		
		JMenu skladište = new JMenu("Skladi\u0161te");
		admin.add(skladište);
		
		JMenuItem knjige = new JMenuItem("Knjige");
		knjige.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				knjigaSwing.main(null);
				dispose();
			}
		});
		skladište.add(knjige);
		
		JMenuItem članarine = new JMenuItem("\u010Clanarine");
		članarine.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tipClanarineSwing.main(null);
				dispose();
			}
		});
		skladište.add(članarine);
		
		JMenuItem žanrovi = new JMenuItem("\u017Danrovi");
		žanrovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				žanroviSwing.main(null);
				dispose();
			}
		});
		skladište.add(žanrovi);
		
		JMenuItem odjava = new JMenuItem("Odjavi se");
		odjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li želite da se odjavite?","Potvrda", dialogButton);
				
				if(dialogResult == 0) {
					prijavaSwing.main(null);
					dispose();																	
				}
			}
		});
		admin.add(odjava);
		
		JMenu članovi = new JMenu("\u010Clanovi");
		članovi.setForeground(Color.BLACK);
		menuBar.add(članovi);
		
		JMenuItem listaČlanova = new JMenuItem("Lista \u010Dlanova");
		listaČlanova.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clanoviAdminSwing.main(null);
				dispose();
			}
		});
		članovi.add(listaČlanova);
		
		JMenuItem iznajmljivanja = new JMenuItem("Iznajmljivanja");
		iznajmljivanja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				iznajmljivanjeAdminSwing.main(null);
				dispose();
			}
		});
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
		
		@SuppressWarnings("rawtypes")
		JComboBox polovi = new JComboBox();
		polovi.setBounds(745, 125, 144, 30);
		polovi.setSelectedItem("Izaberite pol");
		polovi.addItem(Pol.OSTALO);
		polovi.addItem(Pol.MUŠKI);
		polovi.addItem(Pol.ŽENSKI);
		polovi.setSelectedItem(null);
		panel.add(polovi);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 391, 1089, 267);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				surnameField.setText(model.getValueAt(i, 1).toString());
				jmbgField.setText(model.getValueAt(i, 2).toString());
				jmbgField.disable();
				addressField.setText(model.getValueAt(i, 3).toString());
				nameField.setText(model.getValueAt(i, 4).toString());
				wageField.setText(model.getValueAt(i, 5).toString());
				usernameField.setText(model.getValueAt(i, 6).toString());
				passwordField.setText(model.getValueAt(i, 7).toString());
				polovi.setSelectedItem(model.getValueAt(i, 8));								
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
				
				if(splitovanRed[9].equals("false")) {
					
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
				
				
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj bibliotekara");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				jmbgField.enable();
			}
		});
		Biblioteka biblioteka = new Biblioteka();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().equals("") || surnameField.getText().equals("") || jmbgField.getText().equals("") || 
					addressField.getText().equals("") || idField.getText().equals("") || wageField.getText().equals("") || 
					usernameField.getText().equals("") || passwordField.getText().equals("") || polovi.getSelectedItem().equals(null)) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					return;
				}
				else {
					biblioteka.ucitajBibliotekare();
					for(Bibliotekar bibliotekar : biblioteka.bibliotekari){
						if(bibliotekar.getJMBG().contains(jmbgField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Bibliotekar sa prosleđenim JMBG-om već postoji!");
							jmbgField.setText("");
							return;
						}
						
						if(bibliotekar.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Bibliotekar sa prosleđenim ID-ijem već postoji!");
							idField.setText("");	
							return;
						}
						
						if(bibliotekar.getKorisničkoIme().equals(usernameField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Korisničko ime koje ste uneli je već zauzeto!");
							usernameField.setText("");
							return;
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
				
					String bibliotekarLinija = "";
					
					bibliotekarLinija += row[4] + "|" + row[1] + "|" + row[2] + "|" + row[3] + "|" + 
							row[0] + "|" + row[5] + "|" + row[6] + "|" + row[7] + "|" + row[8] + "|" + "false" + "\n" ;
					
					try {
						File bibliotekarFile = new File("src/txt/bibliotekari.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(bibliotekarFile, true));
						writer.write(bibliotekarLinija);
						writer.close();
						
					}catch(IOException e1){
						System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Bibliotekar uspešno dodat u listu!");
					
					nameField.setText("");
					surnameField.setText("");
					jmbgField.setText("");
					addressField.setText("");
					idField.setText("");
					wageField.setText("");
					usernameField.setText("");
					passwordField.setText("");
					polovi.setSelectedItem(null);	
					
				}
					
			}
		});
		addButton.setBounds(906, 338, 177, 30);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj bibliotekara");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				jmbgField.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biblioteka.ucitajBibliotekare();
				int i = table.getSelectedRow();
				
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						
						String bibliotekarID = biblioteka.dobaviNeobrisaneBibliotekare().get(i).getId();
						String[] izmene = new String[8];
						izmene[0] = nameField.getText();
						izmene[1] = surnameField.getText();
						izmene[3] = addressField.getText();
						izmene[6] = usernameField.getText();
						izmene[7] = passwordField.getText();
						
						Double[] doubleIzmene = new Double[6];
						doubleIzmene[5] = Double.parseDouble(wageField.getText());
						
						Pol[] polIzmene = new Pol[9];
						polIzmene[8] = Pol.valueOf(polovi.getSelectedItem().toString());
						
						biblioteka.ažurirajBibliotekara(bibliotekarID, izmene, doubleIzmene, polIzmene);
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
					polovi.setSelectedItem(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite bibliotekara za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(47, 691, 177, 34);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		btnUkloniBibliotekara = new JButton("Ukloni bibliotekara");
		btnUkloniBibliotekara.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				jmbgField.enable();
			}
		});
		btnUkloniBibliotekara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				biblioteka.ucitajBibliotekare();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati bibliotekara?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						biblioteka.dobaviNeobrisaneBibliotekare().get(i).setJeObrisan(true);
						model.removeRow(i);
						nameField.setText("");
						surnameField.setText("");
						jmbgField.setText("");
						addressField.setText("");
						idField.setText("");
						wageField.setText("");
						usernameField.setText("");
						passwordField.setText("");
						polovi.setSelectedItem(null);
						JOptionPane.showMessageDialog(null, "Bibliotekar je uspešno obrisan!");		
						biblioteka.upisiBibliotekare();
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite bibliotekara za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		btnUkloniBibliotekara.setBounds(249, 691, 177, 34);
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
		cancelButton.setBounds(906, 691, 177, 34);
		panel.add(cancelButton);
		
		clearButton = new JButton("Obriši unos");
		clearButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				idField.enable();
				jmbgField.enable();
			}
		});
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
				polovi.setSelectedItem(null);
			}
		});
		clearButton.setBounds(449, 691, 177, 34);
		panel.add(clearButton);
		
		headingBibliotekari = new JLabel("~BIBLIOTEKARI~");
		headingBibliotekari.setForeground(new Color(255, 255, 255));
		headingBibliotekari.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingBibliotekari.setHorizontalAlignment(SwingConstants.CENTER);
		headingBibliotekari.setBounds(187, 11, 702, 90);
		panel.add(headingBibliotekari);
		
		JLabel name = new JLabel("IME:");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setForeground(Color.WHITE);
		name.setBounds(187, 100, 112, 30);
		panel.add(name);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(187, 125, 144, 30);
		panel.add(nameField);
		
		JLabel surname = new JLabel("PREZIME:");
		surname.setHorizontalAlignment(SwingConstants.LEFT);
		surname.setForeground(Color.WHITE);
		surname.setBounds(187, 154, 112, 30);
		panel.add(surname);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(187, 179, 144, 30);
		panel.add(surnameField);
		
		JLabel jmbg = new JLabel("JMBG:");
		jmbg.setHorizontalAlignment(SwingConstants.LEFT);
		jmbg.setForeground(Color.WHITE);
		jmbg.setBounds(187, 207, 112, 30);
		panel.add(jmbg);
		
		jmbgField = new JTextField();
		jmbgField.setColumns(10);
		jmbgField.setBounds(187, 231, 144, 30);
		panel.add(jmbgField);
		
		JLabel address = new JLabel("ADRESA:");
		address.setHorizontalAlignment(SwingConstants.LEFT);
		address.setForeground(Color.WHITE);
		address.setBounds(187, 258, 112, 30);
		panel.add(address);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(187, 281, 144, 30);
		panel.add(addressField);
		
		JLabel id = new JLabel("ID:");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setForeground(Color.WHITE);
		id.setBounds(465, 315, 144, 30);
		panel.add(id);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(465, 338, 144, 30);
		panel.add(idField);
		
		JLabel gender = new JLabel("POL:");
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setForeground(Color.WHITE);
		gender.setBounds(745, 100, 112, 30);
		panel.add(gender);
		
		
		JLabel wage = new JLabel("PLATA:");
		wage.setHorizontalAlignment(SwingConstants.LEFT);
		wage.setForeground(Color.WHITE);
		wage.setBounds(745, 154, 112, 30);
		panel.add(wage);
		
		wageField = new JTextField();
		wageField.setColumns(10);
		wageField.setBounds(745, 179, 144, 30);
		panel.add(wageField);
		
		JLabel username = new JLabel("KORISNIČKO IME:");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.WHITE);
		username.setBounds(745, 207, 112, 30);
		panel.add(username);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(745, 231, 144, 30);
		panel.add(usernameField);
		
		JLabel password = new JLabel("KORISNIČKA ŠIFRA:");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(Color.WHITE);
		password.setBounds(745, 258, 112, 30);
		panel.add(password);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(745, 281, 144, 30);
		panel.add(passwordField);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(bibliotekariSwing.class.getResource("/images/librarianAvatar.png")));
		picLabel.setBounds(430, 100, 210, 210);
		panel.add(picLabel);
		
	}
}