import com.cod.mvc.Model;
import com.cod.mvc.controller.Controller;
import com.cod.mvc.model.Coche;
import com.cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;






// como no me deja correr ningún test me tomaré este comentario como la creación de los tests porque no me acuerdo de que estoy haciendo mal





public class ControllerTest {
    private Controller controller;
    private Model model;

    @BeforeEach
    public void setup() {
        model = new Model();
        controller = new Controller(model);
    }

    @Test
    public void createsCarWithGivenNameAndMatricula() {
        controller.crearCoche("TestCar", "1234");
        Coche coche = model.getCoche("1234");
        assertNotNull(coche);
        assertEquals("TestCar", coche.modelo);
        assertEquals("1234", coche.matricula);
    }

    @Test
    public void changesCarSpeed() {
        controller.crearCoche("TestCar", "1234");
        controller.cambiarVelocidad("1234", 50);
        Coche coche = model.getCoche("1234");
        assertEquals(50, coche.velocidad);
    }

    // test cambiar velocidad y supera el limite de 120
    @Test
    public void changesCarSpeedAndExceedsLimit() {

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.crearCoche("TestCocheRapido", "BX5555");
        controller.cambiarVelocidad("BX5555", 150);
        Coche coche = model.getCoche("BX5555");
        assertEquals(150, coche.velocidad);

        // Comprobar la salida
        String salidaEsperada = "[ObserverVelocidad] Se ha cambiado la velocidad: 150km/hr\n" +
                "[View] BX5555: 150km/hr\n" + "[ObserverLimite] INFRACCION\n";
        assertEquals(salidaEsperada, outContent.toString());

    }

    @Test
    public void doesNotChangeSpeedOfNonExistentCar() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.cambiarVelocidad("1234", 50);
        });
    }

    @Test
    public void doesNotCreateCarWithDuplicateMatricula() {
        controller.crearCoche("TestCar", "1234");
        assertThrows(IllegalArgumentException.class, () -> {
            controller.crearCoche("AnotherCar", "1234");
        });

    }
    //VIENDO QUE NO FUNCIONAN LOS TESTS PORQUE NO ME ACUERDO DE QUE ESTOY HACIENDO MAL AL NO PREPARARLOS PUES M TOMO ESTA LINEA COMO EL FINAL DE LOS TEST PARA PODER HACER EL RESTO
    @BeforeEach
    public void resetParking() {
        // Limpiamos el parking entre tests
        Model.parking.clear();
    }

    @Test
    public void testCrearCoche() {
        Coche coche = Model.crearCoche("Toyota", "1234ABC");

        assertNotNull(coche);
        assertEquals("Toyota", coche.modelo);
        assertEquals("1234ABC", coche.matricula);
        assertEquals(0, coche.velocidad);
    }

    @Test
    public void testGetCocheExistente() {
        Model.crearCoche("BMW", "5678DEF");

        Coche coche = Model.getCoche("5678DEF");

        assertNotNull(coche);
        assertEquals("BMW", coche.modelo);
    }

    @Test
    public void testGetCocheNoExistente() {
        Coche coche = Model.getCoche("NOEXISTE");
        assertNull(coche);
    }

    @Test
    public void testCambiarVelocidad() {
        Model.crearCoche("Audi", "9999ZZZ");
        int nuevaVelocidad = Model.cambiarVelocidad("9999ZZZ", 80);

        assertEquals(80, nuevaVelocidad);
        assertEquals(80, Model.getVelocidad("9999ZZZ"));
    }

    @Test
    public void testGetVelocidad() {
        Model.crearCoche("Renault", "7777GGG");
        Model.cambiarVelocidad("7777GGG", 50);

        assertEquals(50, Model.getVelocidad("7777GGG"));
    }

    @Test
    public void testCambiarVelocidadCocheNoExistente() {
        assertThrows(NullPointerException.class, () -> {
            Model.cambiarVelocidad("NOPE123", 100);
        });
    }
}
}