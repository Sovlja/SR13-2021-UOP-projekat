package Swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Biblioteka;
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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class tipClanarineSwing extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField priceField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addButton;
	private JButton updateButton;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JLabel headingTipČlanarine;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tipClanarineSwing frame = new tipClanarineSwing();
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
	public tipClanarineSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(tipClanarineSwing.class.getResource("/images/library-logo.png")));
		setTitle("Tip Članarine - Biblioteka");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 737);
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
		panel.setBounds(0, 0, 921, 676);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel name = new JLabel("NAZIV:");
		name.setForeground(new Color(255, 255, 255));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setBounds(101, 400, 112, 30);
		panel.add(name);
		
		JLabel id = new JLabel("ID:");
		id.setForeground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.RIGHT);
		id.setBounds(101, 359, 112, 30);
		panel.add(id);
		
		JLabel price = new JLabel("CENA:");
		price.setForeground(new Color(255, 255, 255));
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setBounds(101, 441, 112, 30);
		panel.add(price);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(218, 400, 144, 30);
		panel.add(nameField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(218, 359, 144, 30);
		panel.add(idField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(218, 441, 144, 30);
		panel.add(priceField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 139, 325, 381);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				idField.setText(model.getValueAt(i, 0).toString());
				idField.disable();
				nameField.setText(model.getValueAt(i, 1).toString());
				priceField.setText(model.getValueAt(i, 2).toString());							
			}
				
		});
		table.setBackground(new Color(153, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"ID", "NAZIV", "CENA"};
		final Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
//---------------------------------------------------------------------------------
		try {
			File tipČlanarineFile = new File("src/txt/članarina.txt");
			BufferedReader reader = new BufferedReader(new FileReader(tipČlanarineFile));
			String red;
			while ((red = reader.readLine()) != null) {
				String[] splitovanRed = red.split("\\|");
				
				String ID = splitovanRed[0];
				row[0] = ID;
				
				String naziv = splitovanRed[1];
				row[1] = naziv;
				int cena = Integer.parseInt(splitovanRed[2]);
				row[2] = cena;
				
				model.addRow(row);
				
			}
			reader.close();
		} 
		catch (IOException e) {
			System.out.println("Greška prilikom učitavanja datoteke: " + e.getMessage());
		}
		
		
		
		
//---------------------------------------------------------------------------------
		addButton = new JButton("Dodaj članarinu");
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
				if(nameField.getText().equals("") || idField.getText().equals("") || priceField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas da popunite celu formu!");
					return;
				}
				else {
					biblioteka.učitajTipČlanarine();
					for(TipČlanarine tip : biblioteka.tipČlanarine){
		
						if(tip.getId().equals(idField.getText().toString())){
							JOptionPane.showMessageDialog(null, "Članarina sa prosleđenim ID-ijem već postoji!");
							idField.setText("");
							return;
						}
						
						
					}	
					row[0] = idField.getText();
					row[1] = nameField.getText();
					row[2] = priceField.getText();
					
					model.addRow(row);
					
					JOptionPane.showMessageDialog(null, "Članarina uspešno dodata u listu!");
					
					nameField.setText("");
					idField.setText("");
					priceField.setText("");		
				}
					
			}
		});
		addButton.setBounds(101, 589, 177, 42);
		panel.add(addButton);
		
		updateButton = new JButton("Ažuriraj članarinu");
		updateButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
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
						model.setValueAt(nameField.getText(), i, 1);
						model.setValueAt(priceField.getText(), i, 2);
						JOptionPane.showMessageDialog(null, "Tip članarine je uspešno ažuriran!");																	
					}
					JOptionPane.getRootFrame().dispose();
					nameField.setText("");
					idField.setText("");
					priceField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Izaberite tip članarine za ažuriranje!");
				}
			}
		
		});
		updateButton.setBounds(299, 589, 177, 42);
		panel.add(updateButton);
//---------------------------------------------------------------------------------
		removeButton = new JButton("Ukloni članarinu");
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
				if(i >= 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati članarinu?","Upozorenje", dialogButton);
					
					if(dialogResult == 0) {
						model.removeRow(i);
						nameField.setText("");
						idField.setText("");
						priceField.setText("");
						JOptionPane.showMessageDialog(null, "Tip članarine je uspešno obrisan!");												
					}
					
					JOptionPane.getRootFrame().dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Molimo Vas da obeležite članarinu za brisanje!");
				}
			}
		});
//---------------------------------------------------------------------------------
		removeButton.setBounds(496, 589, 177, 42);
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
		cancelButton.setBounds(693, 589, 177, 42);
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
				nameField.setText("");;
				idField.setText("");
				priceField.setText("");
			}
		});
		clearButton.setBounds(278, 494, 177, 42);
		panel.add(clearButton);
		
		headingTipČlanarine = new JLabel("~TIP ČLANARINE~");
		headingTipČlanarine.setForeground(new Color(255, 255, 255));
		headingTipČlanarine.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 70));
		headingTipČlanarine.setHorizontalAlignment(SwingConstants.CENTER);
		headingTipČlanarine.setBounds(121, 38, 692, 90);
		panel.add(headingTipČlanarine);
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon(tipClanarineSwing.class.getResource("/images/ljdec152019genreadingslug.jpg")));
		picLabel.setBounds(136, 141, 275, 184);
		panel.add(picLabel);
		
	}
}
