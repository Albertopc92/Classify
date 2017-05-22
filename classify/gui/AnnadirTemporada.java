package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.envoltorios.Temporada;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Serie;

public class AnnadirTemporada extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AnnadirTemporada(Serie serie) {
		setTitle("A\u00f1adir Temporada");
		setBounds(100, 100, 380, 209);
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				try {
					serie.altaTemporada(textField_Temporada.getText());
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La Temporada no se ha podido a\u00f1adir: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
