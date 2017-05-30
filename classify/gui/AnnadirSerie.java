package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioSerie;
import classify.jerarquia.Multimedia;

public class AnnadirSerie extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AnnadirSerie(JList<Multimedia> jlist, DefaultListModel<Multimedia> modelo) {
		setTitle("A\u00f1adir Serie");
		setBounds(100, 100, 720, 788);
		// TODO combobox premio
		comboBox_premio.setModel(new DefaultComboBoxModel<PremioSerie>(PremioSerie.values()));
		comboBox_premio.setSelectedIndex(-1);
		textField_puntuacion.setVisible(false);
		lblPuntuacin.setVisible(false);
		btnAccion.setText("A\u00f1adir");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(videoteca.altaSerie(textField_titulo.getText(),
										textField_tituloOriginal.getText(),
										(int)comboBox_anno.getSelectedItem(),
										(int)(Integer.parseInt(textField_duracion.getText())),
										textField_pais.getText(),
										textField_director.getText(),
										textField_guion.getText(),
										textField_musica.getText(),
										textField_fotografia.getText(),
										new String[][] {{textField_principales.getText()},{textField_secundarios.getText()}},
										textField_productora.getText(),
										(Genero)comboBox_genero.getSelectedItem(), 
										textArea_sinopsis.getText(),
										(float)(Float.parseFloat(textField_notaUsuario.getText())),
										checkbox.getState(),
										(PremioSerie)comboBox_premio.getSelectedItem()));
										
				{
					
					JOptionPane.showMessageDialog(getContentPane(), "La Serie se a\u00f1adio correctamente.","Serie a\u00f1adida", JOptionPane.INFORMATION_MESSAGE);
					// Recargar Jlist
					modelo.clear();
					jlist.setModel(modelo);
					for (Multimedia multimedia : videoteca.listarSeries()) {
						modelo.addElement(multimedia);
					}
					reset();
				}
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La Serie no se ha podido a\u00f1adir: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
