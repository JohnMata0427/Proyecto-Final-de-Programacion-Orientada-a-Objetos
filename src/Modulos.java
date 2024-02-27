import javax.swing.*;

public class Modulos {
    JPanel panel;
    private JCheckBox perfilCheckBox;
    private JLabel usuarioLabel;
    private JLabel correoLabel;
    private JButton cerrarSesionButton;
    private JPanel moduloPacientes;
    private JButton verPacientesButton;
    private JButton registrarCitaButton;
    private JButton resultadosExamenesButton;
    private JButton historialMedicoButton;
    private JButton dashboardButton;
    private JPanel moduloRegistro;
    private JPanel moduloExamenes;
    private JPanel moduloHistorial;
    private JPanel moduloReporte;

    public Modulos() {
        usuarioLabel.setText(Login.usuario);
        correoLabel.setText(Login.correo);

        if (Login.tipoUsuario.equals("A")) Main.ventanaBase.setTitle("Módulos - Administrador");
        else {
            moduloReporte.setVisible(false);// oculta el panel de dashboard al personal medico
            Main.ventanaBase.setTitle("Módulos - Médico");
        }

        verPacientesButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(new Pacientes_Registrados().panel);
            Main.ventanaBase.revalidate();
        });

        cerrarSesionButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(Main.loginPanel);
            Main.ventanaBase.revalidate();
        });

    }
}
