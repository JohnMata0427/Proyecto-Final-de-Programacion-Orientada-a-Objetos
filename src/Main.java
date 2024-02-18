import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new RegistrarCita().RegistrarCitaPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(480,640);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }
}