import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modulos {
    JPanel Modulos;
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JButton verPacientesButton;
    private JButton registrarCitaButton;
    private JButton resultadoDeExamenesButton;
    private JButton historialMedicoButton;
    private JPanel moduloPacientes;
    private JLabel CorreoUsuario;
    private JLabel imagenPacientes;

    public Modulos(String usuario) {
        NombreUsuario.setText(Main.usuario);
        CorreoUsuario.setText(Main.correo);
        System.out.println(Main.usuario);
        System.out.println(Main.correo);
        if (usuario.equals("admin")) Main.ventanaBase.setTitle("Módulos - Administrador");
        else {
            moduloPacientes.setVisible(false);
            Main.ventanaBase.setTitle("Módulos - Médico");
        }

        cerrarSesiónButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(Main.login);
            Main.ventanaBase.revalidate();
        });
    }
}
