import java.util.Observable;
import java.util.Observer;

public class ObserverVelocidad implements Observer {
    /**
     * Este método es llamado siempre que hay un cambio
     * El observable cuando hace el notifyObservers
     * 'dispara' todos los update de los Observers
     *
     * @param o   el observable, en nuestro caso es el Model
     * @param arg el argumento pasado por el observable, el coche actualizado
     */
    @Override
    public void update(Observable o, Object arg) {
        // el argumento es tipo Object, porque es general
        // le hacemos un cast para poder trabajar con un objeto Coche
        Coche auxCoche = (Coche) arg;
        System.out.println("Se ha cambiado la velocidad: " + auxCoche.velocidad.toString());
        // le comunicamos a la vista que muestre la velocidad
        View.muestraVelocidad(auxCoche.matricula, auxCoche.velocidad);

        // tambien tenemos acceso al observable en este método,
        // es decir el Model
        // por lo tanto tenemos acceso a 'parking'
        /*for (Coche coche : ((Model) o).parking) {
            System.out.println(coche.matricula);
        }*/

    }
}
