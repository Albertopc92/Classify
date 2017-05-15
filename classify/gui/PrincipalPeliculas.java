package classify.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.excepciones.ListaVaciaException;
import classify.excepciones.NoExisteException;
import classify.excepciones.TituloNoValidoException;
import classify.jerarquia.Multimedia;

import java.awt.event.ActionEvent;


public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;
	private ArrayList<Multimedia> peliculas = videoteca.listarPeliculas();

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		btnVerFichaTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		/*jlist = new JList(videoteca.listarPeliculas().toArray());
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);*/
		
		//TODO actualizacion automatica del jlist
		modelo = new DefaultListModel<Multimedia>();
		jlist = new JList<Multimedia>(modelo);
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);
		for (Multimedia pelicula : peliculas) {
			modelo.addElement(pelicula);
		}
		
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
