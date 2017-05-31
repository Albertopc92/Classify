package classify;

import java.util.regex.Pattern;

/**
 * Clase para comprobar patrones
 * @author alber
 *
 */
public class Patron {
	
	/**
	 * Patron para comprobar si un titulo es valido
	 */
	public static final Pattern PATRON_TITULO = Pattern.compile("^[^\\!\\\"\\$\\%\\&\\/\\\\\\(\\)\\=\\;\\:\\-\\_\\*][0-9A-z\\s].+");
	/**
	 * Patron que comprueba que un campo esta vacio
	 */
	public static final Pattern PATRON_NO_BLANCO = Pattern.compile("[A-z\\s]+");

}
