import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modulos {
    JPanel JPanelModulos;
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JButton verPacientesButton;
    private JButton registrarCitaButton;
    private JButton resultadoDeExamenesButton;
    private JButton historialMedicoButton;

    public Modulos() {
        verPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new Pacientes_Registrados().Pacientes);
                Main.ventanaBase.revalidate();
            }
        });
        registrarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new RegistrarCita().RegistrarCitaPanel);
                Main.ventanaBase.revalidate();
            }
        });
    }
}
