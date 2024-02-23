import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultados {
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JRadioButton VerPacienteRB;
    private JRadioButton HistorialMedicoRB;
    private JRadioButton ResultadosRB;
    private JRadioButton RegistrarCitaRB;
    private JButton volverButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    JPanel ResultadosForm;

    public Resultados(){
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
                Main.ventanaBase.setContentPane(new Historial().HistorialForm);
                Main.ventanaBase.revalidate();
            }
        });

        ResultadosRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new Resultados().ResultadosForm);
                Main.ventanaBase.revalidate();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(Main.moduloAdmin);
                Main.ventanaBase.revalidate();
            }
        });
    }
}
