# FlowersAPI API Restful

### Descripción
El presente proyecto es un API Rest en Java desarrollada con SpringBoot, para el manejo de inventario de flores. El proyecto se estructura bajo una arquitectura limpia y cuenta con pruebas unitarias desarrolladas con JUnit Mas abajo se encuentran documentados los end-points que se exponen.

### Arquitectura
El proyecto utiliza arquitectura hexagonal y utiliza patrones de diseño como: Controlador, Inyección de dependencia y DTO para garantizar una implementación limpia y extensible. La arquitectura hexagonal permite también una abstracción de la infraestructura, en este caso la comunicación con el exterior (Controllador Rest) y el framework mismo

### EndPoints
#### POST: http://localhost:8080/api/flowers
Permite almacenar un conjunto de flores y devuelve un mensaje de éxito. El body en formato JSON, luce como sigue: 
```
[
    {
        "id":"1",
        "name":"rosa",
        "price":15.00
    },
    {
        "id":"2",
        "name":"girasol",
        "price":14.50
    }
]
```
#### GET: http://localhost:8080/api/flowers
Permite obtener una lista de flores, ordenadas alfabéticamente en orden descendente por el nombre, y adicionándole la cadena "-kometsales" a cada nombre. El objeto devuelto no contiene el id. El JSON que devuelve luce como sigue: 
```
[
    {
        "name": "rosa-kometsales",
        "price": 15.0
    },
    {
        "name": "margarita-kometsales",
        "price": 25.3
    }
]
```
#### GET: http://localhost:8080/api/flowers/filter/price
Permite obtener una lista de flores, con su id, que cumplan la condición de tener un precio mayor a 20

#### GET: http://localhost:8080/api/flowers/filter/name/{name}
Permite obtener una lista de flores, con su id, que cumplan la condición de tener un nombre igual al nombre {name} recibido como parámetro

#### DELETE: http://localhost:8080/api/flowers/{id}
Permite eliminar de la lista de flores, aquella cuyo id sea igual al id pasado como parámtro. Devuelve un mensaje de éxito en caso de borrar la flor, caso contrario, retorna un mensaje indicando que no encontró la flor con el id recibido.


### Autor
Pedro Emilio Hernández Muñoz
