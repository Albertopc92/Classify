package classify.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PrincipalSeries extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirSerie annadirSerie;
	private ListarPorGeneroSeries listarPorGeneroSeries;
	private ListarPorPuntuacionSeries listarPorPuntuacionSeries;

	/**
	 * Create the dialog.
	 */
	public PrincipalSeries() {
		setTitle("Series");
		setModal(true);
		setBounds(100, 100, 720, 788);
		btnListarPorNumeroVisualizaciones.setVisible(false);
		
		rellenarJlist(videoteca.listarSeries());
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(PrincipalSeries.class.getResource("/classify/gui/recursos/principalSerie.png")));
		icono.setBounds(87, 68, 64, 64);
		getContentPane().add(icono);
		
		// AÑADIR
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirSerie = new AnnadirSerie(jlist, modelo);
				annadirSerie.setVisible(true);
			}
		});
		
		// LISTAR SERIES POR GENERO
		btnListarPorGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPorGeneroSeries = new ListarPorGeneroSeries(videoteca);
				listarPorGeneroSeries.setVisible(true);
			}
		});
		
		// LISTAR POR PUNTUACION
		btnListarPorPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPorPuntuacionSeries = new ListarPorPuntuacionSeries(videoteca);
				listarPorPuntuacionSeries.setVisible(true);
			}
		});
		
	}

}
