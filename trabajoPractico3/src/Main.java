import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        // SECCIÓN 1: Expresiones Lambda e Interfaces Funcionales
        Predicate<Integer> esPar = n -> n % 2 == 0;
        System.out.println("¿8 es par? " + esPar.test(8));


        Function<String, Integer> longitud = s -> s.length();
        System.out.println("Longitud de 'Hola': " + longitud.apply("Hola"));


        Consumer<Integer> imprimir = n -> System.out.println("Número: " + n);
        imprimir.accept(25);


        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println("Número aleatorio: " + aleatorio.get());


        List<String> textos = new ArrayList<>();
        textos.add("Java");
        textos.add("Programación");
        textos.add("Sol");
        textos.add("Computadora");

        textos.sort((a, b) -> a.length() - b.length());

        System.out.println("Ordenados por longitud:");
        textos.forEach(System.out::println);


        ToIntFunction<String> longitudPrimitiva = s -> s.length();
        System.out.println("Longitud de 'Streams': " +
                longitudPrimitiva.applyAsInt("Streams"));
                

        IntPredicate esParPrimitivo = n -> n % 2 == 0;
        System.out.println("¿10 es par? " +
                esParPrimitivo.test(10));

        // SECCIÓN 2: Streams
        long cantidad = Stream.of(2, 5, 3, 3, 6, 2, 4)
                .distinct()
                .skip(1)
                .limit(3)
                .count();

        System.out.println("Cantidad de elementos: " + cantidad);

        long total = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n > 3)
                .peek(n -> System.out.println("Valor: " + n))
                .count();

        System.out.println("Total mayores a 3: " + total);


        // SECCIÓN 3: Transformación y Ordenación
        Stream.of("Juan", "Maria", "Ana")
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);


        int sumaLetras = Stream.of("Juan", "Maria", "Ana")
                .mapToInt(s -> s.length())
                .sum();

        System.out.println("Suma total de letras: " + sumaLetras);


        List<List<String>> datos = new ArrayList<>();

        datos.add(Arrays.asList("Juan", "Maria"));
        datos.add(Arrays.asList("Alejandro", "Ana"));
        datos.add(Arrays.asList("Pedro", "Luciana"));

        long mayores4 = datos.stream()
                .flatMap(l -> l.stream())
                .filter(nombre -> nombre.length() > 4)
                .count();

        System.out.println("Nombres con más de 4 caracteres: " + mayores4);


        List<String> palabras = Arrays.asList(
                "Banana",
                "Sol",
                "Computadora",
                "Agua"
        );

        System.out.println("Orden natural:");
        palabras.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nOrden por longitud:");
        palabras.stream()
                .sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);


        // SECCIÓN 4: Operaciones Finales y Optional   
        boolean algunoMayor5 = Stream.of(2, 5, 7, 3, 6, 2, 3)
                .anyMatch(n -> n > 5);

        boolean todosMayores0 = Stream.of(2, 5, 7, 3, 6, 2, 3)
                .allMatch(n -> n > 0);

        boolean ningunoNegativo = Stream.of(2, 5, 7, 3, 6, 2, 3)
                .noneMatch(n -> n < 0);

        System.out.println("¿Alguno mayor a 5? " + algunoMayor5);
        System.out.println("¿Todos mayores a 0? " + todosMayores0);
        System.out.println("¿Ninguno negativo? " + ningunoNegativo);


        Optional<Integer> primerPar = Stream.of(1, 3, 5, 8, 10)
                .filter(n -> n % 2 == 0)
                .findFirst();

        if (primerPar.isPresent()) {
            System.out.println("Primer número par: " + primerPar.get());
        } else {
            System.out.println("No se encontró un número par");
        }

        Optional<Integer> suma = Stream.of(1, 2, 3, 4, 5)
                .reduce((a, b) -> a + b);

        System.out.println("Suma total: " + suma.get());

        // Lista sin duplicados
        List<Integer> listaLimpia = Stream.of(1, 2, 2, 3, 4, 4, 5)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Lista sin duplicados: " + listaLimpia);

        // Mapa de personas
        List<Persona> personas = Arrays.asList(
                new Persona(123, "Juan"),
                new Persona(456, "Maria"),
                new Persona(789, "Ana")
        );

        Map<Integer, String> mapaPersonas = personas.stream()
                .collect(Collectors.toMap(
                        p -> p.getDni(),
                        p -> p.getNombre()
                ));

        System.out.println("Mapa de personas:");
        System.out.println(mapaPersonas);
    }
}


class Persona {

    private int dni;
    private String nombre;

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
}