package classify.ficheros;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que gestiona los tipos de ficheros que se usaran en la aplicacion
 * @author Albero Perez Cano
 * @version 1.0
 */
public class Filtro extends FileFilter{
	private String ext;
	private String descripcion;
	
	/**
	 * Constructor que inicializa la extension y la descricion del tipo de archivo
	 * @param ext
	 * @param descripcion
	 */
	public Filtro(String ext, String descripcion) {
		setExt(ext);
		setDescripcion(descripcion);
	}
	

	/**
	 * Obtiene la extension
	 * @return
	 * 			Extension del archivo
	 */
	public String getExt() {
		return ext;
	}


	/**
	 * Establece la extension que se va a usar
	 * @param ext
	 * 		Extension que se va a usar
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}


	/**
	 * Obtiene la descricion del tipo de archivo
	 * @return La descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * Establece la descripcion del tipo de archivo
	 * @param descripcion
	 * 			La descricion que se va a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public boolean accept(File fichero) {
		if(fichero.isDirectory())
			return true;
		return fichero.getName().endsWith(getExt());
	}

	@Override
	public String getDescription() {
		return getDescripcion() + String.format(" (*%s)", getExt());
	}
	
}
