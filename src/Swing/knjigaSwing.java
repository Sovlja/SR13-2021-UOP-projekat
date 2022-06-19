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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

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
	private JTextField genreField;

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
	 */

	public knjigaSwing() {
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
		panel.setBounds(0, 0, 1139, 775);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(121, 256, 225, 115);
		panel.add(textArea);
		
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
				headingField.setText(model.getValueAt(i, 1).toString());
				originalHeadingField.setText(model.getValueAt(i, 2).toString());
				originalHeadingField.disable();
				yearField.setText(model.getValueAt(i, 3).toString());
				textArea.setText(model.getValueAt(i, 4).toString());
				languageField.setText(model.getValueAt(i, 5).toString());
				writterField.setText(model.getValueAt(i, 6).toString());
				genreField.setText(model.getValueAt(i, 7).toString());							
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
		
		Biblioteka b = new Biblioteka();
		try {
			File knjigeFile = new File("src/txt/knjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(knjigeFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
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
				
				b.učitajŽanrove();
				Žanr žanr = new Žanr();
				String žanrID = splitovanRed[7];
				
				for (Žanr ž : b.žanrKnjige) {
					if (ž.getId().equals(žanrID)) {
						žanr = ž;
						row[7] = žanr.getOpis();
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
		addButton = new JButton("Dodaj knjigu");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
			}
		});
		Biblioteka biblioteka = new Biblioteka();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getText().equals("") || headingField.getText().equals("") || originalHeadingField.getText().equals("") || 
					yearField.getText().equals("") || idField.getText().equals("") || languageField.getText().equals("") || 
					writterField.getText().equals("") || genreField.getText().equals("")) {
					
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
					row[7] = genreField.getText();
					model.addRow(row);
				
					
					JOptionPane.showMessageDialog(null, "Knjiga uspešno dodata u listu!");
					
					textArea.setText("");
					headingField.setText("");
					originalHeadingField.setText("");
					yearField.setText("");
					idField.setText("");
					languageField.setText("");
					writterField.setText("");
					genreField.setText("");
				}
					
			}
		});
		addButton.setBounds(460, 379, 177, 30);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj knjigu");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.setValueAt(headingField.getText(), i, 1);
						model.setValueAt(originalHeadingField.getText(), i, 2);
						model.setValueAt(yearField.getText(), i, 3);
						model.setValueAt(textArea.getText(), i, 4);
						model.setValueAt(languageField.getText(), i, 5);
						model.setValueAt(writterField.getText(), i, 6);
						model.setValueAt(genreField.getText(), i, 7);
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
					genreField.setText("");
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
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati knjigu?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.removeRow(i);
						textArea.setText("");
						headingField.setText("");
						originalHeadingField.setText("");
						yearField.setText("");
						idField.setText("");
						languageField.setText("");
						writterField.setText("");
						genreField.setText("");
						JOptionPane.showMessageDialog(null, "Knjiga je uspešno obrisana!");												
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
			public void mouseClicked(MouseEvent e) {
				idField.enable();
				originalHeadingField.enable();
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
				genreField.setText("");
			}
		});
		clearButton.setBounds(449, 730, 177, 34);
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
		about.setBounds(121, 231, 112, 30);
		panel.add(about);
		
		JLabel heading = new JLabel("NASLOV:");
		heading.setHorizontalAlignment(SwingConstants.LEFT);
		heading.setForeground(Color.WHITE);
		heading.setBounds(121, 112, 112, 30);
		panel.add(heading);
		
		headingField = new JTextField();
		headingField.setColumns(10);
		headingField.setBounds(121, 137, 225, 30);
		panel.add(headingField);
		
		JLabel originalHeading = new JLabel("ORIGINALNI NASLOV:");
		originalHeading.setHorizontalAlignment(SwingConstants.LEFT);
		originalHeading.setForeground(Color.WHITE);
		originalHeading.setBounds(121, 166, 112, 30);
		panel.add(originalHeading);
		
		originalHeadingField = new JTextField();
		originalHeadingField.setColumns(10);
		originalHeadingField.setBounds(121, 190, 225, 30);
		panel.add(originalHeadingField);
		
		JLabel year = new JLabel("GODINA:");
		year.setHorizontalAlignment(SwingConstants.LEFT);
		year.setForeground(Color.WHITE);
		year.setBounds(746, 267, 112, 30);
		panel.add(year);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(746, 291, 215, 30);
		panel.add(yearField);
		
		JLabel id = new JLabel("ID:");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setForeground(Color.WHITE);
		id.setBounds(747, 319, 215, 30);
		panel.add(id);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(746, 341, 215, 30);
		panel.add(idField);
		
		
		JLabel language = new JLabel("JEZIK:");
		language.setHorizontalAlignment(SwingConstants.LEFT);
		language.setForeground(Color.WHITE);
		language.setBounds(746, 112, 112, 30);
		panel.add(language);
		
		languageField = new JTextField();
		languageField.setColumns(10);
		languageField.setBounds(746, 137, 215, 30);
		panel.add(languageField);
		
		JLabel writter = new JLabel("PISAC:");
		writter.setHorizontalAlignment(SwingConstants.LEFT);
		writter.setForeground(Color.WHITE);
		writter.setBounds(746, 165, 112, 30);
		panel.add(writter);
		
		writterField = new JTextField();
		writterField.setColumns(10);
		writterField.setBounds(746, 189, 215, 30);
		panel.add(writterField);
		
		JLabel genre = new JLabel("ŽANR:");
		genre.setHorizontalAlignment(SwingConstants.LEFT);
		genre.setForeground(Color.WHITE);
		genre.setBounds(746, 216, 112, 30);
		panel.add(genre);
		
		genreField = new JTextField();
		genreField.setColumns(10);
		genreField.setBounds(746, 239, 215, 30);
		panel.add(genreField);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(knjigaSwing.class.getResource("/images/book_add.png")));
		picLabel.setBounds(414, 112, 250, 256);
		panel.add(picLabel);
		
		
	}
}