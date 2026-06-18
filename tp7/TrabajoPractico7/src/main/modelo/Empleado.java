package main.modelo;

public class Empleado {
    private int id;
    private String nombre;
    private int departamentoId;
    private String foto;
    private String departamentoNombre; // solo para mostrar

    public Empleado() {}

    public Empleado(int id, String nombre, int departamentoId, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.departamentoId = departamentoId;
        this.foto = foto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getDepartamentoNombre() { return departamentoNombre; }
    public void setDepartamentoNombre(String departamentoNombre) { this.departamentoNombre = departamentoNombre; }
}