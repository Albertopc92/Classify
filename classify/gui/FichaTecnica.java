package classify.gui;

import classify.jerarquia.Multimedia;
import classify.jerarquia.Pelicula;
import classify.jerarquia.Serie;

/**
 * Clase que se encarga de mostrar la ficha tecnica
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class FichaTecnica extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana de la ficha tecnica
	 */
	public FichaTecnica(Multimedia multimedia) {
		setBounds(100, 100, 720, 788);
		btnAccion.setVisible(false);
		
		checkbox.setEnabled(false);
		if(multimedia instanceof Serie) {
			Serie serie = (Serie) multimedia;
			checkbox.setState(serie.isEmitiendo());
		}else if(multimedia instanceof Pelicula) {
			checkbox.setVisible(false);
		}

		textField_titulo.setEnabled(false);
		textField_titulo.setText(multimedia.getTitulo());
		
		textField_tituloOriginal.setEnabled(false);
		textField_tituloOriginal.setText(multimedia.getTituloOriginal());
		
		comboBox_anno.setEnabled(false);
		comboBox_anno.setSelectedItem(multimedia.getAnyo());
		
		textField_duracion.setEnabled(false);
		textField_duracion.setText(Integer.toString(multimedia.getDuracion()));
		
		textField_pais.setEnabled(false);
		textField_pais.setText(multimedia.getPais());
		
		textField_director.setEnabled(false);
		textField_director.setText(multimedia.getDirector());
		
		textField_guion.setEnabled(false);
		textField_guion.setText(multimedia.getGuion());
		
		textField_musica.setEnabled(false);
		textField_musica.setText(multimedia.getMusica());
		
		textField_fotografia.setEnabled(false);
		textField_fotografia.setText(multimedia.getFotografia());
		
		textField_productora.setEnabled(false);
		textField_productora.setText(multimedia.getProductora());
		
		textArea_sinopsis.setEnabled(false);
		textArea_sinopsis.setText(multimedia.getSinopsis());
		
		comboBox_genero.setEnabled(false);
		comboBox_genero.setSelectedItem(multimedia.getGenero());
		
		comboBox_premioPrincipal.setEnabled(false);
		if(multimedia instanceof Pelicula) {
			Pelicula pelicula = (Pelicula) multimedia;
			comboBox_premioPrincipal.setSelectedItem(pelicula.getPremios());
		}else if (multimedia instanceof Serie) {
			Serie serie = (Serie) multimedia;
			comboBox_premioPrincipal.setSelectedItem(serie.getPremios());
		}
		
		textField_notaUsuario.setEnabled(false);
		textField_notaUsuario.setText(Float.toString(multimedia.getNotaUsuario()));
		
		textField_puntuacion.setEnabled(false);
		textField_puntuacion.setText(Float.toString(multimedia.puntuable()));
		
		
		textField_principales.setEnabled(true);
		textField_secundarios.setEnabled(true);
		
		for (int i = 0; i < multimedia.getReparto().length; i++) {
			for (int j = 0; j < multimedia.getReparto().length; j++) {
				textField_principales.setText(multimedia.getReparto()[i].toString());
				textField_secundarios.setText(multimedia.getReparto()[j].toString());
			}
		}
		
	}

}
