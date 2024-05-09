import java.util.ArrayList;
import java.util.List;

/**
 * Vamos a usar la interface Observable en el Model
 */
public class Model implements Observable{
    static ArrayList<Coche> parking = new ArrayList<>();

    // para los observadores
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Coche coche) {
        for (Observer observer : observers) {
            observer.update(coche);
        }
    }


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
     * @param matricula identificador del coche
     * @param v nueva velocidad
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;

        // lo notificamos a todos los observadores
        notifyObservers(getCoche(matricula));

        // ya no retornamos la nueva velocidad
        // porque vamos a utilizar el patron observer
        // return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula identificador del coche
     * @return velocidad del coche actual
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
