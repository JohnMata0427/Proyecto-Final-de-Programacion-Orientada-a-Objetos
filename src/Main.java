import javax.swing.*;

public class Main {
    static JFrame ventanaBase = new JFrame("MediCare");
    public static void main(String[] args) {
        ventanaBase.setContentPane(new Login().Inicio_Sesion);
        ventanaBase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaBase.pack();
        //frame.setSize(480,640);
        ventanaBase.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaBase.setVisible(true);

    }
}
