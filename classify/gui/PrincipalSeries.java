package classify.gui;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class PrincipalSeries extends PlantillaPrincipal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalSeries dialog = new PrincipalSeries();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PrincipalSeries() {
		setTitle("Series");
		setModal(true);
		setBounds(100, 100, 720, 788);

	}

}
