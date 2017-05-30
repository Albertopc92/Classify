package classify.gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import classify.Capitulo;
import classify.envoltorios.Temporada;

public class PrincipalCapitulos extends PrincipalSeries {

	private static final long serialVersionUID = 1L;
	private JList<Capitulo> jlistCapitulos;
	private DefaultListModel<Capitulo> modeloCapitulos = new DefaultListModel<Capitulo>();

	/**
	 * Create the dialog.
	 */
	public PrincipalCapitulos(Temporada temporada) {
		setBounds(100, 100, 720, 788);
		setTitle("Capitulos");
		setModal(true);
		btnVerFichaTecnica.setVisible(false);
		btnAnnadir.setText("A\u00f1adir Capitulo");
		btnBorrar.setText("Borrar Capitulo");
		btnModificar.setText("Modificar Capitulo");
		btnMarcaComoVisualizado.setVisible(true);
		btnListarPorGenero.setVisible(false);
		btnListarPorPuntuacion.setVisible(false);
		btnTemporadas.setVisible(false);
		jlist.setVisible(false);
		jlistCapitulos = new JList<Capitulo>();
		jlistCapitulos.setModel(modeloCapitulos);
		jlistCapitulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistCapitulos.setBounds(287, 71, 380, 579);
		getContentPane().add(jlistCapitulos);

	}

}
