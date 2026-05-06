class TareaRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable) - " + i);
        }
    }
}

public class Principal12 {
    public static void main(String[] args) {
        TareaRunnable tarea = new TareaRunnable();
        
        // Pasamos la tarea al constructor de Thread
        Thread h1 = new Thread(tarea);
        Thread h2 = new Thread(tarea);

        h1.start();
        h2.start();
    }
}