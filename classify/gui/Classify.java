package classify.gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import classify.ficheros.Fichero;
import classify.ficheros.Filtro;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.InputEvent;

public class Classify {

	private JFrame frmClassify;
	private JTextField textField_Buscar;
	private PrincipalPeliculas principalPeliculas;
	private PrincipalSeries principalSeries;
	static Videoteca videoteca = new Videoteca();
	private FichaTecnica fichaTecnica;
	private static JFileChooser fileChooser;
	private static Filtro filtro = new Filtro(".obj", "Objeto Videoteca");
	static {
		fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false); // No permito el uso del filtro "Todos los archivos"
		fileChooser.addChoosableFileFilter(filtro); // Permito el uso del filtro 
	}

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
		generar();
		frmClassify = new JFrame();
		frmClassify.setIconImage(Toolkit.getDefaultToolkit().getImage(Classify.class.getResource("/classify/gui/recursos/icon.png")));
		frmClassify.setTitle("Classify - ");
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
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		// NUEVO
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrir();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al abrir fichero: " + e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('H');
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
	
	/**
	 * Crea una nueva videoteca
	 */
	private void crearNuevaVideoteca() {
		String titulo = JOptionPane.showInputDialog(null, "Introduce el nombre del nuevo concesionario", "Nombre del Concesionario", JOptionPane.QUESTION_MESSAGE);
		Fichero.setFichero(titulo);
		videoteca = new Videoteca();
		frmClassify.setTitle(Fichero.fichero.getName());
		videoteca.setModificado(false);
	}
	
	/**
	 * Nueva videoteca
	 */
	private void nuevo() {
		if(videoteca.isModificado()) {
			switch (JOptionPane.showConfirmDialog(null, "No has guardado, ¿Desea Guardar?", "NO HAS GUARDADO",JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				guardarComo();
				crearNuevaVideoteca();
				break;
			case JOptionPane.NO_OPTION:
				crearNuevaVideoteca();
				break;
			default:
				return; //JOptionPane.CANCEL_OPTION
			}
		}else {
			crearNuevaVideoteca();
		}
	}
	
	/**
	 * Guarda con la opcion de Guardar como...
	 */
	private void guardarComo() {
		if(JFileChooser.APPROVE_OPTION == fileChooser.showDialog(fileChooser, "Guardar videoteca")) {
			Fichero.comprobarFichero(fileChooser.getSelectedFile());
			if(Fichero.getFichero().exists()) {
				switch (JOptionPane.showConfirmDialog(null, "El archivo ya existe, ¿Desea Sobreescribir?", "Guardando",JOptionPane.YES_NO_CANCEL_OPTION)) {
				case JOptionPane.YES_OPTION:
					try {
						Fichero.guardarComo(videoteca, Fichero.getFichero());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "El archivo no se ha guardado", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} else {
				guardar();
			}
			
			frmClassify.setTitle(Fichero.getFichero().getName());
			videoteca.setModificado(false);
		}
	}
	
	/**
	 * Guarda un fichero
	 */
	private void guardar() {
		if (Fichero.fichero.getName().equalsIgnoreCase("SinTitulo")) {
			guardarComo();
			videoteca.setModificado(false);
		} else {
			try {
				Fichero.guardar(videoteca);
				videoteca.setModificado(false);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Permite abrir un fichero existente
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void abrir() throws ClassNotFoundException, IOException {
		if(videoteca.isModificado()) {
			switch (JOptionPane.showConfirmDialog(null, "No has guardado, ¿Desea guardar?", "NO HAS GUARDADO",JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				guardarComo();
				break;
			case JOptionPane.NO_OPTION:
				if(fileChooser.showDialog(fileChooser, "Abrir videoteca") == JFileChooser.APPROVE_OPTION) {
					Fichero.fichero = fileChooser.getSelectedFile();
					videoteca = (Videoteca) Fichero.abrir(fileChooser.getSelectedFile());
					frmClassify.setTitle(Fichero.getFichero().getName());
					videoteca.setModificado(false);
				}
			default:
				return;
			}
		}else {
			if(fileChooser.showDialog(fileChooser, "Abrir videoteca") == JFileChooser.APPROVE_OPTION) {
				Fichero.fichero = fileChooser.getSelectedFile();
				videoteca = (Videoteca) Fichero.abrir(fileChooser.getSelectedFile());
				frmClassify.setTitle(Fichero.getFichero().getName());
				videoteca.setModificado(false);
			}
		}
	}
	
	/**
	 * Opcion de salir
	 */
	private void salir() {
		if(videoteca.isModificado()){
			switch (JOptionPane.showConfirmDialog(null, "No has guardado, ¿Desea guardar?", "NO HAS GUARDADO",JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				guardarComo();
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
			default:
				return; // JOptionPane.CANCEL_OPTION
			}
		} else {
			System.exit(0);
		}
	}

	private void generar() {
		try {
			videoteca.altaPelicula("Titanic", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 7.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("Piratas del caribe", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 4.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("300", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("El señor de los anillos", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 9.0f, PremioPelicula.BAFTA);
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
