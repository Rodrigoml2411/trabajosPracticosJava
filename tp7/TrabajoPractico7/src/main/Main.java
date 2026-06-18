package main;    
public class Main {
    public static void main(String[] args) {
        // Crear la vista
        main.vista.VistaEmpleados vista = new main.vista.VistaEmpleados();
        // Crear el controlador inyectando la vista
        new main.controlador.EmpleadoControlador(vista);
    }
}
