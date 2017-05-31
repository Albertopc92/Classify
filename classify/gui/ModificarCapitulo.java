package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.Capitulo;
import classify.excepciones.TituloNoValidoException;

public class ModificarCapitulo extends PlantillaAnnadirTemporadaCapitulo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 * @param capitulo 
	 * @param modeloCapitulos 
	 * @param jlistCapitulos 
	 */
	public ModificarCapitulo(JList<Capitulo> jlistCapitulos, DefaultListModel<Capitulo> modeloCapitulos, Capitulo capitulo) {
		setBounds(100, 100, 380, 209);
		btnAccion.setText("Modificar");
		textField_Temporada.setText(capitulo.getTitulo());
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					capitulo.setTitulo(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "La serie se ha modificado correctamente.","Serie modificada", JOptionPane.INFORMATION_MESSAGE);
					jlistCapitulos.setModel(modeloCapitulos);
				} catch (TituloNoValidoException exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La temporada no se ha podido modificar: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
