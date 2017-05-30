package classify.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioSerie;
import classify.jerarquia.Multimedia;

public class ModificarSerie extends PlantillaAnnadir {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the dialog.
	 */
	public ModificarSerie(JList<Multimedia> jlist, DefaultListModel<Multimedia> modelo, Multimedia multimedia) {
		setTitle("Modificar Serie: " + multimedia.getTitulo());
		setBounds(100, 100, 720, 788);
		comboBox_premio.setModel(new DefaultComboBoxModel<PremioSerie>(PremioSerie.values()));
		textField_titulo.setText(multimedia.getTitulo());
		textField_tituloOriginal.setText(multimedia.getTituloOriginal());
		comboBox_anno.setSelectedItem(multimedia.getAnyo());
		textField_duracion.setText(Integer.toString(multimedia.getDuracion()));
		textField_pais.setText(multimedia.getPais());
		textField_director.setText(multimedia.getDirector());
		textField_guion.setText(multimedia.getGuion());
		textField_musica.setText(multimedia.getMusica());
		textField_fotografia.setText(multimedia.getFotografia());
		textField_productora.setText(multimedia.getProductora());
		textArea_sinopsis.setText(multimedia.getSinopsis());
		comboBox_genero.setSelectedItem(multimedia.getGenero());
		//comboBox_premio.setSelectedItem(); TODO
		//checkbox.setState(); TODO
		textField_notaUsuario.setText(Float.toString(multimedia.getNotaUsuario()));
		textField_puntuacion.setText(Float.toString(multimedia.puntuable()));
		//textField_principales.setText(); TODO
		//textField_secundarioss.setText(); TODO
		
		btnAccion.setText("Modificar");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					multimedia.setTitulo(textField_titulo.getText());
					multimedia.setTituloOriginal(textField_tituloOriginal.getText());
					multimedia.setAnyo((int)comboBox_anno.getSelectedItem());
					multimedia.setDuracion((int)(Integer.parseInt(textField_duracion.getText())));
					multimedia.setPais(textField_pais.getText());
					multimedia.setDirector(textField_director.getText());
					multimedia.setGuion(textField_guion.getText());
					multimedia.setMusica(textField_musica.getText());
					multimedia.setFotografia(textField_fotografia.getText());
					//multimedia.setReparto(reparto); //TODO
					multimedia.setProductora(textField_productora.getText());
					multimedia.setGenero((Genero)comboBox_genero.getSelectedItem());
					multimedia.setSinopsis(textArea_sinopsis.getText());
					multimedia.setNotaUsuario((float)(Float.parseFloat(textField_notaUsuario.getText())));
					//PREMIO TODO
					
					JOptionPane.showMessageDialog(getContentPane(), "La serie se ha modificado correctamente.","Serie modificada", JOptionPane.INFORMATION_MESSAGE);
					jlist.setModel(modelo);
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(), "La serie no se ha podido modificar: " + exception.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
