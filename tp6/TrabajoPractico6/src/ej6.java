import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej6 extends JFrame {
    private JTextField txtNombre;
    private JButton btnSaludar;
    private JLabel lblMensaje;


    public ej6() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ejemplo con GroupLayout (parecida a NetBeans)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JLabel lblInstruccion = new JLabel("Introduce tu nombre:");
        txtNombre = new JTextField(15);
        btnSaludar = new JButton("Saludar");
        lblMensaje = new JLabel(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(lblInstruccion)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSaludar)
                .addComponent(lblMensaje)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblInstruccion)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSaludar)
                .addComponent(lblMensaje)
        );

        btnSaludar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            lblMensaje.setText("¡Alo, " + nombre + ":)");
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ej6().setVisible(true));
    }
}