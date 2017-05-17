package classify.gui;

import classify.jerarquia.Multimedia;

public class FichaTecnica extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public FichaTecnica(Multimedia multimedia) {
		setBounds(100, 100, 720, 788);
		btnAccion.setVisible(false);
		
		checkbox.setEnabled(false);
		//checkbox.setState(multimedia);
		
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
		
		comboBox_premio.setEnabled(false);
		//comboBox_premio.setSelectedItem(); TODO
		
		textField_notaUsuario.setEnabled(false);
		textField_notaUsuario.setText(Float.toString(multimedia.getNotaUsuario()));
		
		textField_puntuacion.setEnabled(false);
		textField_puntuacion.setText(Float.toString(multimedia.puntuable()));
		
		textField_principales.setEnabled(true);
		//textField__principales.setText(); TODO
		
		textField_secundarios.setEnabled(true);
		//textField_secundarioss.setText(); TODO
	}

}
