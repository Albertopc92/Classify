package classify;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;

import classify.excepciones.TituloNoValidoException;

public class Capitulo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private int numVisualizaciones;
	private boolean visualizado;
	private LocalDate ultimaVisualizacion;
	private int IDCapitulo;
	private static int incID = 1;
	private boolean modificado;


	public Capitulo(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
		setIDCapitulo(incID++);
	}
	
	public Capitulo(int IDCapitulo) {
		setIDCapitulo(IDCapitulo);
	}

	public int getIDCapitulo() {
		return IDCapitulo;
	}
	
	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	private void setIDCapitulo(int IDCapitulo) {
		this.IDCapitulo = IDCapitulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = Patron.PATRON_TITULO.matcher(titulo);
		
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		this.titulo = titulo;
	}

	public int getNumVisualizaciones() {
		return numVisualizaciones;
	}

	private void setNumVisualizaciones(int numVisualizaciones) {
		this.numVisualizaciones = numVisualizaciones;
	}

	public boolean isVisualizado() {
		return visualizado;
	}

	private void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}
	
	/**
	 * @return the ultimaVisualizacion
	 */
	public LocalDate getUltimaVisualizacion() {
		return ultimaVisualizacion;
	}

	/**
	 * @param ultimaVisualizacion the ultimaVisualizacion to set
	 */
	public void setUltimaVisualizacion(LocalDate ultimaVisualizacion) {
		this.ultimaVisualizacion = ultimaVisualizacion;
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
		if(!isVisualizado())
			setVisualizado(true);
	}

	@Override
	public String toString() {
		return getTitulo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}

}
