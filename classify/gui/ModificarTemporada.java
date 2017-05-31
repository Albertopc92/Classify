package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.envoltorios.Temporada;
import classify.excepciones.TituloNoValidoException;

/**
 * Clase que modifica los valores de una temporada
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ModificarTemporada extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana donde se modificaran los valores de la temporada
	 * @param temporada 
	 * @param modeloTemporadas 
	 * @param jlistTemporadas 
	 */
	public ModificarTemporada(JList<Temporada> jlistTemporadas, DefaultListModel<Temporada> modeloTemporadas, Temporada temporada) {
		setBounds(100, 100, 380, 209);
		btnAccion.setText("Modificar");
		textField_Temporada.setText(temporada.getTitulo());
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					temporada.setTitulo(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "La serie se ha modificado correctamente.","Serie modificada", JOptionPane.INFORMATION_MESSAGE);
					jlistTemporadas.setModel(modeloTemporadas);
				} catch (TituloNoValidoException exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La temporada no se ha podido modificar: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
