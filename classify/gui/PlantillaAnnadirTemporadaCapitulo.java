package classify.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlantillaAnnadirTemporadaCapitulo extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextField textField_Temporada;
	JButton btnAccion;
	JButton btnSalir;

	/**
	 * Create the dialog.
	 */
	public PlantillaAnnadirTemporadaCapitulo() {
		setTitle("A\u00f1adir");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaAnnadirTemporadaCapitulo.class.getResource("/classify/gui/recursos/icon.png")));
		setModal(true);
		setBounds(100, 100, 380, 209);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00edtulo");
		lblTitulo.setBounds(42, 50, 46, 14);
		getContentPane().add(lblTitulo);
		
		textField_Temporada = new JTextField();
		textField_Temporada.setBounds(82, 47, 166, 20);
		getContentPane().add(textField_Temporada);
		textField_Temporada.setColumns(10);
		
		btnAccion = new JButton("Accion");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAccion.setBounds(159, 118, 89, 23);
		getContentPane().add(btnAccion);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(258, 118, 89, 23);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

	}
	
	void reset(){
		textField_Temporada.setText("");
	}
}
