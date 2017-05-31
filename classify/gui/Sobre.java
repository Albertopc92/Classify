package classify.gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Vetana Sobre la aplicacion
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea la ventana
	 */
	public Sobre() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/classify/gui/recursos/icon.png")));
		setTitle("Sobre Classify");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextArea txtrClassifyVersin = new JTextArea();
		txtrClassifyVersin.setText("\t\r\n\tClassify\r\n\tVersión 1.0\r\n\r\n\tRealizado por: Alberto Pérez Cano");
		txtrClassifyVersin.setBounds(10, 11, 424, 197);
		getContentPane().add(txtrClassifyVersin);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAceptar.setBounds(345, 237, 89, 23);
		getContentPane().add(btnAceptar);

	}
}
