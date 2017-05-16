package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.envoltorios.Videoteca;
import classify.jerarquia.Multimedia;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private FichaTecnica fichaTecnica;
	Videoteca videoteca = Classify.videoteca;
	JList<Multimedia> jlist;
	DefaultListModel<Multimedia> modelo;
	

	/**
	 * Create the dialog.
	 */
	public PlantillaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaPrincipal.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 720, 788);
		getContentPane().setLayout(null);
/*
		jlist = new JList<Multimedia>();
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);
*/
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
				Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
				fichaTecnica = new FichaTecnica(multimedia);
				fichaTecnica.setVisible(true);
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
		btnModificar.setBounds(34, 294, 183, 23);
		getContentPane().add(btnModificar);
		
		btnMarcaComoVisualizado = new JButton("Marca como visualizado");
		btnMarcaComoVisualizado.setBounds(34, 328, 183, 23);
		getContentPane().add(btnMarcaComoVisualizado);
		
		btnListarPorGenero = new JButton("Listar por g\u00e9nero");
		btnListarPorGenero.setBounds(34, 362, 183, 23);
		getContentPane().add(btnListarPorGenero);
		
		btnListarPorPuntuacion = new JButton("Listar por Puntuaci\u00f3n");
		btnListarPorPuntuacion.setBounds(34, 396, 183, 23);
		getContentPane().add(btnListarPorPuntuacion);
		
		btnListarPorNumeroVisualizaciones = new JButton("Listar por visualizaciones");
		btnListarPorNumeroVisualizaciones.setBounds(34, 430, 183, 23);
		getContentPane().add(btnListarPorNumeroVisualizaciones);

	}
	
	/**
	 * Borra un elemento de la videoteca
	 */
	void borrar() {
		Multimedia multimedia = (Multimedia)jlist.getSelectedValue();
		try {
			videoteca.borrar(multimedia.getTitulo());
			JOptionPane.showMessageDialog(null, "Se ha borrado: " + multimedia.getTitulo());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "No se ha podido borrar: " + exception.getMessage());
		}
	}
}
