package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.envoltorios.Temporada;
import classify.jerarquia.Serie;

public class AnnadirTemporada extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 * 
	 * @param modeloTemporadas
	 * @param jlistTemporadas
	 */
	public AnnadirTemporada(Serie serie, JList<Temporada> jlistTemporadas, DefaultListModel<Temporada> modeloTemporadas) {
		setTitle("A\u00f1adir Temporada");
		setBounds(100, 100, 380, 209);
		btnAccion.setText("A\u00f1adir");
		// AL SALIR LANZA AÑADIR SERIE!!
		// AÑADIR TEMPORADA
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serie.altaTemporada(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "La temporada se a\u00f1adio correctamente.",
							"Temporada a\u00f1adida", JOptionPane.INFORMATION_MESSAGE);
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
