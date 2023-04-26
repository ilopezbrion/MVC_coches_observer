public class Controller {

    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        System.out.println("fin del main");
    }

    public void crearCoche(String modelo, String matricula){
        miModelo.crearCoche(modelo, matricula);
    }
}