# Tarea: Mi prompt profesional

## Funcionalidad elegida

Registro básico de clientes en Java.

El sistema permitirá registrar clientes utilizando su nombre, DNI y correo electrónico.

## Version 1: prompt básico

```text
Crea un programa para registrar clientes.
```

### Qué cambié

En esta primera versión utilicé una instrucción muy general.

### Por qué

Quería observar qué resultado obtenía la IA con poca información.

### Qué mejoró en la respuesta

La IA propuso una solución básica, pero no especificó claramente la estructura del programa ni cómo debía funcionar el registro.

### Respuesta simulada

```text
Se puede crear un programa que permita registrar clientes y guardar sus datos.
```

## Version 2

```text
Actua como desarrollador Java. Crea un programa de consola para registrar clientes. Cada cliente debe tener nombre, DNI y correo electrónico.
```

### Qué cambié

Agregué el rol de desarrollador Java, indiqué que sería un programa de consola y definí los datos del cliente.

### Por qué

La primera versión era demasiado general y necesitaba proporcionar más contexto.

### Qué mejoró en la respuesta

La IA pudo generar una solución más específica, utilizando Java y considerando los tres datos del cliente.

### Respuesta simulada

```text
Se puede crear una clase Cliente con los atributos nombre, DNI y correo. El programa permitirá crear objetos Cliente y mostrar sus datos.
```

## Version 3: prompt final

```text
Actua como desarrollador Java. Crea un programa de consola para registrar clientes de una tienda. El programa debe utilizar una clase Cliente con los atributos nombre, DNI y correo electrónico, además de permitir registrar y mostrar los datos de un cliente. Usa como ejemplo los métodos getNombre(), setNombre(String nombre) y mostrarDatos(). No uses librerías externas. Explica primero la estructura de la clase y luego presenta el código Java organizado en una clase Cliente y una clase Main.
```

### Qué cambié

Agregué instrucciones más específicas sobre la funcionalidad, los atributos, los métodos, el ejemplo de nombres de métodos, la restricción de no usar librerías externas y el formato de la respuesta.

### Por qué

Quería que la IA tuviera toda la información necesaria para generar una respuesta clara y organizada.

### Qué mejoró en la respuesta

La respuesta final es más específica y organizada. También indica qué clases utilizar, qué atributos debe tener el cliente y cómo debe presentarse el código.

### Respuesta simulada

```text
La solución utiliza dos clases: Cliente y Main.

La clase Cliente contiene los atributos nombre, DNI y correo electrónico, además de los métodos getNombre(), setNombre() y mostrarDatos().

La clase Main crea un cliente y muestra sus datos.
```

## Componentes del prompt final

| Componente  | Texto de mi prompt final                                                                                                    |
| ----------- | --------------------------------------------------------------------------------------------------------------------------- |
| Rol         | Actua como desarrollador Java.                                                                                              |
| Instrucción | Crea un programa de consola para registrar clientes de una tienda.                                                          |
| Contexto    | El programa debe utilizar una clase Cliente con los atributos nombre, DNI y correo electrónico.                             |
| Ejemplo     | Usa como ejemplo los métodos getNombre(), setNombre(String nombre) y mostrarDatos().                                        |
| Formato     | Explica primero la estructura de la clase y luego presenta el código Java organizado en una clase Cliente y una clase Main. |

## Evaluación del resultado

| Criterio                                | Cumple |
| --------------------------------------- | ------ |
| Está escrito en Java                    | Sí     |
| Utiliza una clase Cliente               | Sí     |
| Contiene nombre, DNI y correo           | Sí     |
| Presenta el código organizado en clases | Sí     |
| No utiliza librerías externas           | Sí     |

## Errores que evité

### Ser demasiado general

En la primera versión la solicitud era muy general. Lo evité indicando el lenguaje Java, el tipo de programa, la clase, los atributos y las acciones que debe realizar.

### No dar contexto

La primera versión no explicaba para qué se utilizaría el registro. Lo evité indicando que se trata de un sistema para registrar clientes de una tienda.
