package classify.gui;


import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;
import javax.swing.JLabel;

/**
 * Clase que muestra las series ordenadas por puntuacion
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ListarPorPuntuacionSeries extends PlantillaListarPorGenero {

	private static final long serialVersionUID = 1L;
	private ArrayList<Multimedia> puntuacion;
	private DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();

	/**
	 * Crea la ventana que muestra las series ordenadas por puntuacion
	 */
	public ListarPorPuntuacionSeries(Videoteca videoteca) {
		setModal(true);
		setTitle("Listar por Puntuacion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaListarPorGenero.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 564, 370);
		
		JLabel lblMayorPuntuacion = new JLabel("Mayor Puntuacion");
		lblMayorPuntuacion.setBounds(37, 57, 177, 14);
		getContentPane().add(lblMayorPuntuacion);
		
		JLabel lblMenorPuntuacion = new JLabel("Menor Puntuacion");
		lblMenorPuntuacion.setBounds(37, 267, 158, 14);
		getContentPane().add(lblMenorPuntuacion);
		lblGenero.setVisible(false);
		comboBox_genero.setVisible(false);
		
		jlist.setModel(modelo);
		try {
			puntuacion = videoteca.listarSeriesPuntuacion();
			for (Multimedia multimedia : puntuacion) {
				modelo.addElement(multimedia);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
		}
		

	}
}
