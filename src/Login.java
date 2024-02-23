import javax.swing.*;
import java.sql.ResultSet;

public class Login {
    JPanel Inicio_Sesion;
    private JTextField textField1;
    private JPanel Contenedor;
    private JPanel contenedorCredenciales;
    private JLabel ImagenInicio;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public Login (){
        ingresarButton.addActionListener(e -> {
            try {
                ResultSet resultado = Conexion.ejecutarQuery("SELECT * FROM usuarios WHERE usuario = '" + textField1.getText() + "' or correo = '" + textField1.getText() + "'  AND contraseña = '" + String.valueOf(passwordField1.getPassword()) + "'");
                resultado.next();
                Main.usuario = resultado.getString("Usuario");
                Main.correo = resultado.getString("Correo");
                if (resultado.getString("Tipo_Usuario").equals("A")) {
                    Main.ventanaBase.setContentPane(Main.moduloAdmin); // Modulos es el JPanel que contiene la interfaz de los modulos
                    Main.ventanaBase.validate(); // Actualiza el contenido de la ventana
                } else {
                    Main.ventanaBase.setContentPane(Main.moduloMedico); // Modulos es el JPanel que contiene la interfaz de los modulos
                    Main.ventanaBase.validate(); // Actualiza el contenido de la ventana
                }
            } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Error: " + ex);}
        });
    }
}
