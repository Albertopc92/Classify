package classify.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import classify.enumeraciones.Genero;
import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;

public class ListarPorGeneroSeries extends PlantillaListarPorGenero {

	private static final long serialVersionUID = 1L;
	private ArrayList<Multimedia> genero;
	private DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();

	/**
	 * Create the dialog.
	 */
	public ListarPorGeneroSeries(Videoteca videoteca) {
		setBounds(100, 100, 564, 370);
		comboBox_genero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					modelo.clear();
					jlist.setModel(modelo);
					genero = videoteca.listarSeriesGenero((Genero)comboBox_genero.getSelectedItem());
					for (Multimedia multimedia : genero) {
						modelo.addElement(multimedia);
					}
				} catch (ListaVaciaException e) {
					JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
				}
			}
		});

	}

}
