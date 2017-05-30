package classify.gui;

import classify.envoltorios.Temporada;
import classify.excepciones.ListaVaciaException;
import classify.jerarquia.Serie;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;

public class PrincipalTemporada extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private AnnadirTemporada annadirTemporada;
	private JList<Temporada> jlistTemporadas;
	private InfoTemporada infoTemporada;
	private PrincipalCapitulos principalCapitulos;
	private ModificarTemporada modificarTemporada;
	private DefaultListModel<Temporada> modeloTemporadas = new DefaultListModel<Temporada>();

	/**
	 * Create the dialog.
	 */
	public PrincipalTemporada(Serie serie) {
		setBounds(100, 100, 720, 788);
		setTitle("Temporadas");
		setModal(true);
		btnListarPorNumeroVisualizaciones.setVisible(false);
		btnVerFichaTecnica.setText("Informaci\u00f3n");
		btnAnnadir.setText("A\u00f1adir Temporada");
		btnBorrar.setText("Borrar Temporada");
		btnModificar.setText("Modificar Temporada");
		btnMarcaComoVisualizado.setVisible(false);
		btnListarPorGenero.setVisible(false);
		btnListarPorPuntuacion.setVisible(false);
		btnTemporadas.setText("Capitulos");
		jlist.setVisible(false);
		jlistTemporadas = new JList<Temporada>();
		jlistTemporadas.setModel(modeloTemporadas);
		jlistTemporadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistTemporadas.setBounds(287, 71, 380, 579);
		getContentPane().add(jlistTemporadas);
		
		try {
			for (Temporada temporada: serie.listarTemporadas()) {
				modeloTemporadas.addElement(temporada);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), "No hay temporadas que mostrar para esta serie. A\u00f1ada alguna.","No hay temporadas", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// INFORMACION DE LA TEMPORADA
		btnVerFichaTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temporada temporada = jlistTemporadas.getSelectedValue();
				comprobarSiSeleccionado(temporada);
				infoTemporada = new InfoTemporada(temporada);
				infoTemporada.setVisible(true);
			}
		});
		
		// AÑADIR TEMPORADA
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirTemporada = new AnnadirTemporada(serie, jlistTemporadas, modeloTemporadas);
				annadirTemporada.setVisible(true);
			}
		});
		
		// BORRAR TEMPORADA
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTemporada(serie);
			}
		});
		
		
		// MODIFICAR TEMPORADA
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		
		// ABRIR VENTANA CAPITULOS
		btnTemporadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temporada temporada = jlistTemporadas.getSelectedValue();
				if(temporada == null) {
					JOptionPane.showMessageDialog(getContentPane(), "Seleccione un elemento de la lista.");
					return;
				}

				principalCapitulos = new PrincipalCapitulos(temporada);
				principalCapitulos.setVisible(true);
			}
		});
		
	}
	
	/**
	 * Modifica una temporada
	 */
	private void modificar(){
		Temporada temporada = jlistTemporadas.getSelectedValue();
		comprobarSiSeleccionado(temporada);
		modificarTemporada = new ModificarTemporada(jlistTemporadas, modeloTemporadas, temporada);
		modificarTemporada.setVisible(true);
	}
	
	
	/**
	 * Borra una temporada
	 * @param serie
	 */
	private void borrarTemporada(Serie serie) {
		Temporada temporada = jlistTemporadas.getSelectedValue();
		comprobarSiSeleccionado(temporada);
		try {
			String[] opciones = {"Si", "No"};
			switch (JOptionPane.showOptionDialog(getContentPane(), "Se va a borrar " + temporada.getTitulo() + " ¿Estas seguro?", "Borrar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0])) {
			case 0:
				serie.bajaTemporada(temporada.getIDTemporada());
				break;
			default:
				return;
			}
			JOptionPane.showMessageDialog(null, "Se ha borrado: " + temporada.getTitulo());
			jlistTemporadas.setModel(modeloTemporadas);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar: " + exception.getMessage());
		}
		
		modeloTemporadas.clear();
		try {
			for (Temporada elemento : serie.listarTemporadas()) {
				modeloTemporadas.addElement(elemento);
			}
		} catch (ListaVaciaException e1) {

		}
	}
	
	
	/**
	 * Comprueba si se ha seleccionado alguna temporada de la lista
	 * @param temporada
	 */
	private void comprobarSiSeleccionado(Temporada temporada) {
		if(temporada == null) {
			JOptionPane.showMessageDialog(getContentPane(), "Seleccione un elemento de la lista.");
			return;
		}
	}

}
