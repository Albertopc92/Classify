package classify.jerarquia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import classify.Patron;
import classify.enumeraciones.Genero;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;

/**
 * Clase que contiene todos los datos de los elementos multimedia y los inicializa
 * @author Alberto Perez Cano
 * @version 1.0
 */
public abstract class Multimedia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String titulo;
	protected String tituloOriginal;
	protected int anyo;
	protected int duracion;
	protected String pais;
	protected String director;
	protected String guion;
	protected String musica;
	protected String fotografia;
	protected String[][] reparto;
	protected String productora;
	protected Genero genero;
	protected String sinopsis;
	protected float notaUsuario;
	protected boolean visualizado;
	protected LocalDate ultimaVisualizacion;
	protected int ID;
	private static int incID = 1;
	
	/**
	 * Constructor que inicializa los campos de los elementos multimedia
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
	 * @throws TituloNoValidoException
	 * @throws DuracionNoValidaException
	 * @throws NotaNoValidaException
	 * @throws ValorNoValidoException
	 */
	public Multimedia(String titulo,String tituloOriginal, int anyo, int duracion, 
			String pais, String director, String guion, String musica, String fotografia,
			String[][] reparto, String productora, Genero genero, String sinopsis, float notaUsuario) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		
		setTitulo(titulo);
		setTituloOriginal(tituloOriginal);
		setAnyo(anyo);
		setDuracion(duracion);
		setPais(pais);
		setDirector(director);
		setGuion(guion);
		setMusica(musica);
		setFotografia(fotografia);
		setReparto(reparto);
		setProductora(productora);
		setGenero(genero);
		setSinopsis(sinopsis);
		setNotaUsuario(notaUsuario);
		setID(incID++);
	}
	
	/**
	 * Constructor que iniciliza elementos multimedia por titulo
	 * @param titulo
	 * @throws TituloNoValidoException
	 */
	public Multimedia(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
	}
	
	/**
	 * Devuelve el titulo de un elemento multimedia
	 * @return	Titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo del elemento multimedia
	 * @param titulo
	 * 			Titulo del elemento multimedia
	 * @throws TituloNoValidoException
	 * 			Se lanza cuando el titulo no es valido
	 */
	public void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = Patron.PATRON_TITULO.matcher(titulo);
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("T\u00edtulo no v\u00e1lido.");
		
		this.titulo = titulo.trim();
	}


	/**
	 * Devuelve el titulo original del elemento multimedia
	 * @return Titulo original
	 */
	public String getTituloOriginal() {
		return tituloOriginal;
	}


	/**
	 * Establece el titulo original
	 * @param tituloOriginal
	 * @throws TituloNoValidoException
	 * 			Se lanza cuando el titulo no es valido
	 */
	public void setTituloOriginal(String tituloOriginal) throws TituloNoValidoException {
		Matcher matcherTituloOriginal = Patron.PATRON_TITULO.matcher(tituloOriginal);
		
		if(!matcherTituloOriginal.matches()) 
			throw new TituloNoValidoException("T\u00edtulo Original no v\u00e1lido.");
		
		this.tituloOriginal = tituloOriginal.trim();
	}


	/**
	 * Se obtiene el año
	 * @return año
	 */
	public int getAnyo() {
		return anyo;
	}


	/**
	 * Establece el año
	 * @param anyo
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	/**
	 * Se obtiene la duracion 
	 * @return
	 */
	public int getDuracion() {
		return duracion;
	}


	/**
	 * Se establece la duracion
	 * @param duracion
	 * @throws DuracionNoValidaException
	 * 			Se lanza cuando al duracion no es valida
	 */
	public void setDuracion(int duracion) throws DuracionNoValidaException {
		if(duracion < 1)
			throw new DuracionNoValidaException("Duraci\u00f3n no v\u00e1lida.");
		this.duracion = duracion;
	}


	/**
	 * Se obtiene el pais
	 * @return
	 */
	public String getPais() {
		return pais;
	}


	/**
	 * Se establece el pais
	 * @param pais
	 * @throws ValorNoValidoException
	 *  			Se lanza cuando el pais no es valido
	 */
	public void setPais(String pais) throws ValorNoValidoException {
		Matcher matcherPais = Patron.PATRON_NO_BLANCO.matcher(pais);
		
		if(!matcherPais.matches()) 
			throw new ValorNoValidoException("Pa\\u00eds no v\u00e1lido.");
		this.pais = pais.trim();
	}


	/**
	 * Se obtiene el director
	 * @return
	 * 			Director
	 */
	public String getDirector() {
		return director;
	}


	/**
	 * Se establece el director
	 * @param director
	 * @throws ValorNoValidoException
	 *  			Se lanza cuando el director no es valido
	 */
	public void setDirector(String director) throws ValorNoValidoException {
		Matcher matcherDirector = Patron.PATRON_NO_BLANCO.matcher(director);
		
		if(!matcherDirector.matches()) 
			throw new ValorNoValidoException("Director no v\u00e1lido.");
		this.director = director.trim();
	}


	/**
	 * Se obtiene el guion
	 * @return
	 * 			guion
	 */
	public String getGuion() {
		return guion;
	}


	/**
	 * Establece el guion
	 * @param guion
	 */
	public void setGuion(String guion) {
		this.guion = guion.trim();
	}


	/**
	 * Se obtiene quien compuso la banda sonora
	 * @return
	 * 			Compositor de la banada sonora
	 */
	public String getMusica() {
		return musica;
	}


	/**
	 * Establece el compositor de la banda sonora
	 * @param musica
	 * @throws ValorNoValidoException
	 *  			Se lanza cuando el valor no es valido
	 */
	public void setMusica(String musica) throws ValorNoValidoException {
		Matcher matcherMusica = Patron.PATRON_NO_BLANCO.matcher(musica);
		
		if(!matcherMusica.matches()) 
			throw new ValorNoValidoException("M\u00fasica no v\u00e1lido.");
		this.musica = musica.trim();
	}


	/**
	 * Obtiene quien se encargo de la fotografia
	 * @return
	 * 			Quien se encargo de la fotografia
	 */
	public String getFotografia() {
		return fotografia;
	}


	/**
	 * Se establece quien se encargo de la fotografia
	 * @param fotografia
	 * @throws ValorNoValidoException
	 * 			Se lanza cuando el valor no es valido
	 */
	public void setFotografia(String fotografia) throws ValorNoValidoException {
		Matcher matcherFotografia = Patron.PATRON_NO_BLANCO.matcher(fotografia);
		
		if(!matcherFotografia.matches()) 
			throw new ValorNoValidoException("Valor no v\u00e1lido.");
		this.fotografia = fotografia.trim();
	}


	/**
	 * Obtiene el reparto
	 * @return
	 * 		reparto
	 */
	public String[][] getReparto() {
		return reparto;
	}


	/**
	 * Se establece el reparto
	 * @param reparto
	 */
	public void setReparto(String[][] reparto) {
		this.reparto = reparto;
	}


	/**
	 * Obtiene la productora
	 * @return
	 * 		productora
	 */
	public String getProductora() {
		return productora;
	}


	/**
	 * Establece la productora
	 * @param productora
	 * @throws ValorNoValidoException
	 * 			Se lanza cuando el valor no es valido
	 */
	public void setProductora(String productora) throws ValorNoValidoException {
		Matcher matcherProductora = Patron.PATRON_NO_BLANCO.matcher(productora);
		
		if(!matcherProductora.matches()) 
			throw new ValorNoValidoException("Valor no v\u00e1lido.");
		this.productora = productora.trim();
	}


	/**
	 * Obtiene el genero
	 * @return
	 * 			Genero
	 */
	public Genero getGenero() {
		return genero;
	}


	/**
	 * Establece el genero
	 * @param genero
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	/**
	 * Obtiene la sinopsis
	 * @return sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
	}


	/**
	 * Establece la sinopsis
	 * @param sinopsis
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis.trim();
	}


	/**
	 * Obtiene la nota que ha establecido el usuario
	 * @return nota del usuario
	 */
	public float getNotaUsuario() {
		return notaUsuario;
	}


	/**
	 * Establece la nota del usuario
	 * @param notaUsuario
	 * @throws NotaNoValidaException
	 * 			Se lanza cuando la nota del usuario no es valida
	 */
	public void setNotaUsuario(float notaUsuario) throws NotaNoValidaException {
		if(notaUsuario < 0 || notaUsuario > 10)
			throw new NotaNoValidaException("La nota no puede ser menor a 0 ni mayor a 10");
		this.notaUsuario = notaUsuario;
	}


	/**
	 * Obtiene si se ha visualizado
	 * @return
	 */
	public boolean isVisualizado() {
		return visualizado;
	}


	/**
	 * Se establece si se ha visualizado
	 * @param visualizado
	 */
	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}


	/**
	 * Obtiene la fecha de ultima visualizacion
	 * @return fecha de ultima visualizacion
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
	 * Obtiene el ID
	 * @return ID
	 */
	public int getID() {
		return ID;
	}


	
	protected void setID(int iD) {
		ID = iD;
	}


	/**
	 * Metodo que se encarga de calcular la puntuacion
	 * @return puntuacion
	 */
	public abstract float puntuable();

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
		Multimedia other = (Multimedia) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}
}
