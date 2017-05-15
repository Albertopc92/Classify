package classify.gui;

import classify.jerarquia.Multimedia;

public class FichaTecnica extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public FichaTecnica(Multimedia multimedia) {
		setBounds(100, 100, 720, 788);
		textField_titulo.setEnabled(false);
		textField_titulo.setText(multimedia.getTitulo());
		
		textField_tituloOriginal.setEnabled(false);
		textField_tituloOriginal.setText(multimedia.getTituloOriginal());
		
		comboBox_anno.setEnabled(false);
		comboBox_anno.setSelectedItem(multimedia.getAnyo());
		
		textField_duracion.setEnabled(false);
		textField_duracion.setText(Integer.toString(multimedia.getDuracion()));
		
		
		
		
	}

}
