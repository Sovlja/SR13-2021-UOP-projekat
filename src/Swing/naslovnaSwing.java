package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;


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
		setForeground(Color.BLACK);
		setTitle("Po\u010Detna - Biblioteka");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 640);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
