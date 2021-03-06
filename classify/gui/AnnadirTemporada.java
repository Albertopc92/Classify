package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.envoltorios.Temporada;
import classify.envoltorios.Videoteca;
import classify.jerarquia.Serie;

/**
 * Clase que se encarga de añadir una temporada a la una serie
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class AnnadirTemporada extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana para añadir una temporada 
	 * 
	 * @param modeloTemporadas
	 * @param jlistTemporadas
	 * @param videoteca 
	 */
	public AnnadirTemporada(Serie serie, JList<Temporada> jlistTemporadas, DefaultListModel<Temporada> modeloTemporadas, Videoteca videoteca) {
		setTitle("A\u00f1adir Temporada");
		setBounds(100, 100, 380, 209);
		btnAccion.setText("A\u00f1adir");

		// AÑADIR TEMPORADA
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serie.altaTemporada(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "La temporada se a\u00f1adi\u00f3 correctamente.",
							"Temporada a\u00f1adida", JOptionPane.INFORMATION_MESSAGE);
					videoteca.setModificado(true);
					reset();
					// Recargar Jlist
					modeloTemporadas.clear();
					jlistTemporadas.setModel(modeloTemporadas);
					for (Temporada temporada : serie.listarTemporadas()) {
						modeloTemporadas.addElement(temporada);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(),
							"La Temporada no se ha podido a\u00f1adir: " + exception.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
