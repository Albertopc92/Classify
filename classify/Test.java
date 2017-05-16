package classify;


/*
videoteca.altaSerie("serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 10f, 6, 6, false, PremioSerie.BLOBO_DE_ORO);
videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 4.0f, PremioPelicula.BAFTA);
 */

import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.envoltorios.Videoteca;
import classify.excepciones.YaExisteException;
import classify.excepciones.ListaVaciaException;

//videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
public class Test {

	public static void main(String[] args) throws ListaVaciaException, YaExisteException{
		
		Videoteca videoteca = new Videoteca();
		
		try {
			videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
			videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-----");
	}

}
