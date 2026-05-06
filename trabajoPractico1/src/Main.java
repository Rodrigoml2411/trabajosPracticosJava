public class Main {

    public static void main(String[] args) {       
        // SECCIÓN 1

        SistemaGestor sistema = new SistemaGestor();
        sistema.mostrarMaxConexiones();

        CuentaBancaria cuenta = new CuentaBancaria("12345", 1000);

        cuenta.depositar(500);
        cuenta.depositar(-100);

        System.out.println("Saldo actual: " + cuenta.getSaldo());

        // SECCIÓN 2

        Reporte reporte = new Reporte();

        reporte.generarEncabezado();

        String cuerpo = reporte.obtenerCuerpo();
        System.out.println(cuerpo);

        // Método con argumentos variables
        reporte.agregarSecciones("Introducción", "Desarrollo", "Conclusión");

        System.out.println("Sin secciones:");
        reporte.agregarSecciones();

        // Sobrecarga de constructores
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario("Rodrigo");
        Usuario u3 = new Usuario("Martín", 20);

        // Sobrecarga de métodos
        u3.actualizarPerfil("correo@gmail.com");
        u3.actualizarPerfil("correo@gmail.com", 266400000);
      
        // SECCIÓN 3

        Documento doc1 = new Factura();
        Documento doc2 = new Recibo();

        doc1.procesar();
        doc2.procesar();

        // Sobrecarga en clase hija
        Factura factura = new Factura();
        factura.procesar(true);
               
        // SECCIÓN 4

        enviarAImpresion(factura);
    }

    // Método que recibe cualquier objeto Exportable
    public static void enviarAImpresion(Exportable documentoExportable) {
        documentoExportable.exportar();
    }
}

class SistemaGestor {

    // Constante de clase
    public static final int MAX_CONEXIONES = 10;

    public void mostrarMaxConexiones() {

        // Variable local
        int conexionesActuales = 5;

        /*
         * Bloque de conf:
         * Aquí puede configurarse parámetros del sistema.
         */

        System.out.println("Máximo de conexiones: " + MAX_CONEXIONES);
        System.out.println("Conexiones actuales: " + conexionesActuales);

        // MAX_CONEXIONES pertenece a la clase porque es static
        // y no puede cambiar porque es final.
    }
}

// ENCAPSULACIÓN

class CuentaBancaria {

    private double saldo;

    private String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("No se permiten montos negativos.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

// MÉTODOS Y RETORNOS

class Reporte {

    // Método sin retorno
    public void generarEncabezado() {
        System.out.println("=== REPORTE DEL SISTEMA ===");
    }

    // Método con retorno
    public String obtenerCuerpo() {
        return "Contenido principal del reporte.";
    }

    // Método con argumentos variables
    public void agregarSecciones(String... secciones) {

        if (secciones.length == 0) {
            System.out.println("No se agregaron secciones.");
        }

        for (String seccion : secciones) {
            System.out.println("Sección: " + seccion);
        }
    }
}

// SOBRECARGA

class Usuario {

    private String nombre;
    private int edad;

    
    public Usuario() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }    
    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de métodos
    public void actualizarPerfil(String correo) {
        System.out.println("Correo actualizado: " + correo);
    }

    public void actualizarPerfil(String correo, int telefono) {
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
    }
}

// HERENCIA Y POLIMORFISMO

// Clase abstracta
abstract class Documento {

    // Método abstracto
    abstract void procesar();
}

class Factura extends Documento implements Exportable, Auditable {

    // Sobrescritura
    @Override
    void procesar() {
        System.out.println("Procesando factura...");
    }

    // Sobrecarga
    public void procesar(boolean esUrgente) {

        if (esUrgente) {
            System.out.println("Procesando factura urgente...");
        } else {
            System.out.println("Procesando factura normal...");
        }
    }

    @Override
    public void exportar() {
        System.out.println("Exportando factura...");
    }

    @Override
    public void registrarAuditoria() {
        System.out.println("Registrando auditoría de factura...");
    }
}

class Recibo extends Documento {

    @Override
    void procesar() {
        System.out.println("Procesando recibo...");
    }
}

// INTERFACES

interface Exportable {
    void exportar();
}



interface Auditable {
    void registrarAuditoria();
}