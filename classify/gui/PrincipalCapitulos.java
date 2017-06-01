package classify.gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import classify.Capitulo;
import classify.envoltorios.Temporada;
import classify.envoltorios.Videoteca;
import classify.excepciones.ListaVaciaException;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * Clase que se encargar de gestionar los capitulos
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class PrincipalCapitulos extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private JList<Capitulo> jlistCapitulos;
	private DefaultListModel<Capitulo> modeloCapitulos = new DefaultListModel<Capitulo>();
	private InfoCapitulo infoCapitulo;
	private AnnadirCapitulo annadirCapitulo;
	private ModificarCapitulo modificarCapitulo;

	/**
	 * Crea la ventana de gestion de capitulos
	 * @param temporada
	 * @param videoteca 
	 */
	public PrincipalCapitulos(Temporada temporada, Videoteca videoteca) {
		btnVerFichaTecnica.setEnabled(false);
		setBounds(100, 100, 720, 788);
		setResizable(false);
		setTitle("Cap\u00edtulos");
		setModal(true);
		lblLista.setText("cap\u00edtulos");
		btnVerFichaTecnica.setEnabled(false);
		btnVerFichaTecnica.setVisible(false);
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
		
		JButton btnInformacion = new JButton("Informacion");
		btnInformacion.setBounds(34, 192, 183, 23);
		getContentPane().add(btnInformacion);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(PrincipalSeries.class.getResource("/classify/gui/recursos/principalSerie.png")));
		icono.setBounds(87, 68, 64, 64);
		getContentPane().add(icono);
		
		
		try {
			for (Capitulo capitulo: temporada.listarCapitulos()) {
				modeloCapitulos.addElement(capitulo);
			}
		} catch (ListaVaciaException e) {
			JOptionPane.showMessageDialog(getContentPane(), "No hay cap\u00edtulos que mostrar para esta temporada. A\u00f1ada alguno.","No hay capitulos", JOptionPane.INFORMATION_MESSAGE);
		}
		
		// INFORMACION CAPITULO
		btnInformacion.addActionListener(new ActionListener() {
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
				annadirCapitulo = new AnnadirCapitulo(temporada, jlistCapitulos, modeloCapitulos, videoteca);
				annadirCapitulo.setVisible(true);
			}
		});
		
		// BORRAR CAPITULO
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCapitulo(temporada);
			}
		});
		
		// MARCAR COMO VISUALIZADO
		btnMarcaComoVisualizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Capitulo capitulo = jlistCapitulos.getSelectedValue();
				comprobarSiSeleccionado(capitulo);
				capitulo.marcarVisualizado();
				videoteca.setModificado(true);
				JOptionPane.showMessageDialog(getContentPane(), "Marcado como visualizado.");
			}
		});
		
		// MODIFICAR CAPITULO
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCapitulo();
			}
		});
		
		// VISUALIZAR
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Capitulo capitulo = jlistCapitulos.getSelectedValue();
				comprobarSiSeleccionado(capitulo);
				capitulo.visualizar();
				capitulo.setUltimaVisualizacion(LocalDate.now());
				videoteca.setModificado(true);
				JOptionPane.showMessageDialog(getContentPane(), "Cap\u00edtulo Visualizado.");
			}
		});
		btnVisualizar.setBounds(34, 158, 183, 23);
		getContentPane().add(btnVisualizar);
		
		

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
			switch (JOptionPane.showOptionDialog(getContentPane(), "Se va a borrar " + capitulo.getTitulo() + " Â¿Estas seguro?", "Borrar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0])) {
			case 0:
				temporada.bajaCapitulo(capitulo.getIDCapitulo());
				videoteca.setModificado(true);
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
	
	/**
	 * Modifica un capitulo
	 */
	private void modificarCapitulo(){
		Capitulo capitulo = jlistCapitulos.getSelectedValue();
		comprobarSiSeleccionado(capitulo);
		modificarCapitulo = new ModificarCapitulo(jlistCapitulos, modeloCapitulos, capitulo, videoteca);
		modificarCapitulo.setVisible(true);
	}
}
