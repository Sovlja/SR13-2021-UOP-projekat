package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
import projekat.Jezik;
import projekat.Knjiga;
import projekat.PrimerakKnjige;
import projekat.TipPoveza;

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
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class primerakSwing extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingKnjige;
	private DefaultTableModel model;
	private JTextField headingCopyField;
	private JTextField printingYearField;
	private JTextField pagesField;
	private JTextField idField;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primerakSwing frame = new primerakSwing();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public primerakSwing() {
		this.biblioteka = new Biblioteka();
		setIconImage(Toolkit.getDefaultToolkit().getImage(primerakSwing.class.getResource("/images/library-logo.png")));
		setTitle("Primerci - Biblioteka");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 836);
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
		mojProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				naslovnaAdminSwing.main(null);
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
		panel.setBounds(0, 0, 1139, 775);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox jezikŠtampe = new JComboBox();
		jezikŠtampe.setBounds(83, 241, 263, 30);
		jezikŠtampe.addItem(Jezik.SRPSKI);
		jezikŠtampe.addItem(Jezik.ENGLESKI);
		jezikŠtampe.addItem(Jezik.MAĐARSKI);
		jezikŠtampe.addItem(Jezik.NEMAČKI);
		jezikŠtampe.addItem(Jezik.RUSKI);
		jezikŠtampe.setSelectedItem(null);
		panel.add(jezikŠtampe);
		
		JComboBox povezi = new JComboBox();
		povezi.setBounds(746, 190, 297, 30);
		povezi.addItem(TipPoveza.MEKI);
		povezi.addItem(TipPoveza.TVRDI);
		povezi.setSelectedItem(null);
		panel.add(povezi);
		
		JRadioButton rentCheck = new JRadioButton("IZNAJMLJENOST");
		rentCheck.setSelected(true);
		rentCheck.setForeground(Color.WHITE);
		rentCheck.setBackground(new Color(51, 51, 153));
		rentCheck.setBounds(83, 278, 141, 30);
		panel.add(rentCheck);
		
		
		JLabel headingCopy = new JLabel("NAZIV:");
		headingCopy.setHorizontalAlignment(SwingConstants.LEFT);
		headingCopy.setForeground(Color.WHITE);
		headingCopy.setBounds(83, 112, 263, 30);
		panel.add(headingCopy);
		
		DefaultComboBoxModel sveKnjige = new DefaultComboBoxModel();
		for(Knjiga k : biblioteka.dobaviNeobrisaneKnjige()) {
			sveKnjige.addElement(k.getOriginalniNaslov());
		}
		JComboBox bookBox = new JComboBox(sveKnjige);
		bookBox.setBounds(746, 137, 297, 30);
		bookBox.setSelectedItem(null);
		panel.add(bookBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 438, 1089, 267);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				headingCopyField.setText(model.getValueAt(i, 1).toString());
				printingYearField.setText(model.getValueAt(i, 2).toString());
				printingYearField.disable();
				pagesField.setText(model.getValueAt(i, 3).toString());
				pagesField.disable();
				
				jezikŠtampe.setSelectedItem(model.getValueAt(i, 4));
				jezikŠtampe.disable();
				bookBox.setSelectedItem(model.getValueAt(i, 5).toString());
				bookBox.disable();
				povezi.setSelectedItem(model.getValueAt(i, 6));
				rentCheck.setSelected(model.getValueAt(i, 7).toString().equals("iznajmljen"));
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "NAZIV", "GODINA ŠTAMPE", "BROJ STRANA", "JEZIK ŠTAMPE", "ORIGINAL", "POVEZ", "IZNAJMLJENOST"};
		final Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		
		try {
			File primerakFile = new File("src/txt/primerciKnjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(primerakFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				if(splitovanRed[5].equals("false")) {
					String brojStrana = splitovanRed[0];
					row[3] = brojStrana;
					
					String godinaŠtampe = splitovanRed[1];
					row[2] = godinaŠtampe;
					
					boolean iznajmljenost = Boolean.parseBoolean(splitovanRed[2]);
					
					if(iznajmljenost == true) {
						row[7] = "iznajmljen";	
					}
					else {
						row[7] = "nije iznajmljen";
					}
					
					String naziv = splitovanRed[3];
					row[1] = naziv;
					
					String ID = splitovanRed[4];
					row[0] = ID;
					
					Jezik jezik = Jezik.valueOf(splitovanRed[6]); 
					row[4] = jezik;
					
					Knjiga knjiga = new Knjiga();
					String knjigaID = splitovanRed[7];
					biblioteka.učitajKnjige();
					
					for (Knjiga k : biblioteka.knjige) {
						if (k.getId().equals(knjigaID)) {
							knjiga = k;
							row[5] = knjiga.getOriginalniNaslov();
						}
					}
					
					TipPoveza povez = TipPoveza.valueOf(splitovanRed[8]);
					row[6] = povez;
					model.addRow(row);		
				}
			}
			reader.close();
			} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke hehe: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj primerak");
		
		addButton.addMouseListener(new MouseAdapter() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				printingYearField.enable();
				bookBox.enable();
				pagesField.enable();
				jezikŠtampe.enable();
			}
		});
		addButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(headingCopyField.getText().equals("") || printingYearField.getText().equals("") || 
					pagesField.getText().equals("") || idField.getText().equals("") || bookBox.getSelectedItem().equals(null)) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					return;
				}
				else {
					biblioteka.učitajPrimerkeKnjiga();
					for(PrimerakKnjige k : biblioteka.primerakKnjige){
						
						if(k.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Primerak sa prosleđenim ID-ijem već postoji!");
							idField.setText("");	
							return;
						}
						
					}	
					row[0] = idField.getText();
					row[1] = headingCopyField.getText();
					row[2] = printingYearField.getText();
					row[3] = pagesField.getText();
					row[4] = jezikŠtampe.getSelectedItem();
					
					int selectedBook = bookBox.getSelectedIndex();
					row[5] = bookBox.getSelectedItem();
					String selectedBookID = biblioteka.dobaviNeobrisaneKnjige().get(selectedBook).getId();
					
					row[6] = povezi.getSelectedItem();
					
					String iznajmljen = String.valueOf(rentCheck.isSelected());
					
					if(iznajmljen == "true") {
						row[7] = "iznajmljen";
					}
					else {
						row[7] = "nije iznajmljen";
					}
					
					model.addRow(row);
					
					String primerakLinija = "";
					
					primerakLinija += row[3] + "|" + row[2] + "|" + iznajmljen + "|" + row[1] + "|" + row[0] + "|" + "false" + "|" + row[4] + "|" + selectedBookID + "|" + row[6] + "\n";
					
					try {
						File primerakFile = new File("src/txt/primerciKnjige.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(primerakFile, true));
						writer.write(primerakLinija);
						writer.close();
						
					}catch(IOException e1){
						System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
					}
				
					
					JOptionPane.showMessageDialog(null, "Primerak uspešno dodat u listu!");
					
					headingCopyField.setText("");
					printingYearField.setText("");
					pagesField.setText("");
					idField.setText("");
					bookBox.setSelectedItem(null);
					jezikŠtampe.setSelectedItem(null);
					rentCheck.setSelected(false);
					povezi.setSelectedItem(null);
				}
					
			}
		});
		addButton.setBounds(566, 379, 177, 30);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj primerak");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				printingYearField.enable();
				bookBox.enable();
				pagesField.enable();
				jezikŠtampe.enable();
				
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						
						String primerakID = biblioteka.dobaviNeobrisanePrimerke().get(i).getId();
						String[] izmene = new String[4];
						TipPoveza[] povezIzmene = new TipPoveza[9];
						
						izmene[3] = headingCopyField.getText();
						boolean iznajmljenost = rentCheck.isSelected();
						povezIzmene[8] = TipPoveza.valueOf(povezi.getSelectedItem().toString());
						
						biblioteka.ažurirajPrimerak(primerakID, izmene, iznajmljenost, povezIzmene);
						
						JOptionPane.showMessageDialog(null, "Primerak je uspešno ažuriran!");																	
					}
					JOptionPane.getRootFrame().dispose();
					headingCopyField.setText("");
					printingYearField.setText("");
					pagesField.setText("");
					idField.setText("");
					bookBox.setSelectedItem(null);
					jezikŠtampe.setSelectedItem(null);
					rentCheck.setSelected(false);
					povezi.setSelectedItem(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite primerak za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(47, 730, 177, 34);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni primerak");
		removeButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				printingYearField.enable();
				bookBox.enable();
				pagesField.enable();
				jezikŠtampe.enable();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati primerak?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						biblioteka.dobaviNeobrisanePrimerke().get(i).setJeObrisan(true);
						model.removeRow(i);
						headingCopyField.setText("");
						printingYearField.setText("");
						pagesField.setText("");
						idField.setText("");
						bookBox.setSelectedItem(null);
						jezikŠtampe.setSelectedItem(null);
						povezi.setSelectedItem(null);
						rentCheck.setSelected(false);
						JOptionPane.showMessageDialog(null, "Primerak je uspešno obrisan!");												
						biblioteka.upišiPrimerakKnjige();
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite primerak za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		removeButton.setBounds(249, 730, 177, 34);
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
		cancelButton.setBounds(906, 730, 177, 34);
		panel.add(cancelButton);
		
		clearButton = new JButton("Obriši unos");
		clearButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				idField.enable();
				printingYearField.enable();
				bookBox.enable();
				pagesField.enable();
				jezikŠtampe.enable();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headingCopyField.setText("");
				printingYearField.setText("");
				pagesField.setText("");
				idField.setText("");
				bookBox.setSelectedItem(null);
				jezikŠtampe.setSelectedItem(null);
				povezi.setSelectedItem(null);
			}
		});
		clearButton.setBounds(449, 730, 177, 34);
		panel.add(clearButton);
		
		headingKnjige = new JLabel("~PRIMERCI KNJIGA~");
		headingKnjige.setForeground(new Color(255, 255, 255));
		headingKnjige.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingKnjige.setHorizontalAlignment(SwingConstants.CENTER);
		headingKnjige.setBounds(83, 29, 960, 81);
		panel.add(headingKnjige);
		
		JLabel lang = new JLabel("JEZIK ŠTAMPE:");
		lang.setHorizontalAlignment(SwingConstants.LEFT);
		lang.setForeground(Color.WHITE);
		lang.setBounds(83, 217, 263, 30);
		panel.add(lang);
		
		
		headingCopyField = new JTextField();
		headingCopyField.setColumns(10);
		headingCopyField.setBounds(83, 137, 263, 30);
		panel.add(headingCopyField);
		
		JLabel printingYear = new JLabel("GODINA ŠTAMPE:");
		printingYear.setHorizontalAlignment(SwingConstants.LEFT);
		printingYear.setForeground(Color.WHITE);
		printingYear.setBounds(83, 166, 263, 30);
		panel.add(printingYear);
		
		printingYearField = new JTextField();
		printingYearField.setColumns(10);
		printingYearField.setBounds(83, 190, 263, 30);
		panel.add(printingYearField);
		
		JLabel pages = new JLabel("BROJ STRANA:");
		pages.setHorizontalAlignment(SwingConstants.LEFT);
		pages.setForeground(Color.WHITE);
		pages.setBounds(746, 217, 112, 30);
		panel.add(pages);
		
		pagesField = new JTextField();
		pagesField.setColumns(10);
		pagesField.setBounds(746, 241, 297, 30);
		panel.add(pagesField);
		
		JLabel id = new JLabel("ID:");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setForeground(Color.WHITE);
		id.setBounds(747, 269, 215, 30);
		panel.add(id);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(746, 291, 297, 30);
		panel.add(idField);
		
		
		JLabel book = new JLabel("KNJIGA:");
		book.setHorizontalAlignment(SwingConstants.LEFT);
		book.setForeground(Color.WHITE);
		book.setBounds(746, 112, 112, 30);
		panel.add(book);
		
		JLabel bindingType = new JLabel("TIP POVEZA:");
		bindingType.setHorizontalAlignment(SwingConstants.LEFT);
		bindingType.setForeground(Color.WHITE);
		bindingType.setBounds(746, 165, 112, 30);
		panel.add(bindingType);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(knjigaSwing.class.getResource("/images/book_add.png")));
		picLabel.setBounds(414, 112, 250, 256);
		panel.add(picLabel);
		
		JButton returnButton = new JButton("Nazad");
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Nazad na knjige?","Potvrda", dialogButton);
				
				if(dialogResult == 0) {
					dispose();
					knjigaSwing.main(null);
				}
				
				JOptionPane.getRootFrame().dispose();
			}
		});
		returnButton.setBounds(353, 379, 177, 30);
		panel.add(returnButton);
			
		
	}
}