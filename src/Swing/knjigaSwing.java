package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
import projekat.Knjiga;
import projekat.Žanr;

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
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class knjigaSwing extends JFrame {

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
	private JTextField headingField;
	private JTextField originalHeadingField;
	private JTextField yearField;
	private JTextField idField;
	private JTextField languageField;
	private JTextField writterField;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					knjigaSwing frame = new knjigaSwing();
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
	 * @param new Biblioteka() 
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public knjigaSwing() {
		this.biblioteka = new Biblioteka();
		setIconImage(Toolkit.getDefaultToolkit().getImage(knjigaSwing.class.getResource("/images/library-logo.png")));
		setTitle("Knjige - Biblioteka");
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
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(103, 256, 243, 115);
		panel.add(textArea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 438, 1089, 267);
		panel.add(scrollPane);
		
		biblioteka.učitajŽanrove();
		DefaultComboBoxModel zanrovi = new DefaultComboBoxModel();
		for (Žanr ž : biblioteka.dobaviNeobrisaneŽanrove()) {
			zanrovi.addElement(ž.getOznaka());
		}
		JComboBox genreBox = new JComboBox(zanrovi);
		genreBox.setBounds(746, 241, 270, 30);
		genreBox.setSelectedItem(null);
		panel.add(genreBox);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				headingField.setText(model.getValueAt(i, 1).toString());
				originalHeadingField.setText(model.getValueAt(i, 2).toString());
				originalHeadingField.disable();
				yearField.setText(model.getValueAt(i, 3).toString());
				yearField.disable();
				textArea.setText(model.getValueAt(i, 4).toString());
				languageField.setText(model.getValueAt(i, 5).toString());
				languageField.disable();
				writterField.setText(model.getValueAt(i, 6).toString());
				writterField.disable();
				genreBox.setSelectedItem(model.getValueAt(i, 7).toString());
				genreBox.disable();
			}
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "NASLOV", "ORIGINALNI NASLOV", "OBJAVLJENO", "OPIS", "JEZIK", "AUTOR", "ŽANR"};
		final Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		try {
			File knjigeFile = new File("src/txt/knjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(knjigeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				if (splitovanRed[8].equals("false")) {
					String ID = splitovanRed[0];
					row[0] = ID;
					
					String naslov = splitovanRed[1];
					row[1] = naslov;
					
					String originalniNaslov = splitovanRed[2];
					row[2] = originalniNaslov;
					
					int godina = Integer.parseInt(splitovanRed[3]);
					row[3] = godina;
					
					String opis = splitovanRed[4];
					row[4] = opis;
					
					String jezik = splitovanRed[5];
					row[5] = jezik;
					
					String pisac = splitovanRed[6];
					row[6] = pisac;
					
					Žanr žanr = new Žanr();
					String žanrID = splitovanRed[7];
					biblioteka.učitajŽanrove();
					for (Žanr ž : biblioteka.žanrKnjige) {
						if (ž.getId().equals(žanrID)) {
							žanr = ž;
							row[7] = žanr.getOznaka();
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
		addButton = new JButton("Dodaj knjigu");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
				yearField.enable();
				writterField.enable();
				languageField.enable();
				genreBox.enable();
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getText().equals("") || headingField.getText().equals("") || originalHeadingField.getText().equals("") || 
					yearField.getText().equals("") || idField.getText().equals("") || languageField.getText().equals("") || 
					writterField.getText().equals("") || genreBox.getSelectedItem().equals(null)) {
					
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					return;
				}
				else {
					biblioteka.učitajKnjige();
					for(Knjiga k : biblioteka.knjige){
						if(k.getOriginalniNaslov().contains(originalHeadingField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Knjiga sa prosleđenim naslovom već postoji!");
							originalHeadingField.setText("");
							return;
						}
						
						if(k.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Knjiga sa prosleđenim ID-ijem već postoji!");
							idField.setText("");	
							return;
						}
						
					}	
					row[0] = idField.getText();
					row[1] = headingField.getText();
					row[2] = originalHeadingField.getText();
					row[3] = yearField.getText();
					row[4] = textArea.getText();
					row[5] = languageField.getText();
					row[6] = writterField.getText();
					int selected = genreBox.getSelectedIndex();
					row[7] = genreBox.getSelectedItem();
					String selectedID = biblioteka.dobaviNeobrisaneŽanrove().get(selected).getId();
					
					model.addRow(row);
				
					String knjigaLinija = "";
					
					knjigaLinija += row[0] + "|" + row[1] + "|" + row[2] + "|" + row[3] + "|" + row[4] + "|" + row[5] + "|" + row[6] + "|" + selectedID + "|" + "false" + "\n";
					
					try {
						File članFile = new File("src/txt/knjige.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(članFile, true));
						writer.write(knjigaLinija);
						writer.close();
						
					}catch(IOException e1){
						System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
					}
					JOptionPane.showMessageDialog(null, "Knjiga uspešno dodata u listu!");
					
					textArea.setText("");
					headingField.setText("");
					originalHeadingField.setText("");
					yearField.setText("");
					idField.setText("");
					languageField.setText("");
					writterField.setText("");
					genreBox.setSelectedItem(null);
				}
					
			}
		});
		addButton.setBounds(346, 397, 177, 30);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj knjigu");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
				yearField.enable();
				writterField.enable();
				languageField.enable();
				genreBox.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						
						String knjigaID = biblioteka.dobaviNeobrisaneKnjige().get(i).getId();
						String [] izmene = new String[7];
						
						izmene[1] = headingField.getText();
						izmene[4] = textArea.getText();
						
						biblioteka.ažurirajKnjigu(knjigaID, izmene);
						
						JOptionPane.showMessageDialog(null, "Knjiga je uspešno ažurirana!");																	
					}
					JOptionPane.getRootFrame().dispose();
					textArea.setText("");
					headingField.setText("");
					originalHeadingField.setText("");
					yearField.setText("");
					idField.setText("");
					languageField.setText("");
					writterField.setText("");
					genreBox.setSelectedItem(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite knjigu za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(47, 730, 177, 34);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni knjigu");
		removeButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
				yearField.enable();
				writterField.enable();
				languageField.enable();
				genreBox.enable();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati knjigu?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						biblioteka.dobaviNeobrisaneKnjige().get(i).setJeObrisan(true);
						model.removeRow(i);
						textArea.setText("");
						headingField.setText("");
						originalHeadingField.setText("");
						yearField.setText("");
						idField.setText("");
						languageField.setText("");
						writterField.setText("");
						genreBox.setSelectedItem(null);;
						JOptionPane.showMessageDialog(null, "Knjiga je uspešno obrisana!");
						biblioteka.upišiKnjigu();
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite knjigu za brisanje!");
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
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
				yearField.enable();
				writterField.enable();
				languageField.enable();
				genreBox.enable();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				headingField.setText("");
				originalHeadingField.setText("");
				yearField.setText("");
				idField.setText("");
				languageField.setText("");
				writterField.setText("");
				genreBox.setSelectedItem(null);
				
			}
		});
		clearButton.setBounds(570, 397, 177, 30);
		panel.add(clearButton);
		
		headingKnjige = new JLabel("~KNJIGE~");
		headingKnjige.setForeground(new Color(255, 255, 255));
		headingKnjige.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingKnjige.setHorizontalAlignment(SwingConstants.CENTER);
		headingKnjige.setBounds(121, 11, 840, 90);
		panel.add(headingKnjige);
		
		JLabel about = new JLabel("OPIS:");
		about.setHorizontalAlignment(SwingConstants.LEFT);
		about.setForeground(Color.WHITE);
		about.setBounds(103, 231, 243, 30);
		panel.add(about);
		
		JLabel heading = new JLabel("NASLOV:");
		heading.setHorizontalAlignment(SwingConstants.LEFT);
		heading.setForeground(Color.WHITE);
		heading.setBounds(103, 112, 112, 30);
		panel.add(heading);
		
		headingField = new JTextField();
		headingField.setColumns(10);
		headingField.setBounds(103, 137, 243, 30);
		panel.add(headingField);
		
		JLabel originalHeading = new JLabel("ORIGINALNI NASLOV:");
		originalHeading.setHorizontalAlignment(SwingConstants.LEFT);
		originalHeading.setForeground(Color.WHITE);
		originalHeading.setBounds(103, 166, 112, 30);
		panel.add(originalHeading);
		
		originalHeadingField = new JTextField();
		originalHeadingField.setColumns(10);
		originalHeadingField.setBounds(103, 190, 243, 30);
		panel.add(originalHeadingField);
		
		JLabel year = new JLabel("GODINA:");
		year.setHorizontalAlignment(SwingConstants.LEFT);
		year.setForeground(Color.WHITE);
		year.setBounds(746, 267, 112, 30);
		panel.add(year);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(746, 291, 270, 30);
		panel.add(yearField);
		
		JLabel id = new JLabel("ID:");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setForeground(Color.WHITE);
		id.setBounds(747, 319, 215, 30);
		panel.add(id);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(746, 341, 270, 30);
		panel.add(idField);
		
		
		JLabel language = new JLabel("JEZIK:");
		language.setHorizontalAlignment(SwingConstants.LEFT);
		language.setForeground(Color.WHITE);
		language.setBounds(746, 112, 112, 30);
		panel.add(language);
		
		languageField = new JTextField();
		languageField.setColumns(10);
		languageField.setBounds(746, 137, 270, 30);
		panel.add(languageField);
		
		JLabel writter = new JLabel("PISAC:");
		writter.setHorizontalAlignment(SwingConstants.LEFT);
		writter.setForeground(Color.WHITE);
		writter.setBounds(746, 165, 112, 30);
		panel.add(writter);
		
		writterField = new JTextField();
		writterField.setColumns(10);
		writterField.setBounds(746, 189, 270, 30);
		panel.add(writterField);
		
		JLabel genre = new JLabel("ŽANR:");
		genre.setHorizontalAlignment(SwingConstants.LEFT);
		genre.setForeground(Color.WHITE);
		genre.setBounds(746, 216, 112, 30);
		panel.add(genre);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(knjigaSwing.class.getResource("/images/book_add.png")));
		picLabel.setBounds(414, 112, 250, 256);
		panel.add(picLabel);
		
		JButton examplesButton = new JButton("Lista primeraka");
		examplesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				primerakSwing.main(null);
			}
		});
		examplesButton.setBounds(460, 730, 225, 35);
		panel.add(examplesButton);
		
		
		
		
	}
}