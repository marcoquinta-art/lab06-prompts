# Bitácora de prompts

Laboratorio 06: Fundamentos de Ingeniería de Prompts.

Herramienta de IA usada: ChatGPT

## Ejercicio 2: Tokens y ventana de contexto

| Texto                              | Caracteres | Tokens |
| ---------------------------------- | ---------: | -----: |
| Los estudiantes programan en Java. |          7 |     35 |
| The students program in Java.      |          6 |     30 |
| desafortunadamente                 |          4 |     18 |

En el primer chat, la IA pudo responder porque previamente le proporcioné la información sobre TiendaTec y Java Swing.
En el chat nuevo, no tenía ese contexto, por lo que no pudo conocer con seguridad el nombre de la aplicación ni la tecnología.

## Ejercicio 3: Temperatura

### Resultados del chat

**Intento 1:**

- [UniBiblio, LecturaCampus, PrestaLibros]

**Intento 2:**

- [BiblioCampus, PrestamoUni, LibroHub]

**Intento 3:**

- [LibriCampus, PrestamoBiblio, CampusLector]

### Resultados del simulador

| Temperatura | BiblioTec | LectoGo | NubeDeTinta | LibroPlus | Biblioteca360 |
| ----------- | --------: | ------: | ----------: | --------: | ------------: |
| 0           |   100.00% |   0.00% |       0.00% |     0.00% |         0.00% |
| 1.8         |    32.31% |  14.04% |      10.64% |    18.54% |        24.47% |

**Primera ejecución con 1.8:** LectoGo, Biblioteca360, NubeDeTinta, LectoGo, Biblioteca360.

**Segunda ejecución con 1.8:** BiblioTec, BiblioTec, LibroPlus, Biblioteca360, LibroPlus.

Al subir la temperatura, las probabilidades se reparten entre las diferentes opciones y los nombres pueden variar más. El simulador nunca inventa un nombre nuevo porque solamente puede elegir entre las opciones que ya están definidas en el programa.

## Ejercicio 4: Prompt vago vs estructurado

### Prompt vago

El sistema de biblioteca es una aplicación diseñada para facilitar la gestión y administración de los recursos bibliográficos de una institución. Su objetivo principal es organizar de manera eficiente los libros, usuarios, préstamos y devoluciones, permitiendo acceder rápidamente a la información y reducir el trabajo manual.

Los usuarios pueden realizar búsquedas de libros mediante diferentes criterios, conocer su disponibilidad y consultar los libros que tienen actualmente en préstamo. Por otro lado, el administrador o bibliotecario puede gestionar el catálogo, registrar nuevos usuarios, controlar los préstamos y generar reportes.

### Prompt estructurado

El sistema web para la gestión de préstamos de libros tiene como objetivo optimizar el control y administración de los recursos bibliográficos de una biblioteca. Permitirá centralizar la información de los libros, usuarios y préstamos, facilitando el seguimiento de las operaciones y reduciendo errores en los registros manuales.

Los usuarios principales serán los bibliotecarios, responsables de administrar el catálogo, registrar préstamos y devoluciones, y consultar la disponibilidad de los libros. También estarán los lectores o usuarios de la biblioteca, quienes podrán consultar el catálogo, verificar la disponibilidad de ejemplares y revisar sus préstamos activos.

Entre sus funcionalidades clave se encuentran: gestión del catálogo de libros, para registrar, actualizar y consultar información bibliográfica; gestión de préstamos y devoluciones, para controlar las fechas, estados y disponibilidad de los ejemplares; y consulta de disponibilidad e historial, para que los usuarios puedan conocer qué libros están disponibles y revisar sus préstamos anteriores.

| Criterio                            | Prompt vago | Prompt estructurado |
| ----------------------------------- | ----------- | ------------------- |
| Menciona el objetivo del sistema    | Si          | Sí                  |
| Menciona a los usuarios principales | Si          | Sí                  |
| Tiene exactamente 3 funcionalidades | No          | Sí                  |
| Está en 3 párrafos                  | No          | Sí                  |
| Lo usaría en un informe real        | No          | Sí                  |

## Ejercicio 5: Anatomía de un prompt

| Componente  | Texto de mi prompt                                                                                                      |
| ----------- | ----------------------------------------------------------------------------------------------------------------------- |
| Rol         | Actua como desarrollador Java.                                                                                          |
| Instrucción | Crea un programa en Java.                                                                                               |
| Contexto    | Para gestionar los productos de una tienda, usando una clase Producto con los atributos codigo, nombre, precio y stock. |
| Ejemplo     | Usa este estilo para los metodos: getPrecio(), setPrecio(double precio).                                                |
| Formato     | Explica primero la estructura de la clase y luego presenta el codigo Java.                                              |

