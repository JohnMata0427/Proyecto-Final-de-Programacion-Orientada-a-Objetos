import javax.swing.*;

public class Main {
    static JFrame ventanaBase = new JFrame("MediCare");
    static JPanel login = new Login().Inicio_Sesion;
    static JPanel moduloAdmin = new Modulos("admin").Modulos;
    static JPanel moduloMedico = new Modulos("medico").Modulos;
    static JPanel pacientes =   new Pacientes_Registrados().Pacientes;
    static String usuario = "";
    static String correo = "";
    public static void main(String[] args) {
        ventanaBase.setContentPane(login); // Inicio_Sesion es el JPanel que contiene la interfaz de inicio de sesion
        ventanaBase.setResizable(false); // No se puede redimensionar la ventana
        ventanaBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana se termina el programa
        ventanaBase.setIconImage(new ImageIcon("src/imgs/Medicare_Logo.png").getImage()); // Icono de la ventana
        ventanaBase.pack(); // Ajusta el tamaño de la ventana al tamaño del JPanel
        ventanaBase.setSize(1200,700); // Tamaño de la ventana
        ventanaBase.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventanaBase.setVisible(true); // Hace visible la ventana en pantalla
    }
}
