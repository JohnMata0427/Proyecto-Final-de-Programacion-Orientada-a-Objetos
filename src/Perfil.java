import javax.swing.*;
import java.sql.ResultSet;

public class Perfil {
    private JCheckBox perfilCheckBox;
    private JLabel usuarioLabel;
    private JLabel correoLabel;
    private JButton cerrarSesionButton;
    private JTextField nombreField;
    private JTextField especialidadField;
    private JTextField numeroField;
    private JTextField direccionField;
    private JTextField correoField;
    private JButton cambiarContrasenaButton;
    JPanel panel;
    private JLabel fotoLabel;
    private JLabel backgroundLabel;
    private JButton volverModulosButton;
    private JPasswordField contrasenaField;
    private JPasswordField confirmarContrasenaField;

    public Perfil() {
        try {
            ResultSet datos = Conexion.visualizarDatos("SELECT * FROM Medicos WHERE Usuario = '" + Login.usuario + "'");
            datos.next();
            nombreField.setText(datos.getString("Nombre_Medico"));
            especialidadField.setText(datos.getString("Especialidad"));
            numeroField.setText(String.valueOf(datos.getInt("Telefono_Medico")));
            direccionField.setText(datos.getString("Ubicacion"));
            correoField.setText(Login.correo);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex);
            System.out.println("Error: " + ex);
        }

        cambiarContrasenaButton.addActionListener(e -> {
            try {
                if (String.valueOf(contrasenaField.getPassword()).equals(String.valueOf(confirmarContrasenaField.getPassword()))){
                    Conexion.insertarDatos("UPDATE Usuarios SET Contraseña = '" + String.valueOf(contrasenaField.getPassword()) + "' WHERE Usuario = '" + Login.usuario + "'");
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: " + ex);
            }
        });
    }
}