### Cambios por nivel

- **Nivel 1:** La IA genera un programa cualquiera porque la instrucción es muy general.
  import java.util.Scanner;

public class Suma {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numero2 = scanner.nextDouble();

        double suma = numero1 + numero2;

        System.out.println("La suma es: " + suma);

        scanner.close();
    }

}

- **Nivel 2:** Se define el rol de la IA como desarrollador Java.
  ¡Claro! Puedo ayudarte como desarrollador Java.

Para crear el programa necesito saber qué debe hacer. Por ejemplo:

🧮 Calculadora de operaciones básicas.

👥 Sistema de registro de usuarios.

🏦 Sistema bancario con cuentas y transacciones.

📦 Sistema de inventario.

📝 Programa CRUD (crear, consultar, actualizar y eliminar).

🎓 Sistema de gestión de estudiantes y notas.

🗄️ Aplicación Java conectada a MySQL.

🌐 API REST con Spring Boot.

🖥️ Aplicación de escritorio con Swing o JavaFX.

Dime qué programa necesitas, y si tienes requisitos específicos (Java 8/11/17/21, consola, interfaz gráfica, base de datos, etc.), los incorporaré.

- **Nivel 3:** Se agrega el contexto de una tienda y sus productos.
  Producto.java
  public class Producto {
  private int id;
  private String nombre;
  private double precio;
  private int stock;

      public Producto(int id, String nombre, double precio, int stock) {
          this.id = id;
          this.nombre = nombre;
          this.precio = precio;
          this.stock = stock;
      }

      public int getId() {
          return id;
      }

      public String getNombre() {
          return nombre;
      }

      public double getPrecio() {
          return precio;
      }

      public int getStock() {
          return stock;
      }

      public void setNombre(String nombre) {
          this.nombre = nombre;
      }

      public void setPrecio(double precio) {
          this.precio = precio;
      }

      public void setStock(int stock) {
          this.stock = stock;
      }

      public double getValorInventario() {
          return precio * stock;
      }

      @Override
      public String toString() {
          return String.format(
              "ID: %d | Nombre: %s | Precio: S/ %.2f | Stock: %d",
              id, nombre, precio, stock
          );
      }

  }
  Tienda.java
  import java.util.ArrayList;
  import java.util.Scanner;

public class Tienda {

    private static final ArrayList<Producto> productos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int siguienteId = 1;

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 6 -> mostrarValorInventario();
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE TIENDA =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Valor total del inventario");
        System.out.println("0. Salir");
    }

    private static void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Stock: ");

        if (precio < 0 || stock < 0) {
            System.out.println("El precio y el stock no pueden ser negativos.");
            return;
        }

        Producto producto = new Producto(
            siguienteId++,
            nombre,
            precio,
            stock
        );

        productos.add(producto);

        System.out.println("Producto agregado correctamente.");
    }

    private static void listarProductos() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void buscarProducto() {
        System.out.println("\n--- BUSCAR PRODUCTO ---");

        int id = leerEntero("Ingrese el ID del producto: ");

        Producto producto = buscarPorId(id);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void actualizarProducto() {
        System.out.println("\n--- ACTUALIZAR PRODUCTO ---");

        int id = leerEntero("Ingrese el ID del producto: ");

        Producto producto = buscarPorId(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        double precio = leerDouble("Nuevo precio: ");
        int stock = leerEntero("Nuevo stock: ");

        if (precio < 0 || stock < 0) {
            System.out.println("El precio y el stock no pueden ser negativos.");
            return;
        }

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);

        System.out.println("Producto actualizado correctamente.");
    }

    private static void eliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");

        int id = leerEntero("Ingrese el ID del producto: ");

        Producto producto = buscarPorId(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        productos.remove(producto);

        System.out.println("Producto eliminado correctamente.");
    }

    private static void mostrarValorInventario() {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getValorInventario();
        }

        System.out.printf(
            "\nValor total del inventario: S/ %.2f%n",
            total
        );
    }

    private static Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

}

- **Nivel 4:** Se especifican la clase y sus cuatro atributos.

Claro. A continuación tienes un ejemplo completo en Java usando una clase Producto con los atributos codigo, nombre, precio y stock. El programa permite registrar, listar, buscar y actualizar productos.
import java.util.ArrayList;
import java.util.Scanner;

