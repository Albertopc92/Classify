package classify.envoltorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import classify.Capitulo;
import classify.Patron;
import classify.excepciones.ListaVaciaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.YaExisteException;

/**
 * Clase que gestiona las temporadas de las series
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Temporada implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Capitulo> temporada;
	private String titulo;
	private int IDTemporada;
	private static int incID = 1;
	
	/**
	 * Comstructor temporadas por titulo
	 * @param titulo
	 * 				Titulo de la temporada
	 * @throws TituloNoValidoException
	 * 				Se lanza cuando el titulo no es valido
	 */
	public Temporada(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
		this.temporada = new ArrayList<Capitulo>();
		setIDTemporada(incID++);
	}
	
	/**
	 * Constructor de temporadas por ID
	 * @param iDTemporada
	 * 				ID de la temporada
	 */
	public Temporada(int IDTemporada) {
		setIDTemporada(IDTemporada);
	}

	/**
	 * Obtiene el ID de la temporada
	 * @return
	 * 			ID de la temporada
	 */
	public int getIDTemporada() {
		return IDTemporada;
	}

	private void setIDTemporada(int iDTemporada) {
		this.IDTemporada = iDTemporada;
	}
	
	/**
	 * Devuelve el titulo de la temporada
	 * @return
	 * 			Titulo de la temporada
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Establece el titulo de la temporada
	 * @param titulo
	 * 				Titulo de la temporada
	 * @throws TituloNoValidoException
	 * 				Se lanza cuando el titulo no es valido
	 */
	public void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = Patron.PATRON_TITULO.matcher(titulo);
		
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		this.titulo = titulo;
	}
	
	/**
	 * Devuelve el numero de capitulos de la temporada
	 * @return
	 * 			Numero de capitulos de la temporada
	 */
	public int getNumCapitulos() {
		return temporada.size();
	}
	
	
	/**
	 * Da de alta un capitulo
	 * @param titulo
	 * 				Titulo del capitulo
	 * @throws TituloNoValidoException
	 * 				Se lanza cuando el titulo no es valido
	 * @throws CapituloYaExisteException
	 * 				Se lanza cuando el capitulo ya existe
	 */
	public boolean altaCapitulo(String titulo) throws YaExisteException, TituloNoValidoException{
		Capitulo capitulo = new Capitulo(titulo);
		if(!temporada.contains(capitulo)) {
			temporada.add(capitulo);
			capitulo.setModificado(true);
			return true;
		}else {
			throw new YaExisteException("El capitulo ya existe.");
		}
	}
	
	/**
	 * De de baja un capitulo
	 * @param IDCapitulo
	 * 			ID del capitulo
	 */
	public void bajaCapitulo(int IDCapitulo) {
		Capitulo capitulo = new Capitulo(IDCapitulo);
		if(temporada.contains(capitulo)) {
			temporada.remove(capitulo);
			capitulo.setModificado(true);
		}
	}
	
	/**
	 * Devuelve los capitulos de la temporada
	 * @return
	 * 			Capitulos de la temporada
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la temporada no tiene capitulos
	 */
	public ArrayList<Capitulo> listarCapitulos() throws ListaVaciaException {
		if(temporada.isEmpty())
			throw new ListaVaciaException("La temporada no contiene capitulos.");
		ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
		for (Capitulo capitulo : temporada) {
			capitulos.add(capitulo);
		}
		
		return capitulos;
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
		Temporada other = (Temporada) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}
}
