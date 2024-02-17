import javax.swing.*;
import java.awt.*;

public class Login {
    JPanel Inicio_Sesion;
    JLabel ImagenInicio;
    ImageIcon imageIcon = new ImageIcon("Sin título (Custom)");
    Image img = imageIcon.getImage();
    Image tamaño = img.getScaledInstance(600,1200,Image.SCALE_SMOOTH);

    ImageIcon nuevoTamaño = new ImageIcon(tamaño);

    public ImageIcon getNuevoTamaño() {
        return nuevoTamaño;
    }
    
}
