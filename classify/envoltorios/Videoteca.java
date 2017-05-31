package classify.envoltorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import classify.OrdenarPuntuacion;
import classify.OrdenarVisualizaciones;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.enumeraciones.PremioSerie;
import classify.excepciones.YaExisteException;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.ListaVaciaException;
import classify.excepciones.NoExisteException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;
import classify.jerarquia.Multimedia;
import classify.jerarquia.Pelicula;
import classify.jerarquia.Serie;

/**
 * Clase que se encarga de gestionar toda la videoteca
 * @author Alberto Perez Cano
 * @version 1.0
 *
 */
public class Videoteca implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * Contiene todas las peliculas y series de la aplicacion
	 */
	public ArrayList<Multimedia> videoteca;
	private boolean modificado;
	
	/**
	 * Constructor de la videoteca
	 */
	public Videoteca() {
		this.videoteca = new ArrayList<Multimedia>();
	}
	
	/**
	 * Comprueba si la videoteca se ha modificado
	 * @return
	 * 			True si se he modificado
	 * 			False si no se ha modificado
	 */
	public boolean isModificado() {
		return modificado;
	}
	
	/**
	 * Establece el estado de modificado
	 * @param modificado
	 * 			Estado de modificado
	 */
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}
	
	/**
	 * Permite dar de alta una serie
	 * @param titulo
	 * @param tituloOriginal
	 * @param anyo
	 * @param duracion
	 * @param pais
	 * @param director
	 * @param guion
	 * @param musica
	 * @param fotografia
	 * @param reparto
	 * @param productora
	 * @param genero
	 * @param sinopsis
	 * @param notaUsuario
	 * @throws YaExisteException
	 * @throws TituloNoValidoException 
	 * @throws DuracionNoValidaException 
	 * @throws NotaNoValidaException 
	 * @throws ValorNoValidoException 
	 */
	public boolean altaSerie(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografia, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, boolean emitiendo, PremioSerie premios) throws YaExisteException, TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		
		Serie serie = new Serie(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografia, reparto, productora, genero, sinopsis, notaUsuario, emitiendo, premios);
		if(!videoteca.contains(serie)) {
			videoteca.add(serie);
			setModificado(true);
			return true;
		}
		else
			throw new YaExisteException("La serie ya existe.");
	}
	
	/**
	 * Permite dar de alta una pelicula
	 * @param titulo
	 * @param tituloOriginal
	 * @param anyo
	 * @param duracion
	 * @param pais
	 * @param director
	 * @param guion
	 * @param musica
	 * @param fotografia
	 * @param reparto
	 * @param productora
	 * @param genero
	 * @param sinopsis
	 * @param notaUsuario
	 * @param numVisualizaciones
	 * @param premios
	 * @throws TituloNoValidoException 
	 * @throws DuracionNoValidaException 
	 * @throws NotaNoValidaException 
	 * @throws ValorNoValidoException 
	 * @throws PeliculaYaExisteException
	 */
	public boolean altaPelicula(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografia, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, PremioPelicula premios) throws YaExisteException, TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		
		Pelicula pelicula = new Pelicula(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografia, reparto, productora, genero, sinopsis, notaUsuario, premios);
		if(!videoteca.contains(pelicula)) {
			videoteca.add(pelicula);
			setModificado(true);
			return true;
		}else {
			throw new YaExisteException("La pelicula ya existe.");
		}
	}
	
	/**
	 * Permite borrar una pelicula o una serie
	 * @param ID
	 * @param titulo
	 * @return
	 * @throws NoExisteException
	 * @throws ListaVaciaException 
	 * @throws TituloNoValidoException 
	 */
	public boolean borrar(String titulo) throws NoExisteException, ListaVaciaException, TituloNoValidoException{
		isEmpty();
		if(videoteca.remove(new Pelicula(titulo))) {
			setModificado(true);
			return true;
		}
		
		throw new NoExisteException("No existe el elemento.");
		
	}
	
	/**
	 * Devuelve las series de la videoteca
	 * @return
	 * 			Las series de la videoteca
	 * @throws ListaVaciaException
	 * 					Salta la excepcion si videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarSeries(){
		ArrayList<Multimedia> series = new ArrayList<Multimedia>();
		for (Multimedia multimedia : videoteca) {
			if(multimedia instanceof Serie)
				series.add((Serie) multimedia);
		}
		
		return series;
	}
	
	/**
	 * Devuelve las peliculas de la videoteca
	 * @return
	 * 			Las peliculas de la videoteca
	 * @throws ListaVaciaException
	 *  		Si videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarPeliculas() {
		ArrayList<Multimedia> peliculas = new ArrayList<Multimedia>();
		for (Multimedia multimedia : videoteca) {
			if(multimedia instanceof Pelicula)
				peliculas.add((Pelicula) multimedia);
		}
		
		return peliculas;
	}
	
	/**
	 * Busca un elemento multimedia por su nombre
	 * @param titulo
	 * 			Titulo del elemento que se busca
	 * @return
	 * 			Elemento que se ha encontrado
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public Multimedia buscar(String titulo) throws ListaVaciaException, TituloNoValidoException{
		isEmpty();
		for (Multimedia multimedia : videoteca)
			if(multimedia.getTitulo().equals(titulo))
				return multimedia;
		throw new TituloNoValidoException("El titulo no es valido.");
	}
	
	/**
	 * Lista series por genero indicado
	 * @param genero
	 * @return
	 * 			Series del genero indicado
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarSeriesGenero(Genero genero) throws ListaVaciaException {
		isEmpty();
		ArrayList<Multimedia> series = new ArrayList<Multimedia>();
		for (Multimedia serie : videoteca) {
			if(serie instanceof Serie) {
				if(serie.getGenero() == genero)
					series.add(serie);
			}
		}
		
		return series;
	}
	
	/**
	 * Lista las series por puntuacion
	 * @return
	 * 			Series ordendas por puntuacion
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarSeriesPuntuacion() throws ListaVaciaException{
		isEmpty();
		ArrayList<Multimedia> series = new ArrayList<Multimedia>();
		Collections.sort(videoteca, new OrdenarPuntuacion());
		for (Multimedia serie : videoteca) {
			if(serie instanceof Serie)
				series.add(serie);
		}
		
		return series;
	}
	
	/**
	 * Lista peliculas por genero indicado
	 * @param genero
	 * @return
	 * 			Peliculas del genero indicado
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarPeliculasGenero(Genero genero) throws ListaVaciaException {
		isEmpty();
		ArrayList<Multimedia> peliculas = new ArrayList<Multimedia>();
		for (Multimedia pelicula : videoteca) {
			if(pelicula instanceof Pelicula) {
				if(pelicula.getGenero() == genero)
					peliculas.add(pelicula);
			}
		}
		
		return peliculas;
	}
	
	/**
	 * Lista las peliculas por puntuacion
	 * @return
	 * 			Peliculas ordenadas por puntuacion
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public ArrayList<Multimedia> listarPeliculasPuntuacion() throws ListaVaciaException{
		isEmpty();
		ArrayList<Multimedia> peliculas = new ArrayList<Multimedia>();
		Collections.sort(videoteca, new OrdenarPuntuacion());
		for (Multimedia pelicula : videoteca) {
			if(pelicula instanceof Pelicula)
				peliculas.add(pelicula);
		}
		
		return peliculas;
	}
	
	/**
	 * Lista las peliculas por numero de visualizaciones
	 * @return
	 * 			Peliculas ordenadas por numero de visualizaciones
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public ArrayList<Pelicula> listarPeliculasVisualizaciones() throws ListaVaciaException{
		isEmpty();
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Multimedia multimedia : videoteca) {
			if(multimedia instanceof Pelicula)
				peliculas.add((Pelicula) multimedia);
		}
		
		Collections.sort(peliculas, new OrdenarVisualizaciones());
		
		return peliculas;
	}
	
	/**
	 * Marca como visualizado un elemento
	 * @param titulo
	 * 			Titulo del elemento
	 * @throws TituloNoValidoException
	 * 			Se lanza cunado el titulo no es valido
	 */
	public void marcarVisualizado(String titulo) throws TituloNoValidoException{
		Pelicula pelicula = new Pelicula(titulo);
		pelicula.marcarVisualizado();
		setModificado(true);
	}
	
	/**
	 * Comprueba si la lista esta vacia
	 * @throws ListaVaciaException
	 * 			Se lanza cuando la videoteca esta vacia
	 */
	public void isEmpty() throws ListaVaciaException {
		if(videoteca.isEmpty())
			throw new ListaVaciaException("La videoteca esta vac�a.");
	}
}
