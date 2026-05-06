import java.util.*;

public class Main {

    public static void main(String[] args) {
      
        // SECCIÓN 1: MATRICES

        // Ejercicio 1.1
        System.out.println("=== Ejercicio 1.1 ===");

        int[] numeros = new int[5];

        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        numeros[2] = 99;//Actualiza 3er elemento 

        // Recupera el último elemento usando length
        int ultimo = numeros[numeros.length - 1];

        System.out.println("Último elemento: " + ultimo);

        // Ejercicio 1.2
        System.out.println("\n=== Ejercicio 1.2 ===");

        String[] nombres = {"Carlos", "Ana", "Pedro", "Lucia"};

        Arrays.sort(nombres);

        System.out.println("Arreglo ordenado:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        int posicion = Arrays.binarySearch(nombres, "Pedro");

        System.out.println("Pedro está en la posición: " + posicion);

        // SECCIÓN 2: LISTAS

      // Ejercicio 2.1
        System.out.println("\n=== Ejercicio 2.1 ===");

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Rojo");
        lista.add("Azul");
        lista.add("Verde");

        // Actualiza segundo elemento
        lista.set(1, "Amarillo");

        // Recupera primer elemento
        System.out.println("Primer elemento: " + lista.get(0));

        // Elimina último
        lista.remove(lista.size() - 1);

        System.out.println("Lista final: " + lista);

        // Ejercicio 2.2
        System.out.println("\n=== Ejercicio 2.2 ===");

        List<String> listaInmutable = List.of("A", "B", "C");

        System.out.println("Lista inmutable: " + listaInmutable);

        try {
            listaInmutable.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar una lista inmutable.");
        }

        LinkedList<String> linkedList = new LinkedList<>(listaInmutable);

        linkedList.add(1, "X");

        System.out.println("LinkedList mutable: " + linkedList);

        // SECCIÓN 3: SETS Y DEQUE

      // Ejercicio 3.1
        System.out.println("\n=== Ejercicio 3.1 ===");

        HashSet<Integer> conjunto = new HashSet<>();

        conjunto.add(5);
        conjunto.add(5);
        conjunto.add(5);

        System.out.println("Tamaño del set: " + conjunto.size());

        System.out.println("¿Existe el 5? " + conjunto.contains(5));

        conjunto.remove(5);

        System.out.println("Set luego de eliminar: " + conjunto);

        // Ejercicio 3.2
        System.out.println("\n=== Ejercicio 3.2 ===");

        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.addFirst("Inicio");
        deque.addLast("Final");
        deque.addFirst("Nuevo Inicio");

        System.out.println("Deque: " + deque);

        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println("removeLast(): " + deque.removeLast());

        System.out.println("Deque final: " + deque);

        // SECCIÓN 4: MAPAS

        // Ejercicio 4.1
        System.out.println("\n=== Ejercicio 4.1 ===");

        HashMap<Integer, String> usuarios = new HashMap<>();

        usuarios.put(1, "Juan");
        usuarios.put(2, "Maria");
        usuarios.put(3, "Pedro");

        System.out.println("Usuario con ID 2: " + usuarios.get(2));

        usuarios.replace(2, "Marta");

        usuarios.remove(3);

        System.out.println("HashMap final: " + usuarios);

        // Ejercicio 4.2
        System.out.println("\n=== Ejercicio 4.2 ===");

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Carlos");
        treeMap.put(1, "Ana");
        treeMap.put(2, "Luis");

        for (Integer clave : treeMap.keySet()) {
            System.out.println(clave + " -> " + treeMap.get(clave));
        }

        // SECCIÓN 5: ORDENAMIENTO

        // Ejercicio 5.1
        System.out.println("\n=== Ejercicio 5.1 ===");

        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan", 30));
        empleados.add(new Empleado("Ana", 25));
        empleados.add(new Empleado("Pedro", 40));

        Collections.sort(empleados);

        System.out.println("Ordenados por edad:");
        for (Empleado e : empleados) {
            System.out.println(e);
        }

        // Ejercicio 5.2
        System.out.println("\n=== Ejercicio 5.2 ===");

        Collections.sort(empleados, new ComparadorNombre());

        System.out.println("Ordenados por nombre:");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
}


class Empleado implements Comparable<Empleado> {

    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Empleado otro) {
        return Integer.compare(this.edad, otro.edad);
    }

    @Override
    public String toString() {
        return nombre + " - " + edad + " años";
    }
}

// Comparador personalizado por nombre
class ComparadorNombre implements Comparator<Empleado> {

    @Override
    public int compare(Empleado e1, Empleado e2) {
        return e1.getNombre().compareTo(e2.getNombre());

    }
}