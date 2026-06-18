package main.controlador;

import main.modelo.Empleado;
import main.dao.EmpleadoDAO;
import main.dao.DepartamentoDAO;
import main.vista.VistaEmpleados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

public class EmpleadoControlador {
    private main.vista.VistaEmpleados vista;
    private main.dao.EmpleadoDAO EmpleadoDAO;
    private main.dao.DepartamentoDAO departamentoDAO;
    private String rutaFotoSeleccionada = "";

    public EmpleadoControlador(main.vista.VistaEmpleados vista) {
        this.vista = vista;
        this.EmpleadoDAO = new main.dao.EmpleadoDAO();
        this.departamentoDAO = new main.dao.DepartamentoDAO();
        this.vista.setControlador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        cargarDepartamentosEnCombo();
        refrescarTabla();
        configurarListeners();
    }

    private void cargarDepartamentosEnCombo() {
        List<main.modelo.Departamento> deptos = departamentoDAO.obtenerTodos();
        for (main.modelo.Departamento d : deptos) {
            vista.getComboDepartamento().addItem(d.getNombre());
        }
    }

    private void refrescarTabla() {
        List<main.modelo.Empleado> empleados = EmpleadoDAO.consultarTodos();
        vista.limpiarTabla();
        for (main.modelo.Empleado emp : empleados) {
            vista.agregarFilaTabla(new Object[]{
                emp.getId(),
                emp.getNombre(),
                emp.getDepartamentoNombre() != null ? emp.getDepartamentoNombre() : "Sin asignar",
                emp.getFoto() != null ? emp.getFoto() : ""
            });
        }
    }

    private void configurarListeners() {
        vista.getBtnCargar().addActionListener(e -> refrescarTabla());
        vista.getBtnModificar().addActionListener(e -> modificarEmpleado());
        vista.getBtnEliminar().addActionListener(e -> eliminarEmpleado());
        vista.getBtnBuscarFoto().addActionListener(e -> seleccionarFoto());

        vista.getTabla().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.getTabla().getSelectedRow();
                if (fila != -1) {
                    int id = (int) vista.getTabla().getValueAt(fila, 0);
                    String nombre = (String) vista.getTabla().getValueAt(fila, 1);
                    String deptoNombre = (String) vista.getTabla().getValueAt(fila, 2);
                    String foto = (String) vista.getTabla().getValueAt(fila, 3);
                    vista.getTxtId().setText(String.valueOf(id));
                    vista.getTxtNombre().setText(nombre);
                    vista.getComboDepartamento().setSelectedItem(deptoNombre);
                    rutaFotoSeleccionada = (foto != null && !foto.isEmpty()) ? foto : "";
                    if (!rutaFotoSeleccionada.isEmpty()) {
                        vista.getLblFotoPreview().setIcon(new ImageIcon(rutaFotoSeleccionada));
                    } else {
                        vista.getLblFotoPreview().setIcon(null);
                    }
                }
            }
        });
    }

    private void modificarEmpleado() {
        try {
            int id = Integer.parseInt(vista.getTxtId().getText());
            String nombre = vista.getTxtNombre().getText();
            String deptoSeleccionado = (String) vista.getComboDepartamento().getSelectedItem();
            int deptoId = departamentoDAO.obtenerIdPorNombre(deptoSeleccionado);
            if (deptoId == -1) {
                JOptionPane.showMessageDialog(vista, "Departamento no válido.");
                return;
            }
            main.modelo.Empleado emp = new main.modelo.Empleado();
            emp.setId(id);
            emp.setNombre(nombre);
            emp.setDepartamentoId(deptoId);
            emp.setFoto(rutaFotoSeleccionada);
            main.dao.EmpleadoDAO empleadoDAO = new main.dao.EmpleadoDAO();
            empleadoDAO.actualizar(emp);
            refrescarTabla();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Seleccione un empleado de la tabla.");
        }
    }

    private void eliminarEmpleado() {
        try {
            int id = Integer.parseInt(vista.getTxtId().getText());
            main.dao.EmpleadoDAO empleadoDAO = new main.dao.EmpleadoDAO();  
            empleadoDAO.eliminar(id);
            refrescarTabla();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Seleccione un empleado de la tabla.");
        }
    }

    private void seleccionarFoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(vista) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            rutaFotoSeleccionada = archivo.getAbsolutePath();
            ImageIcon icon = new ImageIcon(rutaFotoSeleccionada);
            java.awt.Image img = icon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
            vista.getLblFotoPreview().setIcon(new ImageIcon(img));
        }
    }

    private void limpiarCampos() {
        vista.getTxtId().setText("");
        vista.getTxtNombre().setText("");
        vista.getComboDepartamento().setSelectedIndex(0);
        vista.getLblFotoPreview().setIcon(null);
        rutaFotoSeleccionada = "";
    }
}