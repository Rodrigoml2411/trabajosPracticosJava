import javax.swing.*;
import java.awt.event.*;

public class ej4 extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnAcceder;

    private final String CLAVE = "1234";

    public ej4() {

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.add(new JLabel("Usuario:"));

        txtUsuario = new JTextField(15);
        panel.add(txtUsuario);

        panel.add(new JLabel("Contraseña:"));

        txtPassword = new JPasswordField("", 15);
        txtPassword.setEchoChar('*');
        panel.add(txtPassword);

        btnAcceder = new JButton("Acceder");
        btnAcceder.addActionListener(this);
        panel.add(btnAcceder);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String password = new String(txtPassword.getPassword());

        if (password.equals(CLAVE)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Acceso correcto"
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Contraseña incorrecta"
            );
        }
    }

    public static void main(String[] args) {
        new ej4();
    }
}