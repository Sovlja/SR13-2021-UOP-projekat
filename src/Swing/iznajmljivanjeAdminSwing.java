package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
import projekat.Biblioteka;
import projekat.Bibliotekar;
import projekat.Iznajmljivanje;
import projekat.Član;
import projekat.PrimerakKnjige;
import projekat.Zaposleni;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class iznajmljivanjeAdminSwing extends JFrame {

	private JPanel contentPane;
	private Biblioteka biblioteka;
	private JTextField rentDateField;
	private JTextField returnDateField;
	private JTextField idField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingČlanovi;
	private DefaultTableModel model;
	
	@SuppressWarnings("rawtypes")
	public JList listaPrimeraka;
	public ArrayList<String> imenaPrimeraka;
	public int selInd = -1;
	public iznajmljivanjeAdminSwing prozor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iznajmljivanjeAdminSwing frame = new iznajmljivanjeAdminSwing();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public iznajmljivanjeAdminSwing() {
		this.prozor = this;
		this.imenaPrimeraka = new ArrayList<String>();
		this.biblioteka = new Biblioteka();
		setIconImage(Toolkit.getDefaultToolkit().getImage(iznajmljivanjeAdminSwing.class.getResource("/images/library-logo.png")));
		setTitle("Iznajmljivanje - Biblioteka");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 875);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(204, 204, 255));
		setJMenuBar(menuBar);
		
		JMenu admin = new JMenu("Profil");
		admin.setForeground(new Color(0, 0, 0));
		menuBar.add(admin);
		
		JMenuItem mojProfil = new JMenuItem("Moj profil");
		mojProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				naslovnaSwing.main(null);
				dispose();
			}
		});
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
				iznajmljivanjeSwing.main(null);
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
		panel.setBounds(0, 0, 1185, 814);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel rentDate = new JLabel("DATUM IZNAJMLJIVANJA:");
		rentDate.setForeground(new Color(255, 255, 255));
		rentDate.setHorizontalAlignment(SwingConstants.LEFT);
		rentDate.setBounds(91, 119, 163, 30);
		panel.add(rentDate);
		
		JLabel returnDate = new JLabel("DATUM VRAĆANJA:");
		returnDate.setForeground(new Color(255, 255, 255));
		returnDate.setHorizontalAlignment(SwingConstants.LEFT);
		returnDate.setBounds(91, 170, 144, 30);
		panel.add(returnDate);
		
		JLabel employer = new JLabel("ZAPOSLENI:");
		employer.setForeground(new Color(255, 255, 255));
		employer.setHorizontalAlignment(SwingConstants.LEFT);
		employer.setBounds(328, 170, 112, 30);
		panel.add(employer);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setBounds(328, 119, 112, 30);
		panel.add(id);
		
		rentDateField = new JTextField();
		rentDateField.setHorizontalAlignment(SwingConstants.LEFT);
		rentDateField.setBounds(91, 141, 163, 30);
		panel.add(rentDateField);
		rentDateField.setColumns(10);
		
		returnDateField = new JTextField();
		returnDateField.setHorizontalAlignment(SwingConstants.LEFT);
		returnDateField.setColumns(10);
		returnDateField.setBounds(91, 195, 163, 30);
		panel.add(returnDateField);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.LEFT);
		idField.setColumns(10);
		idField.setBounds(328, 141, 163, 30);
		panel.add(idField);
		
		DefaultComboBoxModel zaposlen = new DefaultComboBoxModel();
		for(Administrator a : biblioteka.dobaviNeobrisaneAdmine()) {
			zaposlen.addElement(a.getIme() + " " + a.getPrezime());
		}
		for(Bibliotekar b : biblioteka.dobaviNeobrisaneBibliotekare()) {
			zaposlen.addElement(b.getIme() + " " + b.getPrezime());
		}
		
		JComboBox employerBox = new JComboBox(zaposlen);
		employerBox.setBounds(328, 193, 163, 30);
		employerBox.setSelectedItem(null);
		panel.add(employerBox);
		
		DefaultComboBoxModel clan = new DefaultComboBoxModel();
		for (Član č : biblioteka.dobaviNeobrisaneČlanove()) {
			clan.addElement(č.getIme() + " " + č.getPrezime());
		}
		
		JComboBox clanBox = new JComboBox(clan);
		clanBox.setBounds(560, 141, 163, 30);
		clanBox.setSelectedItem(null);
		panel.add(clanBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(91, 288, 632, 108);
		panel.add(scrollPane_1);
		
		DefaultListModel listaModel = new DefaultListModel();
		
		this.listaPrimeraka = new JList(listaModel);
		scrollPane_1.setViewportView(listaPrimeraka);
		
		JButton addToListBttn = new JButton("Dodaj primerak");
		addToListBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selInd == -1) {
					dodavanjePrimerkaAdminSwing.main(new String[0], prozor);
				}
				else {
					String linija = model.getValueAt(selInd, 5).toString();
					String[] vrednosti = linija.split(",");
					dodavanjePrimerkaAdminSwing.main(vrednosti, prozor);					
				}
			}
		});
		addToListBttn.setBounds(733, 338, 144, 23);
		panel.add(addToListBttn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 422, 1137, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				selInd = i;
				DefaultComboBoxModel prim = new DefaultComboBoxModel();
				String[] vrednosti = model.getValueAt(i, 5).toString().split(",");
				if(vrednosti.length > 0) {
					for (String p : vrednosti) {
						prim.addElement(p);
					}					
				}
				
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				rentDateField.setText(model.getValueAt(i, 1).toString());
				rentDateField.disable();
				returnDateField.setText(model.getValueAt(i, 2).toString());
				employerBox.setSelectedItem(model.getValueAt(i, 3).toString());
				employerBox.disable();
				clanBox.setSelectedItem(model.getValueAt(i, 4).toString());
				clanBox.disable();
				listaPrimeraka.setModel(prim);
				
//				listaPrimeraka.setSelectedIndex(i);
				
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "DATUM IZNAJMLJIVANJA", "DATUM VRAĆANJA", "ZAPOSLENI", "ČLAN", "PRIMERCI"};
		final Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		
