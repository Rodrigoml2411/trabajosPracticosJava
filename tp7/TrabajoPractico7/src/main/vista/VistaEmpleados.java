package main.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaEmpleados extends JFrame {
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField txtId, txtNombre;
    private JComboBox<String> comboDepartamento;
    private JLabel lblFotoPreview;
    private JButton btnBuscarFoto, btnModificar, btnEliminar, btnCargar;
    private main.controlador.EmpleadoControlador controlador;

    

    public VistaEmpleados() {
        setTitle("Gestión de Empleados - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel izquierdo (formulario)
        JPanel panelForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;
        gbc.gridx = 0; gbc.gridy = row;
        panelForm.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(10);
        txtId.setEditable(false);
        panelForm.add(txtId, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        txtNombre = new JTextField(10);
        panelForm.add(txtNombre, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panelForm.add(new JLabel("Departamento:"), gbc);
        gbc.gridx = 1;
        comboDepartamento = new JComboBox<>();
        panelForm.add(comboDepartamento, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panelForm.add(new JLabel("Foto:"), gbc);
        gbc.gridx = 1;
        JPanel panelFoto = new JPanel(new BorderLayout());
        btnBuscarFoto = new JButton("Buscar Foto");
        panelFoto.add(btnBuscarFoto, BorderLayout.WEST);
        lblFotoPreview = new JLabel();
        lblFotoPreview.setPreferredSize(new Dimension(80, 80));
        lblFotoPreview.setBorder(BorderFactory.createEtchedBorder());
        panelFoto.add(lblFotoPreview, BorderLayout.EAST);
        panelForm.add(panelFoto, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelForm.add(panelBotones, gbc);

        add(panelForm, BorderLayout.WEST);

        // Tabla
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Departamento", "Foto"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // Botón cargar (abajo)
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCargar = new JButton("Cargar Datos");
        panelInferior.add(btnCargar);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setControlador(main.controlador.EmpleadoControlador controlador) {
        this.controlador = controlador;
    }

    public JTable getTabla() { return tabla; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JComboBox<String> getComboDepartamento() { return comboDepartamento; }
    public JLabel getLblFotoPreview() { return lblFotoPreview; }
    public JButton getBtnBuscarFoto() { return btnBuscarFoto; }
    public JButton getBtnModificar() { return btnModificar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnCargar() { return btnCargar; }

    public void limpiarTabla() {
        modeloTabla.setRowCount(0);
    }

    public void agregarFilaTabla(Object[] fila) {
        modeloTabla.addRow(fila);
    }
}