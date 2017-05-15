package classify.excepciones;

public class YaExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public YaExisteException(String msg) {
		super(msg);
	}

}
