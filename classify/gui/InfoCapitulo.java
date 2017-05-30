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

	/**
	 * Create the dialog.
	 */
	public InfoCapitulo(Capitulo capitulo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoTemporada.class.getResource("/classify/gui/recursos/icon.png")));
		setModal(true);
		setResizable(false);
		setTitle(capitulo.getTitulo());
		setBounds(100, 100, 367, 212);
		getContentPane().setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00edtulo");
		lblTtulo.setBounds(41, 34, 46, 14);
		getContentPane().add(lblTtulo);
		
		JLabel lblNDeVisualizaciones = new JLabel("Nº de visualizaciones");
		lblNDeVisualizaciones.setBounds(41, 77, 114, 14);
		getContentPane().add(lblNDeVisualizaciones);
		
		textField_nvisualizaciones = new JTextField();
		textField_nvisualizaciones.setEnabled(false);
		textField_nvisualizaciones.setEditable(false);
		textField_nvisualizaciones.setBounds(161, 74, 46, 20);
		getContentPane().add(textField_nvisualizaciones);
		textField_nvisualizaciones.setColumns(10);
		textField_nvisualizaciones.setText(String.valueOf(capitulo.getNumVisualizaciones()));
		
		textField_titulo = new JTextField();
		textField_titulo.setEnabled(false);
		textField_titulo.setEditable(false);
		textField_titulo.setBounds(161, 31, 160, 20);
		getContentPane().add(textField_titulo);
		textField_titulo.setColumns(10);
		textField_titulo.setText(capitulo.getTitulo());
		
		JCheckBox chckbx_visualizado = new JCheckBox("Visualizado");
		chckbx_visualizado.setBounds(114, 118, 97, 23);
		getContentPane().add(chckbx_visualizado);

	}
}
