package classify.gui;

import classify.envoltorios.Temporada;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Serie;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;

public class PrincipalTemporada extends PrincipalSeries {

	private static final long serialVersionUID = 1L;
	private AnnadirTemporada annadirTemporada;
	private JList<Temporada> jlistTemporadas;
	private DefaultListModel<Temporada> modelo = new DefaultListModel<Temporada>();

	/**
	 * Create the dialog.
	 */
	public PrincipalTemporada(Serie serie) {
		setBounds(100, 100, 720, 788);
		setTitle("Temporadas");
		setModal(true);
		btnVerFichaTecnica.setVisible(false);
		btnAnnadir.setVisible(false);
		btnAnnadir.setText("A\u00f1adir Temporada");
		btnBorrar.setText("Borrar Temporada");
		btnModificar.setText("Modificar Temporada");
		btnMarcaComoVisualizado.setVisible(false);
		btnListarPorGenero.setVisible(false);
		btnListarPorPuntuacion.setVisible(false);
		btnTemporadas.setText("Capitulos");
		
		jlistTemporadas = new JList<Temporada>();
		jlistTemporadas.setModel(modelo);
		jlistTemporadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistTemporadas.setBounds(287, 71, 380, 579);
		getContentPane().add(jlistTemporadas);
		
		try {
			for (Temporada temporada: serie.listarTemporadas()) {
				modelo.addElement(temporada);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), "No hay temporadas que mostrar para esta serie. A\u00f1ada alguna.","No hay temporadas", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// AÑADIR TEMPORADA
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirTemporada = new AnnadirTemporada(serie);
				annadirTemporada.setVisible(true);
			}
		});
	}

}
