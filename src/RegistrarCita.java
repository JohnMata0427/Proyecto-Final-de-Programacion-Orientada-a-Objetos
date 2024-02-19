import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCita {
    public JPanel RegistrarCitaPanel;
    private JLabel LogoRegistro;
    private JButton cerrarSesiónButton;
    private JLabel NombreUsuario;
    private JRadioButton VerPacienteRB;
    private JRadioButton RegistrarCitaRB;
    private JRadioButton HistorialMedicoRB;
    private JRadioButton ResultadosRB;
    private JButton volverButton;

    public RegistrarCita() {


        ImageIcon imageIcon = new ImageIcon("src/MediCare_Logo.png"); /*XD*/
        Image img = imageIcon.getImage();
        Image tamaño = img.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(tamaño);

        LogoRegistro.setIcon(imagen);


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
