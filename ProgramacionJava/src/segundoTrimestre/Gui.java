package segundoTrimestre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // Necesario para el evento
import java.awt.event.ActionListener; // Interfaz para el clic
//import com.formdev.flatlaf.FlatDarkLaf;

public class Gui {
	public static void main(String[] args) {
        // 1. Configuración de estilo moderno con FlatLaf
/*        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        // 2. Crear el marco (JFrame)
        JFrame ventana = new JFrame("Ventanas con Swing");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(350, 180);
        ventana.setLayout(new FlowLayout());

        // 3. Crear componentes
        JLabel mensaje = new JLabel("Hola Mundo");
//        JButton botonSalir = new JButton("Salir");

        // 4. Manejo del evento usando una Clase Anónima
        // Aquí explicamos que estamos creando un "escuchador" de clics
/*        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código que se ejecuta al pulsar el botón
                System.exit(0);
            }
        });*/

        // 5. Agregar elementos y mostrar
        ventana.add(mensaje);
//        ventana.add(botonSalir);
        
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true);
    }

}
