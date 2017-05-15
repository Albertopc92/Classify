package classify.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnnadirPelicula extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AnnadirPelicula() {
		setTitle("A\u00f1adir Pel\u00edcula");
		setBounds(100, 100, 720, 788);
		comboBox_premio.setModel(new DefaultComboBoxModel<PremioPelicula>(PremioPelicula.values()));
		btnAccion.setText("A\u00f1adir");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				videoteca.altaPelicula(textField_titulo.getText(), 
										textField_tituloOriginal.getText(), 
										(int)comboBox_anno.getSelectedItem(), 
										(int)(Integer.parseInt(textField_duracion.getText())), 
										textField_pais.getText(), 
										textField_director.getText(), 
										textField_guion.getText(), 
										textField_musica.getText(), 
										textField_fotografia.getText(), 
										new String[][] {{"principales"},{"secundarios"}},
										textField_productora.getText(), 
										(Genero)comboBox_genero.getSelectedItem(), 
										textArea_sinopsis.getText(), 
										(float)(Integer.parseInt(textField_notaUsuario.getText())), 
										(PremioPelicula)comboBox_premio.getSelectedItem());
				//TODO crear un jdialog que avise de que la pelicula se ha creado correctamente y resetear los campos
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La pel\u00edcula no se ha podido a\u00f1adir: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
