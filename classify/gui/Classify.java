package classify.gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.enumeraciones.PremioSerie;
import classify.envoltorios.Videoteca;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;
import classify.excepciones.YaExisteException;
import classify.jerarquia.Multimedia;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Classify {

	private JFrame frmClassify;
	private JTextField textField_Buscar;
	private PrincipalPeliculas principalPeliculas;
	private PrincipalSeries principalSeries;
	static Videoteca videoteca = new Videoteca();
	private FichaTecnica fichaTecnica;

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
		generarPeliculas();
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
		
		// BUSCAR Revisar falla al buscar con un titulo que no existe //TODO
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = textField_Buscar.getText();
				try {
					mostrarFichaTecnica(videoteca.buscar(titulo));
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "No se ha podido encontrar el elemento: " + exception.getMessage(),"No se ha podido encontrar", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
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
	
	/**
	 * Muestra la ficha tecnica del elemento seleccionado
	 */
	private void mostrarFichaTecnica(Multimedia multimedia) {
		fichaTecnica = new FichaTecnica(multimedia);
		fichaTecnica.setVisible(true);
	}
	
	private void generarPeliculas() {
		try {
			videoteca.altaPelicula("Titanic", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 7.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("Piratas del caribe", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 4.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("300", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("El se�or de los anillos", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 9.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("El hobbit", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 1.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("Una mente maravillosa", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 10.0f, PremioPelicula.BAFTA);
			videoteca.altaSerie("Juego de tronos", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.FANTASIA, "sinopsis", 9f, false, PremioSerie.GLOBO_DE_ORO);
			videoteca.altaSerie("Breaking bad", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 10f, false, PremioSerie.GLOBO_DE_ORO);
			videoteca.altaSerie("Prison break", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 8f, true, PremioSerie.GLOBO_DE_ORO);
			videoteca.altaSerie("Los Simpsons", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.COMEDIA, "sinopsis", 7f, false, PremioSerie.GLOBO_DE_ORO);
			videoteca.altaSerie("Perdidos", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 5f, false, PremioSerie.GLOBO_DE_ORO);
		} catch (YaExisteException | TituloNoValidoException | DuracionNoValidaException | NotaNoValidaException
				| ValorNoValidoException e) {
			e.printStackTrace();
		}
	}
}
