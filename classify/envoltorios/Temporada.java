package classify.envoltorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import classify.Capitulo;
import classify.Patron;
import classify.excepciones.ListaVaciaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.YaExisteException;

public class Temporada implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Capitulo> temporada;
	private String titulo;
	private boolean modificado;
	private int IDTemporada;
	private static int incID = 1;
	
	public Temporada(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
		this.temporada = new ArrayList<Capitulo>();
		setIDTemporada(incID++);
	}
	
	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}
	
	public Temporada(int iDTemporada) {
		setIDTemporada(iDTemporada);
	}

	public int getIDTemporada() {
		return IDTemporada;
	}

	private void setIDTemporada(int iDTemporada) {
		this.IDTemporada = iDTemporada;
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

	public int getNumCapitulos() {
		return temporada.size();
	}
	
	
	/**
	 * Da de alta un capitulo
	 * @param titulo
	 * @throws TituloNoValidoException 
	 * @throws CapituloYaExisteException
	 */
	public Capitulo altaCapitulo(String titulo) throws YaExisteException, TituloNoValidoException{
		Capitulo capitulo = new Capitulo(titulo);
		if(!temporada.contains(capitulo)) {
			temporada.add(capitulo);
			setModificado(true);
			return capitulo;
		}
		
		throw new YaExisteException("El capitulo ya existe.");
	}
	
	/**
	 * De de baja un capitulo
	 * @param IDCapitulo
	 */
	public void bajaCapitulo(int IDCapitulo) {
		Capitulo capitulo = new Capitulo(IDCapitulo);
		if(temporada.contains(capitulo)) {
			temporada.remove(capitulo);
			setModificado(true);
		}
	}
	
	/**
	 * Lista todos los capitulos de la temporada
	 * @throws ListaVaciaException
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
		result = prime * result + IDTemporada;
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
		Temporada other = (Temporada) obj;
		if (IDTemporada != other.IDTemporada)
			return false;
		return true;
	}
}
