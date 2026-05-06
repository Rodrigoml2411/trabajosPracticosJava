public class Prioridades {
    public static void main(String[] args) {
        Runnable r = () -> {
            // Imprime la identidad del hilo actual
            System.out.println("Ejecutando: " + Thread.currentThread().toString()); 
        };

        Thread hBaja = new Thread(r, "Hilo-Bajo");
        Thread hAlta = new Thread(r, "Hilo-Alto");

        hBaja.setPriority(Thread.MIN_PRIORITY); // Prioridad 1
        hAlta.setPriority(Thread.MAX_PRIORITY); // Prioridad 10

        hBaja.start();
        hAlta.start();
    }
}