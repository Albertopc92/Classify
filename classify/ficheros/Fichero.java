package classify.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Clase qeu se encarga de gestionar los flujos de datos
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Fichero implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Pattern patron = Pattern.compile("^((\\w)+(\\.obj))$");
	/**
	 * Fichero por defecto
	 */
	public static File fichero = new File("SinTitulo");

	/**
	 * Establece el fichero
	 * @param fichero
	 */
	public static void setFichero(String fichero) {
		Fichero.fichero = new File(fichero);
	}

	/**
	 * Devuelve el fichero
	 * @return
	 * 			Fichero
	 */
	public static File getFichero() {
		return fichero;
	}
	
	/**
	 * Crear un nuevo fichero
	 */
	public static void nuevo(){
		setFichero("SinTitulo.obj");
	}

	/**
	 * Metodo que permite Guardar Como...
	 * 
	 * @param objeto
	 * @param nombre
	 * @throws IOException
	 */
	public static void guardarComo(Object objeto, File nombre) throws IOException {
		fichero = comprobarFichero(nombre);
		guardar(objeto);
	}

	/**
	 * Metodo que permite guardar un archivo ya existente
	 * 
	 * @param objeto
	 * @throws IOException
	 */
	public static void guardar(Object objeto) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
			out.writeObject(objeto);
		}
	}

	/**
	 * Metodo que permite abrir un archivo concesionario existente
	 * 
	 * @param archivo
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object abrir(File archivo) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
			return in.readObject();
		}
	}

	/**
	 * Metodo que comprueba si el nombre del archivo cumple los requisitos del
	 * patron y si es asi le a�ade la extension .obj
	 * 
	 * @param fichero2
	 * @return
	 */
	public static File comprobarFichero(File ficheroUsuario) {
		if (patron.matcher(ficheroUsuario.getName()).matches()) {
			return ficheroUsuario;
		} else {
			setFichero(ficheroUsuario.getAbsolutePath() + ".obj");
			return fichero;
		}

	}
	
}