//---------------------------------------------------------------------------------
		
		try {
			File iznajmljivanjeFile = new File("src/txt/iznajmljivanje.txt");
			BufferedReader reader = new BufferedReader(new FileReader(iznajmljivanjeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				if(splitovanRed[6].equals("false")) {
					
					String ID = splitovanRed[0];
					row[0] = ID;
					
					LocalDate datumIznajmljivanja = LocalDate.parse(splitovanRed[1]);
					row[1] = datumIznajmljivanja;
					
					LocalDate datumVraćanja = LocalDate.parse(splitovanRed[2]);;
					row[2] = datumVraćanja;
					
					biblioteka.ucitajAdministratore();
					biblioteka.ucitajBibliotekare();
					Zaposleni zap = null;
					String imeZaposlenogID = splitovanRed[3];
					
					for (Zaposleni z : biblioteka.bibliotekari) {
						if(z.getId().equals(imeZaposlenogID)){
							zap = z;
							row[3] = zap.getIme() + " " + zap.getPrezime();
						}	
					}
					if (zap == null) {
						for(Zaposleni z : biblioteka.admini) {
							if(z.getId().equals(imeZaposlenogID)) {
								zap = z;
								row[3] = zap.getIme() + " " + zap.getPrezime();
							}
						}
					}
					
					biblioteka.učitajČlanove();
					Član član = null;
					String strČlanovi = splitovanRed[4];
					
					for(Član a : biblioteka.članovi) {
						if(a.getId().equals(strČlanovi)) {
							član = a;
							row[4] = član.getIme() + " " + član.getPrezime();
						}
					}
					
					biblioteka.učitajPrimerkeKnjiga();
					ArrayList<PrimerakKnjige> primerak = new ArrayList<PrimerakKnjige>();
					String sviPrimerci = "";
					String strKnjige = splitovanRed[5];
					for (String idKnjige : strKnjige.split(";")) {
						
						for(PrimerakKnjige a : biblioteka.primerakKnjige) {
							if(a.getId().equals(idKnjige)) {
								sviPrimerci += a.getNazivKnjige() + ",";
								primerak.add(a);
								row[5] = sviPrimerci;
							}
						}
					}
					model.addRow(row);
				}
			}
			
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj iznajmljivanje");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				rentDateField.enable();
				clanBox.enable();
				employerBox.enable();
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rentDateField.getText().equals("") || returnDateField.getText().equals("") || employerBox.getSelectedItem().equals(null)
					 || idField.getText().equals("") || clanBox.getSelectedItem().equals(null) || 
					 listaPrimeraka.getModel().getSize() == 0) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					
				}
				else {
					biblioteka.učitajIznajmljivanje();
					for(Iznajmljivanje i : biblioteka.iznajmljivanje){
						
						if(i.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Iznajmljivanje sa prosleđenim ID-ijem već postoji!");
							idField.setText("");
							return;
						}
					}	
					row[0] = idField.getText();
					row[1] = rentDateField.getText();
					row[2] = returnDateField.getText();
					row[3] = employerBox.getSelectedItem().toString();
					row[4] = clanBox.getSelectedItem();
					
					String idČlana = "";
					for (Član član : biblioteka.dobaviNeobrisaneČlanove()) {
						if((član.getIme() + " " + član.getPrezime()).equals(clanBox.getSelectedItem().toString())) {
							idČlana = član.getId();
						}
					}
					
					String idZaposlenog = "";
					Zaposleni zaposleni = null;
//					String zaposleniIme = String.valueOf(row[3].toString().split(" ")[0]);
//					String zaposleniPrezime = String.valueOf(row[3].toString().split(" ")[1]);
					
					for (Zaposleni z : biblioteka.dobaviNeobrisaneAdmine()) {
						String zapInf = z.getIme().toString() + " " + z.getPrezime().toString();
						if(zapInf.equals(row[3])) {
							zaposleni = z;
							idZaposlenog = zaposleni.getId();
						}
					}
					
					if (zaposleni == null) {
						for(Zaposleni z :biblioteka.dobaviNeobrisaneBibliotekare()) {
							String zapInf = z.getIme().toString() + " " + z.getPrezime().toString();
							if(zapInf.equals(row[3])) {
								zaposleni = z;
								idZaposlenog = zaposleni.getId();
								
							}
						}
					}
					
					
//					String s = "";
//					for(String s2 : imenaPrimeraka) {
//						s += s2 + ", ";
//					}
//					row[5] = s;
					
					String iznajmljeni = "";
					for(PrimerakKnjige pk : biblioteka.dobaviNeiznajmljenePrimerke()) {
						iznajmljeni += pk.getId().toString() + ";"; 
						row[5] = pk.getNazivKnjige().toString() + ";";
					}
					
					model.addRow(row);
					
					String iznajmljivanjeLinija = "";
					
					iznajmljivanjeLinija += row[0] + "|" + row[1] + "|" + row[2] + "|" + idZaposlenog + "|" + idČlana + "|" + iznajmljeni
							+ "|" + "false" + "\n";
					
					try {
						File iznajmljivanjeFile = new File("src/txt/iznajmljivanje.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(iznajmljivanjeFile, true));
						writer.write(iznajmljivanjeLinija);
						writer.close();
						
					}catch(IOException e1){
						System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Napravljeno iznajmljivanje!");
					
					rentDateField.setText("");
					returnDateField.setText("");
					employerBox.setSelectedItem(null);
					idField.setText("");
					clanBox.setSelectedItem(null);
					listaPrimeraka.removeAll();	
					
				}
					
			}
		});
		addButton.setBounds(850, 194, 163, 33);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj iznajmljivanje");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				rentDateField.enable();
				clanBox.enable();
				employerBox.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == 0) {
						
						String iznajmljivanjeID = model.getValueAt(i, 0).toString();
						LocalDate datumIzmene = LocalDate.parse(model.getValueAt(i, 2).toString());
						ArrayList <PrimerakKnjige> primerciKnjige = new ArrayList<PrimerakKnjige>();
						for (String s : imenaPrimeraka) {
							System.out.println(s);
							for(PrimerakKnjige p : biblioteka.primerakKnjige) {
								if(p.getNazivKnjige().equals(s)) {
									primerciKnjige.add(p);
								}
							}
						}
						biblioteka.ažurirajIznajmljivanje(iznajmljivanjeID, datumIzmene, primerciKnjige);

						JOptionPane.showMessageDialog(null, "Iznajmljivanje je uspešno ažurirano!");																	
					}
					JOptionPane.getRootFrame().dispose();
					rentDateField.setText("");
					returnDateField.setText("");
					employerBox.setSelectedItem(null);
					idField.setText("");
					clanBox.setSelectedItem(null);
					listaPrimeraka.removeAll();	
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite iznajmljivanje za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(80, 758, 177, 42);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni iznajmljivanje");
		removeButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				rentDateField.enable();
				clanBox.enable();
				employerBox.enable();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati iznajmljivanje?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						biblioteka.dobaviNeobrisanaIznajmljivanja().get(i).setJeObrisan(true);
						model.removeRow(i);
						rentDateField.setText("");
						returnDateField.setText("");
						employerBox.setSelectedItem(null);
						idField.setText("");
						clanBox.setSelectedItem(null);
						JOptionPane.showMessageDialog(null, "Iznajmljivanje je uspešno obrisan!");	
						biblioteka.upisiIznajmljivanje();
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite iznajmljivanje za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		removeButton.setBounds(296, 758, 177, 42);
		panel.add(removeButton);
		
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
		cancelButton.setBounds(970, 758, 177, 42);
		panel.add(cancelButton);
		
		clearButton = new JButton("Obriši unos");
		clearButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				idField.enable();
				rentDateField.enable();
				clanBox.enable();
				employerBox.enable();
				table.clearSelection();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentDateField.setText("");
				returnDateField.setText("");
				employerBox.setSelectedItem(null);
				idField.setText("");
				clanBox.setSelectedItem(null);
				listaPrimeraka.clearSelection();
			}
		});
		clearButton.setBounds(513, 758, 200, 42);
		panel.add(clearButton);
		
		headingČlanovi = new JLabel("~IZNAJMLJIVANJE~");
		headingČlanovi.setForeground(new Color(255, 255, 255));
		headingČlanovi.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingČlanovi.setHorizontalAlignment(SwingConstants.CENTER);
		headingČlanovi.setBounds(150, 15, 897, 90);
		panel.add(headingČlanovi);
		
		
		
		JLabel person = new JLabel("ČLAN:");
		person.setHorizontalAlignment(SwingConstants.LEFT);
		person.setForeground(Color.WHITE);
		person.setBounds(560, 116, 112, 30);
		panel.add(person);
		
		
		
		JLabel lblPrimerci = new JLabel("PRIMERCI:");
		lblPrimerci.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrimerci.setForeground(Color.WHITE);
		lblPrimerci.setBounds(91, 263, 112, 30);
		panel.add(lblPrimerci);
		
		
		
		
		
		
		
		
	}
}
