package classify.gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import classify.jerarquia.Multimedia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalSeries extends PlantillaPrincipal {

	private static final long serialVersionUID = 1L;
	private ArrayList<Multimedia> series;
	private AnnadirSerie annadirSerie;

	/**
	 * Create the dialog.
	 */
	public PrincipalSeries() {
		setTitle("Series");
		setModal(true);
		setBounds(100, 100, 720, 788);
		
		series = videoteca.listarSeries();
		modelo = new DefaultListModel<Multimedia>();
		for (Multimedia multimedia : series) {
			modelo.addElement(multimedia);
		}
		
		jlist = new JList<Multimedia>(modelo);
		jlist.setBounds(287, 71, 380, 579);
		getContentPane().add(jlist);
		
		btnAnnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirSerie = new AnnadirSerie(jlist, modelo);
				annadirSerie.setVisible(true);
			}
		});
		
	}

}
