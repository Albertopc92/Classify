package classify.gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import classify.Capitulo;
import classify.envoltorios.Temporada;
import classify.excepciones.ListaVaciaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalCapitulos extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private JList<Capitulo> jlistCapitulos;
	private DefaultListModel<Capitulo> modeloCapitulos = new DefaultListModel<Capitulo>();
	private InfoCapitulo infoCapitulo;
	private AnnadirCapitulo annadirCapitulo;

	/**
	 * Create the dialog.
	 */
	public PrincipalCapitulos(Temporada temporada) {
		setBounds(100, 100, 720, 788);
		setTitle("Capitulos");
		setModal(true);
		btnVerFichaTecnica.setText("Informaci\u00f3n");
		btnAnnadir.setText("A\u00f1adir Capitulo");
		btnBorrar.setText("Borrar Capitulo");
		btnModificar.setText("Modificar Capitulo");
		btnMarcaComoVisualizado.setVisible(true);
		btnListarPorGenero.setVisible(false);
		btnListarPorPuntuacion.setVisible(false);
		btnTemporadas.setVisible(false);
		btnListarPorNumeroVisualizaciones.setVisible(false);
		jlist.setVisible(false);
		jlistCapitulos = new JList<Capitulo>();
		jlistCapitulos.setModel(modeloCapitulos);
		jlistCapitulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistCapitulos.setBounds(287, 71, 380, 579);
		getContentPane().add(jlistCapitulos);
		
		try {
			for (Capitulo capitulo: temporada.listarCapitulos()) {
				modeloCapitulos.addElement(capitulo);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), "No hay cap\u00edtulos que mostrar para esta temporada. A\u00f1ada alguna.","No hay capitulos", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// INFORMACION CAPITULO
		btnVerFichaTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Capitulo capitulo = jlistCapitulos.getSelectedValue();
				comprobarSiSeleccionado(capitulo);
				infoCapitulo = new InfoCapitulo(capitulo);
				infoCapitulo.setVisible(true);
			}
		});
		
		// AÑADIR CAPITULO
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirCapitulo = new AnnadirCapitulo(temporada, jlistCapitulos, modeloCapitulos);
				annadirCapitulo.setVisible(true);
			}
		});
		
		// BORRAR CAPITULO
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCapitulo(temporada);
			}
		});
		

	}
	
	/**
	 * Borra un capitulo
	 * @param temporada
	 */
	private void borrarCapitulo(Temporada temporada) {
		Capitulo capitulo = jlistCapitulos.getSelectedValue();
		comprobarSiSeleccionado(capitulo);
		try {
			String[] opciones = {"Si", "No"};
			switch (JOptionPane.showOptionDialog(getContentPane(), "Se va a borrar " + capitulo.getTitulo() + " ¿Estas seguro?", "Borrar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0])) {
			case 0:
				temporada.bajaCapitulo(capitulo.getIDCapitulo());
				break;
			default:
				return;
			}
			JOptionPane.showMessageDialog(null, "Se ha borrado: " + capitulo.getTitulo());
			jlistCapitulos.setModel(modeloCapitulos);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar: " + exception.getMessage());
		}
		
		modeloCapitulos.clear();
		try {
			for (Capitulo elemento : temporada.listarCapitulos()) {
				modeloCapitulos.addElement(elemento);
			}
		} catch (ListaVaciaException e1) {

		}
	}
	
	
}
