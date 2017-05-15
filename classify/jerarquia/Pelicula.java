package classify.jerarquia;

import java.io.Serializable;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;


public class Pelicula extends Multimedia implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numVisualizaciones;
	private PremioPelicula premios;
	
	public Pelicula(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografía, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, PremioPelicula premios) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		super(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografía, reparto, productora, genero,
				sinopsis, notaUsuario);
		setNumVisualizaciones(numVisualizaciones);
		setPremios(premios);
	}
	
	public Pelicula(int ID, String titulo) throws TituloNoValidoException {
		super(ID, titulo);
	}
	
	public int getNumVisualizaciones() {
		return numVisualizaciones;
	}

	private void setNumVisualizaciones(int numVisualizaciones) {
		this.numVisualizaciones = numVisualizaciones;
	}

	private PremioPelicula getPremios() {
		return premios;
	}

	private void setPremios(PremioPelicula premios) {
		this.premios = premios;
	}
	
	/**
	 * Marca como visualizada una pelicula
	 */
	public void marcarVisualizado() {
		if(isVisualizado())
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
		return puntuacion;
	}
}
