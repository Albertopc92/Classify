package classify.gui;

import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classify.Capitulo;
import javax.swing.JCheckBox;

public class InfoCapitulo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField_nvisualizaciones;
	private JTextField textField_titulo;
	private JTextField textField_ultimaVisualizacion;

	/**
	 * Create the dialog.
	 */
	public InfoCapitulo(Capitulo capitulo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoTemporada.class.getResource("/classify/gui/recursos/icon.png")));
		setModal(true);
		setResizable(false);
		setTitle(capitulo.getTitulo());
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
		textField_nvisualizaciones.setText(String.valueOf(capitulo.getNumVisualizaciones()));
		
		textField_titulo = new JTextField();
		textField_titulo.setEnabled(false);
		textField_titulo.setEditable(false);
		textField_titulo.setBounds(193, 31, 160, 20);
		getContentPane().add(textField_titulo);
		textField_titulo.setColumns(10);
		textField_titulo.setText(capitulo.getTitulo());
		
		JCheckBox chckbx_visualizado = new JCheckBox("Visualizado");
		chckbx_visualizado.setEnabled(false);
		chckbx_visualizado.setBounds(142, 185, 97, 23);
		getContentPane().add(chckbx_visualizado);
		
		chckbx_visualizado.setSelected(capitulo.isVisualizado());
		
		JLabel lblUltimaVisualizacion = new JLabel("Ultima visualizacion");
		lblUltimaVisualizacion.setBounds(41, 123, 142, 14);
		getContentPane().add(lblUltimaVisualizacion);
		
		textField_ultimaVisualizacion = new JTextField();
		textField_ultimaVisualizacion.setEditable(false);
		textField_ultimaVisualizacion.setBounds(193, 120, 160, 20);
		getContentPane().add(textField_ultimaVisualizacion);
		textField_ultimaVisualizacion.setColumns(10);
		
		if (capitulo.getUltimaVisualizacion() == null) {
			textField_ultimaVisualizacion.setText("No visualizado");
		}else{
			textField_ultimaVisualizacion.setText(capitulo.getUltimaVisualizacion().toString());
		}
		

	}
}
