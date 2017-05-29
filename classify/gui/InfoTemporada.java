package classify.gui;

import javax.swing.JDialog;

import classify.envoltorios.Temporada;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InfoTemporada extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField_ncapitulos;
	private JTextField textField_titulo;

	/**
	 * Create the dialog.
	 */
	public InfoTemporada(Temporada temporada) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoTemporada.class.getResource("/classify/gui/recursos/icon.png")));
		setModal(true);
		setResizable(false);
		setTitle(temporada.getTitulo());
		setBounds(100, 100, 367, 192);
		getContentPane().setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00edtulo");
		lblTtulo.setBounds(41, 34, 46, 14);
		getContentPane().add(lblTtulo);
		
		JLabel lblNDeCaptulos = new JLabel("Nº de cap\u00edtulos");
		lblNDeCaptulos.setBounds(41, 77, 91, 14);
		getContentPane().add(lblNDeCaptulos);
		
		textField_ncapitulos = new JTextField();
		textField_ncapitulos.setEnabled(false);
		textField_ncapitulos.setEditable(false);
		textField_ncapitulos.setBounds(129, 74, 46, 20);
		getContentPane().add(textField_ncapitulos);
		textField_ncapitulos.setColumns(10);
		textField_ncapitulos.setText(String.valueOf(temporada.getNumCapitulos()));
		
		textField_titulo = new JTextField();
		textField_titulo.setEnabled(false);
		textField_titulo.setEditable(false);
		textField_titulo.setBounds(129, 31, 160, 20);
		getContentPane().add(textField_titulo);
		textField_titulo.setColumns(10);
		textField_titulo.setText(temporada.getTitulo());

	}
}
