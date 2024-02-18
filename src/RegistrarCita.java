import javax.swing.*;
import java.awt.*;

public class RegistrarCita {
    public JPanel RegistrarCitaPanel;
    private JLabel LogoRegistro;
    private JButton cerrarSesiónButton;
    private JLabel NombreUsuario;

    public RegistrarCita() {


        ImageIcon imageIcon = new ImageIcon("src/MediCare_Logo.png"); /*XD*/
        Image img = imageIcon.getImage();
        Image tamaño = img.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(tamaño);

        LogoRegistro.setIcon(imagen);
    }
}
