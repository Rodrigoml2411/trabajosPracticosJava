import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// SECCIÓN 1

// Ejercicio 1.1

class Ejercicio11 {
    public static void main(String[] args) {

        try {
            int numero = Integer.parseInt("abc");
            System.out.println(numero);

        } catch (NumberFormatException e) {

            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Tipo de excepción: " + e.getClass().getName());
        }
    }
}

// Ejercicio 1.2

class Ejercicio12 {

    public static void division() {

        try {
            int resultado = 10 / 0;
            System.out.println(resultado);

        } catch (ArithmeticException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("Limpieza final");
        }
    }

    public static void main(String[] args) {
        division();
    }
}

// Ejercicio 1.3

class Ejercicio13 {

    public static void main(String[] args) {

        String valor = "0";

        try {

            int numero = Integer.parseInt(valor);
            int resultado = 100 / numero;

            System.out.println("Resultado: " + resultado);

        } catch (NumberFormatException | ArithmeticException e) {

            System.out.println("Error de cálculo o conversión");
        }
    }
}

// SECCIÓN 2

// Ejercicio 2.1

class Ejercicio21 {

    public static void registrarUsuario(String nombre, int edad) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (edad < 0) {
            throw new IllegalArgumentException("Edad inválida.");
        }

        System.out.println("Usuario registrado correctamente.");
    }

    public static void main(String[] args) {

        registrarUsuario("Rodrigo", 20);
    }
}

// Ejercicio 2.2

class Ejercicio22 {

    public static void registrarUsuario(String nombre, int edad) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }

        System.out.println("Usuario registrado correctamente.");
    }

    public static void main(String[] args) {

        try {

            registrarUsuario("Juan", -5);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}

// SECCIÓN 3

// Ejercicio 3.1

// Excepción personalizada checked
class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {

        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }

        saldo -= monto;

        System.out.println("Retiro realizado.");
        System.out.println("Saldo restante: " + saldo);
    }
}

class Ejercicio31 {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(1000);

        try {

            cuenta.retirar(1500);

        } catch (SaldoInsuficienteException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Ejercicio 3.2

// Excepción personalizada unchecked
class ProductoInvalidoException extends RuntimeException {

    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {

        if (precio <= 0) {
            throw new ProductoInvalidoException(
                    "El precio debe ser mayor a cero.");
        }

        this.nombre = nombre;
        this.precio = precio;
    }
}

class Ejercicio32 {

    public static void main(String[] args) {

        // El compilador NO obliga a usar try/catch
        Producto producto = new Producto("Teclado", -500);

        System.out.println("Producto creado.");
    }
}

// SECCIÓN 4

class Main {

    public static void main(String[] args) {

        // personas.txt debe existir en la misma carpeta del proyecto

        try (BufferedReader br = new BufferedReader(
            new FileReader("personas.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
            }

        } catch (IOException e) {

            System.out.println("Error al procesar el archivo: "
                + e.getMessage());
        }
    }
}