package classify.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classify.jerarquia.Multimedia;
import classify.jerarquia.Serie;

import javax.swing.ImageIcon;
/**
 * Clase que se encarga de gestionar las series
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class PrincipalSeries extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirSerie annadirSerie;
	private ListarPorGeneroSeries listarPorGeneroSeries;
	private ListarPorPuntuacionSeries listarPorPuntuacionSeries;
	private PrincipalTemporada principalTemporada;

	/**
	 * Crea la ventana donde se gestionaran las series
	 */
	public PrincipalSeries() {
		setTitle("Series");
		setModal(true);
		setBounds(100, 100, 720, 788);
		btnListarPorNumeroVisualizaciones.setVisible(false);
		btnMarcaComoVisualizado.setVisible(false);
		lblLista.setText("Series");
		
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
		
		//ABRIR VENTANA TEMPORADA
		btnTemporadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Multimedia multimedia = (Multimedia) jlist.getSelectedValue();
				if(multimedia == null) {
					JOptionPane.showMessageDialog(getContentPane(), "Seleccione un elemento de la lista.");
					return;
				}
				Serie serie = (Serie) multimedia;
				principalTemporada = new PrincipalTemporada(serie);
				principalTemporada.setVisible(true);
			}
		});
		
	}

}
