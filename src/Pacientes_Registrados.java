
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Pacientes_Registrados {
    JPanel panel;
    private JCheckBox perfilCheckBox;
    private JLabel usuarioLabel;
    private JLabel correoLabel;
    private JButton cerrarSesionButton;
    private JTable pacientesTable;
    private JButton actualizarTablaButton;
    private JTextField buscarField;
    private JButton buscarButton;
    private JButton registrarButton;
    private JComboBox sexoComboBox;
    private JTextField fechaField;
    private JEditorPane resultadosEditorPane;
    private JTextArea medicamentoTextArea;
    private JTextField historialMedicoField;
    private JTextField horaField;
    private JTextField imcField;
    private JTextField nombreField;
    private JTextField correoField;
    private JTextField edadField;
    private JTextField cedulaField;
    private JTextField telefonoField;
    private JTextField alergiasField;
    private JTextField medicoField;
    private JTextField motivoField;
    private JTextField estaturaField;
    private JTextField pesoField;
    private JTextField temperaturaField;
    private JTextField presionField;
    private JTextArea tratamientoTextArea;
    private JPanel formPanel;

    public Pacientes_Registrados() {
        Border lineBorder = BorderFactory.createLineBorder(Color.decode("#7a8a99"), 1);

        historialMedicoField.setBorder(lineBorder);
        fechaField.setBorder(lineBorder);
        horaField.setBorder(lineBorder);
        imcField.setBorder(lineBorder);
        resultadosEditorPane.setBorder(lineBorder);
        medicamentoTextArea.setBorder(lineBorder);
        tratamientoTextArea.setBorder(lineBorder);
        nombreField.setBorder(lineBorder);
        correoField.setBorder(lineBorder);
        edadField.setBorder(lineBorder);
        cedulaField.setBorder(lineBorder);
        telefonoField.setBorder(lineBorder);
        alergiasField.setBorder(lineBorder);
        medicoField.setBorder(lineBorder);
        motivoField.setBorder(lineBorder);
        estaturaField.setBorder(lineBorder);
        pesoField.setBorder(lineBorder);
        temperaturaField.setBorder(lineBorder);
        presionField.setBorder(lineBorder);

        usuarioLabel.setText(Login.usuario);
        correoLabel.setText(Login.correo);

        try {
            ResultSet resultado = Conexion.ejecutarQuery("SELECT * FROM Clientes");
            assert resultado != null;
            ResultSetMetaData metaData = resultado.getMetaData();

            int columnas = resultado.getMetaData().getColumnCount();

            Object[] etiquetas = new Object[columnas];
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
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PreparedStatement preparedStatement= Conexion.insertarDatos("INSERT INTO Clientes VALUES(?,?,?,?,?,?,?,?)");
                    assert preparedStatement != null;
                    preparedStatement.setInt(1, Integer.parseInt(cedulaField.getText()));
                    preparedStatement.setString(2, nombreField.getText());
                    preparedStatement.setString(3, correoField.getText());
                    preparedStatement.setInt(4,Integer.parseInt(telefonoField.getText()));
                    preparedStatement.setString(5, String.valueOf(sexoComboBox.getSelectedItem()));
                    preparedStatement.setString(6, alergiasField.getText());
                    preparedStatement.setInt(7, Integer.parseInt(estaturaField.getText()));
                    preparedStatement.setDouble(8, Double.parseDouble(pesoField.getText()));
                    int filasAfectadas = preparedStatement.executeUpdate();
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null,"Ingreso de datos exitosa");
                    } else {
                        System.out.println("Inserción fallida");
                    }
                }catch(Exception ex){
                    System.out.println("Error:" + ex);
                }
            }
        });

    }
}
