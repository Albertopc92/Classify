package classify;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classify.excepciones.TituloNoValidoException;

public class Capitulo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private int numVisualizaciones;
	private boolean visualizado;
	private int IDCapitulo;
	private static int incID = 1;

	public Capitulo(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
		setIDCapitulo(incID++);
	}
	
	public Capitulo(int iDCapitulo) {
		setIDCapitulo(iDCapitulo);
	}

	private int getIDCapitulo() {
		return IDCapitulo;
	}

	private void setIDCapitulo(int IDCapitulo) {
		this.IDCapitulo = IDCapitulo;
	}

	private String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = Patron.PATRON_TITULO.matcher(titulo);
		
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		this.titulo = titulo;
	}

	private int getNumVisualizaciones() {
		return numVisualizaciones;
	}

	private void setNumVisualizaciones(int numVisualizaciones) {
		this.numVisualizaciones = numVisualizaciones;
	}

	private boolean isVisualizado() {
		return visualizado;
	}

	private void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}
	
	/**
	 * Visualiza un capitulo
	 */
	public void visualizar() {
		setNumVisualizaciones(getNumVisualizaciones() + 1);
		setVisualizado(true);
	}
	
	/**
	 * Marca como visualizado un capitulo
	 */
	public void marcarVisualizado() {
		if(isVisualizado())
			setVisualizado(true);
	}

	@Override
	public String toString() {
		return "Capitulo [Titulo=" + getTitulo() + ", Visualizaciones()=" + getNumVisualizaciones() + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDCapitulo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capitulo other = (Capitulo) obj;
		if (IDCapitulo != other.IDCapitulo)
			return false;
		return true;
	}

}
