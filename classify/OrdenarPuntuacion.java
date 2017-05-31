package classify;

import java.util.Comparator;

import classify.jerarquia.Multimedia;

/**
 * Clase que se encarga de ordenaar por puntuacion
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class OrdenarPuntuacion implements Comparator<Multimedia>{

	public OrdenarPuntuacion() {}
	
	@Override
	public int compare(Multimedia o1, Multimedia o2) {
		if(o1.puntuable() < o2.puntuable()){
            return 1;
        } else if (o2.puntuable() < o1.puntuable()) {
            return -1;
        }else return 0;
	}

}
