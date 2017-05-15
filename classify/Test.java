package classify;

import java.time.LocalDate;

/*
videoteca.altaSerie("serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 10f, 6, 6, false, PremioSerie.BLOBO_DE_ORO);
videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 4.0f, PremioPelicula.BAFTA);
 */

import classify.enumeraciones.Genero;
import classify.enumeraciones.PremioPelicula;
import classify.enumeraciones.PremioSerie;
import classify.envoltorios.Temporada;
import classify.envoltorios.Videoteca;
import classify.excepciones.YaExisteException;
import classify.jerarquia.Serie;
import classify.excepciones.DuracionNoValidaException;
import classify.excepciones.ListaVaciaException;
import classify.excepciones.NotaNoValidaException;
import classify.excepciones.TituloNoValidoException;
import classify.excepciones.ValorNoValidoException;


public class Test {

	public static void main(String[] args) throws ListaVaciaException, YaExisteException{
		
		Videoteca videoteca = new Videoteca();
		
		
		try {
			videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
		} catch (TituloNoValidoException | DuracionNoValidaException | NotaNoValidaException
				| ValorNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Serie serie = null;
		Temporada temporada = null;
		Capitulo capitulo = null;
		try {
			serie = videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 10f, false, PremioSerie.BLOBO_DE_ORO);
			temporada = serie.altaTemporada("Temporada");
			capitulo = temporada.altaCapitulo("Capitulo");
		} catch (TituloNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuracionNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValorNoValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		videoteca.listarSeries();
		serie.listarTemporadas();
		capitulo.visualizar();
		capitulo.visualizar();
		temporada.listarCapitulos();
		
		
	
		try {
		videoteca.altaPelicula("          pelicula          ", "Peliculaoriginal", LocalDate.of(2000, 1, 1).getYear(), 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff", "ldsgjl"},{"fff"}}, "productora", Genero.MELODRAMA, "sinopsis", 4.0f, PremioPelicula.BAFTA);
		videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 5.0f, PremioPelicula.BAFTA);
		videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.COMEDIA, "sinopsis", 7.0f, PremioPelicula.BAFTA);
		videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 4.0f, PremioPelicula.BAFTA);
		videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.TERROR, "sinopsis", 10f, null);
		videoteca.altaPelicula("pelicula", "Peliculaoriginal", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 1.0f, null);
		
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.FANTASIA, "sinopsis", 3f, false, null);
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.DRAMA, "sinopsis", 6f, false, PremioSerie.BLOBO_DE_ORO);
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.ACCION, "sinopsis", 8f, false, PremioSerie.BLOBO_DE_ORO);
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.CIENCIA_FICCION, "sinopsis", 10f, false, PremioSerie.BLOBO_DE_ORO);
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.MELODRAMA, "sinopsis", 9f, false, PremioSerie.BLOBO_DE_ORO);
		videoteca.altaSerie("Serie", "titulo original", 2000, 200, "Spain", "director", "guion", "Musica", "fotografia", new String[][] {{"fff"},{"fff"}}, "productora", Genero.TERROR, "sinopsis", 10f, false, PremioSerie.BLOBO_DE_ORO);
		}catch (TituloNoValidoException e) {
			System.err.println(e.getMessage());
		}catch (DuracionNoValidaException e) {
			System.err.println(e.getMessage());
		}catch (NotaNoValidaException e) {
			System.err.println(e.getMessage());
		}catch (ValorNoValidoException e) {
			System.err.println(e.getMessage());
		}
	
		//videoteca.listarPeliculasGenero(Genero.ACCION);
		//videoteca.listarSeriesGenero(Genero.FANTASIA);
		
		System.out.println("\n\n");
		
		try {
			videoteca.listarPeliculasPuntuacion();
			
			videoteca.listarSeriesPuntuacion();
		} catch (Exception e) {
System.err.println(e.getMessage());
		}
		//videoteca.listarPeliculasVisualizaciones();
		*/
		
		
		
	}

}
