package classify;

import java.util.regex.Pattern;

public class Patron {
	
	public static final Pattern PATRON_TITULO = Pattern.compile("^[^\\!\\\"\\$\\%\\&\\/\\\\\\(\\)\\=\\;\\:\\-\\_\\*][0-9A-z\\s].+");
	public static final Pattern PATRON_NO_BLANCO = Pattern.compile("[A-z\\s]+");

}
