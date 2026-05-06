public class ControlHilos {
    public static void main(String[] args) {
        Thread hLargo = new Thread(() -> {
            try {
                System.out.println("Hilo secundario: Iniciando tarea larga...");
                Thread.sleep(5000); // Simula tarea de 5 segundos
                System.out.println("Hilo secundario: ¡Tarea terminada!");
            } catch (InterruptedException e) {
                // Se captura la interrupción
                System.out.println("Hilo secundario: Fui interrumpido mientras dormía."); 
            }
        });

        hLargo.start();

        // Opción A: Esperar al hilo (join)
        /*
        try {
            hLargo.join(); 
            System.out.println("Main: El hilo secundario ya terminó.");
        } catch (InterruptedException e) {}
        */

        // Opción B: Interrumpir el hilo
        try {
            Thread.sleep(1000); // Esperar un poco antes de interrumpir
            System.out.println("Main: Interrumpiendo al hilo secundario...");
            hLargo.interrupt();
        } catch (InterruptedException e) {}
    }
}