package classify.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import classify.jerarquia.Multimedia;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;
	private ArrayList<Multimedia> peliculas;
	

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		setTitle("Pel\u00edculas");
		btnAnnadirTemporada.setVisible(false);
		setModal(true);
		setBounds(100, 100, 720, 788);

		rellenarJlist();
		
//		jlist = new JList<Multimedia>(modelo);
//		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		//scroll = new JScrollPane(jlist);
//		jlist.setBounds(287, 71, 380, 579);
//		getContentPane().add(jlist);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(PrincipalPeliculas.class.getResource("/classify/gui/recursos/principalPelicula.png")));
		icono.setBounds(87, 68, 64, 64);
		getContentPane().add(icono);

		// AÑADIR
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirPelicula = new AnnadirPelicula(jlist, modelo);
				annadirPelicula.setVisible(true);
			}
		});
	}

	public void rellenarJlist() {
		peliculas = videoteca.listarPeliculas();
		//modelo = new DefaultListModel<Multimedia>();
		for (Multimedia multimedia : peliculas) {
			modelo.addElement(multimedia);
		}
	}
	
	
}
