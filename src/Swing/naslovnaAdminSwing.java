package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projekat.Biblioteka;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class naslovnaAdminSwing extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Biblioteka biblioteka;
	private JTextField subotaDoField;
	private JTextField brTelefonaField;
	private JTextField adresaBibliotekeField;
	private JTextField nazivBibliotekeField;

	private JTextField radniOdField;
	private JTextField radniDoField;
	private JTextField subotaOdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					naslovnaAdminSwing frame = new naslovnaAdminSwing();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public naslovnaAdminSwing() {
		this.biblioteka = new Biblioteka();
		setIconImage(Toolkit.getDefaultToolkit().getImage(naslovnaAdminSwing.class.getResource("/images/library-logo.png")));
		setForeground(Color.BLACK);
		setTitle("Po\u010Detna - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 640);
		
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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel naziv = new JPanel();
		naziv.setForeground(Color.WHITE);
		naziv.setBounds(0, 0, 984, 579);
		naziv.setBackground(new Color(51, 51, 153));
		contentPane.add(naziv);
		naziv.setLayout(null);
		

		subotaDoField = new JTextField();
		subotaDoField.setColumns(10);
		subotaDoField.setBounds(216, 472, 126, 25);
		naziv.add(subotaDoField);
		
		JLabel subotaDo = new JLabel("SUBOTOM DO:");
		subotaDo.setForeground(Color.WHITE);
		subotaDo.setBounds(216, 458, 111, 14);
		naziv.add(subotaDo);
		
		brTelefonaField = new JTextField();
		brTelefonaField.setColumns(10);
		brTelefonaField.setBounds(114, 423, 127, 25);
		naziv.add(brTelefonaField);
		
		JLabel brTelefona = new JLabel("BROJ TELEFONA:");
		brTelefona.setForeground(Color.WHITE);
		brTelefona.setBounds(115, 408, 110, 14);
		naziv.add(brTelefona);
		
		adresaBibliotekeField = new JTextField();
		adresaBibliotekeField.setColumns(10);
		adresaBibliotekeField.setBounds(114, 373, 127, 25);
		naziv.add(adresaBibliotekeField);
		
		JLabel adresaBiblioteke = new JLabel("ADRESA:");
		adresaBiblioteke.setForeground(Color.WHITE);
		adresaBiblioteke.setBounds(114, 360, 111, 14);
		naziv.add(adresaBiblioteke);
		
		
		JLabel nazivBiblioteke = new JLabel("NAZIV:");
		nazivBiblioteke.setForeground(Color.WHITE);
		nazivBiblioteke.setBounds(115, 316, 110, 14);
		naziv.add(nazivBiblioteke);
		
		
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(naslovnaAdminSwing.class.getResource("/images/librarija mala.png")));
		picLabel.setBounds(114, 108, 329, 176);
		naziv.add(picLabel);
		
		
		nazivBibliotekeField = new JTextField();
		nazivBibliotekeField.setColumns(10);
		nazivBibliotekeField.setBounds(114, 329, 127, 25);
		naziv.add(nazivBibliotekeField);
		
		JLabel welcome = new JLabel("~DOBRODOŠLI U NAŠU BIBLIOTEKU~");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 40));
		welcome.setBounds(124, 28, 729, 87);
		naziv.add(welcome);
		
		JLabel nazivBibliotekeLabela = new JLabel();
		nazivBibliotekeLabela.setHorizontalAlignment(SwingConstants.CENTER);
		nazivBibliotekeLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 26));
		nazivBibliotekeLabela.setForeground(Color.WHITE);
		nazivBibliotekeLabela.setBounds(511, 108, 417, 55);
		naziv.add(nazivBibliotekeLabela);
		
		JLabel adresaLabela = new JLabel();
		adresaLabela.setHorizontalAlignment(SwingConstants.CENTER);
		adresaLabela.setForeground(Color.WHITE);
		adresaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		adresaLabela.setBounds(511, 163, 417, 55);
		naziv.add(adresaLabela);
		
		JLabel radnoVreme1 = new JLabel("PONEDELJAK/PETAK:");
		radnoVreme1.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme1.setForeground(Color.WHITE);
		radnoVreme1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme1.setBounds(511, 279, 234, 66);
		naziv.add(radnoVreme1);
		
		JLabel radnoVreme2 = new JLabel("SUBOTA:");
		radnoVreme2.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme2.setForeground(Color.WHITE);
		radnoVreme2.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme2.setBounds(511, 335, 234, 66);
		naziv.add(radnoVreme2);
		
		JLabel radnoVreme3 = new JLabel("NEDELJA: NERADNA");
		radnoVreme3.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme3.setForeground(Color.WHITE);
		radnoVreme3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme3.setBounds(511, 406, 417, 66);
		naziv.add(radnoVreme3);
		
		JLabel brTelefonaLabela = new JLabel();
		brTelefonaLabela.setHorizontalAlignment(SwingConstants.CENTER);
		brTelefonaLabela.setForeground(Color.WHITE);
		brTelefonaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		brTelefonaLabela.setBounds(511, 229, 417, 55);
		naziv.add(brTelefonaLabela);
		
		JLabel radnoVremeLabela = new JLabel();
		radnoVremeLabela.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVremeLabela.setForeground(Color.WHITE);
		radnoVremeLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		radnoVremeLabela.setBounds(716, 285, 212, 55);
		naziv.add(radnoVremeLabela);
		
		JLabel subotaLabela = new JLabel();
		subotaLabela.setHorizontalAlignment(SwingConstants.CENTER);
		subotaLabela.setForeground(Color.WHITE);
		subotaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		subotaLabela.setBounds(716, 341, 212, 55);
		naziv.add(subotaLabela);
		
		JLabel radniOd = new JLabel("RADNIM DANOM OD:");
		radniOd.setForeground(Color.WHITE);
		radniOd.setBounds(317, 316, 126, 14);
		naziv.add(radniOd);
		
		JLabel radniDo = new JLabel("RADNIM DANOM DO:");
		radniDo.setForeground(Color.WHITE);
		radniDo.setBounds(317, 360, 126, 14);
		naziv.add(radniDo);
		
		JLabel subotaOd = new JLabel("SUBOTOM OD:");
		subotaOd.setForeground(Color.WHITE);
		subotaOd.setBounds(318, 409, 126, 14);
		naziv.add(subotaOd);
		
		radniOdField = new JTextField();
		radniOdField.setColumns(10);
		radniOdField.setBounds(317, 330, 126, 25);
		naziv.add(radniOdField);
		
		radniDoField = new JTextField();
		radniDoField.setColumns(10);
		radniDoField.setBounds(317, 374, 126, 25);
		naziv.add(radniDoField);
		
		subotaOdField = new JTextField();
		subotaOdField.setColumns(10);
		subotaOdField.setBounds(318, 424, 126, 25);
		naziv.add(subotaOdField);
		
		try {
			File bibliotekaFile = new File("src/txt/biblioteka.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekaFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String strNaziv = naziv.toString();
				strNaziv = splitovanRed[0];
				nazivBibliotekeField.setText(strNaziv);
				
				String strAdresa = adresaLabela.toString();
				strAdresa = splitovanRed[1];
				adresaBibliotekeField.setText(strAdresa);
				
				String strBrTelefona = brTelefonaLabela.toString();
				strBrTelefona = splitovanRed[2];
				brTelefonaField.setText(strBrTelefona);
				
				String strRadnoVreme = radnoVremeLabela.toString();
				strRadnoVreme = splitovanRed[3] + " - " + splitovanRed[5];
				radniOdField.setText(splitovanRed[3]);
				radniDoField.setText(splitovanRed[5]);		
				
				String strSubota = subotaLabela.toString();
				strSubota = splitovanRed[4] + " - " + splitovanRed[6];
				subotaOdField.setText(splitovanRed[4]);
				subotaDoField.setText(splitovanRed[6]);
				
				nazivBibliotekeLabela.setText(strNaziv);
				adresaLabela.setText(strAdresa);
				brTelefonaLabela.setText(strBrTelefona);
				radnoVremeLabela.setText(strRadnoVreme);
				subotaLabela.setText(strSubota);
			}
			reader.close();
			} catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		JButton radnoVremeIzmena = new JButton("Izmeni radno vreme");
		radnoVremeIzmena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite promeniti informacije o biblioteci?","Upozorenje", dialogButton);
				
				if(dialogResult == 0) {
					if(nazivBibliotekeField.getText().equals("") || adresaBibliotekeField.getText().equals("") || brTelefonaField.getText().equals(null) || radniOdField.getText().equals(null) || radniDoField.getText().equals(null) || subotaOdField.getText().equals(null) || subotaDoField.getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
						return;
					}
					else {
						String bibliotekaLinija = "";
						
						bibliotekaLinija += nazivBibliotekeField.getText() + "|" + adresaBibliotekeField.getText() + "|" + brTelefonaField.getText() + "|" + radniOdField.getText() + "|" + subotaOdField.getText() + "|" + radniDoField.getText() + "|" + subotaDoField.getText();
						try {
							File bibliotekaFile = new File("src/txt/biblioteka.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(bibliotekaFile));
							writer.write(bibliotekaLinija);
							writer.close();
							
						}
						catch(IOException e1){
							System.out.println("Greska prilikom upisa u datoteku: " + e1.getMessage());
						}
					}
					nazivBibliotekeLabela.setText(nazivBibliotekeField.getText());
					adresaLabela.setText(adresaBibliotekeField.getText());
					brTelefonaLabela.setText(brTelefonaField.getText());
					radnoVremeLabela.setText(radniOdField.getText() + " - " + radniDoField.getText());
					subotaLabela.setText(subotaOdField.getText() + " - " + subotaDoField.getText());
					
					
					
				}
				else {
					JOptionPane.getRootFrame().dispose();
				}
			}
		});
		
		radnoVremeIzmena.setBounds(114, 521, 329, 36);
		naziv.add(radnoVremeIzmena);	
		
		
		JButton cancelButton = new JButton("Izađi");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			}
		});
		cancelButton.setBounds(606, 521, 234, 36);
		naziv.add(cancelButton);
	
	}
}
