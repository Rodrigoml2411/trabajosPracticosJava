public class Principal11 {
    static class TareaHilo extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " imprimiendo: " + i);
            }
        }
    }

    public static void main(String[] args) {
        TareaHilo h1 = new TareaHilo();
        TareaHilo h2 = new TareaHilo();
        TareaHilo h3 = new TareaHilo();

        // Se usa start() para ejecución concurrente
        h1.start();
        h2.start();
        h3.start();
    }
}