class Producto {
private String codigo;
private String nombre;
private double precio;
private int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Mostrar información del producto
    public void mostrarProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("-------------------------");
    }

}

public class Tienda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese código: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    Producto nuevoProducto =
                            new Producto(codigo, nombre, precio, stock);

                    productos.add(nuevoProducto);

                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        System.out.println("\n===== LISTA DE PRODUCTOS =====");

                        for (Producto producto : productos) {
                            producto.mostrarProducto();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código del producto: ");
                    String codigoBuscar = scanner.nextLine();

                    boolean encontrado = false;

                    for (Producto producto : productos) {
                        if (producto.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                            System.out.println("\nProducto encontrado:");
                            producto.mostrarProducto();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el código del producto: ");
                    String codigoStock = scanner.nextLine();

                    boolean actualizado = false;

                    for (Producto producto : productos) {
                        if (producto.getCodigo().equalsIgnoreCase(codigoStock)) {

                            System.out.print("Ingrese el nuevo stock: ");
                            int nuevoStock = scanner.nextInt();
                            scanner.nextLine();

                            producto.setStock(nuevoStock);

                            System.out.println("Stock actualizado correctamente.");
                            actualizado = true;
                            break;
                        }
                    }

                    if (!actualizado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

}

- **Nivel 5:** Se indica cómo explicar y presentar la respuesta.
  structura de la clase Producto
  La clase Producto representa un producto individual de la tienda. Tendrá cuatro atributos:

codigo: identifica de manera única al producto.

nombre: almacena el nombre del producto.

precio: indica el precio del producto.

stock: indica la cantidad disponible.

Para aplicar encapsulamiento, los atributos serán private. Se utilizará un constructor para inicializar los productos y métodos get y set para consultar o modificar sus datos.

Además, podemos incluir un método mostrarProducto() para visualizar la información del producto.

Código Java
import java.util.ArrayList;
import java.util.Scanner;

// Clase Producto
class Producto {

    // Atributos
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos getter
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Métodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para mostrar los datos del producto
    public void mostrarProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("---------------------------");
    }

}

// Clase principal
public class Tienda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese código: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    Producto producto = new Producto(
                            codigo,
                            nombre,
                            precio,
                            stock
                    );

                    productos.add(producto);

                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        System.out.println("\n===== PRODUCTOS =====");

                        for (Producto p : productos) {
                            p.mostrarProducto();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código a buscar: ");
                    String codigoBuscar = scanner.nextLine();

                    boolean encontrado = false;

                    for (Producto p : productos) {
                        if (p.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                            p.mostrarProducto();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el código del producto: ");
                    String codigoStock = scanner.nextLine();

                    boolean actualizado = false;

                    for (Producto p : productos) {
                        if (p.getCodigo().equalsIgnoreCase(codigoStock)) {

                            System.out.print("Ingrese el nuevo stock: ");
                            int nuevoStock = scanner.nextInt();
                            scanner.nextLine();

                            p.setStock(nuevoStock);

                            System.out.println(
                                "Stock actualizado correctamente."
                            );

                            actualizado = true;
                            break;
                        }
                    }

                    if (!actualizado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

}

- **Ejemplo:** Se muestra el estilo que deben tener los métodos.

## Ejercicio 6: Del prompt básico al profesional

### Evaluación del prompt profesional

| Qué revisar                                            | Cumple (Sí / No) |
| ------------------------------------------------------ | ---------------- |
| ¿Está escrito en Java y usa Swing?                     | Sí               |
| ¿Pide correo y contraseña?                             | Sí               |
| ¿Explica el funcionamiento antes o después del código? | Sí               |
| ¿El código está organizado en clases?                  | Sí               |
| ¿Valida los datos que ingresa el usuario?              | No               |

### 4. Mejorar (iterar)

En el mismo chat del prompt profesional envié:

```text
Mejora el codigo anterior con estas restricciones: no uses librerias externas, valida que el correo contenga @ y que la contrasena tenga al menos 8 caracteres, y muestra los mensajes con JOptionPane.
```

La mejora agrega restricciones específicas para validar el correo y la contraseña y mostrar los mensajes mediante JOptionPane.

### Prompt final

```text
Actua como desarrollador Java. Crea un ejemplo de login para una aplicacion de escritorio utilizando Swing. El usuario debe ingresar correo y contrasena. Explica brevemente el funcionamiento y presenta el codigo organizado por clases.

Mejora el codigo anterior con estas restricciones: no uses librerias externas, valida que el correo contenga @ y que la contrasena tenga al menos 8 caracteres, y muestra los mensajes con JOptionPane.
```
