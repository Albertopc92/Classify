package classify.jerarquia;

import java.io.Serializable;
import java.util.ArrayList;
import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioSerie;
import classify.envoltorios.Temporada;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.ListaVaciaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;
import classify.excepciones.YaExisteException;

/**
 * Clase que se encarga de gestionar las series
 * @author alber
 *
 */
public class Serie extends Multimedia implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Temporada> serie;
	private PremioSerie premios;
	private boolean emitiendo;
	
	/**
	 * Constructor que inicializa los estados de la serie
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
	 * @param emitiendo
	 * @param premios
	 * @throws TituloNoValidoException
	 * @throws DuracionNoValidaException
	 * @throws NotaNoValidaException
	 * @throws ValorNoValidoException
	 */
	public Serie(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografia, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, boolean emitiendo, PremioSerie premios) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		super(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografia, reparto, productora, genero,
				sinopsis, notaUsuario);
		setPremios(premios);
		setEmitiendo(emitiendo);
		this.serie = new ArrayList<Temporada>();
	}
	
	/**
	 * Obtiene el numero de temporadas de la serie
	 * @return numero de temporadas
	 */
	private int getNumTemporadas() {
		return serie.size();
	}
	
	/**
	 * Obtiene el premio de la serie
	 * @return premio de la serie
	 */
	public PremioSerie getPremios() {
		return premios;
	}
	
	/**
	 * Establece el premio d el aserie
	 * @param premios
	 */
	public void setPremios(PremioSerie premios) {
		this.premios = premios;
	}
	
	/**
	 * Obtiene si se esta emitioendo la serie o no
	 * @return True si se esta emitiendo
	 * 			False si no se esta emitiendo
	 */
	public boolean isEmitiendo() {
		return emitiendo;
	}
	
	/**
	 * Establece si se esta emitiendo o no
	 * @param emitiendo
	 */
	public void setEmitiendo(boolean emitiendo) {
		this.emitiendo = emitiendo;
	}
	
	/**
	 * Da de alta una temporada de una serie
	 * @param titutlo
	 * @throws YaExisteException
	 * @throws TituloNoValidoException 
	 */
	public boolean altaTemporada(String titulo) throws YaExisteException, TituloNoValidoException {
		Temporada temporada = new Temporada(titulo);
		if(!serie.contains(serie)) {
			serie.add(temporada);
			return true;
		}else {
			throw new YaExisteException("La temporada ya existe.");
		}	
	}
	
	/**
	 * Da de baja una temporada
	 * @param IDTemporada
	 */
	public void bajaTemporada(int IDTemporada) {
		Temporada temporada = new Temporada(IDTemporada);
		if(serie.contains(temporada)) {
			serie.remove(temporada);
		}
	}
	
	/**
	 * Lista las temporadas
	 * @return temporadas
	 * @throws ListaVaciaException
	 */
	public ArrayList<Temporada> listarTemporadas() throws ListaVaciaException {
		if(serie.isEmpty())
			throw new ListaVaciaException("No hay temporadas que mostrar.");
		ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
		for (Temporada temporada: serie) {
			temporadas.add(temporada);
		}
		
		return temporadas;
	}
	
	/**
	 * Calcula la puntuacion de una Serie
	 */
	@Override
	public float puntuable() {
		float puntuacion = 0;
		puntuacion += getNotaUsuario() * 0.5f;
		if(getPremios() != null)
			puntuacion += 10 * 0.3f;
		if(getNumTemporadas() > 4)
			puntuacion += getNumTemporadas() * 0.2f;
		return puntuacion;
	}
	
	
}
