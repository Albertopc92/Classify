package classify.jerarquia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import classify.enumeraciones.Genero;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;


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
	protected String fotografía;
	protected String[][] reparto;
	protected String productora;
	protected Genero genero;
	protected String sinopsis;
	protected float notaUsuario;
	protected boolean visualizado;
	protected LocalDate ultimaVisualizacion;
	protected int ID;
	private static int incID = 1;
	private static final Pattern PATRON_TITULO = Pattern.compile("^[^\\!\\\"\\$\\%\\&\\/\\\\\\(\\)\\=\\;\\:\\-\\_\\*][A-z\\s].+");
	private static final Pattern PATRON_NO_BLANCO = Pattern.compile("[A-z\\s]+");
	
	public Multimedia(String titulo,String tituloOriginal, int anyo, int duracion, 
			String pais, String director, String guion, String musica, String fotografía,
			String[][] reparto, String productora, Genero genero, String sinopsis, float notaUsuario) throws TituloNoValidoException, DuracionNoValidaException, NotaNoValidaException, ValorNoValidoException {
		
		setTitulo(titulo);
		setTituloOriginal(tituloOriginal);
		setAnyo(anyo);
		setDuracion(duracion);
		setPais(pais);
		setDirector(director);
		setGuion(guion);
		setMusica(musica);
		setFotografía(fotografía);
		setReparto(reparto);
		setProductora(productora);
		setGenero(genero);
		setSinopsis(sinopsis);
		setNotaUsuario(notaUsuario);
		setID(incID++);
	}
	
	public Multimedia(String titulo) throws TituloNoValidoException {
		setTitulo(titulo);
	}
	
	
	public String getTitulo() {
		return titulo;
	}



	protected void setTitulo(String titulo) throws TituloNoValidoException {
		Matcher matcherTitulo = PATRON_TITULO.matcher(titulo);
		
		if(!matcherTitulo.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		
		this.titulo = titulo.trim();
	}



	protected String getTituloOriginal() {
		return tituloOriginal;
	}



	protected void setTituloOriginal(String tituloOriginal) throws TituloNoValidoException {
		Matcher matcherTituloOriginal = PATRON_TITULO.matcher(tituloOriginal);
		
		if(!matcherTituloOriginal.matches()) 
			throw new TituloNoValidoException("Titulo no valido.");
		
		this.tituloOriginal = tituloOriginal.trim();
	}



	protected int getAnyo() {
		return anyo;
	}



	protected void setAnyo(int anyo) {
		this.anyo = anyo;
	}



	protected int getDuracion() {
		return duracion;
	}



	protected void setDuracion(int duracion) throws DuracionNoValidaException {
		if(duracion < 1)
			throw new DuracionNoValidaException("Duracion no valida.");
		this.duracion = duracion;
	}



	protected String getPais() {
		return pais;
	}



	protected void setPais(String pais) throws ValorNoValidoException {
		Matcher matcherPais = PATRON_NO_BLANCO.matcher(pais);
		
		if(!matcherPais.matches()) 
			throw new ValorNoValidoException("Valor no valido.");
		this.pais = pais.trim();
	}



	protected String getDirector() {
		return director;
	}



	protected void setDirector(String director) throws ValorNoValidoException {
		Matcher matcherDirector = PATRON_NO_BLANCO.matcher(director);
		
		if(!matcherDirector.matches()) 
			throw new ValorNoValidoException("Valor no valido.");
		this.director = director.trim();
	}



	protected String getGuion() {
		return guion;
	}



	protected void setGuion(String guion) {
		this.guion = guion.trim();
	}



	protected String getMusica() {
		return musica;
	}



	protected void setMusica(String musica) throws ValorNoValidoException {
		Matcher matcherMusica = PATRON_NO_BLANCO.matcher(musica);
		
		if(!matcherMusica.matches()) 
			throw new ValorNoValidoException("Valor no valido.");
		this.musica = musica.trim();
	}



	protected String getFotografía() {
		return fotografía;
	}



	protected void setFotografía(String fotografía) throws ValorNoValidoException {
		Matcher matcherFotografia = PATRON_NO_BLANCO.matcher(fotografía);
		
		if(!matcherFotografia.matches()) 
			throw new ValorNoValidoException("Valor no valido.");
		this.fotografía = fotografía.trim();
	}



	protected String[][] getReparto() {
		return reparto;
	}



	protected void setReparto(String[][] reparto) {
		this.reparto = reparto;
	}



	protected String getProductora() {
		return productora;
	}



	protected void setProductora(String productora) throws ValorNoValidoException {
		Matcher matcherProductora = PATRON_NO_BLANCO.matcher(productora);
		
		if(!matcherProductora.matches()) 
			throw new ValorNoValidoException("Valor no valido.");
		this.productora = productora.trim();
	}



	public Genero getGenero() {
		return genero;
	}



	protected void setGenero(Genero genero) {
		this.genero = genero;
	}



	protected String getSinopsis() {
		return sinopsis;
	}



	protected void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis.trim();
	}



	protected float getNotaUsuario() {
		return notaUsuario;
	}



	protected void setNotaUsuario(float notaUsuario) throws NotaNoValidaException {
		if(notaUsuario < 0 || notaUsuario > 10)
			throw new NotaNoValidaException("La nota no puede ser menor a 0 ni mayor a 10");
		this.notaUsuario = notaUsuario;
	}



	protected boolean isVisualizado() {
		return visualizado;
	}



	public void setVisualizado(boolean visualizado) {
		this.visualizado = visualizado;
	}



	protected LocalDate getUltimaVisualizacion() {
		return ultimaVisualizacion;
	}



	protected void setUltimaVisualizacion(LocalDate ultimaVisualizacion) {
		this.ultimaVisualizacion = ultimaVisualizacion;
	}



	public int getID() {
		return ID;
	}



	protected void setID(int iD) {
		ID = iD;
	}



	public abstract float puntuable();

	@Override
	public String toString() {
//		return getClass().getSimpleName() + "[ ID=" + ID + " titulo=" + titulo + ", tituloOriginal=" + tituloOriginal + ", anyo=" + anyo + ", duracion="
//				+ duracion + ", pais=" + pais + ", director=" + director + ", guion=" + guion + ", musica=" + musica
//				+ ", fotografía=" + fotografía + ", reparto=" + Arrays.toString(reparto) + ", productora=" + productora
//				+ ", genero=" + genero + ", sinopsis=" + sinopsis + ", notaUsuario=" + notaUsuario + ", visualizado="
//				+ visualizado + ", ultimaVisualizacion=" + ultimaVisualizacion + " puntuacion =" + puntuable() + "]";
		return getTitulo();
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Multimedia other = (Multimedia) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (ID != other.ID)
			return false;
		return true;
	}
	*/

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
		Multimedia other = (Multimedia) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
