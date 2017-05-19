package classify.gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import classify.enumeraciones.Genero;
import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class ListarPorGenero extends JDialog {

	private static final long serialVersionUID = 1L;
	private ArrayList<Multimedia> genero;
	private DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();
	
	/**
	 * Create the dialog.
	 */
	public ListarPorGenero(Videoteca videoteca) {
		setModal(true);
		setTitle("Listar por Genero");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarPorGenero.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 564, 370);
		getContentPane().setLayout(null);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(59, 42, 46, 14);
		getContentPane().add(lblGenero);
		
		JList<Multimedia> jlist = new JList<>();
		jlist.setBounds(34, 78, 474, 181);
		getContentPane().add(jlist);
		
		JComboBox<Multimedia> comboBox_genero = new JComboBox<Multimedia>();
		comboBox_genero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					modelo.clear();
					jlist.setModel(modelo);
					genero = videoteca.listarPeliculasGenero((Genero)comboBox_genero.getSelectedItem());
					for (Multimedia multimedia : genero) {
						modelo.addElement(multimedia);
					}
				} catch (ListaVaciaException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
				}
			}
		});
		comboBox_genero.setModel(new DefaultComboBoxModel(Genero.values()));
		comboBox_genero.setSelectedIndex(-1);
		comboBox_genero.setBounds(115, 39, 178, 20);
		getContentPane().add(comboBox_genero);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(419, 281, 89, 23);
		getContentPane().add(btnSalir);

	}
}
