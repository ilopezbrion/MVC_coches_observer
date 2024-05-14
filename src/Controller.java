/**
 * Lógica de la aplicación
 * No instanciamos la vista ni el modelo
 * usamos todo static
 */
public class Controller {

    /**
     * Crea un coche y manda mensaje a la vista para el usuario
     * @param modelo del coche a crear
     * @param matricula identificador único del coche
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = Model.crearCoche(modelo, matricula);

        // muestra la velocidad del coche creado
        if (aux != null) View.mostrarVelocidad(aux.matricula, aux.velocidad);

        // TODO mandar mensaje de error si no fue posible crear el coche
    }

    /**
     * Cambia velocidad segun matricula
     * @param matricula del coche a cambiar velocidad
     * @param velocidad nueva del coche
     */
    public static void cambiarVelocidad(String matricula, Integer velocidad){
        Integer v_aux = Model.cambiarVelocidad(matricula, velocidad);

        // muestra la velocidad del coche creado
        if (v_aux != null) View.mostrarVelocidad(matricula, v_aux);

        // TODO mandar mensaje de error si no fue posible cambiar la velocidad
    }
}