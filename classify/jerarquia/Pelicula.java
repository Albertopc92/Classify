package classify.jerarquia;

import java.io.Serializable;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;

/**
 * Clase que gestiona las peliculas
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Pelicula extends Multimedia implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numVisualizaciones;
	private PremioPelicula premios;
	
	/**
	 * Constructor que inicializa el estado de la pelicula
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
	 * @param premios
	 * @throws TituloNoValidoException
	 * @throws DuracionNoValidaException
	 * @throws NotaNoValidaException
	 * @throws ValorNoValidoException
	 */
	public Pelicula(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografia, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, PremioPelicula premios) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		super(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografia, reparto, productora, genero,
				sinopsis, notaUsuario);
		setNumVisualizaciones(numVisualizaciones);
		setPremios(premios);
	}
	
	/**
	 * Constructor qeu incializa por titulo
	 * @param titulo
	 * @throws TituloNoValidoException
	 */
	public Pelicula(String titulo) throws TituloNoValidoException {
		super(titulo);
	}
	
	/**
	 * Obtiene el numero de visualizaciones de la pelicula
	 * @return numero de visualizaciones
	 */
	public int getNumVisualizaciones() {
		return numVisualizaciones;
	}
	
	/**
	 * Establece el numero de visualizaciones
	 * @param numVisualizaciones
	 */
	private void setNumVisualizaciones(int numVisualizaciones) {
		this.numVisualizaciones = numVisualizaciones;
	}

	/**
	 * Obtiene el premio de la pelicula
	 * @return premio de la pelicula
	 */
	public PremioPelicula getPremios() {
		return premios;
	}

	/**
	 * Establece el premio de la pelicula
	 * @param premios
	 */
	public void setPremios(PremioPelicula premios) {
		this.premios = premios;
	}
	
	/**
	 * Marca como visualizada una pelicula
	 */
	public void marcarVisualizado() {
		if(!isVisualizado())
			setVisualizado(true);
	}
	
	/**
	 * Visualiza una película
	 */
	public void visualizar() {
		setNumVisualizaciones(getNumVisualizaciones() + 1);
		setVisualizado(true);
	}

	/**
	 * Calcula la puntuacion de una pelicula
	 */
	@Override
	public float puntuable() {
		float puntuacion = 0;
		puntuacion += getNotaUsuario() * 0.5f;
		if(getPremios() != null)
			puntuacion += 10 * 0.3f;
		if(getNumVisualizaciones() > 5)
			puntuacion += getNumVisualizaciones() *0.5f;
		if(puntuacion > 10)
			return 10;
		return puntuacion;
	}
}
