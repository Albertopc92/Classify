package classify.gui;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import classify.jerarquia.Pelicula;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PrincipalPeliculas extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirPelicula annadirPelicula;
	private ListarPorGeneroPeliculas listarPorGeneroPeliculas;
	private ListarPorPuntuacionPeliculas listarPorPuntuacionPeliculas;
	private ListarPorVisualizacionesPeliculas listarPorVisualizacionesPeliculas;
	private InfoPelicula infoPelicula;
	

	/**
	 * Create the dialog.
	 */
	public PrincipalPeliculas() {
		btnListarPorNumeroVisualizaciones.setLocation(33, 436);
		btnListarPorPuntuacion.setLocation(33, 402);
		btnListarPorGenero.setLocation(33, 368);
		btnMarcaComoVisualizado.setLocation(33, 334);
		btnModificar.setLocation(33, 300);
		btnBorrar.setLocation(33, 266);
		btnAnnadir.setLocation(33, 232);
		btnVerFichaTecnica.setLocation(33, 198);
		setTitle("Pel\u00edculas");
		btnTemporadas.setVisible(false);
		setModal(true);
		setBounds(100, 100, 720, 788);
		btnTemporadas.setVisible(false);
		lblLista.setText("Pel\u00edculas");

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
		
		// MARCAR COMO VISUALIZADO
		btnMarcaComoVisualizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pelicula = (Pelicula)jlist.getSelectedValue();
				comprobarSiSeleccionado(pelicula);
				pelicula.marcarVisualizado();
			}
		});
		
		// VISUALIZAR
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pelicula= (Pelicula)jlist.getSelectedValue();
				comprobarSiSeleccionado(pelicula);
				pelicula.visualizar();
				pelicula.setUltimaVisualizacion(LocalDate.now());
			}
		});
		btnVisualizar.setBounds(33, 470, 183, 23);
		getContentPane().add(btnVisualizar);
		
		// INFORMACION
		JButton btnInformacion = new JButton("Informacion");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula pelicula = (Pelicula)jlist.getSelectedValue();
				comprobarSiSeleccionado(pelicula);
				infoPelicula = new InfoPelicula(pelicula);
				infoPelicula.setVisible(true);
			}
		});
		btnInformacion.setBounds(33, 164, 183, 23);
		getContentPane().add(btnInformacion);
		
		
	}
}
