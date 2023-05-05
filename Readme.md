# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---

En esta rama está añadido los eventos en la IU

En vez de usar `swing`, usaremos [`javafx`](https://openjfx.io/)

De esta manera vemos lo independiente que queda la interfaz gráfica, pudiendo migrarla sin tener que modificar el resto de la App

Mantendremos una estructura básica de javafx

El Model y el Controller no cambian

---
### Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {
          +crearVentana()
          +muestraVelocidad(String, Integer)
          }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      
      class IU {
          +main()
          +start()
      }
      
      class IUController { 
          +mostrarMensaje()
          }
      
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1" IU : association
    View "1" *-- "1" IUController : association
```

---

## Evento en el View

Cuando ocurre un evento en la vista, el `controller` se tiene que enterar.
Tenemos que tener en cuenta que en el MVC estricto, la vista no se comunica con el modelo.

En el listener del botón llamamos al `controller`


```mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant Model
    
    usuario->>View: click! Crear coche
    View->>Controller: el usuario quiere crear un coche
    activate Controller
    Controller->>Model: crea un coche, porfa
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>View: ok, coche creado!
    deactivate Controller
    View-->>usuario: tu coche se creó!
```

Ahora la parte de la Arquitectura de la vista, son las clases de JavaFX
```mermaid
sequenceDiagram
    autonumber
    actor usuario
    box gray Vista con JavaFX
        participant IUController
        participant View
        end
        
    participant Controller
    participant Model

    usuario->>IUController: click! Crear coche
    IUController->>Controller: crearCoche()
    activate Controller
    Controller->>Model: crearCoche()
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: mostrarVelocidad
    deactivate Controller
    View->>-IUController: mostrarMensaje()
```