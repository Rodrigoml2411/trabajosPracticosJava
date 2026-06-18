import javax.swing.*;
import java.awt.event.*;

public class ej2 extends JFrame implements ActionListener {

    private JTextArea areaTexto;
    private JMenuItem limpiar;
    private JMenuItem salir;

    public ej2() {

        setTitle("Ejercicio 2");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar barra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");

        limpiar = new JMenuItem("Limpiar texto");
        salir = new JMenuItem("Salir");

        limpiar.addActionListener(this);
        salir.addActionListener(this);

        archivo.add(limpiar);
        archivo.add(salir);

        barra.add(archivo);
        setJMenuBar(barra);

        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == limpiar) {
            areaTexto.setText("");
        }

        if (e.getSource() == salir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ej2();
    }
}