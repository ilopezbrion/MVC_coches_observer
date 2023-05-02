/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IU extends App {

    static com.castelao.mvc.app.Controller miControlador;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(IUcontroller.class.getResource("IU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("App Coches");
        stage.setScene(scene);
        stage.show();

        // instanciamos el controlador
        // para avisar según la interacción del usuario
        miControlador = new com.castelao.mvc.app.Controller();
    }
}
*/