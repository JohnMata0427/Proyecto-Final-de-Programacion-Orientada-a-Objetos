import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Historial {
    private JLabel LogoRegistro;
    private JLabel NombreUsuario;
    private JButton cerrarSesiónButton;
    private JRadioButton HistorialMedicoRB;
    private JRadioButton ResultadosRB;
    private JRadioButton VerPacienteRB;
    private JRadioButton RegistrarCitaRB;
    private JButton volverButton;
    private JTextField textField1;
    JPanel HistorialForm;
    public Historial(){
        ButtonGroup GrupoModulos = new ButtonGroup();
        GrupoModulos.add(VerPacienteRB);
        GrupoModulos.add(RegistrarCitaRB);
        GrupoModulos.add(HistorialMedicoRB);
        GrupoModulos.add(ResultadosRB);

        VerPacienteRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaBase.setContentPane(new Pacientes_Registrados().panel);
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

        ResultadosRB.addActionListener(e -> {
            Main.ventanaBase.setContentPane(new Resultados().ResultadosForm);
            Main.ventanaBase.revalidate();
        });
        volverButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(new Modulos().panel);
            Main.ventanaBase.revalidate();
        });
    }
}
