import javax.swing.*;
import java.sql.ResultSet;

public class Login {
    JPanel panel;
    private JTextField usuarioField;
    private JPasswordField contraseñaField;
    private JButton ingresarButton;
    static String usuario, correo, tipoUsuario;
    public Login () {
        ingresarButton.addActionListener(e -> {
            try {
                ResultSet resultado = Conexion.ejecutarQuery("SELECT * FROM usuarios WHERE (usuario = '" + usuarioField.getText() + "' or correo = '" + usuarioField.getText() + "')  AND contraseña = '" + String.valueOf(contraseñaField.getPassword()) + "'");
                assert resultado != null; // Si no es nulo se ejecuta el resto del codigo, caso contrario se lanza una excepcion
                resultado.next();
                //mostrar usuario y correo de la persona que ingreso
                usuario = resultado.getString("Usuario");
                correo = resultado.getString("Correo");
                tipoUsuario = resultado.getString("Tipo_Usuario");

                Main.ventanaBase.setContentPane(new Modulos().panel); // Modulos es el JPanel que contiene la interfaz de los modulos
                Main.ventanaBase.validate(); // Actualiza el contenido de la ventana

                usuarioField.setText("");
                contraseñaField.setText("");
            } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);}
        });
    }
}
