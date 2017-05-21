package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import classify.envoltorios.Videoteca;
import classify.excepciones.TituloNoValidoException;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Pelicula;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.Toolkit;

public class PlantillaPrincipal extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JButton btnVerFichaTecnica;
	protected JButton btnAnnadir;
	protected JButton btnBorrar;
	protected JButton btnModificar;
	protected JButton btnMarcaComoVisualizado;
	protected JButton btnListarPorGenero;
	protected JButton btnListarPorPuntuacion;
	protected JButton btnListarPorNumeroVisualizaciones;
	protected JButton btnAnnadirTemporada;
	private FichaTecnica fichaTecnica;
	private ModificarPelicula modificarPelicula;
	private ModificarSerie modificarSerie;
	static Videoteca videoteca = Classify.videoteca;
	JList<Multimedia> jlist;
	DefaultListModel<Multimedia> modelo = new DefaultListModel<Multimedia>();
	

	/**
	 * Create the dialog.
	 */
	public PlantillaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaPrincipal.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 720, 788);
		getContentPane().setLayout(null);
		
		jlist = new JList<Multimedia>();
		jlist.setModel(modelo);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);
		

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(532, 684, 89, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblLista = new JLabel("Lista");
		lblLista.setBounds(287, 46, 46, 14);
		getContentPane().add(lblLista);
		
		// VER FICHA TÉCNICA
		btnVerFichaTecnica = new JButton("Ver ficha t\u00e9cnica");
		btnVerFichaTecnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFichaTecnica();
			}
		});
		btnVerFichaTecnica.setBounds(34, 192, 183, 23);
		getContentPane().add(btnVerFichaTecnica);
		
		btnAnnadir = new JButton("A\u00f1adir");
		btnAnnadir.setBounds(34, 226, 183, 23);
		getContentPane().add(btnAnnadir);
		
		// BORRAR
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setBounds(34, 260, 183, 23);
		getContentPane().add(btnBorrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(34, 294, 183, 23);
		getContentPane().add(btnModificar);
		
		btnMarcaComoVisualizado = new JButton("Marca como visualizado");
		btnMarcaComoVisualizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
				try {
					videoteca.marcarVisualizado(multimedia.getTitulo());
				} catch (TituloNoValidoException e) {
					
				}
			}
		});
		btnMarcaComoVisualizado.setBounds(34, 328, 183, 23);
		getContentPane().add(btnMarcaComoVisualizado);
		
		//LISTAR POR GENERO
		btnListarPorGenero = new JButton("Listar por g\u00e9nero");
		btnListarPorGenero.setBounds(34, 362, 183, 23);
		getContentPane().add(btnListarPorGenero);
		
		btnListarPorPuntuacion = new JButton("Listar por Puntuaci\u00f3n");
		btnListarPorPuntuacion.setBounds(34, 396, 183, 23);
		getContentPane().add(btnListarPorPuntuacion);
		
		btnListarPorNumeroVisualizaciones = new JButton("Listar por visualizaciones");
		btnListarPorNumeroVisualizaciones.setBounds(34, 430, 183, 23);
		getContentPane().add(btnListarPorNumeroVisualizaciones);
		
		btnAnnadirTemporada = new JButton("A\u00F1adir Temporada");
		btnAnnadirTemporada.setBounds(34, 464, 183, 23);
		getContentPane().add(btnAnnadirTemporada);
		
		JLabel icono = new JLabel("");
		icono.setBounds(87, 68, 64, 64);
		getContentPane().add(icono);

	}
	
	/**
	 * Borra un elemento de la videoteca
	 */
	private void borrar() {
		Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
		comprobarSiSeleccionado(multimedia);
		try {
			videoteca.borrar(multimedia.getTitulo());
			JOptionPane.showMessageDialog(null, "Se ha borrado: " + multimedia.getTitulo());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar: " + exception.getMessage());
		}
	}

	
	/**
	 * Muestra la ficha tecnica del elemento seleccionado
	 */
	private void mostrarFichaTecnica() {
		Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
		comprobarSiSeleccionado(multimedia);
			
		fichaTecnica = new FichaTecnica(multimedia);
		fichaTecnica.setVisible(true);
	}
	
	/**
	 * Modifica un elemento de la videoteca
	 */
	private void modificar() {
		Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
		comprobarSiSeleccionado(multimedia);
		if(multimedia instanceof Pelicula) {
			modificarPelicula = new ModificarPelicula(jlist, modelo, multimedia);
			modificarPelicula.setVisible(true);
		}else {
			modificarSerie = new ModificarSerie(jlist, modelo, multimedia);
			modificarSerie.setVisible(true);
		}
	}
	
	/**
	 * Rellena el jlist de peliculas
	 */
	public void rellenarJlist(ArrayList<Multimedia> elementos) {
		for (Multimedia multimedia : elementos) {
			modelo.addElement(multimedia);
		}
	}
	
	/**
	 * Compueba si antes de realizar una accion el usurio ha saleccionado un elemento de la lista
	 * @param multimedia
	 */
	private void comprobarSiSeleccionado(Multimedia multimedia) {
		if(multimedia == null) {
			JOptionPane.showMessageDialog(getContentPane(), "Seleccione un elemento de la lista.");
			return;
		}
	}
}
