package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class iznajmljivanjeSwing extends JFrame {

	private JPanel contentPane;
	private JTextField rentDateField;
	private JTextField returnDateField;
	private JTextField employerField;
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
	private JTextField personField;
	private JTextField exampleField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iznajmljivanjeSwing frame = new iznajmljivanjeSwing();
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
	public iznajmljivanjeSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(iznajmljivanjeSwing.class.getResource("/images/library-logo.png")));
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
		
		JMenu admin = new JMenu("Admin");
		admin.setForeground(new Color(0, 0, 0));
		menuBar.add(admin);
		
		JMenuItem mojProfil = new JMenuItem("Moj profil");
		admin.add(mojProfil);
		
		JMenu zaposleni = new JMenu("Zaposleni");
		zaposleni.setEnabled(false);
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
		skladište.setEnabled(false);
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
				clanoviSwing.main(null);
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
		rentDate.setBounds(150, 116, 163, 30);
		panel.add(rentDate);
		
		JLabel returnDate = new JLabel("DATUM VRAĆANJA:");
		returnDate.setForeground(new Color(255, 255, 255));
		returnDate.setHorizontalAlignment(SwingConstants.LEFT);
		returnDate.setBounds(150, 167, 144, 30);
		panel.add(returnDate);
		
		JLabel employer = new JLabel("ZAPOSLENI:");
		employer.setForeground(new Color(255, 255, 255));
		employer.setHorizontalAlignment(SwingConstants.LEFT);
		employer.setBounds(150, 221, 112, 30);
		panel.add(employer);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setBounds(387, 116, 112, 30);
		panel.add(id);
		
		
		JLabel example = new JLabel("PRIMERAK:");
		example.setForeground(new Color(255, 255, 255));
		example.setHorizontalAlignment(SwingConstants.LEFT);
		example.setBounds(387, 167, 136, 30);
		panel.add(example);
		
		rentDateField = new JTextField();
		rentDateField.setHorizontalAlignment(SwingConstants.LEFT);
		rentDateField.setBounds(150, 138, 163, 30);
		panel.add(rentDateField);
		rentDateField.setColumns(10);
		
		returnDateField = new JTextField();
		returnDateField.setHorizontalAlignment(SwingConstants.LEFT);
		returnDateField.setColumns(10);
		returnDateField.setBounds(150, 192, 163, 30);
		panel.add(returnDateField);
		
		employerField = new JTextField();
		employerField.setHorizontalAlignment(SwingConstants.LEFT);
		employerField.setColumns(10);
		employerField.setBounds(150, 246, 163, 30);
		panel.add(employerField);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.LEFT);
		idField.setColumns(10);
		idField.setBounds(387, 138, 188, 30);
		panel.add(idField);
		
		personField = new JTextField();
		personField.setHorizontalAlignment(SwingConstants.LEFT);
		personField.setColumns(10);
		personField.setBounds(150, 299, 163, 30);
		panel.add(personField);
		
		exampleField = new JTextField();
		exampleField.setBounds(387, 192, 188, 30);
		panel.add(exampleField);
		exampleField.setColumns(10);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 422, 1137, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				rentDateField.setText(model.getValueAt(i, 1).toString());
				returnDateField.setText(model.getValueAt(i, 2).toString());
				employerField.setText(model.getValueAt(i, 3).toString());
				personField.setText(model.getValueAt(i, 4).toString());
				exampleField.setText(model.getValueAt(i, 5).toString());
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "DATUM IZNAJMLJIVANJA", "DATUM VRAĆANJA", "ZAPOSLENI", "ČLAN", "PRIMERCI"};
		final Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		Biblioteka biblioteka = new Biblioteka();
		
		try {
			File iznajmljivanjeFile = new File("src/txt/iznajmljivanje.txt");
			BufferedReader reader = new BufferedReader(new FileReader(iznajmljivanjeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
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
				PrimerakKnjige primerak = null;
				String strKnjige = splitovanRed[5];
				
				for(PrimerakKnjige a : biblioteka.primerakKnjige) {
					if(a.getId().equals(strKnjige)) {
						primerak = a;
						row[5] = primerak.getNazivKnjige();
					}
				}
				model.addRow(row);
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
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rentDateField.getText().equals("") || returnDateField.getText().equals("") || employerField.getText().equals("")
					 || idField.getText().equals("") || exampleField.getText().equals("") || 
					 personField.getText().equals("")) {
					
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
					row[3] = employerField.getText();
					row[4] = personField.getText();
					row[5] = exampleField.getText();
					
					model.addRow(row);
					
					JOptionPane.showMessageDialog(null, "Napravljeno iznajmljivanje!");
					
					rentDateField.setText("");
					returnDateField.setText("");
					employerField.setText("");
					idField.setText("");
					exampleField.setText("");	
					personField.setText("");
					
				}
					
			}
		});
		addButton.setBounds(387, 375, 188, 36);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj iznajmljivanje");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.setValueAt(rentDateField.getText(), i, 1);
						model.setValueAt(returnDateField.getText(), i, 2);
						model.setValueAt(employerField.getText(), i, 3);
						model.setValueAt(personField.getText(), i, 4);
						model.setValueAt(exampleField.getText(), i, 5);

						JOptionPane.showMessageDialog(null, "Iznajmljivanje je uspešno ažurirano!");																	
					}
					JOptionPane.getRootFrame().dispose();
					rentDateField.setText("");
					returnDateField.setText("");
					employerField.setText("");
					idField.setText("");
					exampleField.setText("");
					personField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite člana za ažuriranje!");
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
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati člana?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.removeRow(i);
						rentDateField.setText("");
						returnDateField.setText("");
						employerField.setText("");
						idField.setText("");
						exampleField.setText("");
						personField.setText("");
						JOptionPane.showMessageDialog(null, "Član je uspešno obrisan!");												
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite člana za brisanje!");
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
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentDateField.setText("");
				returnDateField.setText("");
				employerField.setText("");
				idField.setText("");
				exampleField.setText("");
				personField.setText("");
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
		
		
		
		JLabel person = new JLabel("ČLAN");
		person.setHorizontalAlignment(SwingConstants.LEFT);
		person.setForeground(Color.WHITE);
		person.setBounds(150, 274, 112, 30);
		panel.add(person);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(iznajmljivanjeSwing.class.getResource("/images/rentBook.PNG")));
		lblNewLabel.setBounds(691, 116, 356, 277);
		panel.add(lblNewLabel);
		
		
		
	}
}
