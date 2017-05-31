package classify;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;

import classify.excepciones.TituloNoValidoException;
/**
 * Clase que gestiona los capitulos
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Capitulo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private int numVisualizaciones;
	private boolean visualizado;
	private LocalDate ultimaVisualizacion;
	private int IDCapitulo;
	private static int incID = 1;
	private boolean modificado;

	/**
	 * Constructor que incializa los valores de los capitulos
	 * @param titulo
	 * @throws TituloNoValidoException
	 */
	public Capitulo(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
		setIDCapitulo(incID++);
	}
	
	/**
	 * Constructor por ID
	 * @param IDCapitulo
	 */
	public Capitulo(int IDCapitulo) {
		setIDCapitulo(IDCapitulo);
	}
	
	/**
	 * Obtiene el ID del capitulo
	 * @return
	 */
	public int getIDCapitulo() {
		return IDCapitulo;
	}
	
	/**
	 * Establece el id del Capitulo
	 * @param IDCapitulo
	 */
	private void setIDCapitulo(int IDCapitulo) {
		this.IDCapitulo = IDCapitulo;
	}
	
	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}


	/**
	 * Obtiene el titulo del capitulo
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Establece el titulo del capitulo
	 * @param titulo
	 * @throws TituloNoValidoException
	 */
	public void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = Patron.PATRON_TITULO.matcher(titulo);
		
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		this.titulo = titulo;
	}
	
	/**
	 * Obtiene el numero de veces que se ha visualizado
	 * @return
	 */
	public int getNumVisualizaciones() {
		return numVisualizaciones;
	}
	
	/**
	 * Establece las visualizaciones del capitulo
	 * @param numVisualizaciones
	 */
	private void setNumVisualizaciones(int numVisualizaciones) {
		this.numVisualizaciones = numVisualizaciones;
	}
	
	/**
	 * Comprueba si se ha visualizado
	 * @return
	 */
	public boolean isVisualizado() {
		return visualizado;
	}
	
	/**
	 * Se establece el estado de visualizado
	 * @param visualizado
	 */
	private void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}
	
	/**
	 * Obtiene la fecha de ultima visualizacion
	 * @return the ultimaVisualizacion
	 */
	public LocalDate getUltimaVisualizacion() {
		return ultimaVisualizacion;
	}

	/**
	 * Establece la fecha de la ultima visualizacion
	 * @param ultimaVisualizacion
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
