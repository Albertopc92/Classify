package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.Capitulo;
import classify.envoltorios.Temporada;

public class AnnadirCapitulo extends PlantillaAnnadirTemporadaCapitulo {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 * @param modeloCapitulos 
	 * @param jlistCapitulos 
	 * @param temporada 
	 */
	public AnnadirCapitulo(Temporada temporada, JList<Capitulo> jlistCapitulos, DefaultListModel<Capitulo> modeloCapitulos) {
		setTitle("A\u00f1adir Temporada");
		setBounds(100, 100, 380, 209);
		btnAccion.setText("A\u00f1adir");
		
		// AÑADIR CAPITULO
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					temporada.altaCapitulo(textField_Temporada.getText());
					JOptionPane.showMessageDialog(getContentPane(), "El cap\u00edtulo se a\u00f1adio correctamente.",
							"Temporada a\u00f1adida", JOptionPane.INFORMATION_MESSAGE);
					// Recargar Jlist
					modeloCapitulos.clear();
					jlistCapitulos.setModel(modeloCapitulos);
					for (Capitulo capitulo : temporada.listarCapitulos()) {
						modeloCapitulos.addElement(capitulo);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(),
							"El cap\u00edtulo no se ha podido a\u00f1adir: " + exception.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
