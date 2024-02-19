import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pacientes_Registrados {
    JPanel Pacientes;
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JTextField textField1;
    private JRadioButton VerPacienteRB;
    private JRadioButton RegistrarCitaRB;
    private JRadioButton HistorialMedicoRB;
    private JRadioButton ResultadosRB;
    private JButton volverButton;


    public Pacientes_Registrados() {
        ButtonGroup GrupoModulos = new ButtonGroup();
        GrupoModulos.add(VerPacienteRB);
        GrupoModulos.add(RegistrarCitaRB);
        GrupoModulos.add(HistorialMedicoRB);
        GrupoModulos.add(ResultadosRB);

        VerPacienteRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new Pacientes_Registrados().Pacientes);
                Main.ventanaBase.revalidate();
            }
        });

        RegistrarCitaRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new RegistrarCita().RegistrarCitaPanel);
                Main.ventanaBase.revalidate();
            }
        });

        HistorialMedicoRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ResultadosRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new Modulos().JPanelModulos);
                Main.ventanaBase.revalidate();
            }
        });
    }
}
