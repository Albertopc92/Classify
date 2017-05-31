package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Pelicula;
import javax.swing.JComboBox;

/**
 * Clase que modifica los valores de una pelicula
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ModificarPelicula extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana donde se modificara la pelicula
	 */
	public ModificarPelicula(JList<Multimedia> jlist, DefaultListModel<Multimedia> modelo, Multimedia multimedia) {
		setTitle("Modificar Pel\u00edcula: " + multimedia.getTitulo());
		setBounds(100, 100, 720, 788);
		
		JComboBox<PremioPelicula> comboBox_premio = new JComboBox<PremioPelicula>();
		comboBox_premio.setBounds(439, 118, 121, 20);
		getContentPane().add(comboBox_premio);
		comboBox_premioPrincipal.setVisible(false);
		comboBox_premio.setModel(new DefaultComboBoxModel<PremioPelicula>(PremioPelicula.values()));
		checkbox.setVisible(false);
		
		textField_titulo.setText(multimedia.getTitulo());
		textField_tituloOriginal.setText(multimedia.getTituloOriginal());
		comboBox_anno.setSelectedItem(multimedia.getAnyo());
		textField_duracion.setText(Integer.toString(multimedia.getDuracion()));
		textField_pais.setText(multimedia.getPais());
		textField_director.setText(multimedia.getDirector());
		textField_guion.setText(multimedia.getGuion());
		textField_musica.setText(multimedia.getMusica());
		textField_fotografia.setText(multimedia.getFotografia());
		textField_productora.setText(multimedia.getProductora());
		textArea_sinopsis.setText(multimedia.getSinopsis());
		comboBox_genero.setSelectedItem(multimedia.getGenero());
		textField_notaUsuario.setText(Float.toString(multimedia.getNotaUsuario()));
		textField_puntuacion.setText(Float.toString(multimedia.puntuable()));
		
		// Reparto
				for (int i = 0; i < multimedia.getReparto().length; i++) {
					for (int j = 0; j < multimedia.getReparto().length; j++) {
						textField_principales.setText(multimedia.getReparto()[i].toString());
						textField_secundarios.setText(multimedia.getReparto()[j].toString());
					}
				}
		
		
		btnAccion.setText("Modificar");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					multimedia.setTitulo(textField_titulo.getText());
					multimedia.setTituloOriginal(textField_tituloOriginal.getText());
					multimedia.setAnyo((int)comboBox_anno.getSelectedItem());
					multimedia.setDuracion((int)(Integer.parseInt(textField_duracion.getText())));
					multimedia.setPais(textField_pais.getText());
					multimedia.setDirector(textField_director.getText());
					multimedia.setGuion(textField_guion.getText());
					multimedia.setMusica(textField_musica.getText());
					multimedia.setFotografia(textField_fotografia.getText());
					//multimedia.setReparto(reparto); //TODO
					multimedia.setProductora(textField_productora.getText());
					multimedia.setGenero((Genero)comboBox_genero.getSelectedItem());
					multimedia.setSinopsis(textArea_sinopsis.getText());
					multimedia.setNotaUsuario((float)(Float.parseFloat(textField_notaUsuario.getText())));
					//PREMIO
					if(multimedia instanceof Pelicula) {
						Pelicula pelicula = (Pelicula) multimedia;
						pelicula.setPremios((PremioPelicula) comboBox_premio.getSelectedItem());
					}
					
					JOptionPane.showMessageDialog(getContentPane(), "La pel\u00edcula se ha modificado correctamente.","Pelicula modificada", JOptionPane.INFORMATION_MESSAGE);
					jlist.setModel(modelo);
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La pel\u00edcula no se ha podido modificar: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

}
