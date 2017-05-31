package classify.gui;

import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import classify.jerarquia.Pelicula;

public class InfoPelicula extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField_nvisualizaciones;
	private JTextField textField_titulo;
	private JTextField textField_ultimaVisualizacion;

	/**
	 * Create the dialog.
	 * @param pelicula 
	 */
	public InfoPelicula(Pelicula pelicula) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoTemporada.class.getResource("/classify/gui/recursos/icon.png")));
		setModal(true);
		setResizable(false);
		setTitle(pelicula.getTitulo());
		setBounds(100, 100, 420, 282);
		getContentPane().setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00edtulo");
		lblTtulo.setBounds(41, 34, 142, 14);
		getContentPane().add(lblTtulo);
		
		JLabel lblNDeVisualizaciones = new JLabel("N� de visualizaciones");
		lblNDeVisualizaciones.setBounds(41, 77, 142, 14);
		getContentPane().add(lblNDeVisualizaciones);
		
		textField_nvisualizaciones = new JTextField();
		textField_nvisualizaciones.setEnabled(false);
		textField_nvisualizaciones.setEditable(false);
		textField_nvisualizaciones.setBounds(193, 74, 46, 20);
		getContentPane().add(textField_nvisualizaciones);
		textField_nvisualizaciones.setColumns(10);
		textField_nvisualizaciones.setText(String.valueOf(pelicula.getNumVisualizaciones()));
		
		textField_titulo = new JTextField();
		textField_titulo.setEnabled(false);
		textField_titulo.setEditable(false);
		textField_titulo.setBounds(193, 31, 160, 20);
		getContentPane().add(textField_titulo);
		textField_titulo.setColumns(10);
		textField_titulo.setText(pelicula.getTitulo());
		
		JCheckBox chckbx_visualizado = new JCheckBox("Visualizado");
		chckbx_visualizado.setEnabled(false);
		chckbx_visualizado.setBounds(142, 185, 97, 23);
		getContentPane().add(chckbx_visualizado);
		
		chckbx_visualizado.setSelected(pelicula.isVisualizado());
		
		JLabel lblUltimaVisualizacion = new JLabel("Ultima visualizacion");
		lblUltimaVisualizacion.setBounds(41, 123, 142, 14);
		getContentPane().add(lblUltimaVisualizacion);
		
		textField_ultimaVisualizacion = new JTextField();
		textField_ultimaVisualizacion.setEditable(false);
		textField_ultimaVisualizacion.setBounds(193, 120, 160, 20);
		getContentPane().add(textField_ultimaVisualizacion);
		textField_ultimaVisualizacion.setColumns(10);
		
		if(pelicula.getUltimaVisualizacion() == null){
			textField_ultimaVisualizacion.setText("No visualizada");
		}else{
			textField_ultimaVisualizacion.setText(pelicula.getUltimaVisualizacion().toString());
		}
		

	}

}
