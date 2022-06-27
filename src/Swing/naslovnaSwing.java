package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class naslovnaSwing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					naslovnaSwing frame = new naslovnaSwing();
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
	public naslovnaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(naslovnaSwing.class.getResource("/images/library-logo.png")));
		setForeground(Color.BLACK);
		setTitle("Po\u010Detna - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 640);
		
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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel naziv = new JPanel();
		naziv.setBounds(0, 0, 984, 579);
		naziv.setBackground(new Color(51, 51, 153));
		contentPane.add(naziv);
		naziv.setLayout(null);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(naslovnaSwing.class.getResource("/images/Gradska-biblioteka.png")));
		picLabel.setBounds(22, 122, 484, 411);
		naziv.add(picLabel);
		
		JLabel lblNewLabel = new JLabel("~DOBRODOŠLI U NAŠU BIBLIOTEKU~");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(124, 28, 729, 87);
		naziv.add(lblNewLabel);
		
		JLabel nazivBibliotekeLabela = new JLabel();
		nazivBibliotekeLabela.setHorizontalAlignment(SwingConstants.CENTER);
		nazivBibliotekeLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 26));
		nazivBibliotekeLabela.setForeground(Color.WHITE);
		nazivBibliotekeLabela.setBounds(536, 136, 417, 66);
		naziv.add(nazivBibliotekeLabela);
		
		JLabel adresaLabela = new JLabel();
		adresaLabela.setHorizontalAlignment(SwingConstants.CENTER);
		adresaLabela.setForeground(Color.WHITE);
		adresaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		adresaLabela.setBounds(536, 179, 417, 55);
		naziv.add(adresaLabela);
		
		JLabel radnoVreme1 = new JLabel("PONEDELJAK/PETAK:");
		radnoVreme1.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme1.setForeground(Color.WHITE);
		radnoVreme1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme1.setBounds(536, 293, 229, 66);
		naziv.add(radnoVreme1);
		
		JLabel radnoVreme2 = new JLabel("SUBOTA:");
		radnoVreme2.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme2.setForeground(Color.WHITE);
		radnoVreme2.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme2.setBounds(536, 346, 229, 66);
		naziv.add(radnoVreme2);
		
		JLabel radnoVreme3 = new JLabel("NEDELJA: NERADNA");
		radnoVreme3.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme3.setForeground(Color.WHITE);
		radnoVreme3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme3.setBounds(537, 394, 405, 66);
		naziv.add(radnoVreme3);
		
		JLabel radnoVremeLabela = new JLabel();
		radnoVremeLabela.setHorizontalAlignment(SwingConstants.LEFT);
		radnoVremeLabela.setForeground(Color.WHITE);
		radnoVremeLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		radnoVremeLabela.setBounds(794, 298, 180, 55);
		naziv.add(radnoVremeLabela);
		
		JLabel subotaLabela = new JLabel();
		subotaLabela.setHorizontalAlignment(SwingConstants.LEFT);
		subotaLabela.setForeground(Color.WHITE);
		subotaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		subotaLabela.setBounds(732, 351, 212, 55);
		naziv.add(subotaLabela);
		
		JLabel brTelefonaLabela = new JLabel();
		brTelefonaLabela.setHorizontalAlignment(SwingConstants.CENTER);
		brTelefonaLabela.setForeground(Color.WHITE);
		brTelefonaLabela.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		brTelefonaLabela.setBounds(536, 227, 417, 55);
		naziv.add(brTelefonaLabela);
		
		try {
			File bibliotekaFile = new File("src/txt/biblioteka.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekaFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String strNaziv = naziv.toString();
				strNaziv = splitovanRed[0];
				
				String strAdresa = adresaLabela.toString();
				strAdresa = splitovanRed[1];
				
				String strBrTelefona = brTelefonaLabela.toString();
				strBrTelefona = splitovanRed[2];
				
				String strRadnoVreme = radnoVremeLabela.toString();
				strRadnoVreme = splitovanRed[3] + " - " + splitovanRed[5];
				
				String strSubota = subotaLabela.toString();
				strSubota = splitovanRed[4] + " - " + splitovanRed[6];
							
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
		cancelButton.setBounds(627, 471, 238, 46);
		naziv.add(cancelButton);
		
		
	}
}
