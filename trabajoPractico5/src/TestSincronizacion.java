class Contador {
    private int cuenta = 0;

    // Ejercicio 3.1: Usando el modificador 'synchronized' en el método
    public synchronized void incrementarSincronizado() {
        cuenta++;
    }

    // Ejercicio 3.2: Usando bloque sincronizado
    public void incrementarPorBloque() {
        synchronized(this) { // Sección crítica
            cuenta++;
        }
    }

    // Ejercicio 2.1: Método sin sincronizar (causa error)
    public void incrementar() {
        cuenta++;
    }

    public int getCuenta() {
        return cuenta;
    }
}

public class TestSincronizacion {
    public static void main(String[] args) throws InterruptedException {
        Contador cont = new Contador();

        Runnable tarea = () -> {
            for (int i = 0; i < 10000; i++) {
                cont.incrementarSincronizado(); // Cambiar aquí para probar cada ejercicio
            }
        };

        Thread h1 = new Thread(tarea);
        Thread h2 = new Thread(tarea);

        h1.start();
        h2.start();

        h1.join(); // Esperar a que terminen para ver el resultado
        h2.join();

        System.out.println("Resultado final: " + cont.getCuenta());
    }
}