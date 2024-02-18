import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Login {
    JPanel Inicio_Sesion;
    private JLabel ImagenInicio;
    private JPanel Contenedor;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JPanel contenedorCredenciales;

    static class RoundedBorder implements Border{
        private int radio;
        public RoundedBorder(int radio){
            this.radio=radio;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D graphics2D = (Graphics2D) g;
            //graphics2D.setColor(Color.BLACK);
            graphics2D.drawRoundRect(x, y, width , height, radio, radio);
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radio,radio,radio,radio);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }

    public Login(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        ImageIcon imageIcon = new ImageIcon("src/Imagen_Fondo_Login.png"); /*XD*/
        int alto = dimension.height;
        Image img = imageIcon.getImage();
        Image tamaño = img.getScaledInstance(800,alto,Image.SCALE_SMOOTH);
        ImageIcon imagen=new ImageIcon(tamaño);
        ImagenInicio.setIcon(imagen);

        Contenedor.setPreferredSize(new Dimension(500,500));
        Contenedor.revalidate();
        Contenedor.repaint();

        contenedorCredenciales.setPreferredSize(new Dimension(250,250));
        contenedorCredenciales.revalidate();
        contenedorCredenciales.repaint();


        Border roundBorde = new RoundedBorder(100);
        Contenedor.setBorder(roundBorde);
    }
}
