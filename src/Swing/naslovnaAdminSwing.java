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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class naslovnaAdminSwing extends JFrame {

	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(naslovnaAdminSwing.class.getResource("/images/library-logo.png")));
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
		
		JLabel lblNewLabel_1 = new JLabel("Gradska biblioteka u Novom Sadu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(535, 122, 417, 66);
		naziv.add(lblNewLabel_1);
		
		JLabel adresa = new JLabel("Dunavska 1, Novi Sad 21101");
		adresa.setHorizontalAlignment(SwingConstants.CENTER);
		adresa.setForeground(Color.WHITE);
		adresa.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		adresa.setBounds(535, 165, 417, 55);
		naziv.add(adresa);
		
		JLabel radnoVreme1 = new JLabel("PONEDELJAK/PETAK: 07:30 - 20:00");
		radnoVreme1.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme1.setForeground(Color.WHITE);
		radnoVreme1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme1.setBounds(536, 279, 405, 66);
		naziv.add(radnoVreme1);
		
		JLabel radnoVreme2 = new JLabel("SUBOTA: 08:00 - 14:00");
		radnoVreme2.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme2.setForeground(Color.WHITE);
		radnoVreme2.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme2.setBounds(536, 331, 405, 66);
		naziv.add(radnoVreme2);
		
		JLabel radnoVreme3 = new JLabel("NEDELJA: NERADNA");
		radnoVreme3.setHorizontalAlignment(SwingConstants.CENTER);
		radnoVreme3.setForeground(Color.WHITE);
		radnoVreme3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 20));
		radnoVreme3.setBounds(536, 380, 405, 66);
		naziv.add(radnoVreme3);
		
		JLabel adresa_1 = new JLabel("021/ 451 - 233");
		adresa_1.setHorizontalAlignment(SwingConstants.CENTER);
		adresa_1.setForeground(Color.WHITE);
		adresa_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 22));
		adresa_1.setBounds(535, 213, 417, 55);
		naziv.add(adresa_1);
		
		JButton radnoVremeIzmena = new JButton("Izmeni radno vreme");
		radnoVremeIzmena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Ova verzija nema mogućnost izmene radnog vremena!");
			}
		});
		
		radnoVremeIzmena.setBounds(599, 442, 298, 36);
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
		cancelButton.setBounds(599, 497, 298, 36);
		naziv.add(cancelButton);
	}
}
