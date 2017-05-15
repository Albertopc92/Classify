package classify.excepciones;

public class NotaNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NotaNoValidaException(String msg) {
		super(msg);
	}

}
