
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Objects;

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
    private JTable examenesTable;
    private JButton actualizarButton2;
    private JButton buscarButton2;
    private JButton buscarButton3;
    private JButton actualizarButton3;
    private JTable historialTable;

    private void actualizarTabla(String sqlTable, JTable jTable){
        try {jTable.setModel(Conexion.obtenerModelo(sqlTable));} catch (Exception ex){JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);}
    }
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
            pacientesTable.setModel(Conexion.obtenerModelo("clientes"));
            examenesTable.setModel(Conexion.obtenerModelo("resultados"));
            historialTable.setModel(Conexion.obtenerModelo("historialmedico"));
        } catch (Exception ex){
            System.out.println(ex);
        }

        cerrarSesionButton.addActionListener(e -> {
            Main.ventanaBase.setContentPane(Main.loginPanel);
            Main.ventanaBase.validate();
        });
        buscarButton.addActionListener(e -> {
            try{
                if (buscarField.getText().isEmpty()) JOptionPane.showMessageDialog(null, "El campo de busqueda esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
                else pacientesTable.setModel(Conexion.obtenerModelo("clientes WHERE Cedula = " + buscarField.getText()));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        registrarButton.addActionListener(e -> {
            try {
                Conexion.insertarDatos("INSERT INTO clientes VALUES("+cedulaField.getText()+",'"+nombreField.getText()+"','"+correoField.getText()+"',"+telefonoField.getText()+",'"+sexoComboBox.getSelectedItem()+"','"+alergiasField.getText()+"',"+estaturaField.getText()+","+pesoField.getText()+")");
                JOptionPane.showMessageDialog(null, "Paciente registrado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                nombreField.setText(""); correoField.setText(""); cedulaField.setText(""); telefonoField.setText(""); alergiasField.setText(""); estaturaField.setText(""); pesoField.setText("");
                pacientesTable.setModel(Conexion.obtenerModelo("clientes"));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        actualizarTablaButton.addActionListener(e -> actualizarTabla("clientes", pacientesTable));
        actualizarButton2.addActionListener(e -> actualizarTabla("resultados", examenesTable));
        actualizarButton3.addActionListener(e -> actualizarTabla("historialmedico", historialTable));
    }
}
