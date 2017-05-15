package classify.gui;

import java.awt.event.ActionListener;
import javax.swing.JList;

import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;
import classify.excepciones.YaExisteException;

import java.awt.event.ActionEvent;


public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		jlist = new JList(videoteca.listarPeliculas().toArray());
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);
		
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirPelicula = new AnnadirPelicula();
				annadirPelicula.setVisible(true);
			}
		});
		setTitle("Pel\u00edculas");
		setModal(true);
		setBounds(100, 100, 720, 788);
		
		
		
	}
}
