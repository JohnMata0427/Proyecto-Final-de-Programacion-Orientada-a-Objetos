
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Pacientes_Registrados {
    JPanel panel;
    private JCheckBox perfilCheckBox;
    private JLabel usuarioLabel;
    private JLabel correoLabel;
    private JButton cerrarSesionButton;
    private JTable pacientesTable;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public Pacientes_Registrados() {
        usuarioLabel.setText(Login.usuario);
        correoLabel.setText(Login.correo);
        try {
            ResultSet resultado = Conexion.ejecutarQuery("SELECT * FROM Clientes");
            assert resultado != null;
            ResultSetMetaData metaData = resultado.getMetaData();
            int columnas = resultado.getMetaData().getColumnCount();
            Object[] etiquetas = new Object[resultado.getMetaData().getColumnCount()];
            for (int i=0; i<columnas; i++){
                etiquetas[i] = metaData.getColumnLabel(i+1);
            }
            DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
            while(resultado.next()){
                Object[] filas = new Object[columnas];
                for (int i=0; i<columnas; i++){
                    filas[i] = resultado.getObject(i+1);
                }
                model.addRow(filas);
            }
            pacientesTable.setModel(model);
        } catch (Exception ex){
            System.out.println(ex);
        }
        cerrarSesionButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(Main.loginPanel);
            Main.ventanaBase.validate();
        });
    }
}
