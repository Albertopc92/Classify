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
	

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		setTitle("Pel\u00edculas");
		btnAnnadirTemporada.setVisible(false);
		setModal(true);
		setBounds(100, 100, 720, 788);

		rellenarJlist(videoteca.listarPeliculas());
		
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
}
