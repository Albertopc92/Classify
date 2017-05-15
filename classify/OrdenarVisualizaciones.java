package classify;

import java.util.Comparator;

import classify.jerarquia.Pelicula;

public class OrdenarVisualizaciones implements Comparator<Pelicula>{
	
	public OrdenarVisualizaciones() {}

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		if(o1.getNumVisualizaciones() < o2.getNumVisualizaciones()){
            return 1;
        } else if (o2.getNumVisualizaciones() < o1.getNumVisualizaciones()) {
            return -1;
        }else return 0;
	}

}
