# Arquitectura MVC con Observer

En esta rama utilizaremos el patrón Observer

Los cambios de la velocidad que se hagan en el model
serán observados por el com.cod.mvc.controller.Controller

Para notificar a los observadores hacemos dos pasos

* Actualizamos el estado a 'algo a cambiado' con `setChanged()`
* Notificamos a los observadores `notifyObservers(valor)`

De esta manera se *dispara* en todos los observadores el método `update()`

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observable {
        setChanged()
        notifyObserver(valor)
    }
        class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class com.cod.mvc.controller.Controller{
          +main()
      }
      class com.cod.mvc.model.Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class ObserverVelocidad {
          +update()
          }
          com.cod.mvc.controller.Controller "1" *-- "1" ObserverVelocidad: association
          com.cod.mvc.controller.Controller "1" *-- "1" com.cod.mvc.model.Model : association
    com.cod.mvc.model.Model "1" *-- "1..n" Coche : association
    Observable <|-- com.cod.mvc.model.Model
      
```

---

## Diagrama de Secuencia

Que ocurre cuando se cambia la velocidad


```mermaid
sequenceDiagram
    participant com.cod.mvc.view.View
    participant com.cod.mvc.controller.Controller
    participant ObserverVelocidad
    participant com.cod.mvc.model.Model
    
    com.cod.mvc.controller.Controller->>com.cod.mvc.model.Model: cambia la velociad, porfa
    activate com.cod.mvc.model.Model
    com.cod.mvc.model.Model->>ObserverVelocidad: Notificacion de cambio de velocidad
    deactivate com.cod.mvc.model.Model
    activate ObserverVelocidad
    ObserverVelocidad->>+com.cod.mvc.view.View: Muestra la velocidad, porfa
    deactivate ObserverVelocidad
    activate com.cod.mvc.view.View
    com.cod.mvc.view.View->>-com.cod.mvc.view.View: Mostrando velocidad
    deactivate com.cod.mvc.view.View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant com.cod.mvc.view.View
    box gray Controlador
    participant com.cod.mvc.controller.Controller
    participant ObserverVelocidad
    end
    participant com.cod.mvc.model.Model

    com.cod.mvc.controller.Controller->>com.cod.mvc.model.Model: cambiarVelocidad()
    activate com.cod.mvc.model.Model
    com.cod.mvc.model.Model->>ObserverVelocidad: update()
    deactivate com.cod.mvc.model.Model
    activate ObserverVelocidad
    ObserverVelocidad->>+com.cod.mvc.view.View: muestraVelocidad
    deactivate ObserverVelocidad
    activate com.cod.mvc.view.View
    com.cod.mvc.view.View->>-com.cod.mvc.view.View: sout
    deactivate com.cod.mvc.view.View
```

Si sumamos otro observador, entonces el `update()` será en paralelo (**par**)

a todos los Observadores

```mermaid
sequenceDiagram
    participant com.cod.mvc.view.View
    box gray Controlador
    participant com.cod.mvc.controller.Controller
    participant ObserverVelocidad
    participant ObserverOtro
    end
    participant com.cod.mvc.model.Model

    com.cod.mvc.controller.Controller->>com.cod.mvc.model.Model: cambiarVelocidad()
    activate com.cod.mvc.model.Model
    par notificacion
        com.cod.mvc.model.Model->>ObserverVelocidad: update()
    and notificacion
        com.cod.mvc.model.Model->>ObserverOtro: update()
        end
    deactivate com.cod.mvc.model.Model
    activate ObserverVelocidad
    activate ObserverOtro
    ObserverVelocidad->>+com.cod.mvc.view.View: muestraVelocidad
    deactivate ObserverVelocidad
    ObserverOtro->>-ObserverOtro: sout
    activate com.cod.mvc.view.View
    com.cod.mvc.view.View->>-com.cod.mvc.view.View: sout
    deactivate com.cod.mvc.view.View
```

---
## Pasos para la configuración

1. com.cod.mvc.model.Model
   * Extender `Observable` en `com.cod.mvc.model.Model`
   * En el método en donde ocurra el cambio:
     * setChenged()
     * notifyObserver(valor)
2. Crear una clase que sea el observador, que implementa la interface `Observer`
    * definir el método `update()`
3. com.cod.mvc.controller.Controller
    * Instanciar el observer, definido en el punto anterior
    * Añadir este observer al observable con `addObserver()`
