package Swing;

import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import projekat.Biblioteka;
import projekat.PrimerakKnjige;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class dodavanjePrimerkaAdminSwing extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Biblioteka biblioteka;
	@SuppressWarnings("rawtypes")
	public List lista;
	@SuppressWarnings("unused")
	private iznajmljivanjeAdminSwing iznajmljivanjeAdminSwing;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, iznajmljivanjeAdminSwing iznajmljivanjeAdminSwing) {
		try {
			dodavanjePrimerkaAdminSwing dialog = new dodavanjePrimerkaAdminSwing(args, iznajmljivanjeAdminSwing);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
			dialog.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public dodavanjePrimerkaAdminSwing(String [] args, iznajmljivanjeAdminSwing iznajmljivanjeAdminSwing) {
		this.iznajmljivanjeAdminSwing = new iznajmljivanjeAdminSwing();
		this.biblioteka = new Biblioteka();
		setIconImage(Toolkit.getDefaultToolkit().getImage(dodavanjePrimerkaAdminSwing.class.getResource("/images/library-logo.png")));
		setTitle("Dodavanje primerka");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 255));
		panel.setBounds(0, 0, 434, 261);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 75, 399, 94);
		panel.add(scrollPane);
		
		DefaultComboBoxModel prim = new DefaultComboBoxModel();
		if(args.length > 0) {
			for (String s : args) {
				prim.addElement(s);
			}			
		}
		for (PrimerakKnjige p : biblioteka.dobaviNeiznajmljenePrimerke()) {
			prim.addElement(p.getNazivKnjige());
		}
		
		JList listaSvihPrimeraka = new JList(prim);
		scrollPane.setViewportView(listaSvihPrimeraka);
		
		
		
		JLabel lblNewLabel = new JLabel("~LISTA PRIMERAKA~");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 23, 414, 30);
		panel.add(lblNewLabel);
		
		JButton addExamplesBttn = new JButton("Dodaj primerke");
		addExamplesBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = listaSvihPrimeraka.getSelectedIndex();
				List selectedItems = listaSvihPrimeraka.getSelectedValuesList();
				System.out.println(selectedItems);
				if(selected >= 0) {
//					int dialogButton = JOptionPane.YES_NO_OPTION;
//					int dialogResult = JOptionPane.showConfirmDialog(null, "Sačuvati promene?","Upozorenje", dialogButton);
					
//					if(dialogResult == 0) {
					dispose();
					DefaultListModel listModel = new DefaultListModel();
					for (Object item : selectedItems) {
						listModel.addElement(item.toString());
						iznajmljivanjeAdminSwing.imenaPrimeraka.add(item.toString());
					}
					iznajmljivanjeAdminSwing.listaPrimeraka = new JList(listModel);
						
					JOptionPane.showMessageDialog(null, "Primerci su uspešno dodati!");	
						
//					}
					
					
				}
					
				}
		});
		addExamplesBttn.setBounds(72, 211, 128, 23);
		panel.add(addExamplesBttn);
		
		JButton izadjiBttn = new JButton("Iza\u0111i");
		izadjiBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		izadjiBttn.setBounds(229, 211, 127, 23);
		panel.add(izadjiBttn);
		
		
	}
}

