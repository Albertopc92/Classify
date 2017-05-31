package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.Capitulo;
import classify.envoltorios.Videoteca;
import classify.excepciones.TituloNoValidoException;
/**
 * Clase que modifica los valores de los capitulos
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ModificarCapitulo extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana para modificar el capitulo
	 * @param capitulo 
	 * @param modeloCapitulos 
	 * @param jlistCapitulos 
	 * @param videoteca 
	 */
	public ModificarCapitulo(JList<Capitulo> jlistCapitulos, DefaultListModel<Capitulo> modeloCapitulos, Capitulo capitulo, Videoteca videoteca) {
		setBounds(100, 100, 380, 209);
		btnAccion.setText("Modificar");
		textField_Temporada.setText(capitulo.getTitulo());
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					capitulo.setTitulo(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "La serie se ha modificado correctamente.","Serie modificada", JOptionPane.INFORMATION_MESSAGE);
					videoteca.setModificado(true);
					jlistCapitulos.setModel(modeloCapitulos);
				} catch (TituloNoValidoException exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La temporada no se ha podido modificar: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
