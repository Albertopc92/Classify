package classify.gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import classify.enumeraciones.Genero;
import classify.jerarquia.Multimedia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlantillaListarPorGenero extends JDialog {

	private static final long serialVersionUID = 1L;
	JList<Multimedia> jlist;
	JComboBox<Multimedia> comboBox_genero;
	JLabel lblGenero;

	
	/**
	 * Create the dialog.
	 */
	public PlantillaListarPorGenero() {
		setModal(true);
		setResizable(false);
		setTitle("Listar por G\u00e9nero");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaListarPorGenero.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 564, 370);
		getContentPane().setLayout(null);
		
		lblGenero = new JLabel("G\u00e9nero");
		lblGenero.setBounds(59, 42, 46, 14);
		getContentPane().add(lblGenero);
		
		jlist = new JList<>();
		jlist.setBounds(34, 78, 474, 181);
		getContentPane().add(jlist);
		
		comboBox_genero = new JComboBox<Multimedia>();
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
