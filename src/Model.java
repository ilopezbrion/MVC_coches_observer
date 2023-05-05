import java.util.ArrayList;
import java.util.Observable;

/**
 * Vamos a usar Observer en el Model
 * Por lo tanto vamos a poder observar los cambios en variables
 * Si bien esta clase está 'deprecate' nos servirá para entender el patrón
 */
public class Model extends Observable{
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Método que cambia la velocidad, por lo tanto
     * tendrá que avisar al controlador que ha cambiado
     *
     * @param matricula
     * @param v nueva velocidad
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;

        // anotamos el cambio
        setChanged();
        // lo notificamos a todos los observadores
        notifyObservers(getCoche(matricula));

        // ya no retornamos la nueva velocidad
        // porque vamos a utilizar el patron observer
        // return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
