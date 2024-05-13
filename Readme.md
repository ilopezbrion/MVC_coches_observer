# Arquitectura MVC con Observer

En esta rama utilizaremos el patrón Observer

Los cambios de la velocidad que se hagan en el model
serán observados por el Controller

Para notificar a los observadores:

* Notificamos a los observadores `notifyObservers(valor)`

* se *dispara* en todos los observadores el método `update()`

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observer {
        +update(Coche coche)
    }
    class Observable {
        notifyObserver(Coche coche)
    }
        class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller {
            ObserverVelocidad: observoVelocidad
            ObserverLimite: observoLimite
            +cambiarVelocidad(String, Integer)
            +getVelocidad(String)
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class ObserverVelocidad { +update(Coche coche) }
      class ObserverLimite { +update(Coche coche) }
      Controller "1" *-- "1" ObserverVelocidad: association
      Controller "1" *-- "1" ObserverLimite: association
      Controller "1" *-- "1" Model : association
      Model "1" *-- "1..n" Coche : association
      Observable <|.. Model : implements
      Observer <|.. ObserverVelocidad : implements
      Observer <|.. ObserverLimite : implements
      
```

---

## Diagrama de Secuencia

Que ocurre cuando se cambia la velocidad


```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant ObservoVelocidad
    end
    participant Model
    
    Controller->>Model: cambia la velociad, porfa
    activate Model
    Model->>ObservoVelocidad: Notificacion de cambio de velocidad
    deactivate Model
    activate ObservoVelocidad
    ObservoVelocidad->>+View: Muestra la velocidad, porfa
    deactivate ObservoVelocidad
    activate View
    View->>-View: Mostrando velocidad
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant observoVelocidad
    end
    participant Model

    Controller->>Model: cambiarVelocidad()
    activate Model
    Model->>observoVelocidad: update()
    deactivate Model
    activate observoVelocidad
    observoVelocidad->>+View: muestraVelocidad
    deactivate observoVelocidad
    activate View
    View->>-View: sout
    deactivate View
```

Si sumamos otro observador (que vigile el limite de velocidad), entonces el `update()` será en paralelo (**par**)

a todos los Observadores

```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant observoVelocidad
    participant observoLimite
    end
    participant Model

    Controller->>Model: cambiarVelocidad()
    activate Model
    par notificacion
        Model->>observoVelocidad: update()
    and notificacion
        Model->>observoLimite: update()
        end
    deactivate Model
    activate observoVelocidad
    activate observoLimite
    observoVelocidad->>+View: muestraVelocidad
    deactivate observoVelocidad
    observoLimite->>-observoLimite: sout
    activate View
    View->>-View: sout
    deactivate View
```

---
## Pasos para la configuración

1. Model
   * Implementar `Observable` en `Model`
   * En el método en donde ocurra el cambio, notificamos a los observadores con:
     * notifyObserver(valor)
2. Crear una clase para cada observador, que implementa la interface `Observer`
    * definir el método `update()`
3. Controller
    * Instanciar el observer, definido en el punto anterior
    * Añadir este observer al observable con `addObserver()` en el `Model`
