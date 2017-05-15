package classify.excepciones;

public class NoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoExisteException(String msg) {
		super(msg);
	}

}
