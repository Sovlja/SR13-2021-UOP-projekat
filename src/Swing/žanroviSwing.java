package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class žanroviSwing extends JFrame {

	private JPanel contentPane;
	private JTextField descriptionField;
	private JTextField idField;
	private JTextField markField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingŽanrovi;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					žanroviSwing frame = new žanroviSwing();
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
	public žanroviSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(tipClanarineSwing.class.getResource("/images/library-logo.png")));
		setTitle("Žanrovi - Biblioteka");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 719);
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
		panel.setBounds(0, 0, 914, 665);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel description = new JLabel("OPIS:");
		description.setForeground(new Color(255, 255, 255));
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setBounds(101, 400, 112, 30);
		panel.add(description);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(101, 359, 112, 30);
		panel.add(id);
		
		JLabel mark = new JLabel("OZNAKA:");
		mark.setForeground(new Color(255, 255, 255));
		mark.setHorizontalAlignment(SwingConstants.RIGHT);
		mark.setBounds(101, 441, 112, 30);
		panel.add(mark);
		
		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(218, 400, 144, 30);
		panel.add(descriptionField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(218, 359, 144, 30);
		panel.add(idField);
		
		markField = new JTextField();
		markField.setColumns(10);
		markField.setBounds(218, 441, 144, 30);
		panel.add(markField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 139, 325, 395);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				descriptionField.setText(model.getValueAt(i, 1).toString());
				markField.setText(model.getValueAt(i, 2).toString());							
			}
				
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "OPIS", "OZNAKA"};
		final Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		try {
			File žanroviFile = new File("src/txt/žanrovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(žanroviFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				if(splitovanRed[3].equals("false")) {
					String oznaka = splitovanRed[0];
					row[2] = oznaka;
					
					String opis = splitovanRed[1];
					row[1] = opis;
					
					String ID = splitovanRed[2];
					row[0] = ID;
					
					model.addRow(row);					
				}
				
				
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj žanr");
		addButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
			}
		});
		Biblioteka biblioteka = new Biblioteka();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptionField.getText().equals("") || idField.getText().equals("") || markField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					return;
				}
				else {
					biblioteka.učitajŽanrove();
					for(Žanr žanr : biblioteka.žanrKnjige){
		
						if(žanr.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Žanr sa prosleđenim ID-ijem već postoji!");
							idField.setText("");
							return;
						}
						
						
					}	
					row[0] = idField.getText();
					row[1] = descriptionField.getText();
					row[2] = markField.getText();
					
					model.addRow(row);
					
					String žanrLinija = "";
					
					žanrLinija += row[2] + "|" + row[1] + "|" + row[0] + "|" + "false" + "\n" ;
					
					try {
						File žanrFile = new File("src/txt/žanrovi.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(žanrFile, true));
						writer.write(žanrLinija);
						writer.close();
						
					}catch(IOException e1){
						System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
					}
					
					
					JOptionPane.showMessageDialog(null, "Žanr uspešno dodat u listu!");
					
					
					descriptionField.setText("");
					idField.setText("");
					markField.setText("");		
				}
					
			}
		});
		addButton.setBounds(71, 599, 177, 42);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj žanr");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				idField.enable();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biblioteka.učitajŽanrove();
				int i = table.getSelectedRow();
				
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati izmene?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						String žanrID = biblioteka.dobaviNeobrisaneŽanrove().get(i).getId();
						String[] izmene = new String[3];
						izmene[1] = markField.getText();
						izmene[0] = descriptionField.getText();
						
					
						
						biblioteka.ažurirajŽanr(žanrID, izmene);
						
						JOptionPane.showMessageDialog(null, "Žanr je uspešno ažuriran!");																	
					}
					JOptionPane.getRootFrame().dispose();
					descriptionField.setText("");
					idField.setText("");
					markField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite žanr za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(269, 599, 177, 42);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni žanr");
		removeButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				idField.enable();
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				biblioteka.učitajŽanrove();
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati žanr?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						biblioteka.dobaviNeobrisaneŽanrove().get(i).setJeObrisan(true);
						model.removeRow(i);
						descriptionField.setText("");
						idField.setText("");
						markField.setText("");
						JOptionPane.showMessageDialog(null, "Žanr je uspešno obrisan!");	
						biblioteka.upišiŽanrove();
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite žanr za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		removeButton.setBounds(466, 599, 177, 42);
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
		cancelButton.setBounds(663, 599, 177, 42);
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
				descriptionField.setText("");;
				idField.setText("");
				markField.setText("");
			}
		});
		clearButton.setBounds(136, 504, 275, 30);
		panel.add(clearButton);
		
		headingŽanrovi = new JLabel("~ŽANROVI~");
		headingŽanrovi.setForeground(new Color(255, 255, 255));
		headingŽanrovi.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingŽanrovi.setHorizontalAlignment(SwingConstants.CENTER);
		headingŽanrovi.setBounds(121, 38, 692, 90);
		panel.add(headingŽanrovi);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(žanroviSwing.class.getResource("/images/Webp.net-resizeimage.png")));
		picLabel.setBounds(136, 141, 275, 184);
		panel.add(picLabel);
		
	}
}
