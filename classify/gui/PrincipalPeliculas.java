package classify.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import classify.jerarquia.Multimedia;
import java.awt.event.ActionEvent;


public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;
	private ArrayList<Multimedia> peliculas;
	

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		setTitle("Pel\u00edculas");
		setModal(true);
		setBounds(100, 100, 720, 788);

		peliculas = videoteca.listarPeliculas();
		modelo = new DefaultListModel<Multimedia>();
		for (Multimedia multimedia : peliculas) {
			modelo.addElement(multimedia);
		}
		
		jlist = new JList<Multimedia>(modelo);
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);

		// AÑADIR
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirPelicula = new AnnadirPelicula(jlist, modelo);
				annadirPelicula.setVisible(true);
			}
		});
	}
}
