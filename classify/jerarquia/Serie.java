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


public class Serie extends Multimedia implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Temporada> serie;
	private PremioSerie premios;
	private boolean emitiendo;
	private boolean modificado;
	
	public Serie(String titulo, String tituloOriginal, int anyo, int duracion, String pais, String director,
			String guion, String musica, String fotografia, String[][] reparto, String productora, Genero genero,
			String sinopsis, float notaUsuario, boolean emitiendo, PremioSerie premios) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		super(titulo, tituloOriginal, anyo, duracion, pais, director, guion, musica, fotografia, reparto, productora, genero,
				sinopsis, notaUsuario);
		setPremios(premios);
		setEmitiendo(emitiendo);
		this.serie = new ArrayList<Temporada>();
	}
	
	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	private int getNumTemporadas() {
		return serie.size();
	}

	public PremioSerie getPremios() {
		return premios;
	}

	public void setPremios(PremioSerie premios) {
		this.premios = premios;
	}

	public boolean isEmitiendo() {
		return emitiendo;
	}

	public void setEmitiendo(boolean emitiendo) {
		this.emitiendo = emitiendo;
	}
	
	/**
	 * Da de alta una temporada de una serie
	 * @param titutlo
	 * @throws YaExisteException
	 * @throws TituloNoValidoException 
	 */
	public Temporada altaTemporada(String titulo) throws YaExisteException, TituloNoValidoException {
		Temporada temporada = new Temporada(titulo);
		if(!serie.contains(serie)) {
			serie.add(temporada);
			return temporada;
		}
		
		throw new YaExisteException("La temporada ya existe.");
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
