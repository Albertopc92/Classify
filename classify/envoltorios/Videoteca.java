package classify.envoltorios;

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

public class Videoteca {
	
	public ArrayList<Multimedia> videoteca;
	
	public Videoteca() {
		this.videoteca = new ArrayList<Multimedia>();
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
			//return serie;
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
			return true;
		}
		
		throw new NoExisteException("No existe el elemento.");
		
	}
	
	/**
	 * Lista las series
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
	 * Lista las peliculas
	 * @throws ListaVaciaException
	 *  					Si videoteca esta vacia
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
	 * @return
	 * @throws ListaVaciaException 
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
	 * @throws ListaVaciaException 
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
	 * @throws ListaVaciaException 
	 */
	public void listarSeriesPuntuacion() throws ListaVaciaException{
		isEmpty();
		Collections.sort(videoteca, new OrdenarPuntuacion());
		for (Multimedia serie : videoteca) {
			if(serie instanceof Serie)
				System.out.println(serie);
		}
	}
	
	/**
	 * Lista peliculas por genero indicado
	 * @param genero
	 * @throws ListaVaciaException 
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
	 * @throws ListaVaciaException 
	 */
	public void listarPeliculasPuntuacion() throws ListaVaciaException{
		isEmpty();
		Collections.sort(videoteca, new OrdenarPuntuacion());
		for (Multimedia pelicula : videoteca) {
			if(pelicula instanceof Pelicula)
				System.out.println(pelicula);
		}
	}
	
	/**
	 * Lista las peliculas por numero de visualizaciones
	 * @throws ListaVaciaException 
	 */
	public void listarPeliculasVisualizaciones() throws ListaVaciaException{
		isEmpty();
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Multimedia multimedia : videoteca) {
			if(multimedia instanceof Pelicula)
				peliculas.add((Pelicula) multimedia);
		}
		
		Collections.sort(peliculas, new OrdenarVisualizaciones());
		for (Multimedia pelicula : videoteca) {
			if(pelicula instanceof Pelicula)
				System.out.println(pelicula);
		}
	}
	
	//TODO
	public void marcarVisualizado(String titulo) throws TituloNoValidoException{
		Pelicula pelicula = new Pelicula(titulo);
		pelicula.marcarVisualizado();
	}
	
	/**
	 * Comprueba si la lista esta vacia
	 * @throws ListaVaciaException
	 */
	public void isEmpty() throws ListaVaciaException {
		if(videoteca.isEmpty())
			throw new ListaVaciaException("La videoteca esta vac�a.");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void listarTodo() throws ListaVaciaException {
		isEmpty();
		for (Multimedia multimedia : videoteca) {
				System.out.println(multimedia);
		}
	}
}
