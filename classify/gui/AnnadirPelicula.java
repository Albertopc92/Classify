package classify.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.jerarquia.Multimedia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Clase que se encarga de añadir una pelicula a la videoteca
 * @author alber
 *
 */
public class AnnadirPelicula extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana para añadir la pelicula
	 * @param modelo 
	 * @param jlist 
	 * @param jlist 
	 */
	public AnnadirPelicula(JList<Multimedia> jlist, DefaultListModel<Multimedia> modelo) {
		setTitle("A\u00f1adir Pel\u00edcula");
		setBounds(100, 100, 720, 788);
		comboBox_premioPrincipal.setVisible(false);
		JComboBox<PremioPelicula> comboBox_premio = new JComboBox<PremioPelicula>();
		comboBox_premio.setSelectedIndex(-1);
		comboBox_premio.setBounds(439, 118, 124, 20);
		getContentPane().add(comboBox_premio);
		comboBox_premio.setModel(new DefaultComboBoxModel<PremioPelicula>(PremioPelicula.values()));
		comboBox_premio.setSelectedIndex(-1);
		textField_puntuacion.setVisible(false);
		lblPuntuacin.setVisible(false);
		checkbox.setVisible(false);
		btnAccion.setText("A\u00f1adir");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(videoteca.altaPelicula(textField_titulo.getText(),
										textField_tituloOriginal.getText(),
										(int)comboBox_anno.getSelectedItem(),
										(int)(Integer.parseInt(textField_duracion.getText())),
										textField_pais.getText(),
										textField_director.getText(),
										textField_guion.getText(),
										textField_musica.getText(),
										textField_fotografia.getText(),
										new String[][] {{textField_principales.getText()},{textField_secundarios.getText()}},
										textField_productora.getText(),
										(Genero)comboBox_genero.getSelectedItem(), 
										textArea_sinopsis.getText(),
										(float)(Float.parseFloat(textField_notaUsuario.getText())),
										(PremioPelicula)comboBox_premio.getSelectedItem())) {
					
					JOptionPane.showMessageDialog(getContentPane(), "La pel\u00edcula se a\u00f1adi\u00f3 correctamente.","Pel\u00edcula a\u00f1adida", JOptionPane.INFORMATION_MESSAGE);
					// Recargar Jlist
					modelo.clear();
					jlist.setModel(modelo);
					for (Multimedia multimedia : videoteca.listarPeliculas()) {
						modelo.addElement(multimedia);
					}
					reset();
				}
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La pel\u00edcula no se ha podido a\u00f1adir: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
