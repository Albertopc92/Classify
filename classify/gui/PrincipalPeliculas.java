package classify.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;
	private ListarPorGeneroPeliculas listarPorGeneroPeliculas;
	private ListarPorPuntuacionPeliculas listarPorPuntuacionPeliculas;
	private ListarPorVisualizacionesPeliculas listarPorVisualizacionesPeliculas;
	

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		setTitle("Pel\u00edculas");
		btnAnnadirTemporada.setVisible(false);
		setModal(true);
		setBounds(100, 100, 720, 788);
		btnAnnadirTemporada.setVisible(false);

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
		
		// LISTAR POR GENERO
		btnListarPorGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPorGeneroPeliculas = new ListarPorGeneroPeliculas(videoteca);
				listarPorGeneroPeliculas.setVisible(true);
			}
		});
		
		// LISTAR POR PUNTUACION
		btnListarPorPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPorPuntuacionPeliculas = new ListarPorPuntuacionPeliculas(videoteca);
				listarPorPuntuacionPeliculas.setVisible(true);
			}
		});
		
		// LISTAR POR VISUALIZACIONES
		btnListarPorNumeroVisualizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPorVisualizacionesPeliculas = new ListarPorVisualizacionesPeliculas(videoteca);
				listarPorVisualizacionesPeliculas.setVisible(true);
			}
		});
	}
}
