package classify.gui;


import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;

public class ListarPorPuntuacionPeliculas extends PlantillaListarPorGenero {

	private static final long serialVersionUID = 1L;
	private ArrayList<Multimedia> puntuacion;
	private DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();
	

	/**
	 * Create the dialog.
	 */
	public ListarPorPuntuacionPeliculas(Videoteca videoteca) {
		setModal(true);
		setTitle("Listar por Puntuacion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaListarPorGenero.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 564, 370);
		lblGenero.setVisible(false);
		comboBox_genero.setVisible(false);
		
		jlist.setModel(modelo);
		try {
			puntuacion = videoteca.listarPeliculasPuntuacion();
			for (Multimedia multimedia : puntuacion) {
				modelo.addElement(multimedia);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), e.getMessage());
		}
		
	}

}
