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
		
	}

}
