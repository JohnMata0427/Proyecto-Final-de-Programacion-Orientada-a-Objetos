import javax.swing.*;

public class Main {
    static JFrame ventanaBase = new JFrame("MediCare");
    static JPanel loginPanel = new Login().panel;
    public static void main(String[] args) {
        ventanaBase.setContentPane(loginPanel); // Inicio_Sesion es el JPanel que contiene la interfaz de inicio de sesion
        ventanaBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana se termina el programa
        ventanaBase.setIconImage(new ImageIcon("src/imgs/Icon.png").getImage()); // Icono de la ventana
        ventanaBase.pack(); // Ajusta el tamaño de la ventana al tamaño del JPanel
        ventanaBase.setSize(650,400); // Tamaño inicial de la ventana
        ventanaBase.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventanaBase.setVisible(true); // Hace visible la ventana en pantalla
    }
}
