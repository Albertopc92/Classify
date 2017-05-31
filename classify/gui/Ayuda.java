package classify.gui;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

/**
 * Clase que se encarga de mostra la ayuda de la aplicacion
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Ayuda extends JDialog {

	private static final long serialVersionUID = 1L;

	JScrollPane jsp;
	JEditorPane jep;

	/**
	 * Crea la ventana de ayuda
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/classify/gui/recursos/icon.png")));
		setBounds(100, 100, 665, 765);
		getContentPane().setLayout(null);
		
		jep = new JEditorPane();
		jep.setContentType("text/html");
		jep.setEditable(false);
		jep.setText("<h1>Ayuda Classify</h1><br>"
				+ "Classify es una aplicación en la que podrás gestionar toda tu biblioteca de series y películas. Se facilitará un archivo videoteca.obj en el cuál habrá datos precargados para poder realizar una demo de la aplicación.<br>"
				+ "<h2>Ventana principal</h2>"
				+ "En la ventana principal se encontrarán 2 botones para acceder tanto a la zona de series como de películas. Además se proporciona un buscador en el cuál se podrán buscar las series y las pelíclas y se presentará la ficha técnica del elemento buscado.<br>"
				+ "<h2>Películas</h2>"
				+ "En la sección películas podemos encontrar una serie de botones que podemos usar para interactuar con la aplicación: <ul><li>Ver la Ficha Técnica<li>Añadir<li>Borrar<li>Modificar<li>Marcar como visualizada<li>Listar por género<li>Listar por puntuación<li>Listar por visualizaciones<li>visualizar<li>Información</ul>El boton de información podremos ver el numero de veces que hemos visualizado cada película, así como cuando fué la fecha de la ultima visualización, y un checkbox que nos indica si esa pelicula ha sido o no visualizada alguna vez."
				+ "Para poder realizar cualquier acción es necesario que se seleccione previamente la película deseada."
				+ "<h2>Series</h2>"
				+ "En la sección series podemos encontrar una selección de botones similares a la de la sección de películas: <ul><li>Ver Ficha Técnica<li>Añadir<li>Borrar<li>Modificar<li>Listar por género<li>Listar por puntuación<li>Temporadas</ul> Con el botón temporadas podremos pasar a la sección de temporadas de la serie que hayamos seleccionado previamente."
				+ "<h3>Temporadas</h3>"
				+ "En la sección temporadas podemos gestionar las temporadas de nuestras series, en esta ventana podremos: <ul><li>Añadir temporada<li>Borrar Temporada<li>Modificar Temporada<li>Capitulos</ul>Con el botón Capitulos podremos pasar a la sección de capitulos de la serie que hayamos seleccionado previamente."
				+ "<h3>Capítulos</h3>"
				+ "En la sección de Capítulos podemos encontrar unos botones en los que podemos gestionar los capítulos de la temporada seleccionada. En esta ventana podremos: <ul><li>Visualizar<li>Información<li>Añadir Capítulo<li>Borrar Capítulo<li>Modificar Capítulo<li>Marcar como visualizado.");
		jsp = new JScrollPane(jep, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setContentPane(jsp);
		
		
	}
}
