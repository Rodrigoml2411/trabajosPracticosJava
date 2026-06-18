import javax.swing.*;
import java.awt.event.*;

public class ej1 extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JLabel lblResultado;
    private JButton btnSaludar;

    public ej1() {
        setTitle("Ejercicio 1");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.add(new JLabel("Introduce tu nombre:"));

        txtNombre = new JTextField(20);
        panel.add(txtNombre);

        btnSaludar = new JButton("Saludar");
        btnSaludar.addActionListener(this);
        panel.add(btnSaludar);

        lblResultado = new JLabel("");
        panel.add(lblResultado);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblResultado.setText("¡Alo, " + txtNombre.getText() + "!");
    }

    public static void main(String[] args) {
        new ej1();
    }
}


