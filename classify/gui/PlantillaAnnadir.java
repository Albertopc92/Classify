package classify.gui;

import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.envoltorios.Videoteca;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Checkbox;

public class PlantillaAnnadir extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextField textField_titulo;
	JTextField textField_tituloOriginal;
	JTextField textField_duracion;
	JTextField textField_pais;
	JTextField textField_director;
	JTextField textField_guion;
	JTextField textField_musica;
	JTextField textField_fotografia;
	JTextField textField_productora;
	JTextField textField_notaUsuario;
	JTextField textField_puntuacion;
	JTextField textField_principales;
	JTextField textField_secundarios;
	JScrollPane scroll; //TODO
	JComboBox<Integer> comboBox_anno;
	JButton btnAccion;
	Videoteca videoteca = Classify.videoteca;
	JComboBox<Genero> comboBox_genero;
	JTextArea textArea_sinopsis;
	JComboBox<Object> comboBox_premioPrincipal;
	Checkbox checkbox;
	JLabel lblPuntuacin;
	


	/**
	 * Create the dialog.
	 */
	public PlantillaAnnadir() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlantillaAnnadir.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 720, 788);
		getContentPane().setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00edtulo");
		lblTtulo.setBounds(53, 54, 46, 14);
		getContentPane().add(lblTtulo);
		
		textField_titulo = new JTextField();
		textField_titulo.setBounds(131, 51, 160, 20);
		getContentPane().add(textField_titulo);
		textField_titulo.setColumns(10);
		
		JLabel lblTtuloOriginal = new JLabel("T\u00edtulo original");
		lblTtuloOriginal.setBounds(53, 85, 76, 14);
		getContentPane().add(lblTtuloOriginal);
		
		textField_tituloOriginal = new JTextField();
		textField_tituloOriginal.setBounds(131, 82, 160, 20);
		getContentPane().add(textField_tituloOriginal);
		textField_tituloOriginal.setColumns(10);
		
		JLabel lblAnno = new JLabel("A\u00f1o");
		lblAnno.setBounds(53, 121, 46, 14);
		getContentPane().add(lblAnno);
		
		comboBox_anno = new JComboBox<Integer>();
		Integer anyo = LocalDate.now().getYear();
		Vector<Integer> anyos = new Vector<Integer>();
		for(int i = 1895; i <= anyo; i++)
			anyos.add(i);
		comboBox_anno.setModel(new DefaultComboBoxModel<Integer>(anyos));
		comboBox_anno.setSelectedIndex(-1);
		comboBox_anno.setBounds(131, 118, 76, 20);
		getContentPane().add(comboBox_anno);
		
		textField_duracion = new JTextField();
		textField_duracion.setBounds(128, 149, 46, 20);
		getContentPane().add(textField_duracion);
		textField_duracion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duraci\u00f3n");
		lblDuracion.setBounds(53, 152, 65, 14);
		getContentPane().add(lblDuracion);
		
		textField_pais = new JTextField();
		textField_pais.setBounds(128, 180, 163, 20);
		getContentPane().add(textField_pais);
		textField_pais.setColumns(10);
		
		JLabel lblPais = new JLabel("Pa\u00eds");
		lblPais.setBounds(53, 183, 46, 14);
		getContentPane().add(lblPais);
		
		textField_director = new JTextField();
		textField_director.setBounds(128, 211, 163, 20);
		getContentPane().add(textField_director);
		textField_director.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(53, 214, 46, 14);
		getContentPane().add(lblDirector);
		
		textField_guion = new JTextField();
		textField_guion.setBounds(128, 242, 163, 20);
		getContentPane().add(textField_guion);
		textField_guion.setColumns(10);
		
		JLabel lblGuion = new JLabel("Gui\u00f3n");
		lblGuion.setBounds(53, 245, 46, 14);
		getContentPane().add(lblGuion);
		
		textField_musica = new JTextField();
		textField_musica.setBounds(128, 273, 163, 20);
		getContentPane().add(textField_musica);
		textField_musica.setColumns(10);
		
		JLabel lblMusica = new JLabel("M\u00fasica");
		lblMusica.setBounds(53, 276, 46, 14);
		getContentPane().add(lblMusica);
		
		textField_fotografia = new JTextField();
		textField_fotografia.setBounds(128, 304, 163, 20);
		getContentPane().add(textField_fotografia);
		textField_fotografia.setColumns(10);
		
		JLabel lblFotografia = new JLabel("Fotograf\u00eda");
		lblFotografia.setBounds(53, 307, 65, 14);
		getContentPane().add(lblFotografia);
		
		textField_productora = new JTextField();
		textField_productora.setBounds(128, 335, 163, 20);
		getContentPane().add(textField_productora);
		textField_productora.setColumns(10);
		
		JLabel lblProductora = new JLabel("Productora");
		lblProductora.setBounds(53, 338, 65, 14);
		getContentPane().add(lblProductora);
		
		JLabel lblGenero = new JLabel("G\u00e9nero");
		lblGenero.setBounds(362, 85, 46, 14);
		getContentPane().add(lblGenero);
		
		comboBox_genero = new JComboBox<Genero>();
		comboBox_genero.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		comboBox_genero.setSelectedIndex(-1);
		comboBox_genero.setBounds(439, 82, 121, 20);
		getContentPane().add(comboBox_genero);
		
		// TODO
		
		textArea_sinopsis = new JTextArea();
		//scroll = new JScrollPane(textArea_sinopsis, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea_sinopsis.setBounds(128, 395, 486, 230);
		getContentPane().add(textArea_sinopsis);
		//getContentPane().add(scroll);

		
		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(53, 395, 65, 14);
		getContentPane().add(lblSinopsis);
		
		JLabel lblPremio = new JLabel("Premio");
		lblPremio.setBounds(362, 121, 46, 14);
		getContentPane().add(lblPremio);
		
		comboBox_premioPrincipal = new JComboBox<Object>();
		comboBox_premioPrincipal.setBounds(439, 118, 121, 20);
		comboBox_premioPrincipal.setSelectedIndex(-1);
		getContentPane().add(comboBox_premioPrincipal);
		
		textField_notaUsuario = new JTextField();
		textField_notaUsuario.setBounds(439, 149, 39, 20);
		getContentPane().add(textField_notaUsuario);
		textField_notaUsuario.setColumns(10);
		
		JLabel lblNotaUsuario = new JLabel("Nota Usuario");
		lblNotaUsuario.setBounds(362, 152, 76, 14);
		getContentPane().add(lblNotaUsuario);
		
		lblPuntuacin = new JLabel("Puntuaci\u00f3n");
		lblPuntuacin.setBounds(362, 183, 76, 14);
		getContentPane().add(lblPuntuacin);
		
		textField_puntuacion = new JTextField();
		textField_puntuacion.setEditable(false);
		textField_puntuacion.setBounds(439, 180, 39, 20);
		getContentPane().add(textField_puntuacion);
		textField_puntuacion.setColumns(10);
		
		JLabel lblReparto = new JLabel("Reparto");
		lblReparto.setBounds(439, 245, 46, 14);
		getContentPane().add(lblReparto);
		
		JLabel lblPrincipales = new JLabel("Principales");
		lblPrincipales.setBounds(362, 276, 76, 14);
		getContentPane().add(lblPrincipales);
		
		textField_principales = new JTextField();
		textField_principales.setBounds(439, 273, 121, 20);
		getContentPane().add(textField_principales);
		textField_principales.setColumns(10);
		
		textField_secundarios = new JTextField();
		textField_secundarios.setBounds(439, 304, 121, 20);
		getContentPane().add(textField_secundarios);
		textField_secundarios.setColumns(10);
		
		JLabel lblSecundarios = new JLabel("Secundarios");
		lblSecundarios.setBounds(362, 307, 76, 14);
		getContentPane().add(lblSecundarios);
		
		btnAccion = new JButton("Acci\u00f3n");
		btnAccion.setBounds(421, 684, 89, 23);
		getContentPane().add(btnAccion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(532, 684, 89, 23);
		getContentPane().add(btnSalir);
		
		checkbox = new Checkbox("Emitiendo");
		checkbox.setBounds(439, 51, 95, 22);
		getContentPane().add(checkbox);
		
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setBounds(184, 152, 46, 14);
		getContentPane().add(lblMinutos);

	}
	
	/**
	 * Resetea los campos
	 */
	void reset() {
		textField_titulo.setText("");
		textField_tituloOriginal.setText(""); 
		comboBox_anno.setSelectedIndex(-1);
		textField_duracion.setText("");
		textField_pais.setText("");
		textField_director.setText(""); 
		textField_guion.setText("");
		textField_musica.setText(""); 
		textField_fotografia.setText(""); 
		textField_principales.setText("");
		textField_secundarios.setText("");
		textField_productora.setText(""); 
		comboBox_genero.setSelectedIndex(-1);
		comboBox_premioPrincipal.setSelectedIndex(-1);
		textArea_sinopsis.setText(""); 
		textField_notaUsuario.setText("");
		comboBox_premioPrincipal.setSelectedItem(-1);
	}
}
