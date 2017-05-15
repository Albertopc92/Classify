package classify.gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import classify.envoltorios.Videoteca;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Classify {

	private JFrame frmClassify;
	private JTextField textField_Buscar;
	private PrincipalPeliculas principalPeliculas;
	private PrincipalSeries principalSeries;
	static Videoteca videoteca = new Videoteca();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classify window = new Classify();
					window.frmClassify.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Classify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClassify = new JFrame();
		frmClassify.setIconImage(Toolkit.getDefaultToolkit().getImage(Classify.class.getResource("/classify/gui/recursos/icon.png")));
		frmClassify.setTitle("Classify");
		frmClassify.setBounds(100, 100, 450, 300);
		frmClassify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClassify.getContentPane().setLayout(null);

		JButton btnSeries = new JButton("Series");
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principalSeries = new PrincipalSeries();
				principalSeries.setVisible(true);
			}
		});
		btnSeries.setBounds(55, 75, 130, 80);
		frmClassify.getContentPane().add(btnSeries);
		// Icono boton series
		try {
			Image imgSeries = ImageIO.read(getClass().getResource("recursos\\serie.png"));
			btnSeries.setIcon(new ImageIcon(imgSeries));
		} catch (Exception es) {
			System.out.println(es);
		}

		JButton btnPeliculas = new JButton("Pel\u00edculas");
		btnPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principalPeliculas = new PrincipalPeliculas();
				principalPeliculas.setVisible(true);
			}
		});
		btnPeliculas.setBounds(238, 75, 130, 80);
		frmClassify.getContentPane().add(btnPeliculas);
		// Icono boton pelicula
		try {
			Image imgPeliculas = ImageIO.read(getClass().getResource("recursos\\pelicula.png"));
			btnPeliculas.setIcon(new ImageIcon(imgPeliculas));
		} catch (Exception ep) {
			System.err.println("No se encuenta el recurso");
		}

		textField_Buscar = new JTextField();
		textField_Buscar.setBounds(139, 210, 138, 20);
		frmClassify.getContentPane().add(textField_Buscar);
		textField_Buscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(291, 209, 89, 23);
		frmClassify.getContentPane().add(btnBuscar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frmClassify.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmSobreClassify = new JMenuItem("Sobre Classify...");
		mnAyuda.add(mntmSobreClassify);
	}
}
