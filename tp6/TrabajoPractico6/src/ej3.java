import javax.swing.*;
import java.awt.event.*;

public class ej3 extends JFrame {

    private JLabel lblOpciones;

    public ej3() {

        setTitle("Ejercicio 3");
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        lblOpciones = new JLabel("Opciones seleccionadas: Ninguna");

        JButton btnConfigurar = new JButton("Config Preferencias");

        btnConfigurar.addActionListener(e -> {
            DialogoPreferencias dialogo =
                    new DialogoPreferencias(this, lblOpciones);
            dialogo.setVisible(true);
        });

        panel.add(lblOpciones);
        panel.add(btnConfigurar);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ej3();
    }
}

class DialogoPreferencias extends JDialog {

    private JCheckBox oscuro;
    private JCheckBox notificaciones;
    private JCheckBox autoguardado;

    public DialogoPreferencias(JFrame padre, JLabel etiqueta) {

        super(padre, true);

        setTitle("Preferencias");
        setSize(250, 200);

        JPanel panel = new JPanel();

        oscuro = new JCheckBox("Modo Oscuro");
        notificaciones = new JCheckBox("Notis");
        autoguardado = new JCheckBox("Autoguardado");

        JButton aceptar = new JButton("Aceptar");

        aceptar.addActionListener(e -> {

            String opciones = "";

            if (oscuro.isSelected()) {
                opciones += "Modo Oscuro ";
            }

            if (notificaciones.isSelected()) {
                opciones += "Notis ";
            }

            if (autoguardado.isSelected()) {
                opciones += "Autoguardado ";
            }

            if (opciones.isEmpty()) {
                opciones = "Ninguna";
            }

            etiqueta.setText("Opciones seleccionadas: " + opciones);

            dispose();
        });

        panel.add(oscuro);
        panel.add(notificaciones);
        panel.add(autoguardado);
        panel.add(aceptar);

        add(panel);
    }
}