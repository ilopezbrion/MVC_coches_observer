/**
 * Otro observador que se suscribe a los cambios de velocidad de un coche
 */
public class ObserverOtro implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Coche arg) {
        System.out.println("Yo tambien me enteré que la velocidad cambio en " + arg.toString());
    }
}
