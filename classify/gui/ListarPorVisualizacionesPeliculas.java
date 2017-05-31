package classify.gui;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Pelicula;
import javax.swing.JLabel;

/**
 * Clase que muestra las peliculas ordenadas por visualizaciones
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ListarPorVisualizacionesPeliculas extends PlantillaListarPorGenero {

	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> visualizaciones;
	private DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();

	/**
	 * Crea la ventana que muestra las peliculas ordenadas por visualizaciones
	 */
	public ListarPorVisualizacionesPeliculas(Videoteca videoteca) {
		setModal(true);
		setTitle("Listar por Visualizaciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaListarPorGenero.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 564, 370);
		
		JLabel lblMasVista = new JLabel("Mas vista");
		lblMasVista.setBounds(34, 57, 128, 14);
		getContentPane().add(lblMasVista);
		
		JLabel lblMenosVista = new JLabel("Menos vista");
		lblMenosVista.setBounds(34, 269, 191, 14);
		getContentPane().add(lblMenosVista);
		lblGenero.setVisible(false);
		comboBox_genero.setVisible(false);
		
		jlist.setModel(modelo);
		try {
			visualizaciones = videoteca.listarPeliculasVisualizaciones();
			for (Multimedia multimedia : visualizaciones) {
				modelo.addElement(multimedia);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
		}

	}

}
