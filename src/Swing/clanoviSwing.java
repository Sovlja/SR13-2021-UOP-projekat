package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
import projekat.Član;
import projekat.Pol;
import projekat.TipČlanarine;

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

import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class clanoviSwing extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField jmbgField;
	private JTextField addressField;
	private JTextField idField;
	private JTextField cardField;
	private JTextField lastPaymentField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingČlanovi;
	private DefaultTableModel model;
	private JTextField monthsValidField;
	private JTextField passTypeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clanoviSwing frame = new clanoviSwing();
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
	public clanoviSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(clanoviSwing.class.getResource("/images/library-logo.png")));
		setTitle("Članovi - Biblioteka");
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
		
		JLabel name = new JLabel("IME:");
		name.setForeground(new Color(255, 255, 255));
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setBounds(243, 112, 112, 30);
		panel.add(name);
		
		JLabel surname = new JLabel("PREZIME:");
		surname.setForeground(new Color(255, 255, 255));
		surname.setHorizontalAlignment(SwingConstants.LEFT);
		surname.setBounds(243, 163, 112, 30);
		panel.add(surname);
		
		JLabel jmbg = new JLabel("JMBG:");
		jmbg.setForeground(new Color(255, 255, 255));
		jmbg.setHorizontalAlignment(SwingConstants.LEFT);
		jmbg.setBounds(243, 217, 112, 30);
		panel.add(jmbg);
		
		JLabel address = new JLabel("ADRESA:");
		address.setForeground(new Color(255, 255, 255));
		address.setHorizontalAlignment(SwingConstants.LEFT);
		address.setBounds(243, 272, 112, 30);
		panel.add(address);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setBounds(746, 112, 112, 30);
		panel.add(id);
		
		JRadioButton activityCheck = new JRadioButton("AKTIVNOST");
		activityCheck.setForeground(new Color(255, 255, 255));
		activityCheck.setBackground(new Color(51, 51, 153));
		
		activityCheck.setSelected(true);
		activityCheck.setBounds(522, 335, 93, 30);
		panel.add(activityCheck);
		
		
		JLabel card = new JLabel("BROJ ČLANSKE KARTE:");
		card.setForeground(new Color(255, 255, 255));
		card.setHorizontalAlignment(SwingConstants.LEFT);
		card.setBounds(746, 163, 136, 30);
		panel.add(card);
		
		
		JLabel lastPayment = new JLabel("POSLEDNJA UPLATA:");
		lastPayment.setForeground(new Color(255, 255, 255));
		lastPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lastPayment.setBounds(746, 272, 136, 30);
		panel.add(lastPayment);
		
		JLabel monthsValid = new JLabel("VAŽENJE UPLATE(mm):");
		monthsValid.setForeground(new Color(255, 255, 255));
		monthsValid.setHorizontalAlignment(SwingConstants.LEFT);
		monthsValid.setBounds(746, 329, 151, 30);
		panel.add(monthsValid);
		
		JLabel gender = new JLabel("POL:");
		gender.setForeground(new Color(255, 255, 255));
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setBounds(243, 329, 42, 30);
		panel.add(gender);
		
		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setBounds(243, 134, 144, 30);
		panel.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setHorizontalAlignment(SwingConstants.LEFT);
		surnameField.setColumns(10);
		surnameField.setBounds(243, 188, 144, 30);
		panel.add(surnameField);
		
		jmbgField = new JTextField();
		jmbgField.setHorizontalAlignment(SwingConstants.LEFT);
		jmbgField.setColumns(10);
		jmbgField.setBounds(243, 242, 144, 30);
		panel.add(jmbgField);
		
		addressField = new JTextField();
		addressField.setHorizontalAlignment(SwingConstants.LEFT);
		addressField.setColumns(10);
		addressField.setBounds(243, 297, 144, 30);
		panel.add(addressField);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.LEFT);
		idField.setColumns(10);
		idField.setBounds(746, 134, 144, 30);
		panel.add(idField);
		
		cardField = new JTextField();
		cardField.setHorizontalAlignment(SwingConstants.LEFT);
		cardField.setColumns(10);
		cardField.setBounds(746, 188, 144, 30);
		panel.add(cardField);
		
		lastPaymentField = new JTextField();
		lastPaymentField.setHorizontalAlignment(SwingConstants.LEFT);
		lastPaymentField.setColumns(10);
		lastPaymentField.setBounds(746, 297, 144, 30);
		panel.add(lastPaymentField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 422, 1137, 311);
		panel.add(scrollPane);
		
		@SuppressWarnings("rawtypes")
		JComboBox polovi = new JComboBox();
		polovi.setBounds(243, 354, 144, 30);
		polovi.addItem(Pol.OSTALO);
		polovi.addItem(Pol.MUŠKI);
		polovi.addItem(Pol.ŽENSKI);
		polovi.setSelectedItem(null);
		panel.add(polovi);
		
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
				cardField.setText(model.getValueAt(i, 5).toString());
				lastPaymentField.setText(model.getValueAt(i, 6).toString());
				monthsValidField.setText(model.getValueAt(i, 7).toString());
				polovi.setSelectedItem(model.getValueAt(i, 9));	
				
				Biblioteka b = new Biblioteka();
				b.getČlanovi();
				
				for(Član č : b.članovi) {
					if(č.isAktivan()) {
						activityCheck.setSelected(true);	
					}
					else {
						activityCheck.setSelected(false);
					}
				}
				
				polovi.setSelectedItem(model.getValueAt(i, 9).toString());								
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "PREZIME", "JMBG", "ADRESA", "IME", "BR. ČLANSKE KARTE", "POSLEDNJA UPLATA", "VAŽENJE UPLATE", "AKTIVNOST", "POL", "TIP ČLANARINE"};
		final Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		Biblioteka biblioteka = new Biblioteka();
		try {
			File članFile = new File("src/txt/članovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(članFile));
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
				
				String brojČlanskeKarte = splitovanRed[5];
				row[5] = brojČlanskeKarte;
				
				LocalDate datumPoslednjeUplate = LocalDate.parse(splitovanRed[6]);
				row[6] = datumPoslednjeUplate;

				int važenjeUplate = Integer.parseInt(splitovanRed[7]);
				row[7] = važenjeUplate;
				
			
				biblioteka.učitajČlanove();
				
				if(splitovanRed[8].equals("true")) {
					row[8] = "aktivan";
				}
				else {
					row[8] = "neaktivan";
				}
				
				Pol pol = Pol.valueOf(splitovanRed[9]);
				row[9] = pol;
				
				TipČlanarine tipČlanarine = new TipČlanarine();
				String tipČlanarineID = splitovanRed[10];
				biblioteka.učitajTipČlanarine();
				for (TipČlanarine t : biblioteka.tipČlanarine) {
					if (t.getId().equals(tipČlanarineID)) {
						tipČlanarine = t;
						row[10] = tipČlanarine.getNaziv();
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
		addButton = new JButton("Dodaj člana");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				jmbgField.enable();
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().equals("") || surnameField.getText().equals("") || jmbgField.getText().equals("") || 
					addressField.getText().equals("") || idField.getText().equals("") || cardField.getText().equals("") || 
					lastPaymentField.getText().equals("") || monthsValidField.getText().equals("") || polovi.getSelectedItem().equals(null) || passTypeField.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					
				}
				else {
					biblioteka.učitajČlanove();
					for(Član č : biblioteka.članovi){
						
						if(č.getJMBG().equals(jmbgField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Član sa prosleđenim JMBG-om već postoji!");
							jmbgField.setText("");
							return;
						}
						
						if(č.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Član sa prosleđenim ID-ijem već postoji!");
							idField.setText("");
							return;
						}
						
						if(č.getBrojČlanskeKarte().equals(cardField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Član sa prosleđenom članskom kartom već postoji!");
							cardField.setText("");
							return;
						}
						
					}	
					row[0] = idField.getText();
					row[1] = surnameField.getText();
					row[2] = jmbgField.getText();
					row[3] = addressField.getText();
					row[4] = nameField.getText();
					row[5] = cardField.getText();
					row[6] = lastPaymentField.getText();
					row[7] = monthsValidField.getText();
					
					Biblioteka b = new Biblioteka();
					b.getČlanovi();
					
					for(Član č : b.članovi) {
						if(č.isAktivan()) {
							activityCheck.setSelected(true);
							row[8] = "aktivan";
						}
						else {
							activityCheck.setSelected(false);
							row[8] = "neaktivan";
						}
					}
					
					
					row[9] = polovi.getSelectedItem();
					row[10] = passTypeField.getText();
					
					model.addRow(row);
					
					JOptionPane.showMessageDialog(null, "Član uspešno dodat u listu!");
					
					nameField.setText("");
					surnameField.setText("");
					jmbgField.setText("");
					addressField.setText("");
					idField.setText("");
					cardField.setText("");
					lastPaymentField.setText("");
					monthsValidField.setText("");
					activityCheck.setSelected(false);
					polovi.setSelectedItem(null);	
					passTypeField.setText("");
					
				}
					
			}
		});
		addButton.setBounds(465, 370, 200, 36);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj člana");
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
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.setValueAt(surnameField.getText(), i, 1);
						model.setValueAt(jmbgField.getText(), i, 2);
						model.setValueAt(addressField.getText(), i, 3);
						model.setValueAt(nameField.getText(), i, 4);
						model.setValueAt(cardField.getText(), i, 5);
						model.setValueAt(lastPaymentField.getText(), i, 6);
						model.setValueAt(monthsValidField.getText(), i, 7);
						
//						Biblioteka b = new Biblioteka();
//						b.getČlanovi();
//						
//						for(Član č : b.članovi) {
//							if(č.isAktivan()) {
//								activityCheck.setSelected(true);
//								row[8] = "aktivan";
//							}
//							else {
//								activityCheck.setSelected(false);
//								row[8] = "neaktivan";
//							}
//						}
						
						model.setValueAt(polovi.getSelectedItem(), i, 9);
						model.setValueAt(passTypeField.getText(), i, 10);
						JOptionPane.showMessageDialog(null, "Član je uspešno ažuriran!");																	
					}
					JOptionPane.getRootFrame().dispose();
					nameField.setText("");
					surnameField.setText("");
					jmbgField.setText("");
					addressField.setText("");
					idField.setText("");
					cardField.setText("");
					lastPaymentField.setText("");
					monthsValidField.setText("");
					
					polovi.setSelectedItem(null);
					passTypeField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite člana za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(80, 758, 177, 42);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni člana");
		removeButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				jmbgField.enable();
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
						nameField.setText("");
						surnameField.setText("");
						jmbgField.setText("");
						addressField.setText("");
						idField.setText("");
						cardField.setText("");
						lastPaymentField.setText("");
						monthsValidField.setText("");
						activityCheck.setSelected(false);
						polovi.setSelectedItem(null);
						passTypeField.setText("");
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
				jmbgField.enable();
				idField.enable();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				surnameField.setText("");
				jmbgField.setText("");
				addressField.setText("");
				idField.setText("");
				cardField.setText("");
				lastPaymentField.setText("");
				monthsValidField.setText("");
				activityCheck.setSelected(false);
				polovi.setSelectedItem(null);
			}
		});
		clearButton.setBounds(513, 758, 200, 42);
		panel.add(clearButton);
		
		headingČlanovi = new JLabel("~ČLANOVI~");
		headingČlanovi.setForeground(new Color(255, 255, 255));
		headingČlanovi.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingČlanovi.setHorizontalAlignment(SwingConstants.CENTER);
		headingČlanovi.setBounds(243, 38, 647, 90);
		panel.add(headingČlanovi);
		
		monthsValidField = new JTextField();
		monthsValidField.setColumns(10);
		monthsValidField.setBounds(746, 354, 144, 30);
		panel.add(monthsValidField);
		
		
		passTypeField = new JTextField();
		passTypeField.setHorizontalAlignment(SwingConstants.LEFT);
		passTypeField.setColumns(10);
		passTypeField.setBounds(746, 242, 144, 30);
		panel.add(passTypeField);
		
		JLabel passType = new JLabel("TIP ČLANARINE:");
		passType.setHorizontalAlignment(SwingConstants.LEFT);
		passType.setForeground(Color.WHITE);
		passType.setBounds(746, 217, 112, 30);
		panel.add(passType);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(clanoviSwing.class.getResource("/images/avatarPic.png")));
		lblNewLabel.setBounds(467, 134, 200, 200);
		panel.add(lblNewLabel);
		
	}
}
